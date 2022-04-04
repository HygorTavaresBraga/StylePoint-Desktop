
package entidade;


public class Funcionario {
    protected int idFuncionario;
    public String nomeFuncionario;
    public String dataNascimentoFuncionario;
    public String dataAdmissao;
    public String cpfFuncionario;
    public String enderecoFuncionario;
    public String emailFuncionario;
    public String telefoneFuncionario;

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getDataNascimentoFuncionario() {
        return dataNascimentoFuncionario;
    }

    public void setDataNascimentoFuncionario(String dataNascimentoFuncionario) {
        this.dataNascimentoFuncionario = dataNascimentoFuncionario;
    }

    public String getDataAdmissao() {
        return dataAdmissao;
    }

    public void setDataAdmissao(String dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
    }

    public String getCpfFuncionario() {
        return cpfFuncionario;
    }

    public void setCpfFuncionario(String cpfFuncionario) {
        this.cpfFuncionario = cpfFuncionario;
    }

    public String getEnderecoFuncionario() {
        return enderecoFuncionario;
    }

    public void setEnderecoFuncionario(String enderecoFuncionario) {
        this.enderecoFuncionario = enderecoFuncionario;
    }

    public String getEmailFuncionario() {
        return emailFuncionario;
    }

    public void setEmailFuncionario(String emailFuncionario) {
        this.emailFuncionario = emailFuncionario;
    }

    public String getTelefoneFuncionario() {
        return telefoneFuncionario;
    }

    public void setTelefoneFuncionario(String telefoneFuncionario) {
        this.telefoneFuncionario = telefoneFuncionario;
    }


public Funcionario(){
    }
    
    public Funcionario(int idFuncionario,String nomeFuncionario,String dataNascimentoFuncionario,String dataAdmissao,String cpfFuncionario,String enderecoFuncionario,String telefoneFuncionario, String emailFuncionario){
        this.idFuncionario = idFuncionario;
        this.nomeFuncionario = nomeFuncionario;
        this.dataNascimentoFuncionario = dataNascimentoFuncionario;
        this.dataAdmissao = dataAdmissao;
        this.cpfFuncionario = cpfFuncionario;
        this.enderecoFuncionario = enderecoFuncionario;
        this.telefoneFuncionario = telefoneFuncionario;
        this.emailFuncionario = emailFuncionario;
    }
}
