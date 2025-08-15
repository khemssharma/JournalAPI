package com.firstapi.demo.controllers;

import com.firstapi.demo.entity.JournalEntry;
import com.firstapi.demo.services.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;

@RestController
@RequestMapping("/journal")
public class EntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryService.findAll();
    }

    @PostMapping
    public ResponseEntity<JournalEntry> createEntry(@RequestBody JournalEntry myEntry){
        try {
            myEntry.setDate(LocalDateTime.now());
            journalEntryService.save(myEntry);
            return new ResponseEntity<>(myEntry, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("id/{myId}")
    public ResponseEntity<JournalEntry> getJournalEntryById(@PathVariable("myId") ObjectId myId ){
        Optional<JournalEntry> entry = journalEntryService.findById(myId);
        if (entry.isPresent()) {
            return new ResponseEntity<>(entry.get(), HttpStatus.OK);
        } 
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("id/{myId}")
    public ResponseEntity<?> deleteJournalEntryById(@PathVariable("myId") ObjectId myId ){
        journalEntryService.deleteById(myId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("id/{myId}")
    public JournalEntry updateJournalEntryById(@PathVariable("myId") ObjectId myId, @RequestBody JournalEntry myEntry){
        return journalEntryService.findById(myId).map(entry -> {
            entry.setTitle(myEntry.getTitle());
            entry.setContent(myEntry.getContent());
            entry.setDate(LocalDateTime.now());
            return journalEntryService.save(entry);
        }).orElse(null);
    }

    @PostMapping("/sum")
    public int returnSum(@RequestBody NumberRequest request) {
        return request.getNumber() * 2;
    }

    public static class NumberRequest {
        private int number;
        public int getNumber() { return number; }
        public void setNumber(int number) { this.number = number; }
    }
}
