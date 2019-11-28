/**
	* @author Hubert Mazur
	* Klasa reprezentująca sześcian 
 */
public class Cube extends Square {
	/** * Zmienna reprezentująca długość krawędzi sześcianu */
	private double depth;

/** 
	* Konstruktor klasy Cube
	* @param depth Parametr opisujący długosć krawędzi
	* @param x Parametr opisujący współrzędną osi OX
	* @param y Parametr opisujący współrzędna osi OY
 */
	public Cube(double depth, double x, double y) {
		super(depth, x, y);
		name = "Cube";
		this.depth = depth;
	}

/** 
	* Metoda licząca pole powierzchni całkowitej
	* @return Zwraca pole powierzchni całkowitej
 */
	public double area() {
		return 6 * super.area();
	}

/** 
	* Metoda licząca objętość obiektu
	* @return Zwraca objętość
 */
	public double volume() {
		return super.area() * this.depth;
	}

/**
	* Metoda wypisująca na ekran informacje o obiekcie
	* @return Zwraca obiekt typu String z informacją o obiekcie
 */
	public String toString() {
		return new String(super.toString() + "; depth = " + this.depth);
	}

}