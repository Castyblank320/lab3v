package com.udea.lab3v.controller;

import com.udea.lab3v.exception.InvalidRating;
import com.udea.lab3v.exception.ModelNotFoundException;
import com.udea.lab3v.model.Flight;
import com.udea.lab3v.service.FlightService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/flight")
@CrossOrigin("*")
public class FlightController {
    @Autowired
    private FlightService flightService;

    @PostMapping("/save")
    public long save(@RequestBody Flight flight) throws InvalidRating {
        if(flight.getRating()>5) throw new InvalidRating ("Id should be less than or equal to 5");
        flightService.save(flight);
        return flight.getIdflight();
    }

    @GetMapping("/listAll")
    public Iterable<Flight> listAllFlights() {
        return flightService.list();
    }

    @GetMapping("/list/{id}")
    public Flight listFlightById(@PathVariable("id") int id) {
        Optional<Flight> flight = flightService.listId(id);
        if(flight.isPresent()) {
            return flight.get();
        }
        throw new ModelNotFoundException("Id de Vuelo Invalido");
    }



@GetMapping("/topFlights")
public ResponseEntity<List<Flight>> viewBestFlight(){
    List<Flight> list = flightService.viewBestFlight();
    return new ResponseEntity<List<Flight>>(list, HttpStatus.ACCEPTED);
}

@PutMapping
    public Flight updateFlight(@RequestBody Flight flight) {
        return flightService.update(flight);
}

@DeleteMapping("/{id}")
    public String deleteFlight(@PathVariable("id") long id) {
        return flightService.delete(id);
}

}
