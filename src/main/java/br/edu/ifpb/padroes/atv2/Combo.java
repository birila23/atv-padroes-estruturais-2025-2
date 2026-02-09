package br.edu.ifpb.padroes.atv2;

import java.util.ArrayList;
import java.util.List;

public class Combo extends ComponenteCardapio{
    private String nome;
    private double percentualDesconto;
    private List<ComponenteCardapio> elementos = new ArrayList<>();

    public Combo(String nome, double percentualDesconto){
        this.nome = nome;
        this.percentualDesconto = percentualDesconto;
    }

    @Override
    public void adicionar(ComponenteCardapio elemento) {
        elementos.add(elemento);
    }

    @Override
    public void remover(ComponenteCardapio componente) {
        elementos.remove(componente);
    }

    @Override
    public double getPreco() {
        double total = 0;

        for (ComponenteCardapio elemento : elementos) {
            total += elemento.getPreco();
        }

        return total - (total * percentualDesconto);
    }

    @Override
    public void mostrar(String espacamento) {
        System.out.println(espacamento + "+ " + nome +
                " (Total: R$ " + String.format("%.2f", getPreco()) + ")");

        for (ComponenteCardapio elemento : elementos) {
            elemento.mostrar(espacamento + "   ");
        }
    }

}
