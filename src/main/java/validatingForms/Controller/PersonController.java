package validatingForms.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import validatingForms.Model.Person;

import javax.validation.Valid;

@Controller
public class PersonController implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry viewControllerRegistry) {
        viewControllerRegistry.addViewController("/results").setViewName("results");
    }

    @GetMapping("/")
    public String showForm(Person person) {
        return "form";
    }

    @PostMapping("/")
    public String checkPersonInfo(@Valid Person person, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "form";
        }

        return "redirect:/results";
    }
}
