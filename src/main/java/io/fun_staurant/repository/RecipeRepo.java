package io.fun_staurant.repository;

import io.fun_staurant.domain.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RecipeRepo extends JpaRepository<Recipe, Long> {
}
