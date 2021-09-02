package sudokuPackage.userinterface;

import com.sun.prism.image.Coords;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;
import sudokuPackage.sudokuDomain.gridCoordinates;

import java.awt.*;
import java.util.HashMap;

public class userInterfaceImpl implements IUserInterfaceContract.View, EventHandler<KeyEvent>
{

    private final Stage stage;
    private final Group root;

    //Store references to all textfields in hashmaps
    private HashMap<gridCoordinates, SudokuTextField> textFieldCoordinates;

    private IUserInterfaceContract.EventListener listener;

    private static final double WINDOW_X = 750;
    private static final double WINDOW_Y = 680;
    private static final double BOARD_BOARDERS = 50;
    private static final double X_Y = 580;

    private static final Color WINDOW_BACKGROUND = Color.BLACK;
    private static final Color BOARD_BACKGROUND = Color.WHITE;

    private static final String title = "Sudoku";

    public userInterfaceImpl(Stage stage)
    {
        this.stage = stage;
        this.root = new Group();

        this.textFieldCoordinates = new HashMap<>();
        initializeUserInterface();
    }

    public void initializeUserInterface()
    {
        drawBackground(root);
        writeTitle(root);
        drawBoard(root);
        drawTextFields(root);
        drawGrid(root);

        stage.show();
    }


    private void drawBackground(Group root)
    {

    }

    private void writeTitle(Group root)
    {

    }

    private void drawBoard(Group root)
    {

    }

    private void drawTextFields(Group root)
    {

    }

    private void drawGrid(Group root)
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

    @Override
    public void handle(KeyEvent keyEvent)
    {

    }
}
