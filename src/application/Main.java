package application;
	
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Rectangle2D;
import javafx.stage.Screen;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Main extends Application {
	private double xOffSet;
	private double yOffSet;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			
			primaryStage.initStyle(StageStyle.UTILITY);
			primaryStage.setOpacity(0);
			primaryStage.show();
			
			Stage secStage = new Stage();
			secStage.initStyle(StageStyle.UNDECORATED);
			secStage.initOwner(primaryStage);
			
			Parent root = FXMLLoader.load(getClass().getResource("/application/Malaysia.fxml"));
			Scene scene = new Scene(root);
			scene.getStylesheets().add(getClass().getResource("/application/file.css").toExternalForm());
			secStage.setScene(scene);
			secStage.show();
			
			//make it right-top aligned
			Rectangle2D visualBounds = Screen.getPrimary().getVisualBounds();
			secStage.setX(visualBounds.getMaxX() - 25 - scene.getWidth());
			secStage.setY(visualBounds.getMinY() + 25);
			
			//add support for drag and move
			scene.setOnMousePressed(event -> {
				xOffSet = secStage.getX() - event.getScreenX();
				yOffSet = secStage.getY() - event.getScreenY();
			});
			scene.setOnMouseDragged(event -> {
				secStage.setX(event.getScreenX() + xOffSet);
				secStage.setY(event.getScreenY() + yOffSet);
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
