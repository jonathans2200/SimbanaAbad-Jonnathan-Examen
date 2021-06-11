/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.ComidaFacade;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import model.Comida;
import model.Pedido;

/**
 *
 * @author jonat
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class ComidaBean implements Serializable {

    @EJB
    private ComidaFacade ejbComida;
    private double total;
    private String nombre;
    private Double precio;
    private List<Comida> list;
    private Pedido pedido;
    private Double subtotal;

    public ComidaBean() {

    }

    @PostConstruct
    public void init() {
        list = ejbComida.buscarTodo();
        total = 0;
        subtotal = 0.0;

    }

    public String add() {
        ejbComida.crear(new Comida(nombre, precio, pedido));
        total += precio;
        subtotal=total/0.12;
        list = ejbComida.buscarTodo();
        return null;
    }

    public ComidaFacade getEjbComida() {
        return ejbComida;
    }

    public void setEjbComida(ComidaFacade ejbComida) {
        this.ejbComida = ejbComida;
    }

    public String getNombre() {
        return nombre;
    }

    public Double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(Double subtotal) {
        this.subtotal = subtotal;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public List<Comida> getList() {
        return list;
    }

    public void setList(List<Comida> list) {
        this.list = list;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

}
