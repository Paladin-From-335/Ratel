package com.github.ratel.controllers;

import com.github.ratel.dto.BrandDto;
import com.github.ratel.entity.Brand;
import com.github.ratel.services.impl.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/brand")
public class BrandController {

    private final BrandService brandService;

    @Autowired
    public BrandController(BrandService brandService) {
        this.brandService = brandService;
    }

    @GetMapping
    public List<Brand> findAllBrand() { return brandService.findAllBrand(); }

    @GetMapping("/{brandId}")
    public Brand findByIdBrand(@PathVariable long brandId) {
        return brandService.findBrandById(brandId).orElseThrow(()-> new RuntimeException("Id missing"));
    }

    @PostMapping
    public Brand createBrand(@RequestBody BrandDto brandDto) {
        return brandService.saveBrand(brandDto);
    }

    @PostMapping("/{brandId}")
    public Brand updateBrand(@PathVariable long brandId, @RequestBody BrandDto brandDto) {
        return brandService.updateBrandById(brandId, brandDto);
    }

    @PostMapping("/{brandId}")
    public void deleteBrand(@PathVariable long brandId) {
        brandService.deleteBrandById(brandId);
    }

}