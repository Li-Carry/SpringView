package spittr.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import spittr.Spitter;
import spittr.data.SpitterRepository;

import javax.servlet.http.Part;
import javax.validation.Valid;

import java.io.File;
import java.io.IOException;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

@Controller
@RequestMapping("/spitter")
public class SpitterController {

    private SpitterRepository spitterRepository;

    @Autowired
    public SpitterController(SpitterRepository spitterRepository) {
        this.spitterRepository = spitterRepository;
    }

    @RequestMapping(value = "/register", method = GET)
    public String showRegistrationForm(Model model) {
        model.addAttribute(new Spitter());
        return "registerForm";
    }

    //    MultipartFile方式
    @RequestMapping(value = "/register", method = POST)
    public String processRegistration(@Valid SpitterForm spitterForm, Errors errors)
            throws IllegalStateException, IOException {

        if (errors.hasErrors()) {
            return "registerForm";
        }
        Spitter spitter = spitterForm.toSpitter();
        spitterRepository.save(spitter);
        MultipartFile profilePicture = spitterForm.getProfilePicture();
        profilePicture.transferTo(new File("/tmp/spittr/" + spitter.getUsername() + ".jpg"));
        return "redirect:/spitter/" + spitter.getUsername();
    }

    //    Part方式，这种方式不需要配置multipartResolver
    //    @RequestMapping(value = "/register", method = POST)
    //    public String processRegistration(@RequestPart("profilePicture") Part profilePicture, @Valid Spitter spitter,
    //            RedirectAttributes model, Errors errors) {
    //        if (errors.hasErrors()) {
    //            return "registerForm";
    //        }
    //        try {
    //            profilePicture.write("/data/spittr/" + profilePicture.getSubmittedFileName());
    //        } catch (IOException e) {
    //            e.printStackTrace();
    //        }
    //        spitterRepository.save(spitter);
    //        model.addAttribute("username", spitter.getUsername());
    //        model.addFlashAttribute("spitter", spitter);
    //        return "redirect:/spitter/" + spitter.getUsername();
    //    }

    @RequestMapping(value = "/{username}", method = GET)
    public String showSpitterProfile(@PathVariable String username, Model model) {
        if (!model.containsAttribute("spitter")) {
            Spitter spitter = spitterRepository.findByUsername(username);
            model.addAttribute(spitter);
        }
        return "profile";
    }

}
