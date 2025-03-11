package com.hexbee.usermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.hexbee.usermanagement.dto.SlabDTO;
import com.hexbee.usermanagement.entity.SlabEntity;
import com.hexbee.usermanagement.service.SlabService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/slabs")
public class SlabController {

    @Autowired
    private SlabService slabService;

    @PostMapping
    public ResponseEntity<?> createSlab(@Valid @RequestBody SlabDTO slabDTO) {
    	SlabEntity slab=slabService.createSlab(slabDTO);
        return ResponseEntity.ok(slab);
    }

    @GetMapping
    public List<SlabEntity> getAllSlabs() {
        return slabService.getAllSlabs();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SlabEntity> getSlabById(@PathVariable("id") Long id) {
        return ResponseEntity.ok(slabService.getSlabById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<SlabEntity> updateSlab(@PathVariable("id") Long id, @Valid @RequestBody SlabDTO slabDTO) {
        return ResponseEntity.ok(slabService.updateSlab(id, slabDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteSlab(@PathVariable Long id) {
        slabService.deleteSlab(id);
        return ResponseEntity.ok("Slab deleted successfully.");
    }
}
