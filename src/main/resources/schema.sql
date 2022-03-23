CREATE TABLE parking_spot (
    id SERIAL NOT NULL,
    parking_spot_type VARCHAR(10),
    PRIMARY KEY(id)
);

CREATE TABLE parking_sensor (
    id SERIAL NOT NULL,
    parking_spot_id INTEGER REFERENCES parking_spot(id) ON UPDATE CASCADE ON DELETE CASCADE,
    occupied BOOLEAN NOT NULL,
    PRIMARY KEY(id)
);