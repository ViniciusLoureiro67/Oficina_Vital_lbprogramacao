# 🧰 Sistema de Gestão de Oficina Mecânica

Projeto desenvolvido para a disciplina **Laboratório de Programação 1 (Java)**.  
O sistema tem como objetivo simular a gestão de uma oficina mecânica, permitindo o **cadastro de clientes, veículos, mecânicos, e ordens de serviço** através de uma aplicação **desktop (Swing)**, com base nos princípios de **Programação Orientada a Objetos (POO)**.

---

## ⚙️ Tecnologias Utilizadas
- **Java 17+**
- **Eclipse IDE**
- **Swing (Interface Gráfica)**
- **Collections (ArrayList)**
- **Tratamento de Exceções**
- **POO (Abstração, Herança, Polimorfismo, Encapsulamento e Interfaces)**

---


## 🧠 Conceitos de POO aplicados

| Conceito | Aplicação |
|-----------|------------|
| **Abstração** | Classes `Pessoa` e `Veiculo` como bases genéricas |
| **Herança** | `Cliente` e `Mecanico` herdam `Pessoa`; `Carro` e `Moto` herdam `Veiculo` |
| **Polimorfismo** | Método `exibirInfo()` sobrescrito em subclasses |
| **Encapsulamento** | Atributos privados com getters e setters públicos |
| **Interface** | Interface `Servico` define métodos `executar()` e `finalizar()` |
| **Exceções** | Exceções personalizadas (`VeiculoNaoEncontradoException`, `ServicoInvalidoException`) |
| **Coleções** | Uso de `ArrayList` no `OficinaController` |
| **Interface Gráfica** | Telas construídas com Swing (`JPanel`, `JFrame`) |

---

## 📌 Observações

- Projeto dividido em pacotes para organização e legibilidade.  
- Implementa todos os princípios básicos de **POO em Java**.  
- O foco principal é demonstrar **estrutura, reuso e organização de código**.
