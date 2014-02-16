package candidatos;

import java.io.File;

public class Aplicacao {
	
	 private static File f = new File("imagens");
	
	public static void main(String[] args) {
		
		
		
		Organizador organizador = new Organizador();
		Album album = organizador.carregarFotos(f);
		
		album.listarFotos();
		
		
		
		
		
		
	}

}
