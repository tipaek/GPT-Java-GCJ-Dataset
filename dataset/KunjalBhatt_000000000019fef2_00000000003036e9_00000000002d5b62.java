
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	public static void main(String args[]){
		 
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	     int t = in.nextInt(); 
	     for (int i = 1; i <= t; ++i) {
	    	 int r = in.nextInt();
	    	 int c = in.nextInt();
	    	 System.out.print("Case #" + i + ": "+getPath(r, c));
	       }
	     in.close();
	}
	
	static String getPath(int r,int c){
		
		String[] d = {"N","S","E","W"};
		List<String> list = new ArrayList<String>(); 
		int steps = 1;
		int index = 0;
		list.addAll(Arrays.asList(d));
		while(steps < 10){
			int size = list.size();
			while(index < size){
				String s = list.get(index);
				if(isRequire(r, c, s)){
					return s;
				}
				index++;
				for(String ns : d){
					list.add(s+ns);
				}
			}
			steps++;
		}
		
		return "IMPOSSIBLE";
	}
	
	static boolean isRequire(int r, int c, String s){
		char[] ch = s.toCharArray();
		int newR = 0;
		int newC = 0;
		
		int val =1;
		for(int i=0;i<ch.length;i++){
			switch (ch[i]) {
			case 'N':
				newC+=val;
				break;
			case 'S':
				newC-=val;			
				break;
			case 'E':
				newR+=val;
				break;
			case 'W':
				newR-=val;
				break;
			}
			val*=2;
		}
		
		if(r == newR && c== newC){
			return true;
		}else{
			return false;
		}
		
	}
}
