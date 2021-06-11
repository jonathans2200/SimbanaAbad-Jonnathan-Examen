/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.PedidoFacade;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import model.Pedido;

/**
 *
 * @author jonat
 */
@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class PedidoBean implements Serializable {

    @EJB
    private PedidoFacade ejbPedido;
    private List<Pedido> list;
    private int numero;

    private String fecha;
    private int temp;
    private String nombreCliente;
    private String observacion;
    private double subtotal;
    private double iva;
    private double total;

    public PedidoBean() {
    }

   public String add() {

        ejbPedido.crear(new Pedido(fecha, nombreCliente, observacion, subtotal, iva, total));
       
        list = ejbPedido.buscarTodo();
        return null;
    }


    @PostConstruct
    public void init() {
        list = ejbPedido.buscarTodo();
    }

    public PedidoFacade getEjbPedido() {
        return ejbPedido;
    }

    public void setEjbPedido(PedidoFacade ejbPedido) {
        this.ejbPedido = ejbPedido;
    }

    public List<Pedido> getList() {
        return list;
    }

    public void setList(List<Pedido> list) {
        this.list = list;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(double subtotal) {
        this.subtotal = subtotal;
    }

    public double getIva() {
        return iva;
    }

    public void setIva(double iva) {
        this.iva = iva;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

}
