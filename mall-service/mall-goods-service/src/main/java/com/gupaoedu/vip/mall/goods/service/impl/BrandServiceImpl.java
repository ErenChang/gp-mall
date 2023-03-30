package com.gupaoedu.vip.mall.goods.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.gupaoedu.vip.mall.goods.mapper.BrandMapper;
import com.gupaoedu.vip.mall.goods.model.Brand;
import com.gupaoedu.vip.mall.goods.service.BrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrandServiceImpl extends ServiceImpl<BrandMapper, Brand> implements BrandService {

    @Autowired
    private BrandMapper brandMapper;

    @Override
    public List<Brand> queryList(Brand brand) {
        // 多条件构造器
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<Brand>();
        if (StringUtils.isNotBlank(brand.getName())) {
            queryWrapper.like("name", brand.getName());
        }
        if (StringUtils.isNotBlank(brand.getInitial())) {
            queryWrapper.eq("initial", brand.getInitial());
        }
        return brandMapper.selectList(queryWrapper);
    }

    @Override
    public Page<Brand> queryPageList(Long currentPage, Long size, Brand brand) {
        Page<Brand> page = new Page<>(currentPage, size);
        QueryWrapper<Brand> queryWrapper = new QueryWrapper<>();
        if (StringUtils.isNotBlank(brand.getName())) {
            queryWrapper.like("name", brand.getName());
        }
        if (StringUtils.isNotBlank(brand.getInitial())) {
            queryWrapper.eq("initial", brand.getInitial());
        }
        return brandMapper.selectPage(page, queryWrapper);
    }
}
