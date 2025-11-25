package com.example.monolithic.service;

import com.example.monolithic.model.Artist;
import com.example.monolithic.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {
    @Autowired
    private ArtistRepository artistRepository;

    public List<Artist> getAll() {
        return artistRepository.findAll();
    }

    public Artist getById(Long id) {
        return artistRepository.findById(id).orElse(null);
    }

    public Artist create(Artist artist) {
        return artistRepository.save(artist);
    }

    public Artist update(Long id, Artist artistData) {
        Artist artist = getById(id);
        if (artist != null) {
            artist.setName(artistData.getName());
            artist.setEmail(artistData.getEmail());
            return artistRepository.save(artist);
        }
        return null;
    }

    public void delete(Long id) {
        artistRepository.deleteById(id);
    }
}
