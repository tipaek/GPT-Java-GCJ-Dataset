import java.util.*;
import java.util.Map.Entry;
import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;


public class Solution {
    public static void main(String[] args) throws IOException {
    	Scanner sc =  new Scanner(System.in);
		if(sc.hasNext()) {
			long t =sc.nextLong();
			for(long tt =0; tt<t; tt++) {
				String s = sc.next();
				String ans="";
				Stack<Integer> openb = new Stack<>(); 
				int prev=0;
				int count=0;
				if(s.length()>1) {
				for(int j=0; j<s.length(); j++) {
					 count=0;
					 int x = Integer.parseInt(s.charAt(j)+"");
					for(int i=j+1; i<s.length(); i++) {
						int x1=Integer.parseInt(s.charAt(i)+"");
						if(x==x1) {
							count++;
						}
						else {
							break;
						}
					}
					int dif=0;
					if(j==0) {
						for(int i=0; i<x; i++) {
							openb.add(1);
							ans+="(";
						}
						for(int i=0; i<count+1; i++) {
							ans+=x;
						}
						if(openb.size()>0) {
							//ans+=")";
							//openb.pop();
						}
						
					}
					else {
						
							if(x>openb.size()){
								dif=x-openb.size();
								for(int i=0; i<dif; i++) {
									openb.add(1);
									ans+="(";
								}
								for(int i=0; i<count+1; i++) {
									ans+=x;
								}
								
							}
							else if(x<=openb.size()){
								dif=openb.size()-x;
								for(int i=0; i<dif; i++) {
									openb.pop();
									ans+=")";
								}
								for(int i=0; i<count+1; i++) {
									ans+=x;
								}
							}
						
						
					}
					j+=count;
					
				}
				int no = Integer.parseInt(s.charAt(s.length()-1)+"");
				//System.out.println(count);
				if(s.length()==count+1) {
					//no=no-1;
				}
				if(s.length()>1) {
					for(int k=0; k<no; k++) {
						ans+=")";
					}
				}
				
				System.out.println("Case #"+(tt+1)+": "+ans);
			 }
			else {
				int x = Integer.parseInt(s.charAt(0)+"");
				for(int i=0; i<x; i++) {
					ans+="(";
				}
				ans+=x;
				for(int i=0; i<x; i++) {
					ans+=")";
				}
				System.out.println("Case #"+(tt+1)+": "+ans);
			}
		}
        }
    }
 }