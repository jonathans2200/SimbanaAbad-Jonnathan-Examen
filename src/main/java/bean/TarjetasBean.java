/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.TarjetaFacade;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import model.Tarjeta;

/**
 *
 * @author jonat
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped

public class TarjetasBean implements Serializable {

    @EJB
    private TarjetaFacade ejbTarjeta;
    private List<Tarjeta> list;
    private int id;
    private int numeroTarjeta;
    private String nombreTitular;
    private Date fechaCaduca;
    private int codigoFerificacion;
    private int cvv;

    @PostConstruct
    public void init() {
    add();
        list = ejbTarjeta.buscarTodo();
    }

    public void add() {
        ejbTarjeta.crear(new Tarjeta(123456, "lucas", "2024-03-03", 342, 124));
        ejbTarjeta.crear(new Tarjeta(123234, "pedro", "2025-03-03", 753, 533));
        ejbTarjeta.crear(new Tarjeta(1234354, "juan", "20226-03-03", 6534, 124));
   
        
    }



}
