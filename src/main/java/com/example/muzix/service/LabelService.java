package com.example.muzix.service;

import com.example.muzix.exceptions.NotFoundException;
import com.example.muzix.model.Label;
import com.example.muzix.repository.LabelRepository;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class LabelService {
  @Autowired
  private LabelRepository labelRepository;

  public LabelService(LabelRepository labelRepository) {
    this.labelRepository = labelRepository;
  }

  public List<Label> getAllLabels(){
    return labelRepository.findAll();
  }

  public Label getLabelById(int id){
    return labelRepository.findById(id)
      .orElseThrow(()-> new NotFoundException(id));
  }

  public void addLabel(Label label){
    labelRepository.save(label);
  }
  public void updateLabel(Label label){
    labelRepository.save(label);
  }
  public void deleteLabel(int id){
    labelRepository.deleteById(id);
  }
}
