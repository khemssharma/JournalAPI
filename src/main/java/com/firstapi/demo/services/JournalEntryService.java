package com.firstapi.demo.services;

import com.firstapi.demo.entity.JournalEntry;
import com.firstapi.demo.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public JournalEntry save(JournalEntry entry) {
        return journalEntryRepository.save(entry);
    }
    public List<JournalEntry> findAll() {
        return journalEntryRepository.findAll();
    }
    public Optional<JournalEntry> findById(ObjectId id) {
        return journalEntryRepository.findById(id);
    }   
    public void deleteById(ObjectId id) {
        journalEntryRepository.deleteById(id);
    }   
}
