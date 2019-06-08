package pl.coderslab.components;

import java.util.ArrayList;
import java.util.List;

public class AnimalDao {
    private List<Animal> animalList;

    public AnimalDao() {
        this.animalList = new ArrayList<>();
    }

    public List<Animal> getList() {
        return animalList;
    }
}
