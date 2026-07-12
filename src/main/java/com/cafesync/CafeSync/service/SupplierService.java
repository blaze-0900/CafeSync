package com.cafesync.CafeSync.service;

import java.util.List;
import java.util.Optional;

import com.cafesync.CafeSync.entity.Supplier;

public interface SupplierService {

    Supplier saveSupplier(Supplier supplier);

    List<Supplier> getAllSuppliers();

    Optional<Supplier> getSupplierById(Long id);

    Supplier updateSupplier(Supplier supplier);

    void deleteSupplier(Long id);

}