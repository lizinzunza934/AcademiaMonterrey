package com.luv2code.springboot.cruddemo.entity;

import jakarta.persistence.*;

@Entity
@Table(name="magos")
public class Mago {

    // define fields
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name="nombre")
    private String nombre;

    @Column(name="apellido")
    private String apellido;

    @Column(name="casa")
    private String casa;


    // define constructors
    public Mago() {

    }

    public Mago(String nombre, String apellido, String casa) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.casa = casa;
    }

    // define getter/setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String firstName) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getCasa() {
        return casa;
    }

    public void setCasa(String email) {
        this.casa = casa;
    }

    // define toString
    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", casa='" + casa + '\'' +
                '}';
    }
}








