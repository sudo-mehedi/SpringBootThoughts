package com.winrysoft.thought.services;

import java.util.List;

import com.winrysoft.thought.models.Thought;

public interface ThoughtService {
    public void save(Thought thought);
    
    public List<Thought> findAll();

}
