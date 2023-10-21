package com.example.recyclerview.Repository;

import com.example.recyclerview.Model.TrabajadorModel;

import java.util.ArrayList;
import java.util.List;

public class TrabajadorRepository {

    public static List<TrabajadorModel> lstTrabajador;

    public TrabajadorRepository(){
        lstTrabajador = new ArrayList<>();
    }

    public void add(TrabajadorModel trabajadorModel){lstTrabajador.add(trabajadorModel);
    }

    public List<TrabajadorModel> getAll(){
        return lstTrabajador;
    }
}
