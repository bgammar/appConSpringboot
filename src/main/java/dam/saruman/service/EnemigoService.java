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

    public Enemigo editar(Enemigo enemigo) {
        if(this.enemigoRepository.existsById((long) enemigo.getId())){
            return (Enemigo) this.enemigoRepository.save(enemigo);
        }else{
            System.out.println("No se ha encontrado el enemigo "+enemigo.getNombre());
            return null;
        }

    }

    public boolean borrar(Long id) {
        if(this.enemigoRepository.existsById(id)){
            this.enemigoRepository.deleteById(id);
            return true;
        }else{
            System.out.println("No se ha encontrado el enemigo con ID "+id);
            return false;
        }
    }

}
