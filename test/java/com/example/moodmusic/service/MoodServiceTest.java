package com.example.moodmusic.service;

import com.example.moodmusic.model.Song;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MoodServiceTest {

    @Test
    void suggestKnownMood() {
        MoodService s = new MoodService();
        List<Song> songs = s.suggest("happy");
        assertNotNull(songs);
        assertTrue(songs.size() >= 1);
    }

    @Test
    void suggestUnknownMood() {
        MoodService s = new MoodService();
        List<Song> songs = s.suggest("mystic-unknown");
        assertNotNull(songs);
        assertEquals(0, songs.size());
    }
}
