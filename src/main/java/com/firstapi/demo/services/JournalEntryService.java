package com.firstapi.demo.services;

import com.firstapi.demo.entity.JournalEntry;
import com.firstapi.demo.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;

public class entryService {
    @Autowired
    private JournalEntryRepository journalEntryRepository;
    public void saveEntry(JournalEntry journalEntry){
        journalEntryRepository.save(journalEntry);
    }
}
