package com.example.tacocloud;

import org.springframework.data.repository.CrudRepository;
import org.springframework.test.context.jdbc.Sql;

public interface IngredientRepository
        extends CrudRepository<Ingredient, String> {
}