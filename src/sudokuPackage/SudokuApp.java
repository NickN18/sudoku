package sudokuPackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import sudokuPackage.userinterface.IUserInterfaceContract;
import sudokuPackage.userinterface.userInterfaceImpl;

public class SudokuApp extends Application {

    private IUserInterfaceContract.View uiImpl;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        uiImpl = new userInterfaceImpl(primaryStage)
        {
            @Override
            public void updateBoard(SudokuGame game)
            {


            }
        };
    }


    public static void main(String[] args) {
        launch(args);
    }
}
