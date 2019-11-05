package Main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage arg0) throws Exception {

		Pane mainView = new Pane();
		BPmenubar bar = new BPmenubar(mainView);

		VBox root = new VBox(bar, mainView);
		Scene scene = new Scene(root, 650, 550);

		arg0.setScene(scene);
		arg0.setTitle("Oordeel Woonomgeving - Wijken");
		arg0.show();
	}

}
