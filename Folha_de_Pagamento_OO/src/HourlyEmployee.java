/**!
 * @className HourlyEmployee.java
 * @author Edvonaldo Horácio (edvonaldohs@ic.ufal.br)
 * @brief
 * @version 0.1
 * @date 2019-06-19
 *
 * @copyright Copyright (c) IC 2018
 *
 */

public class HourlyEmployee extends Employee {
    private double wageSalary;// Salário horário
    private double beginWordked, endWorked;// Horário de começo e fim do dia
    private double hoursWorked;// Horas trabalhadas
    private double salaryDay;// Salário do dia (incluindo as foras extras

    // Configurando o salário do horista
    public double setWageSalary(double wage)
    {
        if(wage <= 0)
        {
            System.out.println("Salaried invalid! Enter to value > 0!");
        }else {
            this.wageSalary = wage;
        }
    }

    // Retornando o salário horário
    public double getWageSalary()
    {
        return wageSalary;
    }

    // Configurando a hora de início
    public double setBeginWorked(double bWorked)
    {
        if(bWorked < 0 || bWorked >= 24)
        {
            System.out.println("Invalid start time! Enter to number valid!");
        }else{
            this.beginWordked = bWorked;
        }
    }

    // Retorna a hora de início do trabalho
    public double getBeginWordked()
    {
        return beginWordked;
    }

    // Configurando a hora do fim
    public double setEndWorked(double eWorked)
    {
        if(eWorked < 0 || eWorked >= 24)
        {
            System.out.println("Invalid end time! Enter to number valid!");
        }else {
            this.endWorked = eWorked;
        }
    }

    // Retornando a hora do fim de trabalho
    public double getEndWorked()
    {
        return endWorked;
    }

    // Configurando o número de horas trabalhadas
    public double setHoursWorked(double hours)
    {
        hours = getEndWorked() - getEndWorked();
        if(hours < 0.0 || hours > 24.00)
        {
            System.out.println("Invalid hour! Enter to number valid! (Hour > 0 OR Hour <= 24.00");
        }else{
            this.hoursWorked = hours;
        }
    }

    // Retornando o número de horas trabalhadas
    public double getHoursWorked()
    {
        return hoursWorked;
    }

    // Salário do dia
    public double salaryDay()
    {
        if(getHoursWorked() <= 8)
        {
            this.salaryDay = getWageSalary()*getWageSalary();
        }else{
            this.salaryDay = (getHoursWorked() * getWageSalary() + (getHoursWorked() - 8)*1.5);
        }
    }

    @Override
    public double salariedEmplyee()
    {

    }


}
