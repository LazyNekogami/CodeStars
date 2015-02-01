package codestars;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class task3 {

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new FileReader(
				"D:\\19.data"))) {
			String str = reader.readLine();
			String[] words = str.split(" ");
			ArrayList<ArrayList<String>> languageGroups = new ArrayList<ArrayList<String>>();
			languageGroups.add(new ArrayList<String>());
			task2.print(str);
			task2.print("1 " + words[0]);
			task2.print("2 " + words[1]);
			languageGroups.get(0).add(words[0]);
			languageGroups.get(0).add(words[1]);

			while (true) {
				str = reader.readLine();
				if (str == null) {
					break;
				}
				words = str.split(" ");
				
				boolean enter = false;
				for (int i = 0; i < languageGroups.size(); i++) {
					ArrayList<String> temp = languageGroups.get(i);
					if (temp.contains(words[0]) && !temp.contains(words[1])) {
						temp.add(words[1]);
						enter = true;
						break;
					} else if (!temp.contains(words[0])
							&& temp.contains(words[1])) {
						temp.add(words[0]);
						enter = true;
						break;
					}
				}
				if (!enter) {
					ArrayList<String> bufferArray = new ArrayList<String>();
					bufferArray.add(words[0]);
					bufferArray.add(words[1]);
					languageGroups.add(bufferArray);
				}

				System.out.println(languageGroups.size());

			}
		} catch (IOException ex) {

			System.out.println(ex.getMessage());
		}
		// TODO Auto-generated method stub

	}

}
