package org.neo4j.cineasts.dao;

import org.neo4j.cineasts.entity.GoogleProfile;
import org.springframework.data.neo4j.repository.GraphRepository;

public interface GoogleProfileRepository extends GraphRepository<GoogleProfile> {
}