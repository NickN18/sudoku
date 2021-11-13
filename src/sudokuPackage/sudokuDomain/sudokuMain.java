package sudokuPackage.sudokuDomain;

public class sudokuMain<GameState>
{
    private final GameState gameState;
    private final int[][] grid;

    public static final int gridBounds = 9;

    public sudokuMain(GameState gameState, int[][] grid)
    {
        this.gameState = gameState;
        this.grid = grid;
    }

    public GameState getGameState() { return gameState; }

    public int[][] getGrid() { return grid; }


}
