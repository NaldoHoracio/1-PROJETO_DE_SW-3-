/**!
 * @className payroll.employees.Employee.java
 * @author Edvonaldo Horácio (edvonaldohs@ic.ufal.br)
 * @brief
 * @version 0.1
 * @date 2019-06-19
 *
 * @copyright Copyright (c) IC 2018
 *
 */
package payroll.employees;

import java.util.Scanner;

public abstract class Employee {
    Scanner input = new Scanner(System.in);

    // Dados básicos do empregado
    private String name;// Nome
    private String address;// Endereço
    private int idEmployee;// Número de identificação do empregado
    private String typeEmployee;// HOURLY, COMISSION, SALARIED

    // Dados referente ao pagamento
    private String typeOfPayment;// POSTOFFICE, HANDS, DEPOSIT
    private String typeOfAgenda;// WEEKLY, BI-WEEKLY, MONTHLY

    // Dados referente ao sindicato
    private int isSyndicalist;// Verifica se o empregado faz ou não parte do sindicato (1 - Sim | 0 - Não)
    private int idSyndicalist;// Id do empregado no sindicato
    private double unionFee;// Taxa do sindicato, caso o empregado faça parte
    private double othersFee;// Outras taxas e deduções do salário

    // Configura o nome
    public void setName(String nameEmp)
    {
        System.out.println("Enter name employee (Format: FIRST_NAME LAST_NAME)");
        nameEmp = input.nextLine();
        this.name = nameEmp;
    }

    // Retorna o nome
    public String getName()
    {
        return name;
    }

    // Configura o endereço
    public void setAddress(String addressEmp)
    {
        System.out.println("Enter address of employee  (Format: LOCATION, NUMBER_HOUSE, CEP, CITY)");
        addressEmp = input.nextLine();
        this.address = addressEmp;
    }

    // Retorna o endereço
    public String getAddress()
    {
        return address;
    }

    public void setIdEmployee(int id)
    {
        this.idEmployee = id % 1000000;
        System.out.println("ID sucessfully configured!");
    }

    // Retorna o ID do empregado
    public int getIdEmployee()
    {
        return idEmployee;
    }

    // Configurando o typo de empregado
    public void setTypeEmployee(String typeEmp)
    {
        System.out.println("Enter type of employee(HOURLY | SALARIED | COMMISSION):");
        typeEmp = input.nextLine();
        typeEmp = typeEmp.toUpperCase();
        if(typeEmp.equals("HOURLY") || typeEmp.equals("SALARIED") || typeEmp.equals("COMMISSION"))
        {
            this.typeEmployee = typeEmp;
        }else {
            System.out.println("Employee type is not exists");
        }
    }

    // Retornando o tipo de empregado
    public String getTypeEmployee()
    {
        return typeEmployee;
    }

    // Configurando a forma de pagamento
    public void setTypeOfPayment(String typeOfPaymentEmp)
    {
        System.out.println("Enter type of payment (POSTOFFICE | HANDS | DEPOSIT):");
        typeOfPaymentEmp= input.nextLine();
        typeOfPaymentEmp = typeOfPaymentEmp.toUpperCase();
        if(typeOfPaymentEmp.equals("POSTOFFICE") || typeOfPaymentEmp.equals("HANDS") || typeOfPaymentEmp.equals("DEPOSIT"))
        {
            this.typeOfPayment = typeOfPaymentEmp;
        }else {
            System.out.println("Type of payment is not avaible!");
        }
    }

    // Retorna o método de pagamento
    public String getTypeOfPayment()
    {
        return typeOfPayment;
    }

    // Configurando o tipo de Agenda
    public void setTypeOfAgenda(String typeOfAgendaEmp)
    {
        System.out.println("Enter type of payment (WEEKLY | BI-WEEKLY | MONTHLY):");
        typeOfAgendaEmp = input.nextLine();
        typeOfAgendaEmp  = typeOfAgendaEmp .toUpperCase();
        if(typeOfAgendaEmp .equals("WEEKLY") || typeOfAgendaEmp .equals("BI-WEEKLY") || typeOfAgendaEmp .equals("MONTHLY"))
        {
            this.typeOfAgenda = typeOfAgendaEmp;
        }else {
            System.out.println("Type of Agenda is not avaible!");
        }
    }

    // Retorna o tipo de Agenda
    public String getTypeOfAgenda()
    {
        return typeOfAgenda;
    }

    // Retorna se o empregado é sindicalista ou não
    public int isSyndicalistEmployee()
    {
        System.out.println("Is syndicalist (1 - Yes | 0 - No):");
        this.isSyndicalist = input.nextInt();
        return (this.isSyndicalist == 1) ? 1:0;
    }

    // Configurando o id do funcionário no sindicato
    public void setIdSyndicalist(int idSyndicalistEmp)
    {
        idSyndicalistEmp = 1000000 - getIdEmployee();
        this.idSyndicalist = idSyndicalistEmp;
    }
    // Retorna o id do funcionário no sindicato
    public int getIdSyndicalist()
    {
        return idSyndicalist;
    }

    // Configurando a taxa fixa paga pelo empregado
    public void getUnionFee(double fee)
    {
        System.out.println("Enter to fee Syndicate:");
        fee = input.nextDouble();
        if(fee < 0)
        {
            System.out.println("Value < 0!");
        }else{
            this.unionFee = fee;
        }
    }

    // Retorna a taxa do sindicato paga pelo empregado, caso o mesmo faça para do Sindicato
    public double getUnionFee()
    {
        return unionFee;
    }

    // Configurando outras taxas
    public void setOthersFee(double othersFeeEmp)
    {
        System.out.println("Enter to others fee Syndicate:");
        othersFeeEmp = input.nextDouble();
        if(othersFeeEmp < 0)
        {
            System.out.println("Value < 0!");
        }else{
            this.othersFee = othersFeeEmp;
        }
    }

    // Retorna outras taxas descontadas do salário do empregado
    public double getOthersFee()
    {
        return othersFee;
    }

    // Sobrescrevendo o método toString
    @Override
    public String toString()
    {
        return String.format("payroll.employees.Employee %s has ID %d", getName(), getIdEmployee());
    }

    // Método abstrato que retornar o salário total do empregado de acordo com seu tipo
    public abstract double salariedEmployee();
}
