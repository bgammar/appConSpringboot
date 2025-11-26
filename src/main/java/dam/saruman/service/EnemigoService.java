package dam.saruman.service;

import dam.saruman.entity.Enemigo;
import dam.saruman.repository.EnemigoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.PrintStream;
import java.util.List;

@Service
public class EnemigoService {
    @Autowired
    private EnemigoRepository enemigoRepository;

    public List<Enemigo> obtenerTodos(){
        List<Enemigo> enemigos = enemigoRepository.findAll();
        if(enemigos.isEmpty()){
            System.out.println("Acho que esto ta to triste");
        }else{
            System.out.println("Jefe esto va como un maquina ");
            enemigos.forEach(enemigo -> {
                PrintStream var10000 = System.out;
                String var10001 = String.valueOf(enemigo.getId());
                var10000.println("ID" + var10001 + " nombre " + enemigo.getNombre());
            });
        }
        return enemigos;
    }

    public Enemigo guardar(Enemigo enemigo) {
        return (Enemigo)this.enemigoRepository.save(enemigo);
    }

}
