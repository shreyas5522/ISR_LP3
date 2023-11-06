import java.io.*;
import java.util.*;
public class Conflation {
	public static ArrayList<String> stopList = new ArrayList<String>();
	public static ArrayList<String> removestopList = new ArrayList<String>();
	public static String suffixes[] = { "able", "ing", "ion", "y", "ment" };
	public static String stopwords[] = { "i", "big", "am", "m", "a", "we",
			"are", "it", "of", "this", "and", "is", "to", "at", "in", "was",
			"with", "doing", "It", "not", "our" };

	public static void conflation(String fname) {
		BufferedReader buff;
		int i = 0, j = 0;
		try {
			buff = new BufferedReader(new FileReader(fname));
			int flag = 0;
			String line = "";
			line = buff.readLine();
			String[] buffer = line.split(" ");
			for (i = 0; i < buffer.length; i++) {
				flag = 0;
				if (buffer[i].endsWith("."))
					buffer[i] = buffer[i].replace(".", "");

				for (j = 0; j < stopwords.length; j++) {
					if (buffer[i].equals(stopwords[j])) {
						stopList.add(buffer[i]);
						flag = 1;
						break;
					}
				}
				if (flag != 1 && !buffer[i].equals(null)) {
					removestopList.add(buffer[i]);
				}
			}
			System.out.println("\n--------------After Removing Stop Words-----------------");
			for (int k = 0; k < removestopList.size(); k++) {
				System.out.println(removestopList.get(k));
			}

			suffixesString(removestopList);
			countFrequency(removestopList);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void countFrequency(ArrayList<String> removestopList2) {
		// Mapping of String->Integer (word -> frequency)
		System.out.println("\n\n-------After Counting Frequency-----------");
		final Map<String, Integer> frequencyMap = new HashMap<String, Integer>();
		for (int k = 0; k < removestopList.size(); k++) {
			String currentWord = removestopList.get(k);
			Integer frequency = frequencyMap.get(currentWord);
			// Add the word if it doesn't already exist, otherwise increment the
			// frequency counter.
			if (frequency == null) {
				frequency = 0;
			}
			frequencyMap.put(currentWord, frequency + 1);
		}
		Iterator entries = frequencyMap.entrySet().iterator();
		while (entries.hasNext()) {
			Map.Entry entry = (Map.Entry) entries.next();
			String key = (String) entry.getKey();
			Integer value = (Integer) entry.getValue();
			System.out.println(key + " = " + value);
		}
	}
	private static void suffixesString(ArrayList<String> removestopList) {
		System.out.println("\n\n--------After Removing Suffixes------------");
		for (int k = 0; k < removestopList.size(); k++) {
			String suffixString = removestopList.get(k);
			int flag = 0;
			for (int m = 0; m < suffixes.length; m++) {
				if (suffixString.endsWith(suffixes[m])) {
					int len = suffixString.length();
					int len1 = suffixes[m].length();
					int len2 = len - len1;
					String sufString = suffixString.substring(0, len2);
					System.out.print(suffixString + "\t\t");
					System.out.println(sufString);
					flag = 1;
					break;
				}
			}
			if (flag != 1)
				System.out.println(suffixString + "\t\t" + suffixString);
		}
	}
	public static void main(String[] args) {
		InputStreamReader st = new InputStreamReader(System.in);
		BufferedReader buff = new BufferedReader(st);
		String fname = "";
		System.out.println("Enter a filename:");
		try {
			fname = buff.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		conflation(fname);
	}
}
