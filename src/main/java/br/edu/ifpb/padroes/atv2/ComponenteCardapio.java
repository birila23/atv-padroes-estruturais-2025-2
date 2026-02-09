package br.edu.ifpb.padroes.atv2;

public abstract class ComponenteCardapio {

    public void adicionar(ComponenteCardapio elemento) {
        throw new UnsupportedOperationException();
    }

    public void remover(ComponenteCardapio componente) {
        throw new UnsupportedOperationException();
    }

    public abstract double getPreco();
    public abstract void mostrar(String espacamento);
}
