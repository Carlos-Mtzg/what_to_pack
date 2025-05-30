package com.carlos_mtzg.whattopack.services;

import java.util.List;
import java.util.Optional;

import org.springframework.context.annotation.Primary;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.carlos_mtzg.whattopack.models.TripModel;
import com.carlos_mtzg.whattopack.repositories.ITripRepository;

import jakarta.transaction.Transactional;

@Service
@Primary
@Transactional
public class TripService {
    private final ITripRepository repository;

    TripService(ITripRepository repository) {
        this.repository = repository;
    }

    public List<TripModel> getAllTrips() {
        return repository.findAll(Sort.by("id").descending());
    }

    public TripModel findById(Integer id) {
        return this.repository.findById(id).orElse(null);
    }

    public void save(TripModel trip) {
        this.repository.save(trip);
    }

    public void delete(Integer id) {
        Optional<TripModel> optional = repository.findById(id);
        if (optional.isPresent()) {
            this.repository.delete(optional.get());
        }
    }
}
