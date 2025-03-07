import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Solution {
    public static void main(String args[]) {
    	Scanner scanner = new Scanner(System.in);
        int recursive = scanner.nextInt();
 		for (int r = 0; r<recursive; r++) {
 			int U = scanner.nextInt();
 			HashMap<Character,Integer> charMap = new HashMap<Character,Integer>();
 			int flagged = 0;
 			StringBuilder sb = new StringBuilder("          ");
 			scanner.nextLine();
 			while(flagged < 2) {
 				System.out.println(10);
 				String line = scanner.nextLine();
 				String[] list = line.split(" ");
 				if(!list[0].equals("-1") && list[1].length() == 2) {
 					charMap.put(list[1].charAt(0), 1);
 					charMap.put(list[1].charAt(1), 0);
 					flagged = 2;
 				}
 			}
 			while(flagged < 10) {
 				System.out.println((flagged * 10 + 9));
 				String line = scanner.nextLine();
 				String[] list = line.split(" ");
 				if(!list[0].equals("-1")) {
 					String ri = list[1];
 	 				if (ri.length() == 2 && !charMap.containsKey(ri.charAt(0))) {
 	 					charMap.put(ri.charAt(0), flagged);
 	 					flagged++;
 	 				}
 				}
 			}
 			for ( Map.Entry<Character, Integer> entry : charMap.entrySet()) {
 			    char currentChar = entry.getKey();
 			    int index = entry.getValue();
 			    sb.setCharAt(index, currentChar);
 			}
 			System.out.println(sb);
 		}
	}
}