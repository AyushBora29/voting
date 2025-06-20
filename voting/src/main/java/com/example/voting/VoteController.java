package com.example.voting;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@Controller
public class VoteController {

    private Map<String, Integer> voteMap = new HashMap<>();

    public VoteController() {
        voteMap.put("Anjali", 0);
        voteMap.put("Rohan", 0);
        voteMap.put("Priya", 0);
    }

    @GetMapping("/")
    public String showForm(Model model) {
        model.addAttribute("votes", voteMap);
        return "index";
    }

    @PostMapping("/vote")
    public String submitVote(@RequestParam String candidate, Model model) {
        voteMap.put(candidate, voteMap.get(candidate) + 1);
        model.addAttribute("votes", voteMap);
        return "index";
    }
}
