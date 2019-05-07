
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainLauncher extends Application 
{
	Stage window;
    @Override
    public void start(Stage stage) throws Exception 
    {
        Parent root = FXMLLoader.load(getClass().getResource("MainController.fxml"));
        
        Scene scene = new Scene(root);
        window = stage;
        window.setTitle("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ Albums Saver Laba8 ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}