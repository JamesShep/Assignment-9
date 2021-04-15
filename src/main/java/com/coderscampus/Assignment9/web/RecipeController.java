package com.coderscampus.Assignment9.web;

import com.coderscampus.Assignment9.Objects.Recipe;
import com.coderscampus.Assignment9.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class RecipeController {
    @Autowired
    private FileService fileService;

    @GetMapping("/gluten-free")
    public List<Recipe> getGlutenFree () {
        return fileService.getAllRecipes()
                .stream()
                .filter(Recipe::getGlutenFree)
                .collect(Collectors.toList());
    }

    @GetMapping("/vegan")
    public List<Recipe> getVegan () {
        return fileService.getAllRecipes()
                .stream()
                .filter(Recipe::getVegan)
                .collect(Collectors.toList());
    }
    @GetMapping("/vegan-and-gluten-free")
    public List<Recipe> getVeganAndGlutenFree () {
        return fileService.getAllRecipes()
                .stream()
                .filter(recipe -> recipe.getVegan() && recipe.getGlutenFree())
                .collect(Collectors.toList());
    }

    @GetMapping("/vegetarian")
    public List<Recipe> getVegetarian () {
        return fileService.getAllRecipes()
                .stream()
                .filter(Recipe::getVegetarian)
                .collect(Collectors.toList());
    }

    @GetMapping("/all-recipes")
    public List<Recipe> getAllRecipes () {
        return fileService.getAllRecipes();
    }

}
