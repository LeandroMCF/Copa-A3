package minhatela;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DAO {
    public boolean exists(UsersDomain user) throws Exception{
        String sql="SELECT * FROM tb_usuario WHERE nome=? AND senha=?";
        try(Connection conn=ConextionString.obterConexao()){
                PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setString(1,user.getNome());
                    ps.setString(2,user.getSenha());
                    try(ResultSet rs = ps.executeQuery()){
                        return rs.next();
                    }        
        }              
    }
} 
