package application;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class WordParser {
	
	public static String createString(String html) throws IOException{
		
		Document doc = Jsoup.connect(html).get();
		Elements h1= doc.select("h1");
		Elements h3=doc.select("h3");
		Elements h4=doc.select("h4");
		Elements p=doc.select("p");
		
		// create a string of the entire poem, creates an array of strings, then creates a list
		// from the array using the aslist function
		
		String poem = h1.text() + " " +  h3.text() + " " + h4.text() + " " + p.text();
		String[] words = poem.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+");
		List<String> wordList = Arrays.asList(words);
		
		// creates a map of the words using the wordlist and assigning words a key which equals
		// the amount of times its been used.
		
		Map<String, Long> map = wordList.stream()
				.collect(Collectors.groupingBy(e -> e, Collectors.counting()));
		
		
		// this orders the map and sorts it in descending order
		
		List<Map.Entry<String, Long>> result = map.entrySet().stream()
		        .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
		        .collect(Collectors.toList());
		
		
		// creates a list of the words in the map that are now order by greatest use to least
		
		String output = result.toString(),bar = "Top 20 Words!\n";
		String foo[] = output.replaceAll("\\[|\\]|,","").split("\\s+");
		int i;
		for(i=1;i<21;i++)
		{
			bar+= i+". "+ foo[i]+"\n";
		}
		
		return bar;
		
	}


}
