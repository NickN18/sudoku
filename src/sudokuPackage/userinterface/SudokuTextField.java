package sudokuPackage.userinterface;

import javafx.scene.control.TextField;

public class SudokuTextField extends TextField
{
    private final int row;
    private final int col;

    public SudokuTextField(int row, int col)
    {
        this.row = row;
        this.col = col;
    }

    public int getRow() { return row; }
    public int getCol() { return col; }

    @Override
    public void replaceText(int i, int j, String str)
    {
        if(!str.matches("[0-9]"))
        {

        }

    }
}
