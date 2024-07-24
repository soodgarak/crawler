package io.fun_staurant.service;

import io.fun_staurant.domain.Recipe;
import io.fun_staurant.repository.RecipeRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecipeService {
    private final RecipeRepo recipeRepo;

    public void setNewRecipes() {
        List<Recipe> recipes = recipeRepo.findAll();

    }

    public String deleteHtmlAndCss(String content) {
        int index = 0;
        int length = content.length();

        while (index < length) {
            if (content.charAt(index++) == '<') {
                content = content.replaceAll("<.*?>", "");
                length = content.length();
                index--;
            }
        }
        return content;
    }
}
