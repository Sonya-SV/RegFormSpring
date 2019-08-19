package com.training.regform.spring.config.controller;


import com.training.regform.spring.config.entity.Note;
import com.training.regform.spring.config.entity.User;
import com.training.regform.spring.config.service.NoteService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Controller
public class MainController {

    private final NoteService noteService;

    public MainController(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/")
    public String greeting(Map<String, Object> model) {

        return "greeting";
    }


    @GetMapping("/main")
    public String main(@RequestParam(required = false, defaultValue = "") String tag, Model model) {

        Iterable<Note> notes;
        if (tag != null && !tag.isEmpty()) {
            notes = noteService.findNoteByTag(tag);
        } else {
            notes = noteService.findAllNotes();
        }
        model.addAttribute("notes", notes);
        model.addAttribute("tag", tag);
        return "main";
    }

    @PostMapping("/main")
    public String add(
            @AuthenticationPrincipal User user,
            @RequestParam String message,
            @RequestParam String tag,
            Map<String, Object> model) {

        noteService.saveNewNote(Note.builder().message(message)
                .tag(tag)
                .author(user)
                .build());
        Iterable<Note> notes = noteService.findAllNotes();

        model.put("notes", notes);
        return "main";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(request, response, auth);
        }
        return "redirect:/login?logout";}

    @GetMapping("/login")
    public String getLogin(@RequestParam(value = "error", required = false) String error,
                        @RequestParam(value = "logout", required = false) String logout,
                        Model model) {

        model.addAttribute("error", error);
        model.addAttribute("logout", logout);
        return "login";
    }
}