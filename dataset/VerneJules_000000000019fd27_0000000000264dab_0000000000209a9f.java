import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String[] args){
		
		Scanner s = new Scanner(System.in);
		int t = Integer.parseInt(s.nextLine());
		for(int i = 0; i < t; i++){
			String output = "";
			
			String line = s.nextLine().replaceAll("[()]", "");
			int nest = 0;
			int prevd = 0;
			for(int j = 0; j <= line.length(); j++){
				int d = 0;
				try{
					d = Integer.parseInt(String.valueOf(line.charAt(j)));
				}catch(Exception e){
					d = 0;
				}
				
				String prev = "";
				int close = prevd==0?0:prevd<d?(d-prevd):nest>d?(nest-d):0;
				if(close>0){
					prev += String.format(String.format("%%%ds", close), " ").replace(" ",")");
				}
				nest -= close;
				int open = nest<d?(d-nest):0;
				if(open>0){
					prev += String.format(String.format("%%%ds", open), " ").replace(" ","(");
				}
				output += prev + (j<line.length()?d:"");
				nest = nest>d?d:nest<d?open:nest;
				prevd = d;
			}
			System.out.println("Case #"+(i+1)+": "+output);
		}
	}
}