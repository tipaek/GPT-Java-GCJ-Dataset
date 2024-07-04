import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		int t = Integer.parseInt(s.nextLine());
		for(int i = 0; i < t; i++){
			String output = "";
			boolean imp = false;
			int n = s.nextInt();
			int[][] sc = new int[n][2];
			ArrayList<Integer> cam = new ArrayList<Integer>();
			ArrayList<Integer> jay = new ArrayList<Integer>();
			char[] c = new char[n];
			for(int j = 0; j < n; j++){
				sc[j][0] = s.nextInt();
				sc[j][1] = s.nextInt();
				boolean b = false;
				for(int job:cam){
					if(!(sc[job][1] <= sc[j][0] || sc[job][0] >= sc[j][1])){
						b = true;
						break;
					}
				}
				if(b){
					for(int job:jay){
						if(!(sc[job][1] <= sc[j][0] || sc[job][0] >= sc[j][1])){
							imp = true;
							break;
						}
					}
					if(!imp){
						jay.add(j);
						c[j] = 'J';
					}
				}else{
					cam.add(j);
					c[j] = 'C';
				}
			}
			if(!imp){
				output = String.valueOf(c);
			}else{
				output = "IMPOSSIBLE";
			}
			System.out.println("Case #"+(i+1)+": "+output);
		}
	}
}