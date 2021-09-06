package sudokuPackage.sudokuDomain;

import java.util.Objects;

public class gridCoordinates
{
    private final int x, y;

    public gridCoordinates(int x, int y)
    {
        this.x = x;
        this.y = y;
    }

    public int getX() { return x; }

    public int getY() { return y; }

    @Override
    public boolean equals(Object obj)
    {
        if(this == obj) { return true; }

        if(obj == null || getClass() != obj.getClass()) { return false; }

        gridCoordinates next = (gridCoordinates) obj;

        return x == next.x && y == next.y;
    }

    @Override
    public int hashCode() { return Objects.hash(x, y); }
}
