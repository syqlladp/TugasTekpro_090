//*****************************************
// Shape.java
//
// Abstract class representing a shape.
//*****************************************
public abstract class Shape
{
    protected String shapeName;

    // Constructor
    public Shape(String name)
    {
        shapeName = name;
    }

    // Abstract method
    public abstract double area();

    // toString method
    public String toString()
    {
        return shapeName;
    }
}