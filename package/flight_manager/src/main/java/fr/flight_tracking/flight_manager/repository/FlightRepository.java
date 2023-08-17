package fr.flight_tracking.flight_manager.repository;

import fr.flight_tracking.flight_manager.model.flight.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface FlightRepository extends JpaRepository<Flight, UUID> {
}