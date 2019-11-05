package Main;

import View.PercentageView;
import View.RapportcijferView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.Pane;

public class BPmenubar extends MenuBar {

	private Menu mRapport;
	private MenuItem miRapportcijferView, miPercentageView;

	public BPmenubar(Pane mainView) {
		// menus
		mRapport = new Menu("Rapportage");
		miRapportcijferView = new MenuItem("Rapportcijfer");
		miPercentageView = new MenuItem("Percentage");

		// menu activiteit
		miRapportcijferView.setOnAction(event -> {
			mainView.getChildren().clear();
			new RapportcijferView(mainView);
		});

		miPercentageView.setOnAction(event -> {
			mainView.getChildren().clear();
			new PercentageView(mainView);
		});

		mRapport.getItems().addAll(miRapportcijferView, miPercentageView);

		this.getMenus().add(mRapport);
	}

}
