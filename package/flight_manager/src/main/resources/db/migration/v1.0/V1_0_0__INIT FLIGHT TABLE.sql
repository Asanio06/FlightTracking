CREATE TYPE flight_step_enum AS ENUM (
    'none',
    'ground',
    'boarding',
    'pushback',
    'block_on',
    'taxi_out',
    'takeoff',
    'initial_climb',
    'climb',
    'cruise',
    'descent',
    'approach',
    'landing',
    'taxi_in',
    'block_off',
    'deboarding',
    'parked',
    'emergency',
    'crashed',
    'diversion'
    );

CREATE TYPE flight_status_enum AS ENUM (
    'in_progress',
    'deleted',
    'finished'
    'finished'
    );


CREATE TABLE flight
(
    id                       UUID   NOT NULL,
    created_date             BIGINT NOT NULL,
    modified_date            BIGINT,
    flight_number            VARCHAR(255),
    aircraft_icao            VARCHAR(255),
    departure_icao           VARCHAR(255),
    arrival_icao             VARCHAR(255),
    cruise_level             INTEGER,
    expected_departure_time  TIMESTAMP WITHOUT TIME ZONE,
    expected_arrival_time    TIMESTAMP WITHOUT TIME ZONE,
    pilot_name               VARCHAR(255),
    status                   flight_status_enum,
    flight_step              flight_step_enum,
    aircraft_state_histories JSONB,
    CONSTRAINT pk_flight PRIMARY KEY (id)
);