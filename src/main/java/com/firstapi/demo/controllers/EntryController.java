package com.firstapi.demo.controllers;

import com.firstapi.demo.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class EntryController {
    private Map<Long, JournalEntry> journalEntries = new HashMap<>();
    @GetMapping
    public List<JournalEntry> getAll(){
       return new ArrayList<>(journalEntries.values());
    }
    @PostMapping
    public boolean createEntry(@RequestBody JournalEntry myEntry){
        journalEntries.put(myEntry.getId(), myEntry);
        return true;
    }
    @GetMapping("id/{myId}")
    public JournalEntry getJournalEntryById(@PathVariable("myId") Long myId ){
        return journalEntries.get(myId);
    }
    @DeleteMapping("id/{myId}")
    public JournalEntry deleteJournalEntryById(@PathVariable("myId") Long myId ){
        return journalEntries.remove(myId);
    }
    @PutMapping("id/{myId}")
    public JournalEntry updateJournalEntryById(@PathVariable("myId") Long myId, @RequestBody JournalEntry myEntry){
        return journalEntries.put(myId, myEntry);
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
