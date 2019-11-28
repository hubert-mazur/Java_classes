package Armia;

public class Czolg {
	private Rozkaz rozkaz;

	public Czolg() {
		this.rozkaz = new Rozkaz("");
	}

	public void setRozkaz(Rozkaz object) {
		this.rozkaz = object;
	}

	public String ostatniRozkaz() {
		return "Ostatni rozkaz do mnie: " + this.rozkaz;
	}
}