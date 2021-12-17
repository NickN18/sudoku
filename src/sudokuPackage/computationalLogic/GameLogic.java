package sudokuPackage.computationalLogic;

import sudokuPackage.SudokuApp;
import sudokuPackage.constants.GameState;
import sudokuPackage.constants.Rows;
import sudokuPackage.sudokuDomain.sudokuMain;

import java.util.ArrayList;
import java.util.Collections;
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


    public static boolean sudokuIsInvalid(int[][] grid)
    {
        if(rowsAreInvalid(grid)) return true;
        if(columnsAreInvalid(grid)) return true;
        if(squaresAreInvalid(grid)) return true;
        else return false;
    }

    private static boolean rowsAreInvalid(int[][] grid) {
        for(int i = 0; i < sudokuMain.gridBounds; i++)
        {
            List<Integer> row = new ArrayList<>();

            for(int j = 0; j < sudokuMain.gridBounds; j++)
            {
                row.add(grid[j][i]);
            }

            if(collectionHasRepeats(row)) return true;
        }

        return false;
    }

    private static boolean columnsAreInvalid(int[][] grid) {
        for(int i = 0; i < sudokuMain.gridBounds; i++)
        {
            List<Integer> row = new ArrayList<>();

            for(int j = 0; j < sudokuMain.gridBounds; j++)
            {
                row.add(grid[i][j]);
            }

            if(collectionHasRepeats(row)) return true;
        }

        return false;
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
                return false;

            case MIDDLE:
                if(squareIsInvalid(3, 0, grid)) return true;
                if(squareIsInvalid(3, 3, grid)) return true;
                if(squareIsInvalid(3, 6, grid)) return true;
                return false;

            case BOTTOM:
                if(squareIsInvalid(6,0, grid)) return true;
                if(squareIsInvalid(6, 3, grid)) return true;
                if(squareIsInvalid(6, 6, grid)) return true;
                return false;

            default:
                return false;
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

    private static boolean collectionHasRepeats(List<Integer> collection)
    {
        for(int i = 1; i <= sudokuMain.gridBounds; i++)
        {
            if(Collections.frequency(collection, i) > 1) return true;
        }

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
