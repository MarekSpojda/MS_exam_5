package pl.coderslab.components;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AnimalDao {
    private List<Animal> animalList;

    public AnimalDao() {
        this.animalList = new ArrayList<>();
        this.animalList.add(new Animal("Burek", "pies"));
        this.animalList.add(new Animal("Mruczek", "kot"));
        this.animalList.add(new Animal("Krasula", "krowa"));
    }

    public List<Animal> getList() {
        return animalList;
    }
}
