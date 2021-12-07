package sudokuPackage.computationalLogic;

import sudokuPackage.sudokuDomain.gridCoordinates;
import sudokuPackage.sudokuDomain.sudokuMain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GameGenerator
{
    public static int[][] getNewGameGrid()
    {
        return unsolveGame(getSolvedGame());
    }

    private static int[][] unsolveGame(int[][] solvedGame)
    {
        Random random = new Random(System.currentTimeMillis());

        boolean solvable = false;
        int[][] solvableArray = new int[sudokuMain.gridBounds][sudokuMain.gridBounds];

        while(solvable == false)
        {
            SudokuUtils.copSudokuArrayValues(solvedGame, solvableArray);

            int index = 0;

            while(index < 40)
            {
                int xCoord = random.nextInt(sudokuMain.gridBounds);
                int yCoord = random.nextInt(sudokuMain.gridBounds);

                if(solvableArray[xCoord][yCoord] != 0) {
                    solvableArray[xCoord][yCoord] = 0;
                    index++;
                }
            }

            int[][] toBeSolved = new int[sudokuMain.gridBounds][sudokuMain.gridBounds];

            SudokuUtils.copSudokuArrayValues(solvableArray, toBeSolved);

            solvable = SudokuSolver.puzzleIsSolvable(toBeSolved);

        }

        return solvableArray;

    }



    private static int[][] getSolvedGame()
    {
        Random random = new Random(System.currentTimeMillis());

        int[][] newGrid =  new int[sudokuMain.gridBounds][sudokuMain.gridBounds];

        for(int i = 1; i <= sudokuMain.gridBounds; i++)
        {
            int allocations = 0;
            int interrupt = 0;

            List<gridCoordinates> allocTracker = new ArrayList<>();

            int attempt = 0;

            while(allocations < sudokuMain.gridBounds)
            {
                if(interrupt > 200)
                {
                    allocTracker.forEach(coord -> {
                        newGrid[coord.getX()][coord.getY()] = 0;
                    });

                    interrupt = 0;
                    allocations = 0;
                    allocTracker.clear();
                    attempt++;

                    if(attempt > 500)
                    {
                        clearArray(newGrid);
                        attempt = 0;
                        i = 1;
                    }
                }

                int xCoord = random.nextInt(sudokuMain.gridBounds);
                int yCoord = random.nextInt(sudokuMain.gridBounds);

                if(newGrid[xCoord][yCoord] == 0)
                {
                    newGrid[xCoord][yCoord] = i;

                    if(GameLogic.sudokuIsInvalid(newGrid))
                    {
                        newGrid[xCoord][yCoord] = 0;
                        interrupt++;
                    } else
                    {
                        allocTracker.add(new gridCoordinates(xCoord, yCoord));
                        allocations++;
                    }
                }
            }
         }
        return newGrid;
    }

    public static void clearArray(int[][] newGrid)
    {
        for(int i = 0; i < sudokuMain.gridBounds; i++)
        {
            for(int j = 0; j < sudokuMain.gridBounds; j++)
            {
                newGrid[i][j] = 0;
            }
        }

    }


}



