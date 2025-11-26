package dam.saruman.entity;

public class Enemigo {
    private int id;
    private String nombre;
    private String pais;
    private String afiliacion;

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
