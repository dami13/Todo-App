package io.github.dami.reports;

import org.springframework.data.jpa.repository.JpaRepository;


public interface PersistedTaskEventRepository extends JpaRepository<PersistedTaskEvent, Integer> {
}
