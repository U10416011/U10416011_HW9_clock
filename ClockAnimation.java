
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.util.Duration;

public class ClockAnimation extends Application {
	@Override // Override the start method in the Application class
	public void start(Stage primaryStage) {
    ClockPane clock = new ClockPane(); // Create a clock
    
    
	
    // Create a handler for animation
    EventHandler<ActionEvent> eventHandler = e -> {
      clock.setCurrentTime(); // Set a new clock time
    };
    
    // Create an animation for a running clock
    Timeline animation = new Timeline(
      new KeyFrame(Duration.millis(1000), eventHandler));
    animation.setCycleCount(Timeline.INDEFINITE);
    animation.play(); // Start animation
    
    Button btStart = new Button("Start");//add start button
    btStart.setLayoutX(70);
	btStart.setLayoutY(275);
	btStart.setOnAction(e -> animation.play());//add animation
	
    Button btStop = new Button("Stop");//add stop button
    btStop.setLayoutX(150);
	btStop.setLayoutY(275);
	btStop.setOnAction(e -> animation.pause());//add animation
	
	clock.getChildren().clear();
    clock.getChildren().add(btStop);
    clock.getChildren().add(btStart);
    // Create a scene and place it in the stage
    Scene scene = new Scene(clock, 250, 325);
    primaryStage.setTitle("ClockAnimation"); // Set the stage title
    primaryStage.setScene(scene); // Place the scene in the stage
    primaryStage.show(); // Display the stage
  }

  public static void main(String[] args) {
    launch(args);
  }
}
