
// Superclasse abstrata Employee (Empregado)
public abstract class Employee
{
    private String nameEmployee;// Nome do empregado
    private String addressEmployee;// Endereço do empregado
    private String typeEmployee;// Tipo de empregado (hourly/ salaried/ comissioned)
    private String codEmployee;// Código do empregado (único)

    public Employee();// Construtor vazio

    // Configurando o nome
    public void setNameEmployee(String name)
    {
        nameEmployee = name;
    }// Fim do método setNameEmployee

    // Método para retornar o nome do empregado
    public void getNameEmployee()
    {
        return nameEmployee;
    }// Fim do método getNameEmployee

    // Configurando o endereço do empregado
    public void setAddress(String address)
    {
        addressEmployee = address;
    }// Fim do método setAddress

    // Método para retornar o endereço do empregado
    public void getAddress()
    {
        return addressEmployee;
    }// Fim do método que retorna o endereço do empregado

    // Configurando o tipo de empregado
    public void setType(String type)
    {
        typeEmployee = type;
    }// Fim do método getType

    // Método que retorna um número indicando o tipo de empregado
    public void getType()
    {
        return typeEmployee;
    }// Fim do método getType

    // Configurando o código do empregado
    public int setCod(int cod)
    {
        codEmployee = cod;
    }// Fim do método setCod

    // Método que retorna o código (único) do empregado
    public int getCod()
    {
        return codEmployee;
    }// Fim do método getCod

    // Método abstract payment que deve ser escrito pelas classes concretas
    // Como é um método abstract, cada classe concreta deve implementar a sua forma de acordo
    // Com o tipo de funcionário
    public abstract double payment();
}// Fim da classe abstrata Employee
