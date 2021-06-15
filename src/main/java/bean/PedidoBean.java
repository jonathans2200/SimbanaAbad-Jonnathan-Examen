/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bean;

import ejb.ComidaFacade;
import ejb.PedidoFacade;
import ejb.TarjetaFacade;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;
import model.Comida;
import model.Pedido;
import model.Tarjeta;

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

    @EJB
    private TarjetaFacade ejbTarjeta;

    @EJB
    private ComidaFacade ejbComida;

    private Pedido pedido;
    private int auxCodigo;
    private double subtotal;
    private double iva;
    private double total;
    private List<Comida> listaComida;
    private List<Pedido> listaPedidos;
    private List<Tarjeta> listaTarjeta;
    private String buscar;
    private String tarjeta;
    private String nombre;
    private double precio;

    @PostConstruct
    public void init() {
        try {
            listaTarjeta = new ArrayList<Tarjeta>();
            pedido = new Pedido();
            listaComida = new ArrayList<Comida>();
           
            subtotal = 0;
            auxCodigo = 0;
            iva = 0;
            total = 0;

            // crearTarjetas();
        } catch (Exception ex) {
            Logger.getLogger(PedidoBean.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String agregarComida() {

        Comida comida = new Comida();
        comida.setNombre(nombre);
        comida.setPrecio(precio);

        this.listaComida.add(comida);
        for (int i = 0; i < listaComida.size(); i++) {
            this.subtotal += this.listaComida.get(i).getPrecio();
        }
        iva = this.subtotal * 0.12;
        total = subtotal - iva;
        return "";
    }

    public String realiarPedido() {
        this.pedido.setTotal(total);
        this.pedido.setIva(iva);
        this.pedido.setFecha("2021-02-02");
        this.pedido.setComidas(this.listaComida);
        Comida comida;
        for (int i = 0; i < pedido.getComidas().size(); i++) {
            comida = new Comida();
            comida = pedido.getComidas().get(i);
            comida.setPedido(pedido);
            ejbComida.crear(comida);
        }
        ejbPedido.crear(pedido);
        return "";

    }

    public int generarNumeroTarjeta() {
        int numero = (int) (Math.random() * 99999 + 10000);
        return numero;
    }

    public int generarCVV() {
        int numero = (int) (Math.random() * 999 + 100);
        return numero;
    }

    public int generarValidacion() {
        int numero = (int) (Math.random() * 9999 + 1000);
        return numero;
    }

    public String crearTarjetas() {
        auxCodigo = generarNumeroTarjeta();
        ejbTarjeta.crear(new Tarjeta(auxCodigo, "jonathan Simbana", "2023-11-10", generarValidacion(), generarCVV()));
        buscarTarjeta(auxCodigo);
        listaTarjeta = ejbTarjeta.buscarTodo();

        return null;
    }

    public String buscarTarjeta(int aux) {
        try {
            Tarjeta tar = ejbTarjeta.buscarXNumero(Integer.valueOf(aux));
            tarjeta = tar.getNombreTitular() + " " + tar.getNumeroTarjeta();
            this.pedido.setTarjeta(tar);

        } catch (Exception e) {
            // TODO: handle exception
            tarjeta = "Error";
        }
        return "";
    }

    public List<Pedido> obtener(int numero) {
        try {
            return ejbTarjeta.generar(numero);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;

    }

    public String buscarTarjeta() {
        try {
            Tarjeta tar = ejbTarjeta.buscarXNumero(Integer.valueOf(buscar));
            this.listaPedidos = obtener(Integer.valueOf(buscar));

            tarjeta = tar.getNombreTitular() + " " + tar.getNumeroTarjeta();
            this.pedido.setTarjeta(tar);

        } catch (Exception e) {
            // TODO: handle exception
            tarjeta = "TARJETA NO ENCONTRADA";
        }
        return "";
    }

    public Pedido getPedido() {
        return pedido;
    }

    public List<Pedido> getListaPedidos() {
        return listaPedidos;
    }

    public void setListaPedidos(List<Pedido> listaPedidos) {
        this.listaPedidos = listaPedidos;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
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

    public int getAuxCodigo() {
        return auxCodigo;
    }

    public void setAuxCodigo(int auxCodigo) {
        this.auxCodigo = auxCodigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public String getBuscar() {
        return buscar;
    }

    public PedidoFacade getEjbPedido() {
        return ejbPedido;
    }

    public void setEjbPedido(PedidoFacade ejbPedido) {
        this.ejbPedido = ejbPedido;
    }

    public TarjetaFacade getEjbTarjeta() {
        return ejbTarjeta;
    }

    public void setEjbTarjeta(TarjetaFacade ejbTarjeta) {
        this.ejbTarjeta = ejbTarjeta;
    }

    public ComidaFacade getEjbComida() {
        return ejbComida;
    }

    public void setEjbComida(ComidaFacade ejbComida) {
        this.ejbComida = ejbComida;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }

    public String getTarjeta() {
        return tarjeta;
    }

    public void setTarjeta(String tarjeta) {
        this.tarjeta = tarjeta;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public List<Comida> getListaComida() {
        return listaComida;
    }

    public void setListaComida(List<Comida> listaComida) {
        this.listaComida = listaComida;
    }

    public List<Tarjeta> getListaTarjeta() {
        return listaTarjeta;
    }

    public void setListaTarjeta(List<Tarjeta> listaTarjeta) {
        this.listaTarjeta = listaTarjeta;
    }

}
