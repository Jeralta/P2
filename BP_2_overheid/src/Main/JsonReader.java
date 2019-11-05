package Main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.net.URL;
import java.util.ArrayList;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import Model.Cijfer;
import Model.Percentage;
import Model.Rapportcijfer;
import Model.Wijk;

public class JsonReader {

	public JsonReader() {

	}

	public ArrayList<Wijk> readJson() {
		ArrayList<Wijk> al = new ArrayList<Wijk>();

		try {
			URL path = JsonReader.class.getResource("Data.json");
			File f = new File(path.getFile());
			BufferedReader reader = new BufferedReader(new FileReader(f));

			StringBuffer stringbuffer = new StringBuffer();
			String line = reader.readLine();
			while (line != null) {
				stringbuffer.append(line);
				line = reader.readLine();

			}
			JSONArray ja = (JSONArray) JSONValue.parseWithException(stringbuffer.toString());
			for (Object o : ja) {
				JSONObject jsonobject = (JSONObject) o;
				String onderwerp;
				String cijfer;
				ArrayList<Cijfer> cijfers = new ArrayList<>();

				onderwerp = "rapportcijfer algemeen buurtoordeel";
				cijfer = jsonobject.get(onderwerp).toString();
				Rapportcijfer algBO = new Rapportcijfer(onderwerp, cijfer);
				cijfers.add(algBO);

				onderwerp = "rapportcijfer sociale cohesie";
				cijfer = jsonobject.get(onderwerp).toString();
				Rapportcijfer soco = new Rapportcijfer(onderwerp, cijfer);
				cijfers.add(soco);

				onderwerp = "% eigen woonbuurt is (zeer) prettig";
				cijfer = jsonobject.get(onderwerp).toString();
				Percentage eigenWB = new Percentage(onderwerp, cijfer);
				cijfers.add(eigenWB);

				onderwerp = "% onprettige buurt";
				cijfer = jsonobject.get(onderwerp).toString();
				Percentage onprettig = new Percentage(onderwerp, cijfer);
				cijfers.add(onprettig);

				onderwerp = "% dat graag in de buurt wil blijven wonen";
				cijfer = jsonobject.get(onderwerp).toString();
				Percentage buurtblijf = new Percentage(onderwerp, cijfer);
				cijfers.add(buurtblijf);

				onderwerp = "% niet gehecht aan de buurt";
				cijfer = jsonobject.get(onderwerp).toString();
				Percentage nietgehecht = new Percentage(onderwerp, cijfer);
				cijfers.add(nietgehecht);

				onderwerp = "% positieve toekomstverwachting voor de buurt";
				cijfer = jsonobject.get(onderwerp).toString();
				Percentage posToekomst = new Percentage(onderwerp, cijfer);
				cijfers.add(posToekomst);

				onderwerp = "% negatieve toekomstverwachting voor de buurt";
				cijfer = jsonobject.get(onderwerp).toString();
				Percentage negToekomst = new Percentage(onderwerp, cijfer);
				cijfers.add(negToekomst);

				onderwerp = "% vaak last van omwonenden";
				cijfer = jsonobject.get(onderwerp).toString();
				Percentage lastBuren = new Percentage(onderwerp, cijfer);
				cijfers.add(lastBuren);

				onderwerp = "rapportcijfer netheid";
				cijfer = jsonobject.get(onderwerp).toString();
				Rapportcijfer cijfnet = new Rapportcijfer(onderwerp, cijfer);
				cijfers.add(cijfnet);

				onderwerp = "rapportcijfer groenonderhoud in de buurt";
				cijfer = jsonobject.get(onderwerp).toString();
				Rapportcijfer groen = new Rapportcijfer(onderwerp, cijfer);
				cijfers.add(groen);

				onderwerp = "rapportcijfer schoonheid straten in de buurt";
				cijfer = jsonobject.get(onderwerp).toString();
				Rapportcijfer schoon = new Rapportcijfer(onderwerp, cijfer);
				cijfers.add(schoon);

				onderwerp = "% tevreden over verlichting in de buurt";
				cijfer = jsonobject.get(onderwerp).toString();
				Percentage tevreden = new Percentage(onderwerp, cijfer);
				cijfers.add(tevreden);

				onderwerp = "% verantwoordelijk voor buurt";
				cijfer = jsonobject.get(onderwerp).toString();
				Percentage verantwoordelijk = new Percentage(onderwerp, cijfer);
				cijfers.add(verantwoordelijk);

				onderwerp = "% actief in buurt";
				cijfer = jsonobject.get(onderwerp).toString();
				Percentage actief = new Percentage(onderwerp, cijfer);
				cijfers.add(actief);

				onderwerp = "% actief in buurt (vanaf 2016)";
				cijfer = jsonobject.get(onderwerp).toString();
				Percentage actiefVanaf = new Percentage(onderwerp, cijfer);
				cijfers.add(actiefVanaf);

				String wijknaam = jsonobject.get("Wijken").toString();
				Wijk wijk = new Wijk(wijknaam, cijfers);
				al.add(wijk);
			}
			reader.close();
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		return al;
	}
}
