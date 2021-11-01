/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Solucion_Retos;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author USUARIO
 */
@Repository
public class RepositorioBoat {
    
    @Autowired
    private InterfaceBoat crud;

    public List<Boat> getAll(){
        return (List<Boat>) crud.findAll();
    }

    public Optional<Boat> getBarco(int id){
        return crud.findById(id);
    }

    public Boat save(Boat barco){
        return crud.save(barco);
    }
    public void delete(Boat barco){
        crud.delete(barco);
    }
    
}
