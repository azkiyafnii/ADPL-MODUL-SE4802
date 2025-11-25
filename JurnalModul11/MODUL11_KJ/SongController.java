package com.example.monolithic.controller;

import com.example.monolithic.model.Song;
import com.example.monolithic.service.SongService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongController {
    @Autowired
    private SongService songService;

    @GetMapping
    public List<Song> getAll() {
        return songService.getAll();
    }

    @GetMapping("/{id}")
    public Song getById(@PathVariable Long id) {
        return songService.getById(id);
    }

    @PostMapping
    public Song create(@RequestBody Song song, @RequestParam Long artistId) {
        return songService.create(song, artistId);
    }

    @PutMapping("/{id}")
    public Song update(@PathVariable Long id, @RequestBody Song song) {
        return songService.update(id, song);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        songService.delete(id);
    }

    @GetMapping("/artist/{artistId}")
    public List<Song> getByArtist(@PathVariable Long artistId) {
        return songService.getByArtistId(artistId);
    }
}
