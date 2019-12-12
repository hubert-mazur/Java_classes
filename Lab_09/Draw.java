import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;

public class Draw {
	private int xSize;
	private int ySize;
	private String output;
	private int numberOfPoints;
	private ArrayList<ArrayList<Integer>> points;
	private Scanner reader;
	private File file;
	private PrintStream str;
	private File fileOut;
	private ArrayList<Double> lengths;
	public Draw(String inputFile) {

		file = new File(inputFile);

		try {
			reader = new Scanner(file);
		}
		catch(FileNotFoundException e) {
			return;
		}
		this.xSize = reader.nextInt();
		this.ySize = reader.nextInt();

		this.output = new String(reader.next());
		this.numberOfPoints = reader.nextInt();
		points = new ArrayList<ArrayList<Integer>>(numberOfPoints);
		
		for (int i=0;i<numberOfPoints;i++)
			points.add(new ArrayList<Integer>());

		for (int i=0;i<numberOfPoints;i++) {
			points.get(i).add(reader.nextInt());
			points.get(i).add(reader.nextInt());

		}


		lengths = new ArrayList<Double>(numberOfPoints);
	}

	public void run() {
		fileOut = new File(output);
		try {
			str = new PrintStream(fileOut);
		} catch(FileNotFoundException e) {return;}

		str.print("P3");
		str.print("#Hubert Mazur");
		str.print(xSize + " " + ySize);
		str.print("255");


		for (int i=0;i<xSize;i++) {
			for (int j=0;j<ySize;j++) {
				for (int p=0;p<numberOfPoints;p++) {
				lengths.set(p, Math.pow(i - points.get(p).get(0),2) + Math.pow(j - points.get(p).get(1), 2));
				if (i == points.get(p).get(0) && j == points.get(p).get(1)) {
					str.print("255 0 0 ");
					continue;
				}
				}

					double max = lengths.get(0);
					for (double k:lengths)
						if (k > max)
							max = k;

					lengths.remove(max);


					if (Math.abs(lengths.get(0) - lengths.get(1)) < 1.0)
						str.print("0 0 0");
					else
						str.print("255 255 255");

			}
		}
		
	str.close();

	}


}