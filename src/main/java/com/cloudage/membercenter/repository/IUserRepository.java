package com.cloudage.membercenter.repository;

import org.springframework.stereotype.Repository;

import com.cloudage.membercenter.entity.User;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

@Repository
public interface IUserRepository extends PagingAndSortingRepository<User, Integer> {

	@Query("from User u where u.account = ?1")
	User findUserByAccount(String account);

	@Query("from User u where u.email = ?1")
	User findUserByEmail(String email);
    @Query("from User u where u.money =?1")
    User findUserByMoney(Integer money);
    @Query("from User user where user.name = ?1")
	User findByName(String name);

}
