package Model;

import java.util.ArrayList;

public class Wijk {

	private String wijknaam;
	private ArrayList<Cijfer> cijfers;

	public Wijk(String wijknaam, ArrayList<Cijfer> cijfers) {
		this.wijknaam = wijknaam;
		this.cijfers = cijfers;
	}

	public String getWijknaam() {
		return wijknaam;
	}

	public void setWijknaam(String wijknaam) {
		this.wijknaam = wijknaam;
	}

	public ArrayList<Cijfer> getCijfers() {
		return cijfers;
	}

	public void setCijfers(ArrayList<Cijfer> cijfers) {
		this.cijfers = cijfers;
	}

}
