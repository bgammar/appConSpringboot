package dam.saruman.controller;

import dam.saruman.entity.Enemigo;
import dam.saruman.service.EnemigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EnemigoController {
    @Autowired
    private EnemigoService enemigoService;

    public EnemigoController() {
    }

    @GetMapping("/enemigo")
    public List<Enemigo> obtenerEnemigos() {
        return this.enemigoService.obtenerTodos();
    }

    @PostMapping("/enemigo")
    public Enemigo crearEnemigo(@RequestBody Enemigo enemigo) {
        System.out.println("Guardando enemigo ------------ "+enemigo.getNombre());
        return this.enemigoService.guardar(enemigo);
    }

    @PutMapping("/enemigo")
    public Enemigo editarEnemigo(@RequestBody Enemigo enemigo) {
        System.out.println("Editando enemigo enemigo ------------ "+enemigo.getNombre());
        return this.enemigoService.editar(enemigo);
    }

    @DeleteMapping("/enemigo")
    public boolean borrarEnemigo(@RequestBody Long id) {
        System.out.println("Borrando enemigo enemigo con ID ------------ "+id);
        boolean resultado = this.enemigoService.borrar(id);
        if(resultado){
            System.out.println("BORRADO EXITOSO");
        }else{
            System.out.println("NO SE HA PODIDO BORRAR");
        }
        return resultado;
    }
}