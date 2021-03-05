package at.technikum.passwortGen.controller;

import at.technikum.passwortGen.Params;
import at.technikum.passwortGen.PasswortGenService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Controller
public class GeneratorController {

    public GeneratorController(PasswortGenService passwortGenService) {
        this.passwortGenService = passwortGenService;
    }

    private final PasswortGenService passwortGenService;


    @GetMapping(value = "/")
    public String showIndex(Model model) {
        Params params = new Params();
        model.addAttribute(params);
        return "index";
    }

    @PostMapping(value = "/generate")
    public String generatePasswort(@ModelAttribute("params")Params params, Model model) throws ExecutionException, InterruptedException {
        CompletableFuture<List<String>> listCompletableFuture = passwortGenService.generatePasswords(params);
        List<String> passwords = listCompletableFuture.get();
        System.out.println("Generated passwords: " + passwords.size());
        model.addAttribute("password", passwords);
        return "generated";
    }


}
