package edu.greenriver.sdev.writingwebapi.services;

import edu.greenriver.sdev.writingwebapi.exceptions.GeneralException;
import edu.greenriver.sdev.writingwebapi.models.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {
    private final List<Category> categories= new ArrayList<>();
    public void addDemoCategories(){
        categories.add(new Category(1, "demo", "this is demo", "US"));
        categories.add(new Category(2, "demo1", "this is demo1", "UK"));
        categories.add(new Category(3, "demo2", "this is demo2", "Italy"));
        categories.add(new Category(4, "demo3", "this is demo3", "Germany"));
    }
    public List<Category> getAllCategories(){return categories; }

    public Category addCategory(Category category) {
        categories.add(category);
        return category;
    }
     //I used this idea from what you thought in the class
    public Category findCategory(int id) throws GeneralException {
        Category temp = categories.stream()
                .filter(category -> id == category
                        .getId())
                .findAny()
                .orElse(null);
        if(temp == null) {
            throw new GeneralException("Cannot find category.");
        }
        return temp;
    }
    public Category deleteCategory(int id) throws GeneralException {
        Category category= findCategory(id);
        categories.remove(category);
        return category;
    }

    public Category updateCategory(int id, Category category) throws GeneralException {
         Category saved = findCategory(id);
         categories.remove(saved);
         if(category.getId()!=0) {
             saved.setId(category.getId());
         }
         if(category.getOrigin()!=null) {
             saved.setOrigin(category.getOrigin());
         }
         if(category.getName()!=null) {
             saved.setName(category.getName());
         }
         if(category.getDescription()!=null) {
             saved.setDescription(category.getDescription());
         }
         categories.add(saved);
         return saved;
    }
}
