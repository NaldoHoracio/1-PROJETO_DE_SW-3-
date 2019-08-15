## Projeto Folha de Pagamento Refatorado

**Padrões de projetos utilizados**

1. Padrão de projeto 1 e 2 - Templated e Extract :heavy_check_mark:
	- Descrição:
	A classe abstrata _Employee_ possui a variável _liquidSalary_ e a a classe concreta _HourlyEmployee_ possui a variável
	_salaryDay_ que se referem ao salário líquido e ao salário do dia (após o cartão de ponto ser configurado), respectivamente.
	Isso foi simplificado removendo _salaryDay_ e criando _grossSalary_, evitando a redundância causada pelo uso de _salaryDay_ e 		permitindo a extensibilidade, caso mais tipos de empregados sejam criados. O uso dessa extensibilidade também foi aplicada a
	classe concreta _SalariedEmployee_, no qual foi usada essa nova variável.


2. Padrão de projeto 2 - Singleton :heavy_check_mark:
	- Descrição:
	A classe _Main_ chamava todas funcionalidades. Isso, além de expor um código, causa um grande acoplamento. Então, foi usado o 		padrão _Singleton_ e isso proporcionou o desacoplamento. Assim, caso novas funcionalidades sejam implementadas, a nova classe
	_Menu_ irá apenas se preocupar em fornecer as novas opções do **_Menu_**.
