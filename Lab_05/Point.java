/**
	* @author Hubert Mazur
	* Klasa reprezentująca punkt 
 */
public class Point extends Shape{

	/** * Zmienna reprezentująca współrzędną osi OX */
	protected double x;
	
	/** * Zmienna reprezentująca współrzędną osi OY */
	protected double y;

/**
	* Konstruktor Klasy Point
	* @param x Wartośc współrzędnej osi OX
	* @param y Wartość współrzędnej osi OY
 */
	public Point(double x, double y) {
		super();
		this.x = x;
		this.y = y;

		this.name = "Point";
	}

	/** 
		* Metoda wypisania na ekran informacji o obiekcie
		* @return Zwraca obiekt typu String z informacją o obiekcie
	 */
	public String toString() {
		return new String("[" + this.x + ", " + this.y + "]");
	}

}
