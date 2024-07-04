import java.io.*;
import java.util.*;
public class Solution {

	public static void main(String[]args) throws IOException{
		BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(bf.readLine().trim());
		for(int i=1;i<=t;i++) {
			String[] test = bf.readLine().split("");
			String output="";
			int startp=0;
			int endp=0;
			for(int j=0;j<test.length;j++) {
				
				int a=Integer.parseInt(test[j]);
				
				for(int x=(startp-endp);x<a;x++) {
					output+="(";
					startp++;
				}
				
				output+=a;
				int b=10;
				if(j!=test.length-1) {
					b = Integer.parseInt(test[j+1]);
				}
				
				
				while(b<=a&&b!=0) {
					j++;
					for(int k=0;k<(a-b);k++) {
						
						output+=")";
						endp++;
					}
					output+=b;
					a=b;
					if(j<test.length-1) {
					b=Integer.parseInt(test[j+1]);
					}
					else {
						b=10;
					}
					
				}
				if(b==0) {
					for(int l=0;l<(startp-endp);l++) {
						output+=")";
					}
					endp=startp;
				}
				
				
			}
			for(int l=0;l<(startp-endp);l++) {
				output+=")";
			}
			System.out.println("Case #"+i+": "+output);
		}
	}

}
