package com.firstapi.demo.controllers;

import com.firstapi.demo.entity.JournalEntry;
import com.firstapi.demo.services.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/journal")
public class EntryController {

    @Autowired
    private JournalEntryService journalEntryService;

    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntryService.save(myEntry);
        return true;
    }
    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable("myId") Long myId ){
        return null;
    }
    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable("myId") Long myId ){
        return null;
    }
    @PutMapping("id/{myId}")
    public JournalEntry updateJournalEntryById(@PathVariable("myId") Long myId, @RequestBody JournalEntry myEntry){
        return null;
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

    @PostMapping("/journal")
    public ResponseEntity<JournalEntry> createJournalEntry(@RequestBody JournalEntry entry) {
        JournalEntry savedEntry = journalEntryService.save(entry);
        return ResponseEntity.ok(savedEntry);
    }
}
