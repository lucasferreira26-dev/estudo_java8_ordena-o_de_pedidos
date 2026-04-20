package Aula5_Ordenando_No_Java8_labs;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;

public class Main {

    public static void main(String[] args){

        List<Pedido> pedidos = new ArrayList<>();

        LocalDate data1 = LocalDate.of(2022, 8, 07);
        LocalDate data2 = LocalDate.of(2022, 10, 24);
        LocalDate data3 = LocalDate.of(2024, 12, 19);
        LocalDate data4 = LocalDate.of(2025, 7, 30);

        pedidos.add(new Pedido("Pedro", 1000, true, data1));
        pedidos.add(new Pedido("João", 2000, false, data2));
        pedidos.add(new Pedido("Maria", 3000, false, data3));
        pedidos.add(new Pedido("Ana", 1500, true, data4));

        // 1° DESAFIO
        // Antes de fazer uma comparação na nossa lista, vamos estabelecer um critério de
        // comparação, que nesse caso vai ser o valor de um pedido.
        ToDoubleFunction<Pedido> extraiValor = valor -> valor.getValor();

        // Depois de pegar o valor como critério, então nós podemos fazer uma comparação
        Comparator<Pedido> comparatorValorPedido = Comparator.comparingDouble(extraiValor);

        // Agora nós ordenamos a lista com base nessa comparação (Do menor valor para o maior)
        pedidos.sort(comparatorValorPedido);

        // Agora nós exibimos a lista ordenada
        pedidos.forEach(pedido -> System.out.println(pedido));

        System.out.println("--------------------------------------------------------");

        // 2° DESAFIO
        // Vamos ordenar nossa lista agora pelo nome dos clientes, mas vamos precisar a
        // interface Function<T, R>
        Function<Pedido, String> extraiNomeCliente = nome -> nome.getNomeCliente();

        Comparator<Pedido> comparatorNomeCliente = Comparator.comparing(extraiNomeCliente);

        pedidos.sort(comparatorNomeCliente);

        pedidos.forEach(pedido -> System.out.println(pedido));

        System.out.println("--------------------------------------------------------");

        // 3° DESAFIO
        // Esse terceiro desafio implica em ordenar a lista com os seguintes critérios:
        // Primeiro nós ordenamos os pedidos pagos com status de pagamento verdadeiro
        // Mas se no caso os status de dois ou mais pedidos empatarem, qual deve vir primeiro na lista?
        // Então nós estabelecemos o segundo critério que é ordem decrescente de valores de pedidos
        // Nós vamos utilizar o método thenComparing() da interface Comparator para nos auxiliar

        // Extraindo primeiro critério: status de pagamento
        Function<Pedido, Boolean> extraiStatus = pago ->
                pago.isPago();

        // Extraindo segundo critério: valor do pedido
        Function<Pedido, Double> extraiValor2 = valor ->
                valor.getValor();

        // Uma pequena ressalva: Por padrão o Java enumera primeiramente objetos com valor false
        // como nós já vimos, no caso de valores numéricos, do menor para o maior. Nós criamos dois
        // Comparators para fazer essa comparação com base no valor extraido,
        // mas também usamos o método reversed() para inverter a ordem natural dos objetos.
        // Dessa forma primeiro vem pedidos com status pagamento = true e com valores mais altos primeiro
        Comparator<Pedido> comparatorStatus =
                Comparator.comparing(extraiStatus).reversed();

        Comparator<Pedido> comparatorValor2 = Comparator.comparing(extraiValor2).reversed();

        // Esse terceiro Compaarator vai definir o raciocinio, pois nós utilizamos os dois primeiros
        // comparators, com auxilio do método thenComparing(), para fazer o encadeamento de comparadores.
        Comparator<Pedido> comparatorStatusValor = comparatorStatus.thenComparing(comparatorValor2);

        // Ordenando a lista com base no terceiro comparador
        pedidos.sort(comparatorStatusValor);

        // Exibindo a lista ordenada
        pedidos.forEach(pedido -> System.out.println(pedido));

        System.out.println("--------------------------------------------------------");

        Function<Pedido, LocalDate> extraiData = data -> data.getData();

        Comparator<Pedido> comparatorData = Comparator.comparing(extraiData).reversed();

        Comparator<Pedido> comparatorDataCliente = comparatorData.thenComparing(comparatorNomeCliente);

        pedidos.sort(comparatorDataCliente);

        pedidos.forEach(pedido -> System.out.println(pedido));
    }
}
