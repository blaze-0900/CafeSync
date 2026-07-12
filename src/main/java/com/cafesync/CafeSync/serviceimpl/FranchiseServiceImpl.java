package com.cafesync.CafeSync.serviceimpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cafesync.CafeSync.entity.Franchise;
import com.cafesync.CafeSync.repository.FranchiseRepository;
import com.cafesync.CafeSync.service.FranchiseService;

@Service
public class FranchiseServiceImpl implements FranchiseService {

    @Autowired
    private FranchiseRepository franchiseRepository;

    @Override
    public Franchise saveFranchise(Franchise franchise) {
        return franchiseRepository.save(franchise);
    }

    @Override
    public List<Franchise> getAllFranchises() {
        return franchiseRepository.findAll();
    }

    @Override
    public Optional<Franchise> getFranchiseById(Long id) {
        return franchiseRepository.findById(id);
    }

    @Override
    public Franchise updateFranchise(Franchise franchise) {
        return franchiseRepository.save(franchise);
    }

    @Override
    public void deleteFranchise(Long id) {
        franchiseRepository.deleteById(id);
    }
}
