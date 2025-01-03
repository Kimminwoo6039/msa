package com.example.msaplaybackservice.domain.repository;

import com.example.msaplaybackservice.domain.entity.EventLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventLogRepository extends JpaRepository<EventLog, Long> {
}
