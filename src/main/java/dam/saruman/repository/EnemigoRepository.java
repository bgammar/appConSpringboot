package dam.saruman.repository;

import dam.saruman.entity.Enemigo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

// ACCESO A LOS DATOS
@Repository
public interface EnemigoRepository extends MongoRepository<Enemigo, String> {
    List<Enemigo> findByNombre(String nombre);

    //Consulta personalizada
    //@Query('SELECT * FROM ASFA WHERE AAAAA');

    //List<Enemigo> findEnemigosRojos(@Param('genero'));

}
