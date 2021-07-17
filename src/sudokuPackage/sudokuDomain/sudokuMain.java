package sudokuPackage.sudokuDomain;

public class sudokuMain
{
    private final State gameState;
    private final int[][] grid;

    public static final gridBounds = 9;

    public sudokuMain(State gameState, int[][] grid)
    {
        this.gameState = gameState;
        this.grid = grid;
    }

    public State getGameState() { return gameState; }

    public int[][] getGrid() { return grid; }
}
