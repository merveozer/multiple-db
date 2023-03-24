package merveozer.multipledb.primary.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import merveozer.multipledb.primary.model.UserInfo;

public interface UserRepository extends JpaRepository<UserInfo, Integer>{
	
}
