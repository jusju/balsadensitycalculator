package engine;

public class Balsalevy {
	private int id;
	private double pituus;
	private double leveys;
	private double paksuus;
	private double paino;
	private double tiheys;
	private String grain;

	public Balsalevy() {
		super();
	}

	public Balsalevy(int id, double pituus, double leveys, double paksuus, double paino, double tiheys, String grain) {
		super();
		this.id = id;
		this.pituus = pituus;
		this.leveys = leveys;
		this.paksuus = paksuus;
		this.paino = paino;
		this.tiheys = tiheys;
		this.grain = grain;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPituus() {
		return pituus;
	}

	public void setPituus(double pituus) {
		this.pituus = pituus;
	}

	public double getLeveys() {
		return leveys;
	}

	public void setLeveys(double leveys) {
		this.leveys = leveys;
	}

	public double getPaksuus() {
		return paksuus;
	}

	public void setPaksuus(double paksuus) {
		this.paksuus = paksuus;
	}

	public double getPaino() {
		return paino;
	}

	public void setPaino(double paino) {
		this.paino = paino;
	}

	public double getTiheys() {
		return tiheys;
	}

	public void setTiheys(double tiheys) {
		this.tiheys = tiheys;
	}

	public String getGrain() {
		return grain;
	}

	public void setGrain(String grain) {
		this.grain = grain;
	}

	@Override
	public String toString() {
		return "Balsalevy [id=" + id + ", pituus=" + pituus + ", leveys=" + leveys + ", paksuus=" + paksuus + ", paino="
				+ paino + "]";
	}
}
