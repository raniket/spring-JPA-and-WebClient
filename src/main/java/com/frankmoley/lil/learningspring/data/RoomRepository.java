package com.frankmoley.lil.learningspring.data;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository // It's also a DAO
public interface RoomRepository extends CrudRepository<Room, Long> {
}
