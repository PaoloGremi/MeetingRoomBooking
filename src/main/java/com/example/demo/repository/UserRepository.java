package com.example.demo.repository;

import com.example.demo.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;
import java.util.List;

@RepositoryRestResource
public interface UserRepository extends CrudRepository<User, Integer>{

    Collection<User> findAllUsersByName(String name);
    Collection<User> findAllUsersBySurname(String surname);

    @Query(value = "SELECT * FROM public.\"User\" WHERE name = :name", nativeQuery = true)
    Collection<User> finder(@Param("name") String name);

    @Query(value = "SELECT * FROM public.\"User\" WHERE surname = :surname", nativeQuery = true)
    Collection<User> finderCF(@Param("surname") String surname);

    @Query(value = "SELECT * FROM public.\"User\" WHERE email = :email and password = :password", nativeQuery = true)
    User findUser(@Param("email") String email, @Param("password") String password);

    @Query(value = "SELECT * FROM public.\"User\"", nativeQuery = true)
    List<User> findAllUsers();


}
