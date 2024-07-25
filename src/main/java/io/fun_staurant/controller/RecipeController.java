package io.fun_staurant.controller;

import io.fun_staurant.domain.Recipe;
import io.fun_staurant.service.RecipeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/recipe")
public class RecipeController {
    private final RecipeService recipeService;

    @GetMapping
    public List<Recipe> getRecipe() {
        return recipeService.setNewRecipes();
    }
}
