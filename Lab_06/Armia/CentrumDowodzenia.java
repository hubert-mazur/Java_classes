package Armia;

import java.util.ArrayList;

public class CentrumDowodzenia {

private ArrayList<Czolg> czolgi;
private ArrayList<ArrayList<Rozkaz>> rozkazCzolgu;


public CentrumDowodzenia() {
	this.czolgi = new ArrayList<Czolg>();
	this.rozkazCzolgu = new ArrayList<ArrayList<Rozkaz>>();
}

public void zarejestrujCzolg(Czolg object) {
	this.czolgi.add(object);
	this.rozkazCzolgu.add(new ArrayList<Rozkaz>());
}

public void wydajRozkaz(String numerCzolgu, Rozkaz object) {
	this.czolgi.get(Integer.parseInt(numerCzolgu ) - 1).setRozkaz(object);
	this.rozkazCzolgu.get(Integer.parseInt(numerCzolgu) - 1).add(object);
}

public String toString() {
	String str = new String("");

	str += "Do tej pory centrum dowodzenia wyslalo nastepujace rozkazy:\n";
	for(int i=0;i<this.czolgi.size(); i++) {
		str += "Czolg nr " + (i+1) + " otrzymal rozkazy:\n";
		
		for (Rozkaz it:this.rozkazCzolgu.get(i)) 
			str += it + "\n";
		str += "\n";
	}

	return str;

}

}