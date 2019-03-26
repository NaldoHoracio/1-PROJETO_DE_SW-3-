package interpretercontext;

public class Number implements Operate
{
    private double number;

    public Number(double number)
    {
        this.number = number;
    }

    @Override
    public double interpreterContext()
    {
        return this.number;
    }
}

