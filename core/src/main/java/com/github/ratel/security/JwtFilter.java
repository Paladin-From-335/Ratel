package com.github.ratel.security;

import com.github.ratel.services.impl.CustomUserDetailsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.filter.GenericFilterBean;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

import static org.springframework.util.StringUtils.hasText;

@Slf4j
public class JwtFilter extends GenericFilterBean {

    @Autowired
    private JwtTokenProvider jwtTokenProvider;

    @Autowired
    private CustomUserDetailsService customUserDetailsService;

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        logger.info("Do filter: ");
        var token = getTokenFromRequest((HttpServletRequest) request);
        if (token != null && this.jwtTokenProvider.validateToken(token)) {
            var id = this.jwtTokenProvider.getUserIdFromToken(token);
            UserDetails user = this.customUserDetailsService.loadUserById(id);
            UsernamePasswordAuthenticationToken auth =
                    new UsernamePasswordAuthenticationToken(
                            user,
                            null,
                            user.getAuthorities());
            SecurityContextHolder.getContext().setAuthentication(auth);
            request.setAttribute("userId", id);
        }
        chain.doFilter(request, response);
    }

    private String getTokenFromRequest(HttpServletRequest req) {
        String bearer = req.getHeader("Authorization");
        if (hasText(bearer) && bearer.startsWith("Bearer ")) {
            return bearer.substring(7);
        }
        return null;
    }
}
