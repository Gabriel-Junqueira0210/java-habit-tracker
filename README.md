# Habit Tracker

Projeto desenvolvido para consolidar conceitos de **Engenharia de Software**, **Arquitetura em Camadas** e **Programação Orientada a Objetos (POO)** em Java.

O objetivo principal foi criar uma aplicação resiliente, com separação clara de responsabilidades, garantindo que a lógica de negócios fosse independente da interface e da persistência de dados.

## Funcionalidades (v1.0)
* **CRUD Completo:** Gerenciamento total de hábitos (Criar, Listar, Atualizar e Deletar) via terminal.
* **Persistência em Arquivo:** Dados salvos automaticamente em `Habits.txt`.
* **Resiliência:** Tratamento de falhas silenciosas ("Silent Failure") para ignorar dados corrompidos no banco de dados textual sem interromper a execução.
* **Validação de Dados:** Filtro rigoroso contra entradas inválidas para evitar exceções em tempo de execução.

## Estrutura do Projeto
A aplicação foi dividida em camadas para facilitar a manutenção e evolução:

```text
src/main/java/com/gabriel/habittracker/
 ├── menu/         # Interface com o usuário via console (Menu.java)
 ├── model/        # Entidades de domínio (Habit.java)
 ├── persistence/  # Manipulação de arquivos e IO (HabitFileManager.java)
 ├── repository/   # Gerenciamento da coleção de dados (HabitRepository.java)
 ├── service/      # Regras de negócio e lógica da aplicação (HabitService.java)
 └── Main.java     # Ponto de entrada e Injeção de Dependência manual
