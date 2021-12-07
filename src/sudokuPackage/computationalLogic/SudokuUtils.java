package sudokuPackage.computationalLogic;

import sudokuPackage.SudokuApp;
import sudokuPackage.sudokuDomain.sudokuMain;

public class SudokuUtils
{
    public static void copSudokuArrayValues(int[][] oldArray, int[][] newArray)
    {
        for(int i = 0; i < sudokuMain.gridBounds; i++)
        {
            for(int j = 0; j < sudokuMain.gridBounds; j++)
            {
                newArray[i][j] = oldArray[i][j];
            }
        }

    }

    public static int[][] copyToNewArray(int[][] oldArray)
    {
        int[][] newArray = new int[sudokuMain.gridBounds][sudokuMain.gridBounds];

        for(int i = 0; i < sudokuMain.gridBounds; i++)
        {
            for(int j = 0; j < sudokuMain.gridBounds; j++)
            {
                newArray[i][j] = oldArray[i][j];
            }
        }

        return newArray;
    }


}
