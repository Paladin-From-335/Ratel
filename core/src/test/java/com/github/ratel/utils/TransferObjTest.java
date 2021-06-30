package com.github.ratel.utils;

import com.github.ratel.dto.ProductDto;
import com.github.ratel.entity.Product;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
public class TransferObjTest {

    @Test
    public void toProduct() {
        Product exp = new Product(
                "Name",
                new BigDecimal(100),
                "",
                1,
                "",
                "",
                "",
                ""
        );
        Product act = TransferObj.toProduct(new ProductDto(
                "Name",
                new BigDecimal(100),
                "",
                1,
                "",
                "",
                "",
                ""
        ));
        assertEquals(exp, act);
    }

    @Test
    public void fromProduct() {
    }

    @Test
    public void toUser() {
    }

    @Test
    public void fromUserAuth() {
    }

    @Test
    public void testToUser() {
    }

    @Test
    public void fromUserReg() {
    }

    @Test
    public void toOrder() {
    }

    @Test
    public void fromOrder() {
    }
}