package com.hexbee.usermanagement.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.hexbee.usermanagement.entity.CustomersEntity;


@Repository
@EnableJpaRepositories
public interface CustomersRepository extends JpaRepository<CustomersEntity, Integer> {

}
