/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Solucion_Retos;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author USUARIO
 */
@Service
public class ServiciosBoat {
     @Autowired
    private RepositorioBoat metodosCrud;
    private int barcoId;

    public List<Boat> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Boat> getBarco(int barcoId) {
        return metodosCrud.getBarco(barcoId);
    }

    public Boat save(Boat barco){
        if(barco.getId()==null){
            return metodosCrud.save(barco);
        }else{
            Optional<Boat> e=metodosCrud.getBarco(barco.getId());
            if(e.isEmpty()){
                return metodosCrud.save(barco);
            }else{
                return barco;
            }
        }
    }

    public Boat update(Boat barco){
        if(barco.getId()!=null){
            Optional<Boat> e=metodosCrud.getBarco(barco.getId());
            if(!e.isEmpty()){
                if(barco.getName()!=null){
                    e.get().setName(barco.getName());
                }
                if(barco.getBrand()!=null){
                    e.get().setBrand(barco.getBrand());
                }
                if(barco.getRooms()!=null){
                    e.get().setRooms(barco.getRooms());
                }
                if(barco.getDescription()!=null){
                    e.get().setDescription(barco.getDescription());
                }
                if(barco.getCategory()!=null){
                    e.get().setCategory(barco.getCategory());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return barco;
            }
        }else{
            return barco;
        }
    }


    public boolean deleteCabin(int cabinId) {
        Boolean aBoolean = getBarco(barcoId).map(cabin -> {
            metodosCrud.delete(cabin);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
