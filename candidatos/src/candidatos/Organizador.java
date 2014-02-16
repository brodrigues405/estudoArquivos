package candidatos;

import java.io.File;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Organizador {
	

	public static Date formataData(String data){
		
		DateFormat df = new SimpleDateFormat("yyyyMMdd");
		
		Date dfor = null;
		try {
			dfor = df.parse(data);
		} catch (ParseException e) {
			e.printStackTrace();
		}

		return dfor; 
	}


	 public Album carregarFotos(File diretorio){
		 	
		File[] arquivos = diretorio.listFiles();
		
		Album album = new Album();
		
		for (File file : arquivos) {
			
			String nomeArquivo = file.getName(); 
			nomeArquivo = nomeArquivo.substring(0, nomeArquivo.length() - 4);
			
			Scanner scan = new Scanner(nomeArquivo);
			
			scan.useDelimiter("[-_]");
			
			String token = null;
			
			token = scan.next();
			int id = 0;
			try {
				 id = Integer.parseInt(token.substring(3));
			} catch (NumberFormatException e) {
				new Exception("Erro ao Converter id do arquivo...");
			}
			
			token = scan.next(); 
			
			Date data = formataData(token);
			
			String local = null;
			
			if(scan.hasNext()){
				local = scan.next();
			}
			
			scan.close();
			
			album.adicionar(id, data, local);
		
		}

		 return album;
	 }
	
}
