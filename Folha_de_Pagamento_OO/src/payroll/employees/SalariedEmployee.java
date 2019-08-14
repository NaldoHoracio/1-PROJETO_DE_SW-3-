/**!
 * @className payroll.employees.SalariedEmployee.java
 * @author Edvonaldo Horácio (edvonaldohs@ic.ufal.br)
 * @brief
 * @version 0.1
 * @date 2019-06-19
 *
 * @copyright Copyright (c) IC 2019
 *
 */
package payroll.employees;

public class SalariedEmployee extends Employee{
    // Construtor
    public SalariedEmployee(int idEmployeeEmp)
    {
        super.setName();
        super.setAddress();
        super.setSalaryMonthly();
        super.setIdEmployee(idEmployeeEmp);
        super.setTypeEmployee("ASSALARIADO");
        super.setTypeOfPayment("DEPOSITO");
        super.setTypeOfAgenda("MENSAL");
        super.setDayWeeklyPay(-1);// Dia da semana do pagamento
        super.setDataPay(27);// Data do pagamento
        this.isSyndicalist = false;
    }

    // Método para o salário do empregado
    @Override
    public double setLiquidSalariedEmployee()
    {
        return this.liquidSalary += this.salaryMonthly - getUnionFee() - getOthersFee();
    }
}
