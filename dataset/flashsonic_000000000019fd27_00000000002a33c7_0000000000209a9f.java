import java.util.*;
import java.io.*;

public class Solution{
	public static void main(String args[]){
		Scanner kb=new Scanner(System.in);
		
		int cases=kb.nextInt();
		kb.nextLine();
		for(int n=0; n<cases; n++) {
			String S=kb.nextLine();
			String ans="";
			
			int count=0;
			
			int previous=0;
			
			for(int i=0; i<S.length(); i++) {
				int hi=Integer.parseInt(S.substring(i, i+1));
			
				if(i==0) {
					previous=hi;
					count=hi;
					
					for(int j=0; j<count; j++) {
						ans+="(";
					}
					
					ans+=hi;
					
					if(i==S.length()-1) {
						for(int j=0; j<count; j++) {
							ans+=")";
						}
					}
				}
				else{
					if(hi>previous) {
						for(int j=0; j<hi-previous; j++) {
							ans+="(";
						}
						count+=(hi-previous);
					}
					else {
						for(int j=0; j<previous-hi; j++) {
							ans+=")";
						}
						count-=(previous-hi);
					}
					
					ans+=hi;
					previous=hi;
					
					if(i==S.length()-1) {
						for(int j=0; j<count; j++) {
							ans+=")";
						}
					}
				}
				
			}
			System.out.println(ans);
		}
	}
}
