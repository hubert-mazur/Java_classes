public class lab3string {

	public static int dlugosc(String string) {
		return string.length();
	}

	public static int ile_razy_literka_wystepuje(String string, char c) {
		int counter = 0;
		for (int i=0;i<string.length();i++) {
			if (string.charAt(i) == c)
				counter ++;
		}
		return counter;
	}

	public static boolean czy_takie_same(String str1, String str2) {
		return str1.equals(str2);
	}

	public static String wspak(String str) {
		StringBuilder strTemp = new StringBuilder();

		for (int i = str.length() - 1 ; i >= 0; i--)
			strTemp.append(str.charAt(i));
		return new String(strTemp);
	}

	public static boolean czy_plaindrom(String str) {
		return str.equals(wspak(str));
	}


	public static boolean czy_abecadlowe(String str) {
		char prev = str.charAt(0);

		for (int i = 1; i < str.length(); i++) {
			if ((int) str.charAt(i) < (int) prev)
				return false;
			else
				prev = str.charAt(i);
		}
		return true;
	}

	public static String rot13 (String str) {
		StringBuilder tempString = new StringBuilder();

		for (int i=0;i<str.length();i++) {
			if (Character.isLetter((str.charAt(i))))  {
				if (Character.isLowerCase(str.charAt(i)))
					tempString.append((char)(((str.charAt(i) -  'a' + 13) % 26) + 'a'));
				else 
					tempString.append((char)(((str.charAt(i) -  'A' + 13) % 26) + 'A'));
			}
				else 
					tempString.append(str.charAt(i));
		}

		return new String(tempString);
	}
}