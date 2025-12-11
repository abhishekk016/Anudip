package com.example.moodmusic.service;

import com.example.moodmusic.model.Song;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MoodService {
    private final Map<String, List<Song>> moodMap = new HashMap<>();

    public MoodService() {
        // seed some example songs for a few moods
        List<Song> happy = new ArrayList<>();
        happy.add(new Song("Happy", "Pharrell Williams", "https://example.com/happy"));
        happy.add(new Song("Walking on Sunshine", "Katrina & The Waves", "https://example.com/walkingsunshine"));

        List<Song> sad = new ArrayList<>();
        sad.add(new Song("Someone Like You", "Adele", "https://example.com/someonelikeyou"));
        sad.add(new Song("Fix You", "Coldplay", "https://example.com/fixyou"));

        List<Song> relaxed = new ArrayList<>();
        relaxed.add(new Song("Weightless", "Marconi Union", "https://example.com/weightless"));
        relaxed.add(new Song("Clair de Lune", "Debussy", "https://example.com/clairdelune"));

        List<Song> energetic = new ArrayList<>();
        energetic.add(new Song("Titanium", "David Guetta", "https://example.com/titanium"));
        energetic.add(new Song("Eye of the Tiger", "Survivor", "https://example.com/eyeofthetiger"));

        moodMap.put("happy", happy);
        moodMap.put("sad", sad);
        moodMap.put("relaxed", relaxed);
        moodMap.put("energetic", energetic);
    }

    public List<Song> suggest(String mood) {
        if (mood == null) return new ArrayList<>();
        List<Song> r = moodMap.get(mood.toLowerCase().trim());
        return r == null ? new ArrayList<>() : r;
    }
}
