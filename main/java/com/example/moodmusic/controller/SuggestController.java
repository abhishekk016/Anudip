package com.example.moodmusic.controller;

import com.example.moodmusic.model.Song;
import com.example.moodmusic.service.MoodService;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class SuggestController {

    private final MoodService moodService;

    public SuggestController(MoodService moodService) {
        this.moodService = moodService;
    }

    @GetMapping("/suggest")
    public List<Song> suggest(@RequestParam(name = "mood") String mood) {
        return moodService.suggest(mood);
    }
}
