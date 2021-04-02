package com.pairlearning.expencetrackerapi.services;

import com.pairlearning.expencetrackerapi.entities.Category;
import com.pairlearning.expencetrackerapi.exceptions.ETBadRequestException;
import com.pairlearning.expencetrackerapi.exceptions.EtAuthException;
import com.pairlearning.expencetrackerapi.exceptions.EtResourceNotFoundException;

import java.util.List;

public interface CategoryService {

    List<Category> fetchAllCategories(Integer userId);

    Category fetchCategoryById(Integer userId, Integer categoryId) throws EtResourceNotFoundException;

    Category addCategory(Integer userId, String title, String description) throws ETBadRequestException, EtResourceNotFoundException;

    void updateCategory(Integer userId, Integer categoryId, Category category) throws ETBadRequestException;

    void removeCategoryWithAllTransactions(Integer userId, Integer categoryId) throws EtResourceNotFoundException;
}
