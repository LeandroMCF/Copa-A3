/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

import Domain.Chave;
import Domain.Players;
import Domain.Times;
import Settings.ConexaoBD;
import Domain.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

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
    
    public Usuario [] obterUsuarios () throws Exception{
        String sql = "SELECT * FROM tb_users"; 
        try (Connection conn = ConexaoBD.obterConexao(); 
            PreparedStatement ps = 
            conn.prepareStatement(sql, 
                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_READ_ONLY); 
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
    
    //times
    
    public void inserirTimes (Times times) throws Exception{ 
        String sql = "INSERT INTO tb_times (nome, pontos, status) VALUES (?, 0, 1);"; 
        try (Connection conexao = ConexaoBD.obterConexao(); 
                PreparedStatement ps = conexao.prepareStatement(sql)){ 
            ps.setString(1, times.getNome()); 
            ps.execute(); 
        } 
    } 
    
    public int quantTimes () throws Exception{
        String sql = "SELECT nome FROM tb_times"; 
        try (Connection conn = ConexaoBD.obterConexao(); 
            PreparedStatement ps = 
            conn.prepareStatement(sql, 
                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_READ_ONLY); 
            ResultSet rs = ps.executeQuery()){ 
            int totalDeUsuarios = rs.last () ? rs.getRow() : 0; 
            
            return totalDeUsuarios; 
        }
    }
    
    public Times [] obterTimes () throws Exception{
        String sql = "SELECT nome FROM tb_times"; 
        try (Connection conn = ConexaoBD.obterConexao(); 
            PreparedStatement ps = 
            conn.prepareStatement(sql, 
                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_READ_ONLY); 
            ResultSet rs = ps.executeQuery()){ 
            int totalDeUsuarios = rs.last () ? rs.getRow() : 0; 
            Times [] times = new Times[totalDeUsuarios]; 
            rs.beforeFirst(); 
            int contador = 0; 
            while (rs.next()){ 
                String nome = rs.getString("nome"); 
                times[contador++] = new Times(nome); 
            } 
            return times; 
        }
    }
    
    //players
    
    public void inserirPlayers (Players players) throws Exception{ 
        String sql = "INSERT INTO tb_players (times_id, nome, numero) VALUES (?, ?, ?);"; 
        try (Connection conexao = ConexaoBD.obterConexao(); 
                PreparedStatement ps = conexao.prepareStatement(sql)){ 
            String id = String.valueOf(players.getTimeId());
            String numero = String.valueOf(players.getNumero());
            ps.setString(1, id);
            ps.setString(2, players.getNome());
            ps.setString(3, numero);
            ps.execute(); 
        } 
    } 
    
    public int quantPlayers () throws Exception{
        String sql = "SELECT nome FROM tb_players"; 
        try (Connection conn = ConexaoBD.obterConexao(); 
            PreparedStatement ps = 
            conn.prepareStatement(sql, 
                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_READ_ONLY); 
            ResultSet rs = ps.executeQuery()){ 
            int totalDePlayers = rs.last () ? rs.getRow() : 0; 
            
            return totalDePlayers; 
        }
    }
    
    public Players [] obterPlayers () throws Exception{
        String sql = "SELECT nome FROM tb_players"; 
        try (Connection conn = ConexaoBD.obterConexao(); 
            PreparedStatement ps = 
            conn.prepareStatement(sql, 
                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_READ_ONLY); 
            ResultSet rs = ps.executeQuery()){ 
            int totalDeUsuarios = rs.last () ? rs.getRow() : 0; 
            Players [] players = new Players[totalDeUsuarios]; 
            rs.beforeFirst(); 
            int contador = 0; 
            while (rs.next()){ 
                String nome = rs.getString("nome"); 
                players[contador++] = new Players (nome); 
            } 
            return players; 
        }
    }
    
        //Chaves
    
    public void inserirChave (Chave chave) throws Exception{ 
        String sql = "INSERT INTO tb_chave(time1, time2, time3, time4, nome) VALUES (?, ?, ?, ?, ?);"; 
        try (Connection conexao = ConexaoBD.obterConexao(); 
                PreparedStatement ps = conexao.prepareStatement(sql)){ 
            String timeId1 = String.valueOf(chave.getTimeId1());
            String timeId2 = String.valueOf(chave.getTimeId2());
            String timeId3 = String.valueOf(chave.getTimeId3());
            String timeId4 = String.valueOf(chave.getTimeId4());
            
            ps.setString(1, timeId1);
            ps.setString(2, timeId2);
            ps.setString(3, timeId3);
            ps.setString(4, timeId4);
            ps.setString(5, chave.getNome());
            
            ps.execute(); 
        } 
    } 
    
    public Chave [] obterChave1 () throws Exception{
        String sql = "SELECT t.nome FROM tb_chave c, tb_times t WHERE (c.nome = \"A\" && t.id = c.time1) || (c.nome = \"A\" &&t.id = c.time2) || (c.nome = \"A\" &&t.id = c.time3) || (c.nome = \"A\" &&t.id = c.time4);"; 
        try (Connection conn = ConexaoBD.obterConexao(); 
            PreparedStatement ps = 
            conn.prepareStatement(sql, 
                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_READ_ONLY); 
            ResultSet rs = ps.executeQuery()){ 
            int totalDeUsuarios = rs.last () ? rs.getRow() : 0; 
            Chave [] chave = new Chave[totalDeUsuarios]; 
            rs.beforeFirst(); 
            int contador = 0; 
            while (rs.next()){ 
                String nome = rs.getString("nome"); 
                chave[contador++] = new Chave(nome); 
            } 
            return chave; 
        }
    }
    
    public Chave [] obterChave2 () throws Exception{
        String sql = "SELECT t.nome FROM tb_chave c, tb_times t WHERE (c.nome = \"B\" && t.id = c.time1) || (c.nome = \"B\" &&t.id = c.time2) || (c.nome = \"B\" &&t.id = c.time3) || (c.nome = \"B\" &&t.id = c.time4);"; 
        try (Connection conn = ConexaoBD.obterConexao(); 
            PreparedStatement ps = 
            conn.prepareStatement(sql, 
                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_READ_ONLY); 
            ResultSet rs = ps.executeQuery()){ 
            int totalDeUsuarios = rs.last () ? rs.getRow() : 0; 
            Chave [] chave = new Chave[totalDeUsuarios]; 
            rs.beforeFirst(); 
            int contador = 0; 
            while (rs.next()){ 
                String nome = rs.getString("nome"); 
                chave[contador++] = new Chave(nome); 
            } 
            return chave; 
        }
    }
    
    public Chave [] obterChave3 () throws Exception{
        String sql = "SELECT t.nome FROM tb_chave c, tb_times t WHERE (c.nome = \"C\" && t.id = c.time1) || (c.nome = \"C\" &&t.id = c.time2) || (c.nome = \"C\" &&t.id = c.time3) || (c.nome = \"C\" &&t.id = c.time4);"; 
        try (Connection conn = ConexaoBD.obterConexao(); 
            PreparedStatement ps = 
            conn.prepareStatement(sql, 
                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_READ_ONLY); 
            ResultSet rs = ps.executeQuery()){ 
            int totalDeUsuarios = rs.last () ? rs.getRow() : 0; 
            Chave [] chave = new Chave[totalDeUsuarios]; 
            rs.beforeFirst(); 
            int contador = 0; 
            while (rs.next()){ 
                String nome = rs.getString("nome"); 
                chave[contador++] = new Chave(nome); 
            } 
            return chave; 
        }
    }
    
    public Chave [] obterChave4 () throws Exception{
        String sql = "SELECT t.nome FROM tb_chave c, tb_times t WHERE (c.nome = \"D\" && t.id = c.time1) || (c.nome = \"D\" &&t.id = c.time2) || (c.nome = \"D\" &&t.id = c.time3) || (c.nome = \"D\" &&t.id = c.time4);"; 
        try (Connection conn = ConexaoBD.obterConexao(); 
            PreparedStatement ps = 
            conn.prepareStatement(sql, 
                ResultSet.TYPE_SCROLL_INSENSITIVE, 
                ResultSet.CONCUR_READ_ONLY); 
            ResultSet rs = ps.executeQuery()){ 
            int totalDeUsuarios = rs.last () ? rs.getRow() : 0; 
            Chave [] chave = new Chave[totalDeUsuarios]; 
            rs.beforeFirst(); 
            int contador = 0; 
            while (rs.next()){ 
                String nome = rs.getString("nome"); 
                chave[contador++] = new Chave(nome); 
            } 
            return chave; 
        }
    }
}
