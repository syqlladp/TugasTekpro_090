//*****************************************
// Rectangle.java
//
// Represents a rectangle.
//*****************************************
public class Rectangle extends Shape
{
    private double length;
    private double width;

    // Constructor
    public Rectangle(double l, double w)
    {
        super("Rectangle");
        length = l;
        width = w;
    }

    // Computes area
    public double area()
    {
        return length * width;
    }

    // toString method
    public String toString()
    {
        return super.toString() + " of length " + length + " and width " + width;
    }
}