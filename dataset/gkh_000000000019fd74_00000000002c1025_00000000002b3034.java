import java.util.*;
import java.io.*;

// java Solution < input_file.txt > output_file.txt
public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t = in.nextInt();
		
		for(int x = 1; x <= t; ++x) {
			int n = in.nextInt();
			String[] patterns = new String[n];
			for(int i=0; i<n; i++){
				patterns[i] = in.next().toUpperCase();
			}
			String name = new String("*");
			String newName = new String("");
			for(int i=0; i<patterns.length; i++){
				String current = patterns[i];
				for(int j=i+1; j<patterns.length; j++){
					String other = patterns[j];
					
					if(name.length() < newName.length()){
						name = newName;
					}
				}
			}
			System.out.println("Case #"+x+": "+name);
		}
		
		in.close();
	}




}