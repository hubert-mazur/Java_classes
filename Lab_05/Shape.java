/**
	* @author Hubert Mazur
	* Klasa Shape
	* Prosta klasa zaimplementowana w celu dziedziczenia
 */
public class Shape {
	/**
		* Przechowuje nazwę obiektu
	 */
	protected String name;

	/** 
		* Konstruktor klasy Shape
	 */
	public Shape() {
		this.name = new String();
	} 

	/** 
		* @return Zwraca nazwę obiektu
	 */
	public String getName() {
		return this.name;
	}


	/** 
		* @return Zwraca pole powierzchni.
		* Pole powierzchni może nie istnieć dla danego typu obiektu!
	 */
	public double area() {
		return 0.0;
	}

	/** 
		* @return Zwraca objętość obiektu.
		* Objętość może nie istnieć dla danego typu obiektu!
	 */
	public double volume() {
		return 0.0;
	}


}