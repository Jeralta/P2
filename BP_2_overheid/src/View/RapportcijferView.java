
package View;

import java.util.ArrayList;

import Main.JsonReader;
import Model.Cijfer;
import Model.Rapportcijfer;
import Model.Wijk;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;

public class RapportcijferView extends GridPane {

	private ArrayList<Wijk> wijken = new ArrayList<Wijk>();
	private JsonReader jreader = new JsonReader();
	private ComboBox<String> cbx = new ComboBox<String>();
	private ComboBox<String> cbx1 = new ComboBox<String>();
	private ListView<String> resultaat, resultaat1;
	private Button btn, btn1;
	private ObservableList<String> oList = FXCollections.observableArrayList();
	private ObservableList<String> oList1 = FXCollections.observableArrayList();

	public RapportcijferView(Pane mainView) {
		// ComboBox
		cbx.setPromptText("Kies Wijk");
		cbx1.setPromptText("Kies Wijk 2");

		// Fill ComboBox
		wijken = jreader.readJson();
		for (Wijk w : wijken) {

			cbx.getItems().add(w.getWijknaam());
			cbx1.getItems().add(w.getWijknaam());
		}
		// button & action
		btn = new Button("Show");
		btn.setOnAction(e -> {
			oList.clear();

			String Wijknaam = cbx.getValue().toString();
			// For loop
			for (Wijk w : wijken) {
				if (w.getWijknaam().equals(Wijknaam)) {
					for (Cijfer c : w.getCijfers()) {
						if (c instanceof Rapportcijfer) {
							Rapportcijfer r = (Rapportcijfer) c;

							oList.add(r.getOnderwerp() + " : " + r.getCijfer());

						}

					}
				}
			}
		});
		// button & action
		btn1 = new Button("Show");
		btn1.setOnAction(e -> {
			oList1.clear();

			String Wijknaam = cbx1.getValue().toString();
			// For loop
			for (Wijk w : wijken) {
				if (w.getWijknaam().equals(Wijknaam)) {
					for (Cijfer c : w.getCijfers()) {
						if (c instanceof Rapportcijfer) {
							Rapportcijfer r = (Rapportcijfer) c;
							oList1.add(r.getOnderwerp() + " : " + r.getCijfer());

						}

					}
				}
			}
		});

		// padding
		this.setPadding(new Insets(10, 10, 10, 10));
		this.setVgap(10);
		this.setHgap(5);

		// layout
		resultaat = new ListView<String>(oList);
		resultaat.setPrefHeight(370);
		resultaat.setPrefWidth(300);

		resultaat1 = new ListView<String>(oList1);
		resultaat1.setPrefHeight(370);
		resultaat1.setPrefWidth(300);

		add(cbx, 1, 1);
		add(btn, 1, 3);
		add(resultaat, 1, 4);

		add(cbx1, 2, 1);
		add(btn1, 2, 3);
		add(resultaat1, 2, 4);

		mainView.getChildren().add(this);

	}
}
