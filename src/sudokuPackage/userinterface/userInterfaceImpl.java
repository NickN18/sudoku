package sudokuPackage.userinterface;

import javafx.event.EventHandler;
import javafx.scene.input.KeyEvent;

public class userInterfaceImpl implements IUserInterfaceContract.View, EventHandler<KeyEvent>
{

        @Override
        public void handle(KeyEvent keyEvent)
        {

        }

        @Override
        public void setListener(IUserInterfaceContract.EventListener listener)
        {

        }

        @Override
        public void updateSquare(int row, int col, int input)
        {

        }

        @Override
        public void updateBoard(SudokuGame game)
        {

        }

        @Override
        public void showDialog(String message)
        {

        }

        @Override
        public void showError(String message)
        {

        }
    }

}
