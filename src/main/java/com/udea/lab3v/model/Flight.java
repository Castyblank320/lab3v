package com.udea.lab3v.model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Flight implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "idflight")
    private Long idflight;

    @Column(name = "nombreavion", nullable = false, length = 80)
    private @NonNull String nombreAvion;

    @Column(name = "numerovuelo", nullable = false, length = 80)
    private @NonNull String numeroVuelo;

    @Column(name = "origen", nullable = false, length = 80)
    private @NonNull String origen;

    @Column(name = "destino", nullable = false, length = 80)
    private @NonNull String destino;

    @Column(name = "capacidad", nullable = false, length = 80)
    private @NonNull int capacidad;

    @Column(name = "rating", nullable = false, length = 80)
    @Min(value = 1, message = "id shoud be more or than equals 1")
    @Max(value = 5, message = "id shoud be less or than equals 5" )
    private @NonNull int rating;

    @Column(name = "planvuelo", nullable = false, length = 80)
    private @NonNull long planVuelo;

    private Boolean cumplido;

    public Long getIdflight() {
        return idflight;
    }

    public void setIdflight(Long idflight) {
        this.idflight = idflight;
    }

    public @NonNull String getNombreAvion() {
        return nombreAvion;
    }

    public void setNombreAvion(@NonNull String nombreAvion) {
        this.nombreAvion = nombreAvion;
    }

    public @NonNull String getNumeroVuelo() {
        return numeroVuelo;
    }

    public void setNumeroVuelo(@NonNull String numeroVuelo) {
        this.numeroVuelo = numeroVuelo;
    }

    public @NonNull String getOrigen() {
        return origen;
    }

    public void setOrigen(@NonNull String origen) {
        this.origen = origen;
    }

    public @NonNull String getDestino() {
        return destino;
    }

    public void setDestino(@NonNull String destino) {
        this.destino = destino;
    }

    @NonNull
    public int getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(@NonNull int capacidad) {
        this.capacidad = capacidad;
    }

    @Min(value = 1, message = "id shoud be more or than equals 1")
    @Max(value = 5, message = "id shoud be less or than equals 5")
    @NonNull
    public int getRating() {
        return rating;
    }

    public void setRating(@Min(value = 1, message = "id shoud be more or than equals 1") @Max(value = 5, message = "id shoud be less or than equals 5") @NonNull int rating) {
        this.rating = rating;
    }

    @NonNull
    public long getPlanVuelo() {
        return planVuelo;
    }

    public void setPlanVuelo(@NonNull long planVuelo) {
        this.planVuelo = planVuelo;
    }

    public Boolean getCumplido() {
        return cumplido;
    }

    public void setCumplido(Boolean cumplido) {
        this.cumplido = cumplido;
    }
}
