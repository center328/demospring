package com.example.demo.repositories;

import com.example.demo.models.User;
import com.example.demo.models.UserEvent;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserEventRepository extends PagingAndSortingRepository<UserEvent, Long> {
}
