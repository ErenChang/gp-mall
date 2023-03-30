package com.gupaoedu.vip.mall.goods.controller;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.gupaoedu.mall.util.RespResult;
import com.gupaoedu.vip.mall.goods.model.Brand;
import com.gupaoedu.vip.mall.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {

    @Autowired
    private BrandService brandService;


    @PostMapping
    public RespResult add(@RequestBody Brand brand) {
        brandService.save(brand);
        return RespResult.ok();
    }

    @PutMapping
    public RespResult update(@RequestBody Brand brand) {
        brandService.saveOrUpdate(brand);
        return RespResult.ok();
    }

    @DeleteMapping("/{id}")
    public RespResult delete(@PathVariable(value = "id") Integer id) {
        brandService.removeById(id);
        return RespResult.ok();
    }

    @GetMapping
    public RespResult<List<Brand>> query(Brand brand) {
        List<Brand> brands = brandService.queryList(brand);
        return RespResult.ok(brands);
    }

    @GetMapping("/page")
    public RespResult<Page<Brand>> queryPageList(Long currentPage, Long size, Brand brand) {
        return RespResult.ok(brandService.queryPageList(currentPage, size, brand));
    }
}
