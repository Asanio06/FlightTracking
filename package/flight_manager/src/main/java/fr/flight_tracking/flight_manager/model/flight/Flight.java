package fr.flight_tracking.flight_manager.model.flight;

import fr.flight_tracking.flight_manager.model.core.Auditor;
import io.hypersistence.utils.hibernate.type.basic.PostgreSQLEnumType;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.annotations.Type;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.*;


@Entity
@Table(name = "flight")
public class Flight extends Auditor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column
    private String flightNumber;

    @Column
    private String aircraftIcao;

    @Column
    private String departureIcao;

    @Column
    private String arrivalIcao;

    @Column
    private int cruiseLevel;

    @Column
    private LocalDateTime expectedDepartureTime;

    @Column
    private LocalDateTime expectedArrivalTime;

    @Column
    private String pilotName;

    @Column
    @Enumerated(EnumType.STRING)
    @Type(PostgreSQLEnumType.class)
    private FlightStatus status;

    @Column
    @Enumerated(EnumType.STRING)
    @Type(PostgreSQLEnumType.class)
    private FlightStep flightStep;

    @JdbcTypeCode(SqlTypes.JSON)
    private Map<String, Object> aircraftStateHistories;

    public Flight() {
    }


    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getAircraftIcao() {
        return aircraftIcao;
    }

    public void setAircraftIcao(String aircraftIcao) {
        this.aircraftIcao = aircraftIcao;
    }

    public String getDepartureIcao() {
        return departureIcao;
    }

    public void setDepartureIcao(String departureIcao) {
        this.departureIcao = departureIcao;
    }

    public String getArrivalIcao() {
        return arrivalIcao;
    }

    public void setArrivalIcao(String arrivalIcao) {
        this.arrivalIcao = arrivalIcao;
    }

    public int getCruiseLevel() {
        return cruiseLevel;
    }

    public void setCruiseLevel(int cruiseLevel) {
        this.cruiseLevel = cruiseLevel;
    }

    public LocalDateTime getExpectedDepartureTime() {
        return expectedDepartureTime;
    }

    public void setExpectedDepartureTime(LocalDateTime expectedDepartureTime) {
        this.expectedDepartureTime = expectedDepartureTime;
    }

    public LocalDateTime getExpectedArrivalTime() {
        return expectedArrivalTime;
    }

    public void setExpectedArrivalTime(LocalDateTime expectedArrivalTime) {
        this.expectedArrivalTime = expectedArrivalTime;
    }

    public String getPilotName() {
        return pilotName;
    }

    public void setPilotName(String pilotName) {
        this.pilotName = pilotName;
    }

    public FlightStatus getStatus() {
        return status;
    }

    public void setStatus(FlightStatus status) {
        this.status = status;
    }

    public FlightStep getFlightStep() {
        return flightStep;
    }

    public void setFlightStep(FlightStep flightStep) {
        this.flightStep = flightStep;
    }

    public Map<String, Object> getAircraftStateHistories() {
        return aircraftStateHistories;
    }

    public void setAircraftStateHistories(Map<String, Object> aircraftStateHistories) {
        this.aircraftStateHistories = aircraftStateHistories;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(id, flight.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Flight{" + "id=" + id + ", flightNumber='" + flightNumber + '\'' + ", aircraftIcao='" + aircraftIcao + '\'' + ", departureIcao='" + departureIcao + '\'' + ", arrivalIcao='" + arrivalIcao + '\'' + ", cruiseLevel=" + cruiseLevel + ", expectedDepartureTime=" + expectedDepartureTime + ", expectedArrivalTime=" + expectedArrivalTime + ", pilotName='" + pilotName + '\'' + ", status=" + status + ", flightStep=" + flightStep + '}';
    }
}
