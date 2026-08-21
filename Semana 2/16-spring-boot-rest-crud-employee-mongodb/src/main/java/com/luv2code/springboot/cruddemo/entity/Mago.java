package com.luv2code.springboot.cruddemo.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "magos")
public class Mago {

    // define fields
    //
    // El id es String, no int: MongoDB genera un ObjectId (hexadecimal de 24
    // caracteres). No lleva @GeneratedValue — el driver lo asigna al insertar.
    @Id
    private String id;

    // Sin @Column: MongoDB no tiene esquema, así que el campo del documento se
    // llama igual que la propiedad Java. No hay nada que mapear.
    private String nombre;

    private String apellido;

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

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
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

    public void setCasa(String casa) {
        this.casa = casa;
    }

    // define toString
    @Override
    public String toString() {
        return "Mago{" +
                "id='" + id + '\'' +
                ", nombre='" + nombre + '\'' +
                ", apellido='" + apellido + '\'' +
                ", casa='" + casa + '\'' +
                '}';
    }
}
