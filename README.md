# 📦 Ordenação de Pedidos com Java 8

Projeto desenvolvido com o objetivo de praticar os principais conceitos de **Java 8**, com foco em ordenação de coleções utilizando programação funcional.

---

## 🧠 Conceitos abordados

- Interface `Comparator`
- Interface funcional `Function`
- Interface funcional `ToDoubleFunction`
- Expressões lambda
- Ordenação com múltiplos critérios
- Encadeamento de comparadores (`thenComparing`)
- Inversão de ordem (`reversed`)

---

## 📋 Estrutura da classe `Pedido`

Cada pedido possui os seguintes atributos:

- `nomeCliente` (String)
- `valor` (double)
- `pago` (boolean)
- `data` (LocalDate)

---

## 🚀 Desafios implementados

### 🔹 1º Desafio — Ordenação por valor

Ordena os pedidos com base no valor, do menor para o maior.

### 💡 Lógica aplicada:
- Extração do valor com `ToDoubleFunction`
- Uso de `Comparator.comparingDouble`

---

### 🔹 2º Desafio — Ordenação por nome do cliente

Ordena os pedidos em ordem alfabética com base no nome do cliente.

### 💡 Lógica aplicada:
- Uso de `Function<Pedido, String>`
- Ordenação natural de `String`

---

### 🔹 3º Desafio — Múltiplos critérios (status + valor)

Ordenação baseada em dois critérios:

1. Pedidos **pagos primeiro**
2. Em caso de empate → pedidos de **maior valor primeiro**

### 💡 Lógica aplicada:
- Criação de comparadores separados
- Inversão da ordem com `reversed`
- Encadeamento com `thenComparing`

---

### 🔹 4º Desafio — Data + nome do cliente

Ordenação baseada em:

1. Pedidos mais **recentes primeiro**
2. Em caso de empate → ordem alfabética do cliente

### 💡 Lógica aplicada:
- Uso de `LocalDate` como critério
- Reutilização de comparator de nome
- Encadeamento de regras

---

## 📊 Exemplo de saída
- Cliente: Ana; Valor do Pedido: R$1500.0; Data: 2025-07-30; Pago? true
- Cliente: Maria; Valor do Pedido: R$3000.0; Data: 2024-12-19; Pago? false
- Cliente: João; Valor do Pedido: R$2000.0; Data: 2022-10-24; Pago? false
- Cliente: Pedro; Valor do Pedido: R$1000.0; Data: 2022-08-07; Pago? true

---

## 💡 Principais aprendizados

- Separação de responsabilidades entre extração (`Function`) e comparação (`Comparator`)
- Criação de comparadores reutilizáveis
- Controle total da ordenação através de múltiplos critérios
- Diferença entre ordenação natural e customizada
- Como escrever código mais legível utilizando Java 8
