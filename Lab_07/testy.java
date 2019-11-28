import java.util.ArrayList;
import java.util.Scanner;

public class testy {
	private Scanner reader = new Scanner(System.in);
	private int numberOfTests;
	private int elements;
	private ArrayList<ArrayList<Integer>> group1;
	private ArrayList<ArrayList<Integer>> group2;
	private ArrayList<Integer> checkList;
	
	public testy() {
		group1 = new ArrayList<ArrayList<Integer>>();
		group2 = new ArrayList<ArrayList<Integer>>();
		read();
		checkList = new ArrayList<Integer>();
	}


	private void read() {
		elements = reader.nextInt();
		numberOfTests = reader.nextInt();

		for (int i=0;i<numberOfTests;i++) {
			group1.add(new ArrayList<Integer>());
			group2.add(new ArrayList<Integer>());

			for (int j=0;j<elements;j++) {
				if(j < elements /2) 
					group1.get(i).add(reader.nextInt());
				else
					group2.get(i).add(reader.nextInt()); 
			}
		}
	}


    public boolean check() {

        for (int i = 1; i <= elements; i++) {
            checkList.clear();
            for (int j = 0; j < numberOfTests; j++) {
                if (isToGroup1(j, i))
                    for (int k : group2.get(j))
                        if (!checkList.contains(k))
                            checkList.add(k);
                        else
                            ;
                else {
                    for (int k : group1.get(j))
                        if (!checkList.contains(k))
                            checkList.add(k);
                }
            }
            checkList.add(i);

            for (int z = 1; z <= elements; z++)
                if (!checkList.contains(z))
                    return false;
        }

        return true;
    }

	private boolean isToGroup1(int testNumber, int number) {
		if (group1.get(testNumber).contains(number))
			return true;
		
		return false;
	}


	public void print() {
		System.out.println("Group1: " + group1);
		System.out.println("Group2: " + group2);
	}

}