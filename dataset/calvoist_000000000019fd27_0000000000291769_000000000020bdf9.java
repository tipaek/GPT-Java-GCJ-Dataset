import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Solution {
	
	public static void main(String[] args){
		Scanner s = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
		int t =s.nextInt();
		for(int i=1;i<=t;i++) {
			int n= s.nextInt();
			int matrix [][]= new int[n][2];
			for(int j=0;j<n;j++) {
				matrix[j][0]=s.nextInt();
				matrix[j][1] =s.nextInt();
			}
			
			List<Integer> cameron = new ArrayList<Integer>();
			List<Integer> james = new ArrayList<Integer>();
			String answer="";
			int beginNumber =matrix[0][0];
			int endNumber =matrix[0][1];
			
			
			for(int j=beginNumber; j<endNumber;j++) {
				cameron.add(j);
			}
			
			answer=answer+"C";
			
			for(int j=1; j<n;j++) {
				beginNumber =matrix[j][0];
				endNumber =matrix[j][1];
				boolean contains=false;
				for(int k=beginNumber; k<endNumber;k++) {
					if(cameron.contains(k)) {
						contains=true;
						break;
					}
				}
				if(!contains) {
					for(int k=beginNumber; k<endNumber;k++) {
						cameron.add(k);
					}
					answer = answer+"C";
				}
				else {
					contains=false;
					for(int k=beginNumber; k<endNumber;k++) {
						if(james.contains(k)) {
							contains=true;
							break;
						}
					}
					
					if(!contains) {
						for(int k=beginNumber; k<endNumber;k++) {
							james.add(k);
						}
						
						answer = answer+"J";
					}else {
						answer = "IMPOSSIBLE";
					}
				}
			}
			
			System.out.println("Case #"+i+": "+answer);
			
		}  
	}

}
