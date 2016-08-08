# Atividades da Disciplina
### Revisões deste documento e lançamentos
Atividades da disciplina de POD 2016.1 do curso de Analise e Desenvolvimento de Sistema (ADS) do IFPB, Campus Cajazeiras.
#### Histórico das atividades
Data          |   Versão    |               Descrição                                                                                 |  Autor
------------- | ----------- | ------------------------------------------------------------------------------------------------------- | ---------------------
17/06/2016    |  1.0.0      |  [Estilo Arquitetural baseado em Objetos](https://github.com/Laerton2016/POD_equipe2)                   | [Aluísio](https://github.com/AluisioPereira)
22/06/2016    |  1.0.0      |  [Estilo Arquitetural baseado em Eventos](https://github.com/AluisioPereira/projeto2_pod)               | [Aluísio](https://github.com/AluisioPereira)
22/06/2016    |  1.0.0      |  [Estilo Arquitetural baseado em Dados](https://github.com/AluisioPereira/PODAtividadeBaseadoEmDados)   | [Aluísio](https://github.com/AluisioPereira)
08/08/2016    |  1.0.0      |  [Exercício sobre Sistemas Distribuídos](https://github.com/AluisioPereira/PODSistemasDistribuidos)     | [Aluísio](https://github.com/AluisioPereira)


# Exercício 01
Considere o cenário onde existe a necessidade comunicação de uma aplicação cliente com dois bancos de dados em máquinas diferentes.
considere que uma consulta será consistente se recuperar informações de ambos. Quais são os problemas inereentes a este cenários cite pelo menos 4
Implemente este cenário utilizando RMI

# Exercício 02
Com RMI considere o cenário onde uma aplicação cliente precisa analizar o banco de dados quando uma outra aplicação receber informações
de uma terceira aplicação onde:
n2 manda mensagem n3
no2 notifica no1;
no1 atualiza no banco

Restrições:
no1 é cliente de no2
no2 é cliente de no3

no1 se conectar a no2 
colocar tudo em uma pasta e mandar o codigo para o github e enviar por email para ele.

# Exercício 03
Considere o caso onde uma aplicação como servidor 3 nós, sendo que 2 (dois) deles são replicados. quando a aplicação cliente tentar requisitar nos servidores e apenas um estiver
acessível para o cliente, este possibilitará o acesso aos demais.
com base neste cenário implemente-o em RMI.
no1->no3
no1->no2
no1->no22
no3<->no2
no3<->n22
no2<->n3
no22<->n2
no22<->n3

# Exercício 04
Desenvolva uma solução para um cliente deseja enviar um mensagem para um dispositivo móvel, mas não o conhece na rede considere o fato de que os nós trabalham como,
definido no gráfico:

no1 -> no2
no1 -> no3

no3 <-> no2
no3 -> no4
no2 -> no4

definido no grafício que deseja enviar um mensagem para um dispoisitivo móveis, mas não o conhece na rede


![https://github.com/AluisioPereira/PODSistemasDistribuidos/atividade.pdf][Atividade]