package dev.danvega.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import jakarta.persistence.Embeddable;


@Data
@AllArgsConstructor
@Embeddable
public class Geo {

    private String lat;
    private String lng;

    public Geo() {}
}
