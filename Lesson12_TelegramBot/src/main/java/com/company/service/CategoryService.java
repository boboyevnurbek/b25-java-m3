package com.company.service;

import com.company.db.Database;
import com.company.entity.Category;

import java.util.Optional;

public class CategoryService {
    public static String addCategory(String name) {
        try{
            if(name == null || name.isBlank()){
                throw new RuntimeException("Category name is required");
            }

            Optional<Category> categoryOptional = Database.CATEGORY_LIST.stream()
                    .filter(category -> category.getName().equalsIgnoreCase(name))
                    .findFirst();

            if(categoryOptional.isPresent()) {
                return "This category already exists";
            }

            Category category = new Category(Database.CATEGORY_LIST.size() + 1, name);
            Database.CATEGORY_LIST.add(category);

        }catch (RuntimeException e){
            return e.getMessage();
        }

        return String.format("New category (%s) added.", name.trim());
    }
}
