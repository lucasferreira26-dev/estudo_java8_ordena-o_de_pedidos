package Aula5_Ordenando_No_Java8_labs;

import java.time.LocalDate;

public class Pedido {

    private String nomeCliente;
    private double valor;
    private LocalDate data;
    private boolean pago;

    public Pedido(String nomeCliente, double valor, boolean pago, LocalDate data) {
        this.nomeCliente = nomeCliente;
        this.valor = valor;
        this.data = data;
        this.pago = pago;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public double getValor() {
        return valor;
    }

    public LocalDate getData() {
        return data;
    }

    public boolean isPago() {
        return pago;
    }

    @Override
    public String toString() {
        return "Cliente: " + nomeCliente + "; Valor do Pedido: R$" + valor +
                "; Data: " + data + "; Pago? " + pago;
    }
}
