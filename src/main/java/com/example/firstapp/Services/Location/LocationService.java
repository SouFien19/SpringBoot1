package com.example.firstapp.Services.Location;


import com.example.firstapp.Entity.Location;

import java.util.List;

public interface LocationService {

    List<Location> getAllLocations();
    Location getLocationByID(Long id);

    Location createLocation(Location location);

    Location updateLocation(Long id, Location updatedLocation);

    void deleteLocation(Long id);
}
