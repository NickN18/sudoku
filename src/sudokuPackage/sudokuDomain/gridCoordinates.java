package sudokuPackage.sudokuDomain;

public class gridCoordinates
{
    private final int x, y;

    public gridCoordinates(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX()
    {
        return x;
    }

    public int getY()
    {
        return y;
    }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) { return true; }

        if(obj == null || getClass() != obj.getClass()) { return false; }




    }
}
