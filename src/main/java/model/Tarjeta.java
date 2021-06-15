/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author jonat
 */
@Entity
public class Tarjeta implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private int numeroTarjeta;
    private String nombreTitular;
    private String fechaCaduca;
    private int codigoFerificacion;

    private int cvv;

    public Tarjeta() {
    }

    public Tarjeta(int numerotarjeta, String nombreTitular, String fechaCaduca, int codigoFerificacion, int cvv) {
        this.numeroTarjeta = numerotarjeta;
        this.nombreTitular = nombreTitular;
        this.fechaCaduca = fechaCaduca;
        this.codigoFerificacion = codigoFerificacion;
        this.cvv = cvv;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNumeroTarjeta() {
        return numeroTarjeta;
    }

    public void setNumeroTarjeta(int numeroTarjeta) {
        this.numeroTarjeta = numeroTarjeta;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getFechaCaduca() {
        return fechaCaduca;
    }

    public void setFechaCaduca(String fechaCaduca) {
        this.fechaCaduca = fechaCaduca;
    }

    public int getCodigoFerificacion() {
        return codigoFerificacion;
    }

    public void setCodigoFerificacion(int codigoFerificacion) {
        this.codigoFerificacion = codigoFerificacion;
    }

  
    public int getCvv() {
        return cvv;
    }

    public void setCvv(int cvv) {
        this.cvv = cvv;
    }

}
