# 📚 Sistema de Biblioteca - Programação Orientada a Objetos (POO)

Sistema de gerenciamento de biblioteca desenvolvido em **Java** como parte de uma atividade acadêmica prática, aplicando rigorosamente os conceitos de Orientação a Objetos (Associação, Agregação e Composição), além de regras de negócio estritas para controle de acervo e empréstimos.

---

## 🚀 Tecnologias Utilizadas
* **Linguagem:** Java
* **IDE:** Apache NetBeans
* **Controle de Versão:** Git e GitHub

---

## 🛠️ Arquitetura e Domínio do Sistema
O sistema foi estruturado em camadas e classes bem definidas:
* **`Leitor`**: Gerencia os dados cadastrais dos usuários com validação de campos obrigatórios.
* **`Livro`**: Controla o acervo de livros e seus respectivos status de disponibilidade.
* **`Biblioteca`**: Classe controladora central que armazena as listas (`ArrayList`) e aplica as validações de cadastro, consultas e remoções.
* **`Emprestimo` e `ItemEmprestimo`**: Realizam a composição dos itens emprestados vinculados a um leitor e à data corrente do sistema.
* **`Aplicacao`**: Classe principal (`main`) que gerencia a interface em modo texto via terminal (`Scanner` e menu `switch-case`) para testes e simulações do fluxo completo.

---

Desenvolvido por Ana Júlia Martins Silva, estudante de Sistemas de Informação (2º Período).
