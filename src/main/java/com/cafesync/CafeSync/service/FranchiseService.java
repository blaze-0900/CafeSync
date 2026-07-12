package com.cafesync.CafeSync.service;

import java.util.List;
import java.util.Optional;

import com.cafesync.CafeSync.entity.Franchise;

public interface FranchiseService {

    Franchise saveFranchise(Franchise franchise);

    List<Franchise> getAllFranchises();

    Optional<Franchise> getFranchiseById(Long id);

    Franchise updateFranchise(Franchise franchise);

    void deleteFranchise(Long id);

}
