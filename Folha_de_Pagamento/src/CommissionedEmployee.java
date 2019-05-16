/**!
 * @className CommissionedEmployee.java
 * @author Edvonaldo Horácio (edvonaldohs@ic.ufal.br)
 * @brief
 * @version 0.1
 * @date 2019-05-16
 *
 * @copyright Copyright (c) IC 2018
 *
 */

public class CommissionedEmployee
{
    // ATRIBUTOS DO EMPREGADO
    private String name;// Nome do empregado
    private String addr;// Endereço do empregado
    private char type;// Tipo de empregado - H (horista)/ A (assalariados)/ C (comissionados)

    // ATRIBUTOS ASSOCIADOS DO EMPREGADO
    private double hourlyWage = 0.0;// Salário horário
    private double monthlySalary = 0.0;// Salário mensal
    private double comissionSalary = 0.0;// Comissão
    private int employeeSale = 0;

    // ID DO EMPREGADO
    private int idEmployee;// Id do empregado - único

    // SALÁRIO DO EMPREGADO
    private double salaryEmployee;

    // SINDICATO
    private boolean isSyndicate = false;
    private int idSyndicate;// Id do sindicato
    private double fixedMonthlyFee;// Taxa mensal fixa

    // NOME DO EMPREGADO
    public void setName(String name)
    {
        this.name = name;
    }
    public void getName()
    {
        return name;
    }

    // ENDEREÇO DO EMPREGADO
    public String setAddr(String addr)
    {
        this.addr = addr;
    }
    public String getAddr()
    {
        return addr;
    }

    // TIPO DO EMPREGADO
    public char setTypeEmployee(char type)
    {
        this.type = type;
    }
    public char getTypeEmployee()
    {
        return type;
    }

    // ID DO EMPREGADO
    public int setIdEmployee(int idEmployee)
    {
        this.idEmployee = idEmployee;
    }
    public int getIdEmployee()
    {
        return idEmployee;
    }

    // SALÁRIO DO EMPREGADO
    public double setSalaryEmployee(double salaryEmployee)
    {
        this.salaryEmployee = salaryEmployee;
    }
    public double getSalaryEmployee()
    {
        return salaryEmployee;
    }

    // VENDA DO EMPREGADO
    public int setEmployeeSale(int employeeSale)
    {
        this.employeeSale = employeeSale;
    }
    public int getEmployeeSale()
    {
        return employeeSale;
    }

    // VERIFICA SE PERTENCE AO SINDICATO
    public boolean setIsSyndicate(boolean isSyndicate)
    {
        this.isSyndicate = isSyndicate;
    }
    public boolean getIsSyndicate()
    {
        return isSyndicate;
    }

    // NUMERO DO SINDICADO
    public int setIdSyndicate(int idSyndicate)
    {
        this.idSyndicate = idSyndicate;
    }
    public int getIdSyndicate()
    {
        return idSyndicate;
    }

    // TAXA MENSAL FIXA
    public double setFixedMonthlyFee(double fixedMonthlyFee)
    {
        this.fixedMonthlyFee = fixedMonthlyFee;
    }
    public double getFixedMonthlyFee()
    {
        return fixedMonthlyFee;
    }
}
