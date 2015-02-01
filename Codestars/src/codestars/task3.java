package codestars;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class task3 {

	public static void main(String[] args) {
		try (BufferedReader reader = new BufferedReader(new FileReader(
				"D:\\3.data"))) {
			String str = reader.readLine();
			String[] words = str.split(" ");
			ArrayList<ArrayList<String>> languageGroups = new ArrayList<ArrayList<String>>();
			languageGroups.add(new ArrayList<String>());
			languageGroups.get(0).add(words[1]);
			languageGroups.get(0).add(words[2]);
			
			while(true){
				str = reader.readLine();
				if(str == null){
					break;
				}
				words = str.split(" ");
				
				for(int i = 0; i< languageGroups.size(); i++){
					ArrayList<String> temp = languageGroups.get(i);
					if(temp.contains(words[1]) && !temp.contains(words[2])){
						temp.add(words[2]);
					}
					else if(!temp.contains(words[1]) && temp.contains(words[2])){
						temp.add(words[1]);
					} else if(!temp.contains(words[1])&& !temp.contains(words[2])){
						ArrayList<String> bufferArray =  new ArrayList<String>();
						bufferArray.add(words[1]);
						bufferArray.add(words[2]);
						languageGroups.add(bufferArray);
					}
				}
				
			System.out.println(languageGroups.size());
				
			}
			} catch (IOException ex) {

			System.out.println(ex.getMessage());
		}
		// TODO Auto-generated method stub

	}

}
