package com.carlos_mtzg.whattopack.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.carlos_mtzg.whattopack.models.TripModel;

public interface ITripRepository extends JpaRepository<TripModel, Integer> {

}
