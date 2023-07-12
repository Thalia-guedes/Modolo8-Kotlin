import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Venda {
    private Vendedor vendedor;
    private Cliente cliente;
    private double preco;
    private String nomeProduto;
    private int quantidade;
    private int codigo;


    public Venda(Vendedor vendedor, Cliente cliente, double preco, String nomeProduto, int quantidade, int codigo) {
        this.vendedor = vendedor;
        this.cliente = cliente;
        this.preco = preco;
        this.nomeProduto = nomeProduto;
        this.quantidade = quantidade;
        this.codigo = codigo;
    }


    public Vendedor getVendedor() {
        return vendedor;
    }


    public Cliente getCliente() {
        return cliente;
    }


    public double getPreco() {
        return preco;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public Vendedor setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
        return vendedor;
    }



    public Cliente setCliente(Cliente cliente) {
        this.cliente = cliente;
        return cliente;
    }

    public double setPreco(double preco) {
        this.preco = preco;
        return preco;
    }

    public String setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
        return nomeProduto;
    }

    public int setQuantidade(int quantidade) {
        this.quantidade = quantidade;
        return quantidade;
    }

    public int setCodigo(int codigo) {
        this.codigo = codigo;
        return codigo;
    }


}

