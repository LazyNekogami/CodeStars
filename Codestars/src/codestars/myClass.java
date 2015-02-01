package codestars;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class myClass {
	static final char[] eng = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i',
			'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
			'w', 'x', 'y', 'z' };
	static final String eng1 = " abcdefghijklmnopqrstuvwxyz";
	static final String rus = " אבגדהוזחיךכלםמןנסעףפץצקרשתûü‎‏ÿ";
	static String result = "";

	static public void print(String a) {
		System.out.println(a);
	}

	public static void main(String[] args) {
		int i = 0;

		try (BufferedReader reader = new BufferedReader(new FileReader(
				"D:\\65.result"))) {
			// while (true) {
			String str = reader.readLine();
			// if (str == null)
			// break;
			String[] words = str.split(" ");
			print(Integer.toString(words.length));
			for (String word : words) {
				System.out.println(word);
				if (word.contains("Yo")) {
					i++;
				} else if (word.contains("Nice")) {
					result = result + eng1.charAt(i);
					i = 0;
				}

				// }
				// str = null;
			}
			System.out.println(result);

		} catch (IOException ex) {

			System.out.println(ex.getMessage());
		}
	}
}
