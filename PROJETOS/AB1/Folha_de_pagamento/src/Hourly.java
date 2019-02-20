// Classe derivada (ou subclasse ou classe concreta) Hourly
// Empregados tipo horistas
public class Hourly extends Employee
{
    // Constantes úteis
    private final double MIN_HOUR = 0.0;// Mínimo de horas possíveis
    private final double NORMAL_WEEKLY_SCHEDULE = 40.0;// Carga horária semanal normal
    private final double MAX_HOUR = 168.0;// Máximo de horas - 24h*7dias (It is a machine?)
    private double hourlyWorked;// Horas trabalhadas
    private double hourlyWage;// Preço por hora

    public Hourly();// Construtor vazio

    // Método para configurar as horas
    public void setHours(double hours)
    {
        // Número
        if((hours <= MIN_HOUR) || (hours >= MAX_HOUR))
        {
            throw new IllegalAccessException("Hour worked must be >= 0.0 and <= 168.0");
        }else{
            this.hours = hourlyWorked;
        }
    }// Fim do método setHour

    // Método para pegar as horas
    public double getHours()
    {
        return hourlyWorked;
    }// Fim do método getHour

    // Método para configurar o preço por hora
    public void setWage(double wage)
    {
        if(wage <= 0.0)
        {
            throw new IllegalAccessException("Hourly wage must be > 0.0.");
        }else{
            this.hourlyWage = wage;
        }
    }// Fim do método setWage

    // Método para pegar o preço por hora
    public double getWage()
    {
        return hourlyWage;
    }// Fim do método getWage

    // Sobre-escrevendo método payment declarado abstract em Employee
    @Override
    public double payment()
    {
        // Sem hora extra
        if(getHours() <= NORMAL_WEEKLY_SCHEDULE)
        {
            return getWage()*getHours();
        }else{
            return (NORMAL_WEEKLY_SCHEDULE * getWage() + (getHours() - (NORMAL_WEEKLY_SCHEDULE
            * getWage()) * 1.5));
        }
    }
}// Fim da classe Hourly
