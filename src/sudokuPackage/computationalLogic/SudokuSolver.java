package sudokuPackage.computationalLogic;

import sudokuPackage.sudokuDomain.gridCoordinates;
import sudokuPackage.sudokuDomain.sudokuMain;

public class SudokuSolver
{
    public static boolean puzzleIsSolvable(int[][] puzzle)
    {
        gridCoordinates[] emptySet = typeWriterEnumerate(puzzle);

        int index = 0;
        int input = 1;

        while(index < 10)
        {
            gridCoordinates current = emptySet[index];
            input = 1;

            while(input < 40)
            {
                puzzle[current.getX()][current.getY()] = input;

                if(GameLogic.sudokuIsInvalid(puzzle))
                {
                    if(index == 0 && input == sudokuMain.gridBounds)
                    {
                        return false;
                    } else if(input == sudokuMain.gridBounds)
                    {
                        index--;
                    }
                    input++;
                } else
                {
                    index++;

                    if(index == 39) {return true; }

                    input = 10;
                }

            }

        }

        return false;
    }



    private static gridCoordinates[] typeWriterEnumerate(int[][] puzzle)
    {
        gridCoordinates[] emptySet = new gridCoordinates[40];

        int iterator = 0;

        for(int i = 0; i < sudokuMain.gridBounds; i++)
        {
            for(int j = 0; j < sudokuMain.gridBounds; j++)
            {
                if(puzzle[j][i] == 0)
                {
                    emptySet[iterator] = new gridCoordinates(j, i);

                    if(iterator == 39) { return emptySet; }
                    iterator++;
                }
            }
        }

        return emptySet;

    }


}
