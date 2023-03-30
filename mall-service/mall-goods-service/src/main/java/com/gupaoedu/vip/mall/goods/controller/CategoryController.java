package com.gupaoedu.vip.mall.goods.controller;

import com.gupaoedu.mall.util.RespResult;
import com.gupaoedu.vip.mall.goods.model.Category;
import com.gupaoedu.vip.mall.goods.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/category")
@CrossOrigin
public class CategoryController {
    @Autowired
    private CategoryService categoryService;

    @GetMapping(value = "/parentId/{pid}")
    public RespResult<List<Category>> queryCategoryList(@PathVariable("pid") Integer pid) {
        return RespResult.ok(categoryService.queryByParentId(pid));
    }

}
