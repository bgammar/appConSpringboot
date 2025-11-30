package dam.saruman.entity;

import jakarta.persistence.*;

@Entity
@Table(name="enemigosestado")
public class Enemigo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column
    private String nombre;

    @Column
    private String pais;

    @Column
    private String afiliacion;

    public Enemigo() {
    }

    public Enemigo(int id, String nombre, String pais, String afiliacion) {
        this.id = id;
        this.nombre = nombre;
        this.pais = pais;
        this.afiliacion = afiliacion;
    }

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

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public String getAfiliacion() {
        return afiliacion;
    }

    public void setAfiliacion(String afiliacion) {
        this.afiliacion = afiliacion;
    }
}
