package sudokuPackage.userinterface;

public interface IUserInterfaceContract
{
    interface EventListener
    {
        void onInput(int row, int col, int input);
        void onClick();
    }

    interface View
    {
        void setListener(IUserInterfaceContract.EventListener listener);

        void updateSquare(int row, int col, int input);
        void updateBoard(SudokuGame game);

        void showDialog(String message);
        void showError(String message);

    }

}
