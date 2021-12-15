package services;

import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Escritor extends Lector{
    public Escritor(String nombre){
        super(nombre);
    }
    public void escribirLetraPorLetra(String texto) throws  Exception{
        try{
            FileWriter miEscritor = new FileWriter(this.nombreArchivo);
            for(int i = 0; i <= texto.length()-1; i++){
                miEscritor.write(texto.charAt(i));
            }
            miEscritor.close();
        }catch(FileNotFoundException notFoundException){
            throw new FileNotFoundException("No se encontro el archivo");
        }catch(IOException ioException){
            throw new IOException("Error desconocido de entrada salida: " + ioException.getMessage());
        }catch(Exception ex){
            throw new Exception("Error desconocido: " + ex.getMessage());
        }finally{
            this.leerLineaPorLinea();
        }
    }
}