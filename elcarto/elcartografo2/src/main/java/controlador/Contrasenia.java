/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;
import java.security.MessageDigest;
/**
 *
 * @author el3ctrix
 */
public class Contrasenia {
    /**
     * Clase que usa el algoritmo MD5 para encriptar contraseñas.
     * @param contra la contraseña a encriptar
     * @return la contraseña encriptada
     * @throws Exception no algorithmexception
     */
    public static String encripta(String contra) throws Exception{
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(contra.getBytes());
        byte[] bytes = md.digest();
        StringBuilder sb = new StringBuilder();
        for(int i=0; i< bytes.length ;i++){
            sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
        }
        return sb.toString();
    }
}
