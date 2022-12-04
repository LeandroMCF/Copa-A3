package minhatela;
public class UsersDomain {
    private int id;
    private String nome;
    private String email;
    private String senha;
    
    public String getNome() {
        return nome;
    }

    public UsersDomain(String nome, String senha) {
        this.nome = nome;
        this.senha = senha;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
 
    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
