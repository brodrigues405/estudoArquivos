package candidatos;

import java.util.Date;

public class Foto {
	
	private int id;
	private Date data;
	private String local;
	
	public Foto() {
		// TODO Auto-generated constructor stub
	}
	

	@Override
	public String toString() {
		return "Foto [id=" + id + ", data=" + data + ", local=" + local + "]";
	}


	public Foto(int id, Date data, String local) {
		this.id = id;
		this.data = data;
		this.local = local;
	}




	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Date getData() {
		return data;
	}
	public void setData(Date data) {
		this.data = data;
	}
	public String getLocal() {
		return local;
	}
	public void setLocal(String local) {
		this.local = local;
	}
	
	

}
