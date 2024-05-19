<p style="text-align: center;">
    <a href="https://www.espm.br/cursos-de-graduacao/sistemas-de-informacao/"><img src="https://avatars.githubusercontent.com/u/49880458?s=200&v=4" alt="Sistemas de Informação ESPM" style="height: 200px; width: 200px;"/></a>
</p>

## Sistema de Reservas para Restaurante 🍽️

Este programa em Java simula um sistema de reservas para um restaurante exclusivo com apenas 6 mesas disponíveis. O sistema permite:

- Cadastrar clientes como Pessoa Física ou Pessoa Jurídica.
- Fazer reservas, definindo a forma de pagamento (à vista ou parcelado).
- Pesquisar reservas por CPF ou CNPJ.
- Imprimir a lista de reservas confirmadas.
- Imprimir a lista de espera, caso o número de reservas exceda a capacidade do restaurante.
- Cancelar reservas.

### Como executar o programa 🚀

1. **Baixe o código-fonte:**
   - Faça o download do código-fonte deste repositório.

2. **Compile o código:**
   - Utilize um compilador Java para compilar todos os arquivos `.java` presentes na pasta `src`.

3. **Execute o programa:**
   - Execute a classe `Main` para iniciar o sistema de reservas.

### Detalhes da implementação ⚙️

- O programa foi desenvolvido utilizando o paradigma de Orientação a Objetos.
- As classes `PessoaFisica` e `PessoaJuridica` herdam da classe abstrata `Cliente`.
- A classe `Reserva` implementa a interface `Pagamento` para calcular o valor da reserva com base na forma de pagamento.
- A classe `SistemaReservas` gerencia as reservas, a lista de espera e as operações de pesquisa e cancelamento.
- O programa utiliza a biblioteca `JOptionPane` para interagir com o usuário através de janelas de diálogo.

### Considerações 💡

- O programa assume que cada reserva corresponde a uma mesa com 4 lugares.
- O valor da reserva é fixo (R$ 3200,00), com desconto de 10% para pagamento à vista.
- O sistema não implementa persistência de dados, ou seja, as reservas são perdidas ao encerrar o programa.

---

## Integrantes
- [Alex Macedo](https://github.com/Alexxmfs)
- [Débora Duarte](https://github.com/duartedebis)
- [Henrique Sardella](https://github.com/henrique-sdc)
- [Thiago Alonso](https://github.com/ThiagoAlonso05)
- [Rafa Ambrosio](https://github.com/rafaambrosio)

**Data:** 2024-01

**Linguagem:** Java

**Paradigma:** Orientação a Objetos

## Licença

Este projeto é licenciado sob a [MIT License](https://github.com/tech-espm/inter-2sem-2024-diet-control/blob/main/LICENSE).
