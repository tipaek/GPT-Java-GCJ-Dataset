import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;


public class Solution {
	
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			int t = Integer.parseInt(br.readLine());
			for(int c = 1; c<=t; ++c) {
				int l = Integer.parseInt(br.readLine());
				String act = "";
				boolean bandera = false;
				String[] words = new String[l];
				String[] words2 = new String[l];
				for(int i = 0 ; i < l; ++i) {
					String ln[] = br.readLine().split("\\*");
					words[i] = ln[1];
					words[2] = ln[2];
				}
				Arrays.sort(words, new Comparator<String>() { 
					@Override public int compare(String p1, String p2) 
					{ 
						return p1.length() - p2.length(); 
					} 
				}); 
				Arrays.sort(words2, new Comparator<String>() { 
					@Override public int compare(String p1, String p2) 
					{ 
						return p1.length() - p2.length(); 
					} 
				}); 
				
				
				for(int i  = 0 ; i < l-1; ++i) {
					if(!words[l-1].endsWith(words[i]) || !(words2[l-1].endsWith(words2[i]))) {
						bandera = true;
						System.out.println("Case #"+c+": *");
						break;
					}
				}
				if(!bandera) {
					System.out.println("Case #"+c+": "+words2[l-1]+"*"+words[l-1]);
				}
				
				
			}
		} catch (Exception e) {
			e.printStackTrace();// TODO: handle exception
		}
	}

}
