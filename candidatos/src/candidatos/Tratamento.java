package candidatos;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Tratamento {
	
	private static final int ID    = 0;
	private static final int DATA  = 1;
	private static final int LOCAL = 2;
	
	
	public static void main(String[] args) {
		Album album = new Tratamento().carregarObjeto("candidatos.txt");
		
		album.iniserirAlbum(); 
		
		
	}
	
	
	public Album carregarObjeto(String arq){
		
		File file = new File(arq);
		
		System.out.println("Lendo arquivo,  " + file.getName() );
		System.out.println("----------------------------------");
		Scanner scan = null;
		

		Album album = new Album();
			
		try {
			scan = new Scanner(file);
			
			while(scan.hasNext()){
				
				String token = null;
				
				token = scan.nextLine();
				
				token = token.substring(0, token.length() - 4);
				
				String [] colunas = token.split("[-_]");
				
				
				for (; ; ) {
					 
					
					int id = Integer.parseInt(colunas[ID].substring(4));
					
					Date data = null;
					try {
						data = formatarData(colunas[DATA]);
					} catch (Exception e) {
						new Exception("Erro ao converter a data!!");
					}
					
					String local = null; 
					
					try{
						if(colunas[LOCAL] != null){
							local = colunas[LOCAL];
						}
					}catch(ArrayIndexOutOfBoundsException e){
						local = "";
					}

					album.adicionar(id, data, local);
					break;
				}
			
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		scan.close();

		return album;
	}
	
	
	public static Date formatarData(String data) throws ParseException{
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
		
		return sdf.parse(data); 
	}
	

}
