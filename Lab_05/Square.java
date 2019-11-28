/**
	* @author Hubert Mazur
	* Klasa reprezentująca kwadrat 
 */
public class Square extends Point {
	/** * Zmienna przechowująca długość krawędzi obiektu */
	protected double side;

/**
	* Konstruktor klasy Square
	* @param side Reprezentuje długość krawędzi kwadratu
	* @param x Reprezentuje współrzędną osi OX
	* @param y Reprezentuje współrzędną osi OY 
 */
	public Square(double side, double x, double y) {
		super(x,y);
		this.side = side;
		name = "Corner";
	}

/** 
	* Metoda licząca pole powierzchni
	* @return Zwraca pole powierzchni obiektu
 */
	public double area() {
		return Math.pow(this.side, 2);
	}

/** 
	* Metoda wypisania inforomacji o obiekcie
	* @return Zwraca obiekt typu String z informacją o obiekcie
 */
	public String toString() {
		return new String("Corner = " + super.toString() + "; " + "side = " +  this.side);
	}

}