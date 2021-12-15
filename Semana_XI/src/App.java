import services.Lector;
import services.Escritor;

public class App {
    public static void main(String[] args) throws Exception {
        Lector lector = new Lector("../bin.Archivo.txt");
        String texto = lector.leer();
        System.out.println(texto);
    }
    Escritor escritor = new Escritor("../bin.Archivo.txt");
    escritor.escribirLetraPorLetra("Asi escribe el escritor caracter por caracter");
}
