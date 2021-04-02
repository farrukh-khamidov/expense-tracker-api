package com.pairlearning.expencetrackerapi.repositories;

import com.pairlearning.expencetrackerapi.entities.Category;
import com.pairlearning.expencetrackerapi.exceptions.ETBadRequestException;
import com.pairlearning.expencetrackerapi.exceptions.EtResourceNotFoundException;

import java.util.List;

public interface CategoryRepository {

    List<Category> findAll(Integer userId) throws EtResourceNotFoundException;

    Category findById(Integer userId, Integer categoryId) throws EtResourceNotFoundException;

    Integer create(Integer userId, String title, String description) throws ETBadRequestException;

    void update(Integer userId, Integer categoryId, Category category) throws ETBadRequestException;

    void removeById(Integer userId, Integer categoryId);
}
