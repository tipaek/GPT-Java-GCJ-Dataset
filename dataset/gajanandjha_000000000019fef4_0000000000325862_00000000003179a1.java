import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class Solution {

	/**
	 * @param args
	 * @throws IOException 
	 * @throws NumberFormatException 
	 */
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int test = Integer.parseInt(br.readLine().trim());
		for(int t = 1; t <= test; t++) {
			br.readLine();
			HashMap<String, Integer> hs = new HashMap<String, Integer>();
			for(int i = 0; i < 10000; i++) {
				String[] spl = br.readLine().split("\\s+");
				char[] chr = spl[1].toCharArray();
				for(char ch : chr) {
					if(hs.get(ch + "") == null) hs.put(ch + "", 1);
					else hs.put(ch + "", hs.get(ch + "") + 1);
				}
			}
			HashMap<String, Integer> mm = sortByValue(hs);
			StringBuffer sb = new StringBuffer();
			for(String str : mm.keySet()) {
				sb.append(str);
			}
			System.out.println("Case #" + t + ": " + sb.substring(sb.length()-1, sb.length()) + sb.toString().substring(0, sb.length()-1));
		}
	}
	
	public static HashMap<String, Integer> sortByValue(HashMap<String, Integer> hm) 
    { 
        // Create a list from elements of HashMap 
        List<Map.Entry<String, Integer> > list = 
               new LinkedList<Map.Entry<String, Integer> >(hm.entrySet()); 
  
        // Sort the list 
        Collections.sort(list, new Comparator<Map.Entry<String, Integer> >() { 
            public int compare(Map.Entry<String, Integer> o1,  
                               Map.Entry<String, Integer> o2) 
            { 
                return (o2.getValue()).compareTo(o1.getValue()); 
            } 
        }); 
          
        // put data from sorted list to hashmap  
        HashMap<String, Integer> temp = new LinkedHashMap<String, Integer>(); 
        for (Map.Entry<String, Integer> aa : list) { 
            temp.put(aa.getKey(), aa.getValue()); 
        } 
        return temp; 
    } 

}
