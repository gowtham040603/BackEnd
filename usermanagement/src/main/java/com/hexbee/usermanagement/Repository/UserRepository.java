	package com.hexbee.usermanagement.Repository;

	import org.springframework.data.jpa.repository.JpaRepository;
	import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
	import org.springframework.stereotype.Repository;

	import com.hexbee.usermanagement.entity.UserEntity;

	@Repository
	@EnableJpaRepositories
	public interface UserRepository extends JpaRepository<UserEntity, Integer> {

		UserEntity findByUsernameAndPassword(String username,String password);

		UserEntity findByUsername(String username);



	}


	
