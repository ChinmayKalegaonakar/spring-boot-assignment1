package com.example.muzix.service;

import com.example.muzix.exceptions.NotFoundException;
import com.example.muzix.exceptions.TrackExistsException;
import com.example.muzix.model.Track;
import com.example.muzix.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TrackService {

  @Autowired
  private TrackRepository trackRepository;

  public TrackService(TrackRepository trackRepository) {
    this.trackRepository = trackRepository;
  }

  public Track addTrack(Track track){

    if(trackRepository.existsById(track.getTrackId()))
      throw new TrackExistsException(trackRepository.findById(track.getTrackId()));

    trackRepository.save(track);
    return track;
  }

  public Track getTrackById(int id){
    return trackRepository.findById(id)
      .orElseThrow(()-> new NotFoundException(id));
  }

  public List<Track> getAllTracks(){
    return trackRepository.findAll();
  }

  public void deleteTrack(int id){
    trackRepository.deleteById(id);
  }

  public void updateTrack(Track track){
    trackRepository.save(track);
  }

  public List<Track> getTrackByName(String trackName){
    return trackRepository.findByTrackName(trackName);
  }

  public List<Track> getTrackByAlbum(String trackAlbum){
    return trackRepository.findByTrackAlbum(trackAlbum);
  }

}
