package sudokuPackage.computationalLogic;

import sudokuPackage.SudokuApp;
import sudokuPackage.constants.GameState;
import sudokuPackage.constants.Rows;
import sudokuPackage.sudokuDomain.sudokuMain;

import java.util.ArrayList;
import java.util.List;

public class GameLogic
{
    public static SudokuApp getNewGame()
    {
        return new SudokuApp(GameState.NEW, GameGenerator.getNewGameGrid());
    }

    public static GameState checkCompletion(int[][] grid)
    {
        if(sudokuIsInvalid(grid)) return GameState.ACTIVE;
        if(tilesAreNotFilled(grid)) return GameState.ACTIVE;

        return GameState.FINISHED;
    }


    private static boolean sudokuIsInvalid(int[][] grid)
    {
        if(rowsAreInvalid(grid)) return true;
        if(columnsAreInvalid(grid)) return true;
        if(squaresAreInvalid(grid)) return true;
        else return false;
    }

    private static boolean squaresAreInvalid(int[][] grid)
    {
        if(rowOfSquaresIsInvalid(Rows.TOP, grid)) return true;
        if(rowOfSquaresIsInvalid(Rows.MIDDLE, grid)) return true;
        if(rowOfSquaresIsInvalid(Rows.BOTTOM, grid)) return true;

        return false;
    }

    private static boolean rowOfSquaresIsInvalid(Rows value, int[][] grid)
    {
        switch (value)
        {
            case TOP:
                if(squareIsInvalid(0, 0, grid)) return true;
                if(squareIsInvalid(0, 3, grid)) return true;
                if(squareIsInvalid(0, 6, grid)) return true;

        }

        return false;
    }

    private static boolean squareIsInvalid(int x, int y, int[][] grid)
    {
        int xEnd = x + 3;
        int yEnd = y + 3;

        List<Integer> square = new ArrayList<>();

        while(y < yEnd)
        {
            while(x < xEnd)
            {
                square.add(grid[x][y]);

                x++;
            }
            x -= 3;
            y++;
        }

        if(collectionHasRepeats(square)) return true;
        return false;

    }

    private static boolean collectionHasRepeats(List<Integer> square)
    {


        return false;
    }


    private static boolean tilesAreNotFilled(int[][] grid)
    {
        for(int i = 0; i < sudokuMain.gridBounds; i++)
        {
            for(int j = 0; j < sudokuMain.gridBounds; j++)
            {
                if(grid[i][j] == 0) return true;
            }
        }

        return false;

    }

}
