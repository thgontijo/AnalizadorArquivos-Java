# ☕ Java File Analyzer

> Projeto em Java para analisar arquivos fornecidos pelo usuário, usando regex, contagem de palavras e caracteres, extração de emails e telefones, manipulação de arquivos e tratamento de exceções relacionadas a I/O.

---

## 🚀 Funcionalidades

* Analisar arquivos a partir de um path fornecido pelo usuário
* Contar palavras e caracteres
* Extrair emails e números de telefone usando regex
* Mostrar todas as informações no console
* Opcionalmente criar um arquivo `.txt` com o relatório

  * Caso o usuário escolha criar, ele informa o path e o nome do relatório
* Tratar exceções de I/O e validar entradas

---

## 💻 Tecnologias

* Java
* Regex
* Manipulação de arquivos (I/O)

---

## 📦 Instalação

```bash
# Clonar o repositório
git clone https://github.com/seunome/java-file-analyzer.git

# Entrar na pasta do projeto
cd java-file-analyzer

# Compilar o projeto
javac -d bin src/**/*.java

# Executar o projeto
java -cp bin main.Main
```

---

## 📝 Como usar

1. Forneça o path do arquivo que deseja analisar.
2. O programa exibirá todas as informações no console.
3. Se desejar criar um relatório em `.txt`:

   * Confirme a criação do arquivo quando solicitado
   * Forneça o path e o nome do relatório

---

## 🛠️ Próximos passos

* [ ] Suporte a múltiplos formatos de arquivo
* [ ] Melhorar a interface do usuário (CLI ou GUI)
* [ ] Gerar relatórios automáticos com mais detalhes

---

## 👨‍💻 Autor

* **Thyago Gontijo** – [GitHub](https://github.com/thgontijo)
