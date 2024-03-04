/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.ArrayList;
import java.util.List;
import mx.desarrollo.DAO.UnidadAprendizajeDAO;
import mx.desarrollo.entidad.UnidadAprendizaje;

/**
 *
 * @author lukki
 */
public class test {
    public static void main(String[] args) {
        List<UnidadAprendizaje> listaUnidad = new ArrayList();
        UnidadAprendizajeDAO unidadDao = new UnidadAprendizajeDAO();
        listaUnidad = unidadDao.findAll();
        
        for(UnidadAprendizaje us : listaUnidad){
            System.out.println("Correo: " + us.getNombreUnidad());
        }
    }
}
