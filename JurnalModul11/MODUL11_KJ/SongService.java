package com.example.monolithic.service;

import com.example.monolithic.model.Song;
import com.example.monolithic.model.Artist;
import com.example.monolithic.repository.SongRepository;
import com.example.monolithic.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongService {
    @Autowired
    private SongRepository songRepository;

    @Autowired
    private ArtistRepository artistRepository;

    public List<Song> getAll() {
        return songRepository.findAll();
    }

    public Song getById(Long id) {
        return songRepository.findById(id).orElse(null);
    }

    public Song create(Song song, Long artistId) {
        Artist artist = artistRepository.findById(artistId).orElse(null);
        if (artist != null) {
            song.setArtist(artist);
            return songRepository.save(song);
        }
        return null;
    }

    public Song update(Long id, Song songData) {
        Song song = getById(id);
        if (song != null) {
            song.setTitle(songData.getTitle());
            return songRepository.save(song);
        }
        return null;
    }

    public void delete(Long id) {
        songRepository.deleteById(id);
    }

    public List<Song> getByArtistId(Long artistId) {
        return songRepository.findByArtistId(artistId);
    }
}
