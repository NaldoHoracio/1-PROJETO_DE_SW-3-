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

    // Sobrescrevendo o método toString
    @Override
    public String toString()
    {
        return String.format("Employee %s has ID %d", getName(), getIdEmployee());
    }

    // Método abstrato que retornar o salário total do empregado de acordo com seu tipo
    public abstract double salariedEmployee();
}
