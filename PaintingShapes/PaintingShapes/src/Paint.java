public class Paint
{
    private double coverage; //square feet per gallon

    // Constructor
    public Paint(double c)
    {
        coverage = c;
    }

    // Computes amount of paint needed
    public double amount(Shape s)
    {
        System.out.println("Computing amount for " + s);
        return s.area() / coverage;
    }
}