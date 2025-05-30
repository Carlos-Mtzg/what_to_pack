package com.carlos_mtzg.whattopack.controllers;

import java.sql.Timestamp;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carlos_mtzg.whattopack.models.TripModel;
import com.carlos_mtzg.whattopack.services.TripService;
import com.carlos_mtzg.whattopack.utils.Utilities;

@RestController
@RequestMapping("/api")
public class TripController {
    private final TripService tripService;

    private static final String INTERNAL_SERVER_ERROR = "An internal server error occurred.";

    TripController(TripService tripService) {
        this.tripService = tripService;
    }

    // GetAll
    @GetMapping("/trip")
    public List<TripModel> listTrips() {
        return tripService.getAllTrips();
    }

    // GetById
    @GetMapping("/trip/{id}")
    public TripModel getById(@PathVariable("id") Integer id) {
        return this.tripService.findById(id);
    }

    // TripRegister
    @PostMapping("/trip")
    public ResponseEntity<Object> registerTrip(@RequestBody TripModel request) {
        try {
            request.setCreatedAt(new Timestamp(System.currentTimeMillis()));
            tripService.save(request);
            return Utilities.generateResponse(HttpStatus.OK, "Record created successfully");
        } catch (Exception e) {
            return Utilities.generateResponse(HttpStatus.INTERNAL_SERVER_ERROR, INTERNAL_SERVER_ERROR);
        }
    }

}
