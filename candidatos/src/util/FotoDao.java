package util;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import candidatos.Foto;

public class FotoDao {
	
	private volatile Connection conn = null;
	private PreparedStatement stmt = null;
	
	private void initConexao(){
		if(this.conn == null){
			this.conn = ConnectionSingleton.getConnection();
		}
	}
	

	public FotoDao() {
		initConexao();
	}
	
	
	public boolean inserirFoto(Foto foto){
		
		boolean isInsert = false;
		String sql = "INSERT INTO softblue.tratamento VALUES(?,?,?)";
		
		try {
			 stmt = conn.prepareStatement(sql);
			 stmt.setInt(1, foto.getId());
			 stmt.setDate(2, new java.sql.Date(foto.getData().getTime()));
			 stmt.setString(3, foto.getLocal());
			 isInsert = stmt.execute();

		} catch (SQLException e) {
		e.printStackTrace();
		} finally{
			
		}
		
		
		return isInsert;
	}
	
	

}
