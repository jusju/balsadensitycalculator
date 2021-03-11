package engine;

public class Balsalevy {
	private int id;
	private double pituus;
	private double leveys;
	private double paksuus;
	private double paino;
	
	
	public Balsalevy() {
		super();
	}

	public Balsalevy(int id, double pituus, double leveys, double paksuus, double paino) {
		super();
		this.id = id;
		this.pituus = pituus;
		this.leveys = leveys;
		this.paksuus = paksuus;
		this.paino = paino;
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

	@Override
	public String toString() {
		return "Balsalevy [id=" + id + ", pituus=" + pituus + ", leveys=" + leveys + ", paksuus=" + paksuus + ", paino="
				+ paino + "]";
	}
}
