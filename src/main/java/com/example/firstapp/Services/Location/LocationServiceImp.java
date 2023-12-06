package com.example.firstapp.Services.Location;


import com.example.firstapp.Entity.Location;
import com.example.firstapp.Repository.Location.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LocationServiceImp implements LocationService {

    private final LocationRepository locationRepository;

    @Autowired
    public LocationServiceImp(LocationRepository locationRepository) {
        this.locationRepository = locationRepository;
    }

    @Override
    public List<Location> getAllLocations() {
        return locationRepository.findAll();
    }

    @Override
    public Location getLocationByID(Long id) {

        return locationRepository.findById(id).get();
    }

    @Override
    public Location createLocation(Location location) {

        return locationRepository.save(location);
    }

    @Override
    public Location updateLocation(Long id, Location updatedLocation) {
        if (locationRepository.existsById(id)) {
            updatedLocation.setId(id);
            return locationRepository.saveAndFlush(updatedLocation);
        } else {
            // Handle the case where the location with the specified ID doesn't exist.
            return null;
        }
    }

    @Override
    public void deleteLocation(Long id) {
        locationRepository.deleteById(id);
    }
}
