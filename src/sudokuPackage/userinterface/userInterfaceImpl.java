package sudokuPackage.userinterface;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Background;

import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import sudokuPackage.SudokuApp;
import sudokuPackage.constants.GameState;
import sudokuPackage.sudokuDomain.gridCoordinates;

import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;

import javafx.scene.shape.Rectangle;
import javafx.scene.paint.*;
import javafx.scene.text.Font;
import sudokuPackage.sudokuDomain.sudokuMain;


import java.awt.*;
import java.util.HashMap;

public abstract class userInterfaceImpl implements IUserInterfaceContract.View, EventHandler<KeyEvent>
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

    private static final String TITLE = "Sudoku";

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
        Scene scene = new Scene(root, WINDOW_X, WINDOW_Y);
        scene.setFill(WINDOW_BACKGROUND);
        stage.setScene(scene);
    }

    private void writeTitle(Group root)
    {
        Text title = new Text(235, 690, TITLE);
        title.setFill(Color.WHITE);
        Font titleFont = new Font(43);
        title.setFont(titleFont);
        root.getChildren().add(title);


    }

    /**
     * Draws the board according to the previously stated dimensions above. Sets the
     * background color to white (also previously stated)
     *
     * @param root
     */
    private void drawBoard(Group root)
    {
        Rectangle boardBackground = new Rectangle();

        boardBackground.setX(BOARD_BOARDERS);
        boardBackground.setY(BOARD_BOARDERS);

        boardBackground.setWidth(X_Y);
        boardBackground.setHeight(X_Y);

        boardBackground.setFill(BOARD_BACKGROUND);

        root.getChildren().addAll(boardBackground);         //MINUTE 34:37

    }

    /**
     * Draws textfields for numbers on sudoku boards. Handles the tiles to be passed the numbers into
     *
     * @param root
     */
    private void drawTextFields(Group root)
    {
        final int xOrigin = 50;
        final int yOrigin = 50;

        final int X_YDelta = 64;

        //O(n^2) complexity (obviously)
        for(int xIndex = 0; xIndex < 9; xIndex++)
        {
            for(int yIndex = 0; yIndex < 9; yIndex++)
            {
                int x = xOrigin + xIndex * X_YDelta;
                int y = yOrigin + yIndex * X_YDelta;

                SudokuTextField tile = new SudokuTextField(xIndex, yIndex);

                styleSudokuTile(tile, x, y);

                tile.setOnKeyPressed(this);

                textFieldCoordinates.put(new gridCoordinates(xIndex, yIndex), tile);    //Coordinates become key and tile becomes value

                root.getChildren().add(tile);

            }
        }

    }


    /**
     * Creates a single Sudoku tile of size 64x64 pixels and at given coordinates x and y
     *
     * @param tile Tile to be stylized
     * @param x x-coordinate to place tile
     * @param y y-coordinate to place tile
     */
    private void styleSudokuTile(SudokuTextField tile, double x, double y)
    {
        Font numberFont = new Font(32);

        tile.setFont(numberFont);
        tile.setAlignment(Pos.CENTER);

        tile.setLayoutX(x);
        tile.setLayoutY(y);
        tile.setPrefHeight(64);
        tile.setPrefWidth(64);

        tile.setBackground(Background.EMPTY);
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

        line.setFill(Color.BLACK);

        return line;
    }

    @Override
    public void setListener(IUserInterfaceContract.EventListener listener)
    {

    }

    @Override
    public void updateSquare(int row, int col, int input)
    {
        SudokuTextField tile = textFieldCoordinates.get(new gridCoordinates(row, col));

        String value = Integer.toString(input);

        if(value.equals("0")) value = "";

        tile.textProperty().set(value);

    }

    @Override
    public void updateBoard(sudokuMain game)
    {
        for(int i = 0; i < 9; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                SudokuTextField tile = textFieldCoordinates.get(new gridCoordinates(i, j));

                String value = Integer.toString(game.getCopyOfGridState()[i][j]);

                if(value.equals("0")) value = "";

                tile.setText(value);

                if(game.getGameState() == GameState.NEW)
                {
                    if(value.equals(""))
                    {
                        tile.setStyle("-fx-opacity: 1;");
                        tile.setDisable(false);
                    } else
                    {
                        tile.setStyle("-fx-opacity: 0.8;");
                        tile.setDisable(true);

                    }

                }
            }
        }

    }

    @Override
    public void showDialog(String message)
    {
        Alert dialog = new Alert(Alert.AlertType.CONFIRMATION, message, ButtonType.OK);
        dialog.showAndWait();

        if(dialog.getResult() == ButtonType.OK) listener.onClick();

    }

    @Override
    public void showError(String message)
    {
        Alert dialog = new Alert(Alert.AlertType.ERROR, message, ButtonType.OK);
        dialog.showAndWait();

    }

    @Override
    public void handle(KeyEvent keyEvent)
    {
        if(keyEvent.getEventType() == KeyEvent.KEY_PRESSED)
        {
            if(keyEvent.getText().matches("[0-9]"))
            {
                int value = Integer.parseInt(keyEvent.getText());

            }
        }

    }
}
