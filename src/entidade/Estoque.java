package entidade;

public class Estoque {
    public int idRoupa;
    public String nomeRoupa;
    public String descricao;
    public double preco;
    public String tamanho;
    public String cor;

    public int getIdRoupa() {
        return idRoupa;
    }

    public void setIdRoupa(int idRoupa) {
        this.idRoupa = idRoupa;
    }

    public String getNomeRoupa() {
        return nomeRoupa;
    }

    public void setNomeRoupa(String nomeRoupa) {
        this.nomeRoupa = nomeRoupa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getTamanho() {
        return tamanho;
    }

    public void setTamanho(String tamanho) {
        this.tamanho = tamanho;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Estoque(){
    }
    
    public Estoque (int idRoupa,String nomeRoupa,String descricao,double preco,String tamanho,String cor){
    this.idRoupa = idRoupa;
    this.nomeRoupa = nomeRoupa;
    this.descricao = descricao;
    this.preco = preco;
    this.tamanho = tamanho;
    this.cor = cor;
    
    }
}