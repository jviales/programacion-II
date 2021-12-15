package services;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Lector {
    private String nombreArchivo;
    public Lector(String nombre){
        this.nombreArchivo = nombre;
    }
    public String Leer() throws Exception{
        String texto = "";
        try{
            FileReader myFileReader = new FileReader(this.nombreArchivo);
            int posicionCaracter = myFileReader.read();
            while(posicionCaracter != -1){
                texto += (char)posicionCaracter;
                posicionCaracter = myFileReader.read();
            }
            myFileReader.close();
        }catch(FileNotFoundException notFoundException){
            throw new FileNotFoundException("No se encontro el archivo");
        }catch(IOException ioException){
            throw new IOException("Error desconocido de entrada salida: " + ioException.getMessage());
        }catch(Exception ex){
            throw new Exception("Error desconocido: " + ex.getMessage());
        }finally{
            return texto;
        }
    }
    public void leerLineaPorLinea() throws Exception{
        try{
            File file = new File(this.nombreArchivo);
            FileReader myReader = new FileReader(file);
            BuffereReader myBuffer = new BufferedReader(myReader);
            String lineaDeTexto = myBuffer.readLine();
            while(lineaDeTexto != null){
                System.out.println(lineaDeTexto);
                lineaDeTexto = myBuffer.readLine();
            }
            myReader.close();
        }catch(FileNotFoundException notFoundException){
            throw new FileNotFoundException("No se encontro el archivo");
        }catch(IOException ioException){
            throw new IOException("Error desconocido de entrada salida: " + ioException.getMessage());
        }catch(Exception ex){
            throw new Exception("Error desconocido: " + ex.getMessage());
        }

    }
    public String leerTodasLasLineas() throws Exception{
        StringBuffer stringBuffer = new StringBuffer();
        try{
            File file = new File(this.nombreArchivo);
            FileReader myReader = new FileReader(file);
            BufferedReader myBuffer = new BufferedReader(myReader);
            String lineaDeTexto = myBuffer.readLine();
            while(lineaDeTexto != null){
                stringBuffer.append(lineaDeTexto + "\n");
                lineaDeTexto = myBuffer.readLine();
            }
            myReader.close();
        }catch(FileNotFoundException notFoundException){
            throw new FileNotFoundException("No se encontro el archivo");
        }catch(IOException ioException){
            throw new IOException("Error desconocido de entrada salida: " + ioException.getMessage());
        }catch(Exception ex){
            throw new Exception("Error desconocido: " +ex.getMessage());
        }finally{
            return stringBuffer.toString();
        }
    }
    
}
