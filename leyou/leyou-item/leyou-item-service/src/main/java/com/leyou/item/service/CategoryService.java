package com.leyou.item.service;

import com.leyou.item.mapper.CategoryMapper;
import com.leyou.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService
{
    @Autowired
    CategoryMapper categoryMapper;
    public List<Category> queryCategoriesByPid(Long pid){
        //查数据库中有没有这样的东西有就返回
        //pid 是parentId 通过pid来查询
        Category category=new Category();
        category.setParentId(pid);
        //相当于 select *from  where pid =#{pid}
        return categoryMapper.select(category);
    }
}
