package com.example.tacocloud.Repositories;

import com.example.tacocloud.Entities.Ingredient;
import org.springframework.data.repository.CrudRepository;

public interface IngredientRepository
        extends CrudRepository<Ingredient, String> {
}