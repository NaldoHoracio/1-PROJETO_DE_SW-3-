/**!
 * @className Employee.java
 * @author Edvonaldo Horácio (edvonaldohs@ic.ufal.br)
 * @brief
 * @version 0.1
 * @date 2019-06-19
 *
 * @copyright Copyright (c) IC 2018
 *
 */

public abstract class Employee {
    private String name;// Nome
    private String address;// Endereço
    private int idEmployee;// Número de identificação do empregado
    private int isSyndicalist;// Verifica se o empregado faz ou não parte do sindicato (1 - Sim | 0 - Não)
    private int idSyndicalist;// Id do empregado no sindicato
    private double unionFee;// Taxa do sindicato, caso o empregado faça parte
    private double othersFee;// Outras taxas e deduções do salário

    // Retorna o nome
    public String getName()
    {
        return name;
    }

    // Retorna o endereço
    public String getName()
    {
        return address;
    }

    // Retorna o ID do empregado
    public int getIdEmployee()
    {
        return idEmployee;
    }

    // Retorna se o empregado é sindicalista ou não
    public int isSyndicalistEmployee(int is)
    {
        return (is == 1) ? 1:0;
    }

    // Retorna o id do funcionário no sindicato
    public int getIdSyndicalist()
    {
        return idSyndicalist;
    }

    // Retorna a taxa do sindicato paga pelo empregado, caso o mesmo faça para do Sindicato
    public double getUnionFee()
    {
        return unionFee;
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
        return String.format("Employee %s has ID %d", getName(), getIdEmployee());
    }

    // Método abstrato que retornar o salário total do empregado de acordo com seu tipo
    public abstract double salariedEmployee();
}
