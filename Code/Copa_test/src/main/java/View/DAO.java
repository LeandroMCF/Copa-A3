/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package View;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author leand
 */
public class DAO {
    public boolean existe(Usuario usuario) throws Exception{
        String sql="SELECT * FROM tb_users WHERE nome=? AND senha=?";
        try(Connection conn=ConexaoBD.obterConexao()){
                PreparedStatement ps = conn.prepareStatement(sql);
                    ps.setString(1,usuario.getNome());
                    ps.setString(2,usuario.getSenha());
                    try(ResultSet rs = ps.executeQuery()){
                        return rs.next();
                    }        
        }              
    }
    
    public void inserirUsuario (Usuario usuario) throws Exception{ 
        String sql = "INSERT INTO tb_users (nome, email, senha) VALUES (?, ?, ?);"; 
        try (Connection conexao = ConexaoBD.obterConexao(); 
                PreparedStatement ps = conexao.prepareStatement(sql)){ 
            ps.setString(1, usuario.getNome()); 
            ps.setString(2, usuario.getEmail());
            ps.setString(3, usuario.getSenha());
            ps.execute(); 
        } 
    }  
    
    public Usuario [] obterUsuario () throws Exception{ 
        String sql = "SELECT * FROM tb_users"; 
        try (Connection conn = ConexaoBD.obterConexao();
                
        PreparedStatement ps = conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY); 
        
        ResultSet rs = ps.executeQuery()){ 
            int totalDeUsuarios = rs.last () ? rs.getRow() : 0; 
            
            Usuario [] usuarios = new Usuario[totalDeUsuarios]; 
            rs.beforeFirst(); 
            int contador = 0;

            while (rs.next()){ 
                int id = rs.getInt("id"); 
                String nome = rs.getString("nome"); 
                String email = rs.getString ("email");
                usuarios[contador++] = new Usuario (id, nome, email); 
            }
            
            return usuarios; 
        } 
    }
}
