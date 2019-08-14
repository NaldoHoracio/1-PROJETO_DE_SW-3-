/**!
 * @className tools.BackupTransation.java
 * @author Edvonaldo Horácio (edvonaldohs@ic.ufal.br)
 * @brief
 * @version 0.1
 * @date 2019-06-26
 *
 * @copyright Copyright (c) IC 2019
 *
 */
package payroll.tools;

import payroll.employees.Employee;

public class BackupTransation {

    public static void safetyData(Employee empCurrent, Employee empBackup)
    {
        // Configurar corretamente a inserção dos dados em empBackup
        /*empBackup.getName() = empCurrent.getName();
        // BACKUP ADRESS
        empBackup.getPublicPlace() = empCurrent.getPublicPlace();
        empBackup.getNumHouse() = empCurrent.getNumHouse();
        empBackup.getCepPlace() = empCurrent.getCepPlace();
        empBackup.getCity() = empCurrent.getCity();
        empBackup.getCountry() = empCurrent.getCountry();
        empBackup.getSalaryMonthly() = empCurrent.getSalaryMonthly();// Backup salario mensal
        empBackup.getIdEmployee() = empCurrent.getIdEmployee();// Backup ID
        empBackup.getTypeEmployee() = empCurrent.getTypeEmployee();// Backup TIPO DE EMPREGADO
        empBackup.getTypeOfPayment() = empCurrent.getTypeOfPayment();// Backup TIPO DE PAGAMENTO
        empBackup.getDataPay() = empCurrent.getDataPay();// Backup data do mês
        empBackup.getDayWeeklyPay() = empCurrent.getDayWeeklyPay();// Backup do dia da semana
        empBackup.isSyndicalist() = empCurrent.isSyndicalist();// Backup da situação sindical
        empBackup.getIdSyndicalist() = empCurrent.getIdSyndicalist();// Backup ID sindicato
        empBackup.getUnionFee() = empCurrent.getUnionFee();// Backup da TAXA FIXA do sindicato
        empBackup.getOthersFee() = empCurrent.getOthersFee();// Backup das outras taxas
        if(empCurrent instanceof CommissionEmployee)
        {
            ((CommissionEmployee )empBackup).getSalesResult() = ((CommissionEmployee )empCurrent).getSalesResult();// Backup vendas
            ((CommissionEmployee )empBackup).getCommissionSale() = ((CommissionEmployee )empCurrent).getCommissionSale();// Backup do percentual
        }
        if(empCurrent instanceof HourlyEmployee)
        {
            ((HourlyEmployee)empBackup).getWageSalary() = ((HourlyEmployee)empCurrent).getWageSalary();
            ((HourlyEmployee)empBackup).getSalaryDay() = ((HourlyEmployee)empCurrent).getSalaryDay();
        }*/
    }
}
