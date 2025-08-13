package com.firstapi.demo.services;

import com.firstapi.demo.entity.JournalEntry;
import com.firstapi.demo.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class JournalEntryService {

    @Autowired
    private JournalEntryRepository journalEntryRepository;

    public JournalEntry save(JournalEntry entry) {
        return journalEntryRepository.save(entry);
    }
}
