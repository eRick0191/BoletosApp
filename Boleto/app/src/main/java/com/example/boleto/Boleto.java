package com.example.boleto;


public class Boleto {
    private int id;
    private String nombre;
    private double precio;
    private int tipo;
    private String fecha;
    private String destino;


    //Constructor vacio
    public Boleto() {
        this.id = 0;
        this.nombre = "";
        this.precio = 0;
        this.tipo = 0;
        this.fecha = "";
        this.destino = "";
    }

    //Constructor parametros
    public Boleto(int id, String nombre, double precio, int tipo, String fecha, String destino) {
        this.id = id;
        this.nombre = nombre;
        this.precio = precio;
        this.tipo = tipo;
        this.fecha = fecha;
        this.destino = destino;
    }

    //Constructor de copia
    public Boleto(Boleto boleto) {
        this.id = boleto.id;
        this.nombre = boleto.nombre;
        this.precio = boleto.precio;
        this.tipo = boleto.tipo;
        this.fecha = boleto.fecha;
        this.destino = boleto.destino;
    }
// Get y Set

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    //Metodos

    public double obtenerSubtotal (){
        if(this.tipo == 2){
            return this.precio *1.8;
        }else{
            return this.precio;
        }
    }

    public double obtenerIVA () {
        return this.obtenerSubtotal()*.16;
    }

    public double obtenerDescuento (int edad){
        if (edad > 60){
            return this.obtenerSubtotal()/2;
        }else{
            return 0;
        }
    }


    public double obtenerTotal (){
        return obtenerSubtotal() + obtenerIVA() ;
    }

}
