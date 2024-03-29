package com.example.muzix.service;

import com.example.muzix.exceptions.NotFoundException;
import com.example.muzix.model.Artist;
import com.example.muzix.repository.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ArtistService {
  @Autowired
  private ArtistRepository artistRepository;

  public ArtistService(ArtistRepository artistRepository) {
    this.artistRepository = artistRepository;
  }

  public List<Artist> getAllArtists() {
    return artistRepository.findAll();
  }

  public Artist getArtistById(int id) {
    return artistRepository.findById(id)
      .orElseThrow(() -> new NotFoundException(id));
  }

  public void addArtist(Artist artist) {
    artistRepository.save(artist);
  }

  public void updateArtist(Artist artist) {
    artistRepository.save(artist);
  }

  public void deleteArtist(int id) {
    artistRepository.deleteById(id);
  }
}
