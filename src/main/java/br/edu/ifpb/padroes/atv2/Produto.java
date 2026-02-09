package br.edu.ifpb.padroes.atv2;

public class Produto extends ComponenteCardapio{
    private String nome;
    private double preco;

    public Produto(String nome, double preco) {
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public void mostrar(String espacamento) {
        System.out.println(espacamento + "- " + nome + " (R$ " + String.format("%.2f", preco) + ")");
    }
}
