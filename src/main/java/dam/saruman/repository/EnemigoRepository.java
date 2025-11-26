package dam.saruman.repository;

import dam.saruman.entity.Enemigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// ACCESO A LOS DATOS
@Repository
public interface EnemigoRepository extends JpaRepository<Enemigo, Long> {
    List<Enemigo> findByNombre(String nombre);

    //Consulta personalizada
    //@Query('SELECT * FROM ASFA WHERE AAAAA');

    //List<Enemigo> findEnemigosRojos(@Param('genero'));

}
