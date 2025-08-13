# Gerenciador de Tarefas - Projeto de Seleção

Aplicação web de um simples gerenciador de tarefas, desenvolvida como parte de um processo seletivo para a vaga de Estágio em Desenvolvimento Java.

## Tecnologias Utilizadas

A aplicação foi construída utilizando um conjunto de tecnologias modernas do ecossistema Jakarta EE:

* **Linguagem:** Java 21
* **Framework Web:** Jakarta Server Faces (JSF) 4.0
* **Biblioteca de Componentes:** PrimeFaces 14.0.0
* **Persistência:** Jakarta Persistence API (JPA) 3.0 com Hibernate
* **Injeção de Dependência:** CDI 4.0 com Weld
* **Banco de Dados:** PostgreSQL 16
* **Servidor de Aplicação:** Apache Tomcat 10.1
* **Build Tool:** Apache Maven

### Itens Implementados

-   **(a) Aplicação Java Web com JavaServer Faces (JSF):** ✅ Implementado.
-   **(b) Persistência em banco de dados PostgreSQL:** ✅ Implementado.
-   **(c) Utilização de JPA:** ✅ Implementado.
-   **(f) Outros diferenciais:**
    * **Interface Rica com PrimeFaces:** A interface foi desenvolvida com a biblioteca de componentes PrimeFaces para proporcionar uma experiência de usuário mais rica e moderna.
    * **Filtros de Busca Dinâmicos:** A listagem de tarefas permite a filtragem em tempo real por Título e por Responsável.

## Funcionalidades

* CRUD completo de tarefas (Criar, Editar, Excluir, Listar).
* Capacidade de marcar tarefas como "Concluídas".
* Filtragem dinâmica da lista de tarefas.

## Como Executar o Projeto Localmente

**Pré-requisitos:**
* JDK 21
* Apache Maven 3.8+
* PostgreSQL 16
* Apache Tomcat 10.1+

**Passos:**

1.  **Clone o repositório:**
    ```bash
    git clone [https://github.com/Oskar-Fernandes/desafio-gerenciador-tarefas.git](https://github.com/Oskar-Fernandes/desafio-gerenciador-tarefas.git)
    ```
2.  **Crie e configure o banco de dados** no PostgreSQL com o nome `gerenciador_tarefas_db`.
3.  **Configure a conexão** no arquivo `src/main/resources/META-INF/persistence.xml`, alterando o usuário e a senha do banco.
4.  **Execute o projeto** através do IntelliJ IDEA, utilizando a configuração do servidor "Smart Tomcat".
5.  Acesse: `http://localhost:8080/tarefas/listagem.xhtml`.