package com.example.course.services;


import com.example.course.entities.Category;
import com.example.course.entities.Order;
import com.example.course.exceptions.BadRequestException;
import com.example.course.repositories.CategoryRepository;
import com.example.course.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public List<Category> findAll(){
        return repository.findAll();
    }

    public Category findById(Long id){
        return repository.findById(id).orElseThrow(() -> new BadRequestException("Category not found"));
    }
}
