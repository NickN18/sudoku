package sudokuPackage.sudokuDomain;

import java.io.IOException;

public interface storage
{
    void updateGameGrid(sudokuMain game) throws IOException;
    sudokuMain getGameGrid() throws IOException;
}
