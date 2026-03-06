public class Salesperson implements Comparable<Salesperson>
{
    private String firstName, lastName;
    private int totalSales;

    public Salesperson(String first, String last, int sales)
    {
        firstName = first;
        lastName = last;
        totalSales = sales;
    }

    public String toString()
    {
        return lastName + ", " + firstName + ": \t" + totalSales;
    }

    public int compareTo(Salesperson other)
    {
        if (totalSales < other.totalSales)
            return -1;
        else if (totalSales > other.totalSales)
            return 1;
        else
        {
            int result = lastName.compareTo(other.lastName);

            if (result == 0)
                result = firstName.compareTo(other.firstName);

            return result;
        }
    }

    public String getFirstName()
    {
        return firstName;
    }

    public String getLastName()
    {
        return lastName;
    }

    public int getSales()
    {
        return totalSales;
    }
}