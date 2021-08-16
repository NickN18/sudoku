package sudokuPackage;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sudokuPackage.userinterface.IUserInterfaceContract;

public class SudokuApp extends Application {

    private IUserInterfaceContract.View uiImpl;

    @Override
    public void start(Stage primaryStage) throws Exception
    {
        uiImpl = new UserInterfaceImpl(primaryStage);
    }


    public static void main(String[] args) {
        launch(args);
    }
}
