package sudokuPackage.userinterface.logic;

import sudokuPackage.SudokuApp;
import sudokuPackage.computationalLogic.GameLogic;
import sudokuPackage.constants.GameState;
import sudokuPackage.constants.gameMessages;
import sudokuPackage.sudokuDomain.storage;
import sudokuPackage.sudokuDomain.sudokuMain;
import sudokuPackage.userinterface.IUserInterfaceContract;

import java.io.IOException;

public class ControlLogic implements IUserInterfaceContract.EventListener
{

    private sudokuPackage.sudokuDomain.storage storage;

    private IUserInterfaceContract.View view;

    public ControlLogic(storage storage, IUserInterfaceContract.View view)
    {
        this.storage = storage;
        this.view = view;
    }

    @Override
    public void onInput(int row, int col, int input)
    {
        try
        {
            sudokuMain gameData = storage.getGameGrid();

            int[][] newGameState = gameData.getCopyOfGridState();
            newGameState[row][col] = input;

            gameData = new SudokuApp(GameLogic.checkCompletion(newGameState), newGameState);

            storage.updateGameGrid(gameData);

            view.updateSquare(row, col, input);

            if(gameData.getGameState() == GameState.FINISHED)
            {
                view.showDialog(gameMessages.gameComplete);
            }

        } catch (IOException e)
        {
            e.printStackTrace();
            view.showError(gameMessages.gameError);
        }

    }

    @Override
    public void onClick()
    {
        try
        {
            storage.updateGameGrid(GameLogic.getNewGame());

            view.updateBoard(storage.getGameGrid());


        } catch (IOException e)
        {
            view.showError(gameMessages.gameError);
        }

    }
}
