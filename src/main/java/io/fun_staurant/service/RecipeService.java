package io.fun_staurant.service;

import io.fun_staurant.domain.Recipe;
import io.fun_staurant.repository.RecipeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepo recipeRepo;

    public List<Recipe> setNewRecipes() {
        List<Recipe> recipes = recipeRepo.findAll();

        for (Recipe recipe : recipes) {
            recipe.setContent(deleteHtmlAndCss(recipe.getContent()));
        }

        return recipes;
    }

    private String deleteHtmlAndCss(String content) {
        content = content.replaceAll("<.*?>", "");
        return content.replaceAll("&.*?;", "");
    }
}
