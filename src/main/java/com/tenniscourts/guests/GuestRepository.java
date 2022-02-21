package com.tenniscourts.guests;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GuestRepository extends JpaRepository<Guest, Long> {

//    List<Guest> findAll();

    List<Guest> findByName(String name);

    List<Guest> findByNameContains(String name);
 }
