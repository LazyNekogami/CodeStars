package codestars;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

public class task3_1 {
	//private static Logger log = Logger.getLogger(task3_1.class.getName());

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[][] table = new int[1000][1000];
		for (int i = 0; i < table.length; i++) {
			for (int j = 0; j < table[i].length; j++) {
				table[i][j] = 0;
			}
		}

		try (BufferedReader reader = new BufferedReader(new FileReader(
				"D:\\19.data"))) {
			String str = null;
			do {
				str = reader.readLine();
				if (str == null) {
					break;
				}
				String[] words = str.split(" ");
				int a = Integer.parseInt(words[0]);
				int b = Integer.parseInt(words[1]);
				table[a][b] = 1;
				table[b][a] = 1;
			} while (str != null);

		} catch (IOException ex) {

			System.out.println(ex.getMessage());
		}
		int sum = 0;
		for (int i = 0; i < table.length; i++) {
			for (int j = i + 1; j < table[i].length; j++) {
				if (0 == table[i][j]) {
					sum++;
				}
			}
		}

		System.out.println(sum);

	}

}
