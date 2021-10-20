package sudokuPackage.userinterface;

import sudokuPackage.sudokuDomain.gridCoordinates;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.Paint;

import java.awt.*;
import java.util.HashMap;

public class userInterfaceImpl implements IUserInterfaceContract.View, EventHandler<KeyEvent>
{

    private final Stage stage;
    private final Group root;

    //Store references to all textfields in hashmaps
    private HashMap<gridCoordinates, SudokuTextField> textFieldCoordinates;

    private IUserInterfaceContract.EventListener listener;

    private static final double WINDOW_X = 680;
    private static final double WINDOW_Y = 750;
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

    /**
     * Draws the whole grid. Uses getLine() as a helper function
     *
     * @param root
     */
    private void drawGrid(Group root)
    {
        int startingGridLine = 114;                 //where we start to draw the gridlines
        int index = 0;

        while (index < 8)
        {
            int thickness;

            if(index == 2 || index == 5)
            {
                thickness = 3;
            } else
            {
                thickness = 2;
            }

            Rectangle verticalLine = getLine(
                    startingGridLine + (64 * index),
                    BOARD_BOARDERS,
                    X_Y,
                    thickness
            );

            Rectangle horizontalLine = getLine(
                    BOARD_BOARDERS,
                    startingGridLine + (64 * index),
                    thickness,
                    X_Y
            );

            root.getChildren().addAll(verticalLine, horizontalLine);

            index++;
        }
    }

    /**
     * Helper function
     *
     * Returns a straight line as determined by the x and y coordinates given, and the width and height
     * of the desired line
     *
     * It's important to understand that the code is simply creating a rectangle that, given the
     * parameters, returns a rectangle that appears as a line
     *
     * @param x x-coordinate
     * @param y y-coordinate
     * @param height how long the line should be in the y-direction
     * @param width how long the line should be in the x-direction
     * @return solid black line
     */
    private Rectangle getLine(double x, double y, double height, double width)
    {
        Rectangle line = new Rectangle();

        line.setX(x);
        line.setY(y);
        line.setHeight(height);
        line.setWidth(width);

        line.setFill(javafx.scene.paint.Color.BLACK);

        return line;
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
