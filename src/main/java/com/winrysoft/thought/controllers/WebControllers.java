package com.winrysoft.thought.controllers;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.view.RedirectView;

import com.winrysoft.thought.models.Thought;
import com.winrysoft.thought.repositories.ThoughtRepository;
import com.winrysoft.thought.services.ThoughtService;

@Controller
public class WebControllers {
    public ThoughtService thoughtService;
    public ThoughtRepository thoughtRepository;

    public WebControllers(ThoughtService thoughtService, ThoughtRepository thoughtRepository) {
        this.thoughtService = thoughtService;
        this.thoughtRepository = thoughtRepository;
    }


    @GetMapping("/")
    public String home(Model model, @RequestParam(name = "page", defaultValue = "1") Integer page) {
        PageRequest pageable = PageRequest.of(page, 5, Sort.by("createdAt").descending());
        Page<Thought> pageOfThoughts = thoughtRepository.findAll(pageable);
        List<Thought> thoughts = pageOfThoughts.getContent();

        int totalPage = pageOfThoughts.getTotalPages();

        int currentPage = page;

        model.addAttribute("thoughts", thoughts);
        model.addAttribute("thought", new Thought());
        model.addAttribute("totalPage", totalPage);
        model.addAttribute("currentPage", currentPage);
        return "home";
    }

    @GetMapping("/profile")
    public String profile() {
        return "profile";
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/register")
    public String register() {
        return "register";
    }

    @PostMapping("/add")
    public RedirectView addThought(@ModelAttribute Thought thought, Model model) {
        System.out.println(thought.getContent());
        System.out.println(thought.getIsPublic());
        thought.setCreatedAt(java.time.LocalDateTime.now());
        thoughtService.save(thought);
        return new RedirectView("/");
    }

}
