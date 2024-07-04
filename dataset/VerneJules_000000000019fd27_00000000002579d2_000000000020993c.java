import java.io.*;
import java.util.*;

public class ProblemA{
	public static void main(String[] args){
		
		Scanner s = new Scanner(System.in);
		int t = Integer.parseInt(s.nextLine());
		for(int i = 0; i < t; i++){
			int n = s.nextInt();
			int trace = 0; //trace
			int r = 0; //rows with duplicates
			int c = 0; //columns with duplicates
			ArrayList<Integer>[] rows = new ArrayList[n];
			ArrayList<Integer>[] columns = new ArrayList[n];
			for(int j = 0; j < n; j++){
				rows[j] = new ArrayList<Integer>();
				for(int k = 0; k < n; k++){
					if(j == 0){
						columns[k] = new ArrayList<Integer>();
					}
					int cell = s.nextInt();
					if(j==k){
						trace += cell;
					}
					boolean b = true;
					for(int rs:rows[j]){
						if(rs==cell){
							b = false;
							break;
						}
					}
					if(b){
						rows[j].add(cell);
					}else{
						b = true;
					}
					
					if(k == n - 1){
						if(rows[j].size()<n){
							r++;
						}
					}
					
					for(int cs:columns[k]){
						if(cs==cell){
							b = false;
							break;
						}
					}
					if(b){
						columns[k].add(cell);
					}
					
					if(j == n -1){
						if(columns[k].size()<n){
							c++;
						}
					}
				}
			}
			System.out.println("Case #"+(i+1)+": "+trace+" "+r+" "+c);
		}
	}
}