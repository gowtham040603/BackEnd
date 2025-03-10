package com.hexbee.usermanagement.service;

import java.util.List;

import com.hexbee.usermanagement.dto.SlabDTO;
import com.hexbee.usermanagement.entity.SlabEntity;

import jakarta.validation.Valid;

public interface SlabService {

	public SlabEntity createSlab(@Valid SlabDTO slabDTO);

	public List<SlabEntity> getAllSlabs();


	public void deleteSlab(Long id);

	public SlabEntity getSlabById(Long id);

	SlabEntity updateSlab(Long id, SlabDTO slabDTO);

	



	

}
