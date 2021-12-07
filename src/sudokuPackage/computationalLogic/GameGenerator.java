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
            }
         }

        return new int[0][];
    }

    public static void clearArray(int[][] newGrid)
    {

    }


}
