package com.winrysoft.thought.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.winrysoft.thought.models.Thought;
import com.winrysoft.thought.repositories.ThoughtRepository;

@Service
public class ThoughtServiceImpl implements ThoughtService {

    @Autowired
    ThoughtRepository thoughtRepository;

    @Override
    public void save(Thought thought) {
        thoughtRepository.save(thought);
    }

    @Override
    public List<Thought> findAll() {
        return thoughtRepository.findAll(Sort.by("createdAt").descending());
    }

}
