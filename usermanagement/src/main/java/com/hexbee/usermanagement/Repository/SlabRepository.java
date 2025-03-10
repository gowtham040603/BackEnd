package com.hexbee.usermanagement.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.hexbee.usermanagement.entity.SlabEntity;


@Repository
public interface SlabRepository extends JpaRepository<SlabEntity, Long> {
	

	List<SlabEntity> findAll();

	Optional<SlabEntity> findById(Long id);


}
