package com.leyou.item.controller;

import com.leyou.item.service.CategoryService;
import com.leyou.pojo.Category;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
//大的请求
@RequestMapping("category")
public class CategoryController
{
    @Autowired
    CategoryService categoryService;
    //服务端
    @GetMapping("list")
    public ResponseEntity<List<Category>> queryCategoriesByPid(
            @RequestParam("pid") Long pid){
        //如果不成功的话,两种情况,400 服务器的问题,404,不对
        if(pid==null||pid.longValue()<0){
            //响应400,说明用户打的东西无法查询或者错误
            return ResponseEntity.badRequest().build();
        }
        //404用户查的没有
        List<Category> categories=categoryService.queryCategoriesByPid(pid);
        if(CollectionUtils.isEmpty(categories)){
            //响应404
            return ResponseEntity.notFound().build();
        }
        //如果成功的话
        return ResponseEntity.ok(categories);
}
}
