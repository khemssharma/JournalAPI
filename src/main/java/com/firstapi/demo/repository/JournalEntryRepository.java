package com.firstapi.demo.repository;

import com.firstapi.demo.entity.JournalEntry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface journalEntryRepo extends MongoRepository<JournalEntry, String> {

}
