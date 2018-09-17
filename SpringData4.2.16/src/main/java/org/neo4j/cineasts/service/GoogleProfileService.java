package org.neo4j.cineasts.service;

import org.neo4j.cineasts.entity.GoogleProfile;
import org.springframework.data.neo4j.conversion.Result;

public interface GoogleProfileService {
    GoogleProfile create(GoogleProfile profile);

    void delete(GoogleProfile profile);

    GoogleProfile findById(long id);

    Result<GoogleProfile> findAll();
}