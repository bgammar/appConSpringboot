package dam.saruman.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "enemigos")
public class Enemigo {
    @Id
    private String id;

    @Indexed(unique = true)
    private String nombre;

    private String pais_origen;

    private String afiliacion;

    public Enemigo() {
    }

    public Enemigo(String id, String nombre, String pais, String afiliacion) {
        this.id = id;
        this.nombre = nombre;
        this.pais_origen = pais;
        this.afiliacion = afiliacion;
    }

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

    public String getPais() {
        return pais_origen;
    }

    public void setPais(String pais) {
        this.pais_origen = pais;
    }

    public String getAfiliacion() {
        return afiliacion;
    }

    public void setAfiliacion(String afiliacion) {
        this.afiliacion = afiliacion;
    }

    @Override
    public String toString(){
        return "Enemigo{"+
                "id='"+id+'\''+
                ", nombre='" +nombre+ '\''+
                ", pais='" +pais_origen+ '\''+
                ", afiliacion='" +afiliacion+ '\''+
                '}';
    }
}
