/**!
 * @className payroll.employees.HourlyEmployee.java
 * @author Edvonaldo Horácio (edvonaldohs@ic.ufal.br)
 * @brief
 * @version 0.1
 * @date 2019-06-19
 *
 * @copyright Copyright (c) IC 2019
 *
 */
package payroll.employees;

public class HourlyEmployee extends Employee {
    private double wageSalary;// Salário horário
    private double hoursWorked;// Horas trabalhadas
    private double partialSalary = 0;// Salario do dia (incluindo as horas extras)

    // Construtor
    public HourlyEmployee(int idEmployeeEmp)
    {
        super.setName();
        super.setAddress();
        super.setIdEmployee(idEmployeeEmp);
        super.setTypeEmployee("HOURLY");
        super.setTypeOfPayment("DEPOSIT");
        super.setTypeOfAgenda("WEEKLY");
    }

    // Configurando o salário do horista
    public void setWageSalary(double wage)
    {
        if(wage <= 0)
        {
            System.out.println("Salário inválido! Digite um valor maior que 0!");
        }else {
            this.wageSalary = wage;
        }
    }

    // Retornando o salário horário
    public double getWageSalary()
    {
        return wageSalary;
    }

    // Configurando o número de horas trabalhadas
    public void setHoursWorked(double hours)
    {

        if(hours < 0.0 || hours > 24.00)
        {
            System.out.println("Hora inválida! Entre com um valor maior que 0 e menor que 24!");
        }
        this.hoursWorked = hours;
    }

    // Retornando o número de horas trabalhadas
    public double getHoursWorked()
    {
        return hoursWorked;
    }

    // Calculando o salário do dia
    public void setSalaryDay(double salaryDay)
    {
        if(getHoursWorked() <= 8)
        {
            salaryDay = getHoursWorked()*getWageSalary();
        }else{
            salaryDay = 8 * getWageSalary() + (8 - getHoursWorked()) * (1.5 * getWageSalary());
        }
        this.partialSalary += salaryDay;
    }

    // Retornando o salário do dia
    public double getSalaryDay()
    {
        return partialSalary;
    }

    // Submentendo cartão de ponto
    public void submitCardPoint()
    {
        System.out.println("Submit the Card Point Today:");

    }

    // Configurando o salário do empregado
    @Override
    public double salariedEmployee() {
        return 0;
    }
}
