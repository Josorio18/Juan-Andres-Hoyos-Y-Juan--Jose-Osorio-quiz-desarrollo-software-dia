package demo;

import java.util.UUID;

public class Motocicleta {
    private String id;
    private String marcaMotocicleta;
    private String placaMotocicleta;
    private int cilindrajeMotocicleta;
    private double precioMotocicleta;
    private String colorMotocicleta;

    // Constructor
    public Motocicleta() {
        this.id = UUID.randomUUID().toString(); // Generar ID aleatorio
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getMarcaMotocicleta() {
        return marcaMotocicleta;
    }

    public void setMarcaMotocicleta(String marcaMotocicleta) {
        this.marcaMotocicleta = marcaMotocicleta;
    }

    public String getPlacaMotocicleta() {
        return placaMotocicleta;
    }

    public void setPlacaMotocicleta(String placaMotocicleta) {
        this.placaMotocicleta = placaMotocicleta;
    }

    public int getCilindrajeMotocicleta() {
        return cilindrajeMotocicleta;
    }

    public void setCilindrajeMotocicleta(int cilindrajeMotocicleta) {
        this.cilindrajeMotocicleta = cilindrajeMotocicleta;
    }

    public double getPrecioMotocicleta() {
        return precioMotocicleta;
    }

    public void setPrecioMotocicleta(double precioMotocicleta) {
        this.precioMotocicleta = precioMotocicleta;
    }

    public String getColorMotocicleta() {
        return colorMotocicleta;
    }

    public void setColorMotocicleta(String colorMotocicleta) {
        this.colorMotocicleta = colorMotocicleta;
    }
}