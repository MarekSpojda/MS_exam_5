package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import pl.coderslab.components.Animal;
import pl.coderslab.components.History;
import pl.coderslab.components.Product;

import java.util.Random;

@Controller
public class HistoryController {
    private final History history;

    @Autowired
    public HistoryController(History history) {
        this.history = history;
    }

    @RequestMapping("/add-history")
    @ResponseBody
    public void addToHistory(Model model) {
        Random rand = new Random();
        history.addProduct(new Product("prod" + rand.nextInt(10), rand.nextDouble()));
        System.out.println(history.getLastProducts().size());
        for (Product product : history.getLastProducts()) {
            System.out.println(product.getName() + " " + product.getPrice());
        }
    }

    @RequestMapping("/show-history")
    public String showHistory(Model model) {
        StringBuilder sb = new StringBuilder();
        for (Product product : history.getLastProducts()) {
            sb.append(product.getName()).append(", ").append(product.getPrice()).append("<br>");
        }

        model.addAttribute("historylist", sb.toString());
        return "history";
    }
}
