package candidatos;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import util.FotoDao;

public class Album {
	
	private List<Foto> fotos;
	
	
	public void adicionar(int id, Date data, String local){
		initAlbum(); 
		this.fotos.add(new Foto(id,data,local));
	}
	
	public void listarFotos(){
		for (Foto foto : this.fotos) {
			 System.out.println(foto); 
		}
	}
	
	
	public void iniserirAlbum(){
		
		for (Foto foto : this.fotos) {
			 inserirFoto(foto);
		}
	}
	
	
	public void inserirFoto(Foto foto){
		
		new FotoDao().inserirFoto(foto);
	}
	
	
	
	private void initAlbum(){
		if(this.fotos == null){
			this.fotos = new ArrayList<Foto>();
		}
	}
	
	
	
	
	
	

}
