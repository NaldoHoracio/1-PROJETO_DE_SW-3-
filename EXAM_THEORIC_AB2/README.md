# Prova 2
No projeto antigo são apenas 3 grandes classes, conforme modelo do dia.

Padrão de projeto 1 - Template Method

Métodos aplicáveis: pagarMensal, pagarSemanal, pagarBissemanal.
Novo método: pagarFuncionario.
Funcionalidades: pagar de acordo com o tipo de pagamento escolhido. Os três métodos têm os mesmos parâmetros, mas podem ser implementados de forma diferente de acordo com a escolha do cliente, tal como foi feito com eles na classe folhaDePagamento. 
Vantagens: é possível adicionar mais formas de pagamento, caso sejam necessárias. O programa fica extensível.

Padrão de projeto 2 - Interpreter.
Classe aplicável: Empregado.
Objetivo: criar uma classe de acordo com o tipo de empregado cadastrado (Horista, Assalariado e Comissionado).
Funcionalidades: através de uma interface, é escolhido o tipo de empregado cadastrado, cujos dados são tratados em sua respectiva classe.
As funcionalidades de cada uma das classes criadas tem as mesmas variáveis, mas possuem a vantagem de saber qual tipo de funcionário se trata.
Vantagens: O programa fica extensível.

