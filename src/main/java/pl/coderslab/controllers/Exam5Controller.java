package pl.coderslab.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.SessionScope;
import org.springframework.web.util.WebUtils;
import pl.coderslab.components.Animal;
import pl.coderslab.components.AnimalDao;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@SessionAttributes({"param1", "param2"})
public class Exam5Controller {
    @SuppressWarnings("FieldCanBeLocal")
    private AnimalDao animalDao;

    public Exam5Controller(AnimalDao animalDao) {
        this.animalDao = animalDao;
    }

    @RequestMapping(path = "/", produces = "text/html; charset=UTF-8")
    public String start() {
        return "home";
    }

    @GetMapping(path = "/first/{param1}/{param2}", produces = "text/html; charset=UTF-8")
    public String firstaction(@PathVariable String param1, @PathVariable String param2, Model model) {
        model.addAttribute("param1", param1);
        model.addAttribute("param2", param2);
        return "first";
    }

    @RequestMapping(path = "/check", produces = "text/html; charset=UTF-8")
    public String check() {
        return "check";
    }

    @GetMapping(path = "/createCookie/{cookieName}/{cookieValue}/{cookieTime}", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String createCookie(@PathVariable String cookieName, @PathVariable String cookieValue, @PathVariable int cookieTime, HttpServletResponse response) {
        Cookie cookie1 = new Cookie(cookieName, cookieValue);
        cookie1.setPath("/");
        cookie1.setMaxAge(cookieTime);
        response.addCookie(cookie1);
        return "Utworzono ciasteczko";
    }

    @GetMapping(path = "/deleteCookie/{cookieName}", produces = "text/html; charset=UTF-8")
    @ResponseBody
    public String deleteCookie(@PathVariable String cookieName, HttpServletRequest request, HttpServletResponse response) {
        try {
//            Cookie c = WebUtils.getCookie(request, cookieName);
//
//            if (c == null) {
//                return "Brak ciasteczka";
//            }

//            response.setCharacterEncoding("UTF-8");
//            response.getWriter().println("Ciasteczko " + c.getName() + " o wartości " + c.getValue());
//            c.setMaxAge(0);

            Cookie[] cookies = request.getCookies();
            boolean found = false;
            if (cookies != null) {
                for (Cookie cookie : cookies) {
                    if (cookie.getName().equals(cookieName)) {
                        response.getWriter().println("Ciasteczko " + cookie.getName() + " o wartości " + cookie.getValue());
                        cookie.setMaxAge(0);
                        found = true;
                    }
                }
                if (!found) {
                    return "Brak ciasteczka";
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Usunieto ciasteczko " + cookieName;
    }

    @RequestMapping(path = "/animals", produces = "text/html; charset=UTF-8")
    public String animals(Model model) {
//        animalDao.getList().add(new Animal("Burek", "pies"));
//        animalDao.getList().add(new Animal("Mruczek", "kot"));
//        animalDao.getList().add(new Animal("Krasula", "krowa"));

        StringBuilder sb = new StringBuilder();
        for (Animal animal : animalDao.getList()) {
            sb.append(animal.getName()).append(", ").append(animal.getType()).append("<br>");
        }

        model.addAttribute("animallist", sb.toString());

        return "animal";
    }
}
