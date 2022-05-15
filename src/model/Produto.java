package model;

public class Produto {
    private int id;
    private String nome;
    private String fornecedor;
    private String cnpj;
    private String tipo;
    private int quantidade;

    public Produto() {
    }

    public Produto(int id, String nome, String fornecedor, String cnpj, String tipo, int quantidade) {
        this.id = id;
        this.nome = nome;
        this.fornecedor = fornecedor;
        this.cnpj = cnpj;
        this.tipo = tipo;
        this.quantidade = quantidade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(String fornecedor) {
        this.fornecedor = fornecedor;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
}
