import java.io.*;
import java.util.*;

public class Solution{
	public static void main(String[] args){
		
		Scanner s = new Scanner(System.in);
		int t = Integer.parseInt(s.nextLine());
		for(int i = 0; i < t; i++){
			String output = "POSSIBLE";
			int n = s.nextInt();
			int trace = s.nextInt(); //trace
			int tr = 0;
			if(trace%n>0 && trace <= Math.pow(n,2)){
				output = "Case #"+(i+1)+": IMPOSSIBLE";
			}else{
				output =  "Case #"+(i+1)+": POSSIBLE";
				tr = trace/n;
				for(int j = 0; j < n; j++){
					for(int k = 0; k < n; k++){
						int num = tr+j-k;
						if(num>n){
							num = num%n;
						}else if(num<1){
							num += n;
						}
						output += (k==0?"\n":" ")+num;
					}
				}
			}
			System.out.println(output);
		}
	}
}