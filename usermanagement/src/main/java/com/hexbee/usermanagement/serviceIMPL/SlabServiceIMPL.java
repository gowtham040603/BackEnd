package com.hexbee.usermanagement.serviceIMPL;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hexbee.usermanagement.Repository.SlabRepository;
import com.hexbee.usermanagement.dto.SlabDTO;
import com.hexbee.usermanagement.entity.SlabEntity;
import com.hexbee.usermanagement.service.SlabService;


import jakarta.transaction.Transactional;
import jakarta.validation.Valid;

@Service
@Transactional
public class SlabServiceIMPL implements SlabService {

    @Autowired
    private SlabRepository slabRepository;

    @Override
    public SlabEntity createSlab(@Valid SlabDTO slabDTO) {
        SlabEntity slab = new SlabEntity();

        slab.setFromAmount(slabDTO.getFromAmount());
        slab.setToAmount(slabDTO.getToAmount());
        slab.setAmount(slabDTO.getAmount());

        return slabRepository.save(slab);
    }

    @Override
    public List<SlabEntity> getAllSlabs() {
        return slabRepository.findAll();
    }

    @Override
    public SlabEntity getSlabById(Long id) {
        return slabRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Slab not found with ID: " + id));
    }

    @Override
    public SlabEntity updateSlab(Long id, SlabDTO slabDTO) {
        SlabEntity editSlab = slabRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Slab not found with ID: " + id));

        editSlab.setFromAmount(slabDTO.getFromAmount());
        editSlab.setToAmount(slabDTO.getToAmount());
        editSlab.setAmount(slabDTO.getAmount());

        return slabRepository.save(editSlab);
    }

    @Override
    public void deleteSlab(Long id) {
        if (!slabRepository.existsById(id)) {
            throw new RuntimeException("Slab not found with ID: " + id);
        }
        slabRepository.deleteById(id);
    }
}
