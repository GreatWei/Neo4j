package org.neo4j.cineasts.service;

import org.neo4j.cineasts.dao.GoogleProfileRepository;
import org.neo4j.cineasts.entity.GoogleProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.neo4j.conversion.Result;
import org.springframework.stereotype.Service;

@Service("googleProfileService")
public class GoogleProfileServiceImpl implements GoogleProfileService {
    @Autowired
    private GoogleProfileRepository googleProfileRepository;

    public GoogleProfile create(GoogleProfile profile) {
        return googleProfileRepository.save(profile);
    }

    public void delete(GoogleProfile profile) {
        googleProfileRepository.delete(profile);
    }

    public GoogleProfile findById(long id) {
        return googleProfileRepository.findOne(id);
    }

    public Result<GoogleProfile> findAll() {
        return googleProfileRepository.findAll();
    }
}