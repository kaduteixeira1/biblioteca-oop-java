# 📚 Sistema de Gerenciamento de Biblioteca – Java (POO)

Este repositório contém a implementação de um sistema de gerenciamento de biblioteca desenvolvido em Java, utilizando o paradigma da **Programação Orientada a Objetos (POO)**. O projeto foi criado como parte da disciplina **Paradigmas de Linguagens de Programação**.

## 🎯 Objetivo

O objetivo do trabalho é aplicar os principais conceitos da orientação a objetos na construção de um sistema com regras de negócio reais, como:

- Cadastro de livros com validação de disponibilidade.
- Registro e controle de empréstimos e devoluções.
- Associação entre livros, usuários e datas.
- Demonstração de princípios como abstração, encapsulamento e polimorfismo.

## 🧠 Conceitos Aplicados

- **Abstração**: Modelagem de entidades do mundo real (Livro, Usuário, Empréstimo).
- **Encapsulamento**: Controle de acesso aos atributos via métodos públicos.
- **Herança e Polimorfismo**: Preparação para expansão com especialização de classes e sobrecarga de métodos.
- **Tratamento de exceções**: Verificação de disponibilidade de livros.

## 🛠️ Tecnologias Utilizadas

- Linguagem: **Java 17**
- IDE recomendada: **IntelliJ IDEA** ou **Eclipse**
- Controle de versão: **Git + GitHub**
- Diagrama de classes: **PlantUML**
- Testes: **JUnit (em implementação futura)**

## 📂 Estrutura do Projeto

```plaintext
biblioteca-oop-java/
├── src/
│   ├── Livro.java
│   ├── Usuario.java
│   ├── Emprestimo.java
│   └── Biblioteca.java
└── README.md
