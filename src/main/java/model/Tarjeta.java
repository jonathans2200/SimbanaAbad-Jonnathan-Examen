/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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

    public Tarjeta(int numeroTarjeta, String nombreTitular, String fechaCaduca, int codigoFerificacion, int cvv) {
        this.numeroTarjeta = numeroTarjeta;
        this.nombreTitular = nombreTitular;
        this.fechaCaduca = fechaCaduca;
        this.codigoFerificacion = codigoFerificacion;
        this.cvv = cvv;
    }

}
