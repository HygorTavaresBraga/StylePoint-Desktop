
package entidade;

import java.util.List;


public class Locacao {
    protected int idLocacao;
    protected int idCliente;
    protected int idRoupa;
    public String dataLocacao;
    public String dataDevolucao;
    public String observacao;
    public Double valorTotal;

    public int getIdLocacao() {
        return idLocacao;
    }

    public void setIdLocacao(int idLocacao) {
        this.idLocacao = idLocacao;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdRoupa() {
        return idRoupa;
    }

    public void setIdRoupa(int idRoupa) {
        this.idRoupa = idRoupa;
    }

    public String getDataLocacao() {
        return dataLocacao;
    }

    public void setDataLocacao(String dataLocacao) {
        this.dataLocacao = dataLocacao;
    }

    public String getDataDevolucao() {
        return dataDevolucao;
    }

    public void setDataDevolucao(String dataDevolucao) {
        this.dataDevolucao = dataDevolucao;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Locacao(){
    }
    
    public Locacao(int idLocacao,int idCliente,int idRoupa,String dataLocacao,String dataDevolucao,String observacao,Double valorTotal){
        this.idLocacao = idLocacao;
        this.idCliente = idCliente;
        this.idRoupa = idRoupa;
        this.dataLocacao = dataLocacao;
        this.dataDevolucao = dataDevolucao;
        this.observacao = observacao;
        this.valorTotal = valorTotal;
    }

    public void setIdCliente(List<Cliente> cliente) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public void setIdCliente(Object selectedItem) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}