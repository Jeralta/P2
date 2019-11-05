package Model;

public class Cijfer {

	protected String onderwerp;
	protected Object cijfer;

	protected Cijfer(String onderwerp, Object cijfer) {
		this.onderwerp = onderwerp;
		this.cijfer = cijfer;
	}

	public String getOnderwerp() {
		return onderwerp;
	}

	public void setOnderwerp(String onderwerp) {
		this.onderwerp = onderwerp;
	}

	public Object getCijfer() {
		return cijfer;
	}

	public void setCijfer(String cijfer) {
		this.cijfer = cijfer;
	}
}