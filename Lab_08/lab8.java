import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;


public class lab8 {

	public static void main(String[] args) {
		ArrayList<Double> array = new ArrayList<Double>();
		File file_in;
		File file_out;
		PrintStream str;
		Scanner reader;
		int count = 0;
		double sum = 0;


		try {
			if (args.length <2)
				throw new IndexOutOfBoundsException("Nie podano wszystkich sciezek do plikow.");
		}

		catch(IndexOutOfBoundsException e) {
			System.out.println("Blad: " +  e.getMessage());
			return;
		}

		file_in = new File(args[0]);
		file_out = new File(args[1]);

		try {

			if (!file_in.exists())
				throw new FileNotFoundException("Nie znalezeiono pliku " + args[0]);

			if (!file_out.exists())
				throw new FileNotFoundException("Nie znaleziono pliku: " + args[1]);


			reader = new Scanner(file_in);
			str = new PrintStream(file_out);


			while(reader.hasNextLine()) {
				array.add(reader.nextDouble());
				count ++;
			}


			for(double k:array) 
				sum += k;
			
			if (count == 0)
				throw new ArithmeticException("Dzielenie przez zero.");

			str.print(sum / count);
			str.close();
			reader.close();

		}
		catch(FileNotFoundException e) {
			System.out.println("Blad: " +  e.getMessage());
			System.out.println("(WSKAZOWKA:) Plik istnieje?");
			return;

		}
		catch(InputMismatchException e) {
			System.out.println("Blad: Nieprawidlowy format danych wejsciowych. Oczekiwano wartosci typu double.");
			return;
		}
		catch(ArithmeticException e) {
			System.out.println("Blad: " +  e.getMessage());
			System.out.println("(WSKAZOWKA:) Pusty plik z danymi wejsciowymi?");
			return;
		}
		catch(NoSuchElementException e) {
			System.out.println("Blad: brak danych.");
			System.out.println("(WSKAZOWKA:) Pusta linia na koncu pliku z danymi?");
			return;
		}
	}
}