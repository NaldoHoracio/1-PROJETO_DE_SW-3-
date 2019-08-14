/**!
 * @className employees.CommissionEmployee.java
 * @author Edvonaldo Horácio (edvonaldohs@ic.ufal.br)
 * @brief
 * @version 0.1
 * @date 2019-07-24
 *
 * @copyright Copyright (c) IC 2018
 *
 */
package employees;

import java.util.Scanner;

public class CommissionEmployee extends Employee {

    private double salesResult;// Resultado das vendas
    private double commissionSale;// Comissão de vendas

    // Construtor
    public CommissionEmployee(int idEmployeeEmp)
    {
        super.setName();
        super.setAddress();
        super.setSalaryMonthly();
        setIdEmployee(idEmployeeEmp);
        super.setTypeEmployee("COMISSIONADO");
        super.setTypeOfPayment("DEPOSITO");
        super.setTypeOfAgenda("BISSEMANAL");
        super.setDayWeeklyPay(4);// Dia da semana do pagamento
        super.setDataPay(-1);// Data do pagamento
        setCommissionSale();
        this.isSyndicalist = false;
    }

    // Configurando o resultado das vendas em um período
    public void setSalesResult()
    {
        double salesResultEmp;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite o resultado das vendas (Ex.: 200,00 é R$200,00):");
        salesResultEmp = input.nextDouble();
        if(salesResultEmp < 0)
        {
            System.out.println("ERROR! Resultado das vendas menor que 0.");
        }else{
            this.salesResult = salesResultEmp;
        }
    }

    // Retorna o resultado das vendas
    public double getSalesResult()
    {
        return this.salesResult;
    }

    // Configura o percentual de comissão
    public void setCommissionSale()
    {
        double commissionSaleEmp;
        Scanner input = new Scanner(System.in);
        System.out.println("Digite a comissão do empregado (Ex.: 20,00 é 20%):");
        commissionSaleEmp = input.nextDouble();
        if(commissionSaleEmp < 0)
        {
            System.out.println("ERROR! Comissão menor que 0!");
        }else{
            this.commissionSale = (commissionSaleEmp/100);
        }
    }

    // Retorna a comissão
    public double getCommissionSale()
    {
        return this.commissionSale;
    }

    // Salário do Empregado comissionado
    @Override
    public double setLiquidSalariedEmployee()
    {
        return this.liquidSalary += this.salaryMonthly/2 + getCommissionSale()*getSalesResult()
                - getUnionFee()/2 - getOthersFee()/2;
    }
}
