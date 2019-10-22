// Na tablicy napisane są dwa ciągi zer i jedynek. Chcemy teraz w każdym z tych ciągów skreślić niektóre cyfry tak, żeby pozostałe ciągi były takie same oraz były uporządkowane, tj. 
// po pierwszym wystąpieniu jedynki nie może już wystąpić żadne zero (czyli np. 0000111111). 
// Jaki najdłuższy ciąg może pozostać na tablicy? Na wejściu podane są długości obu ciągów oraz same ciągi np:

// 3 4
// 0 1 0 1
// 0 0 1 1

// daje wynik:
// 3
// [ bo taki sam ciąg to : 0 1 1 i powstaje on z pierwszego poprzez skreślenie ostatniego 0 oraz z drugiego poprzez skreślenie pierwszego zera]

// inny przykład:
// 5 5
// 0 1 0 1 1
// 0 1 1 0 0
// daje wynik:
// 3
// [ ciąg: 0 1 1] 

// Przykład jak można wczytać dane z klawiatury:

// import java.util.Scanner;

// public class input_test
// {
//  public static void main(String[] args)
//  {
//   Scanner in = new Scanner(System.in);
//   int x = in.nextInt();
//   int y = in.nextInt();
//   System.out.println(x+"+"+y+"="+(x+y));
//  }
// }

import java.util.*;


public class lab02 {

    public static void main(String[] args) {
        Progression str1 = new Progression(); 
        Progression str2 = new Progression();
       
		Scanner reader = new Scanner(System.in);

		int length1 = reader.nextInt();
		int length2 = reader.nextInt();

		String strFirst = new String();
		String strSecond = new String();

		for (int i = 0;i < length1 ; i++) {
			strFirst += reader.nextInt();
		}
		for (int i = 0;i < length2 ; i++) {
			strSecond += reader.nextInt();
		}

		str1.setString(strFirst);
		str2.setString(strSecond);

        str1.unique();
        str2.unique();

        // for (String it : str1.getUniqueList())
        // System.out.println(it);

        // System.out.println();
		// System.out.println();
		
        // for (String it : str2.getUniqueList())
        // System.out.println(it);

        int longest = 0; 
        int result = 0; 



        for (String i : str1.getUniqueList()) {
            for (String j : str2.getUniqueList()) {
                result = (Math.min(str1.howManyCharsIn(i, '0'), str2.howManyCharsIn(j, '0'))
                        + Math.min(str1.howManyCharsIn(i, '1'), str2.howManyCharsIn(j, '1')));

                if (longest < result)
                    longest = result;
                // System.out.println("result is: " + longest);
            }
        }
        System.out.println(longest);

    }
}


class Progression {
    public String getString() {
        return progress;
    }

    public void setString(String str) {
        progress = str;
        setZeros();
        setOnes();
    }

    public Progression(String str) {
        progress = new String(str);
        this.setZeros();
        this.setOnes();
    }


    public Progression() {
        progress = new String("");
    }

    public void setZeros() {
        int count = 0;
        for (int i = 0; i < this.progress.length(); i++) {
            if (this.progress.charAt(i) == '0') {
                count++;
                this.zeroIndexList.add(i);
            }
        }
        zeros = count;
    }

    public int getZeros() {

        return zeros;
    }

    public void setOnes() {

        int count = 0;
        for (int i = 0; i < this.progress.length(); i++) {
            if (this.progress.charAt(i) == '1') {
                count++;
            }
        }
        ones = count;
    }


    public void unique() {

        String temp = new String();

        for (int i = 0; i < this.ones; i++)
            temp += '1';
        this.uniq.add(temp);
        temp = "";
        for (int i = this.zeros; i > 0; i--) {
            for (int j = 0; j < i; j++)
                temp += '0';

            for (int z = zeroIndexList.get(i - 1); z < progress.length(); z++)
                if (progress.charAt(z) == '1')
                    temp += '1';
            this.uniq.add(temp);
            temp = "";
        }
    }

    public int howManyCharsIn(String s, char c) {
        int count = 0;
        for (int i = 0; i < s.length(); i++)
            if (s.charAt(i) == c)
                count++;
        // System.out.println("Returning " + count + " characters: " + c);
        return count;
    }

    public ArrayList<String> getUniqueList() {
        return uniq;
    }

    private String progress;
    private int zeros;
    private int ones;
    private ArrayList<Integer> zeroIndexList = new ArrayList<Integer>();
    private ArrayList<String> uniq = new ArrayList<String>();
}