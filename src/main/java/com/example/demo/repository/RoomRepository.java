package com.example.demo.repository;

import com.example.demo.entity.MeetingRoom;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.Collection;
import java.util.List;

@RepositoryRestResource
public interface RoomRepository extends CrudRepository<MeetingRoom, Integer> {

    Collection<MeetingRoom> findAllMeetingRoomByName(String name);

    @Query(value = "SELECT * FROM public.\"MeetingRoom\"", nativeQuery = true)
    List<MeetingRoom> findAllMeetingRoom();



}
