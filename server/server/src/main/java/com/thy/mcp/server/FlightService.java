package com.thy.mcp.server;

import jakarta.annotation.PostConstruct;
import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightService {

    private List<Flight> flights = new ArrayList<>();

    @Tool(name = "dv_get_flights", description = "Get all flights")
    public List<Flight> getFlights() {
        return flights;
    }

    @Tool(name = "dv_get_flight", description = "Get a single  flight by flight number")
    public Flight getFlight(String flightNumber) {
        return flights.stream()
                .filter(flight -> flight.flightNumber().equalsIgnoreCase(flightNumber))
                .findFirst()
                .orElse(null);
    }

    @PostConstruct
    public void init() {
        flights.add(new Flight("TK101", "Istanbul"));
        flights.add(new Flight("TK102", "Ankara"));
        flights.add(new Flight("TK103", "Izmir"));
        flights.add(new Flight("TK104", "Antalya"));
        flights.add(new Flight("TK105", "Bodrum"));
    }

}
