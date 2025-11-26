package dam.saruman.controller;

import dam.saruman.entity.Enemigo;
import dam.saruman.service.EnemigoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/api"})
public class EnemigoController {
    @Autowired
    private EnemigoService enemigoService;

    public EnemigoController() {
    }

    @GetMapping({"/enemigo"})
    public List<Enemigo> obtenerEnemigos() {
        return this.enemigoService.obtenerTodos();
    }

    @PostMapping({"/enemigo"})
    public Enemigo crearEnemigo(@RequestBody Enemigo enemigo) {
        return this.enemigoService.guardar(enemigo);
    }
}