package mx.desarrollo.sauap.negocio.delegate;

import mx.desarrollo.sauap.dao.ProfesorDAO;
import mx.desarrollo.sauap.entity.Profesores;
import mx.desarrollo.sauap.integration.ServiceLocator;
public class ProfesorDelegate {

    private static ServiceLocator serviceLocator;
    public void guardarProfesor(Profesores profesor){
        validarVacio(profesor);
        validarLongitud(profesor);
        validarRFC(profesor.getRfc());
        ServiceLocator.getInstanceProfesorDAO().guardarProfesor(profesor);
    }
    public void validarLongitud(Profesores profesor){
            validarTexto("nombre", profesor.getNombre(), 50);
            validarTexto("Apellido Materno", profesor.getApellidoMaterno(), 50);
            validarTexto("Apellido Paterno", profesor.getApellidoPaterno(), 50);
    }
    public void validarRFC(String RFC){
        if(!RFC.trim().toUpperCase().matches("^[A-ZÑ&]{3,4}\\d{6}[A-Z0-9]{3}$")){
            throw new IllegalArgumentException("El RFC no cumple con el formato establecido");
        }
    }
    public void validarVacio(Profesores profesor){
        validarTextoVacio("nombre", profesor.getNombre());
        validarTextoVacio("Apellido Materno", profesor.getApellidoMaterno());
        validarTextoVacio("Apellido Paterno", profesor.getApellidoPaterno());
        validarTextoVacio("RFC", profesor.getRfc());
    }
    public void validarTexto(String campo, String texto, int max){
        if(texto.length()>max){
            throw new IllegalArgumentException("El " + campo + "No puede superar los" + max + "caracteres");
        }
    }
    public void validarTextoVacio(String campo, String texto){
        if(texto == null || texto.trim().isEmpty()){
            throw new IllegalArgumentException("El " + campo + "No puede estar vacio");
        }
    }
}
