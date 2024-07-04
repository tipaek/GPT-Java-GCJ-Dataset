//package competitive;
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
import java.util.regex.*;

public class Solution {
	
    public static void main(String[] args) throws IOException {
    	Scanner sc =  new Scanner(System.in);
		if(sc.hasNext()) {
			int t = sc.nextInt();
			for(int tt=0; tt<t; tt++) {
				int n =sc.nextInt();
				//System.out.println(n);
				List<String> l= new ArrayList<>();
				int max =0;
				String ms ="";
				for(int j=0; j<n ; j++) {
					String s = sc.next();
					s=(s.substring(0,s.length()));
					l.add(s);
					if(s.length()>max) {
						max = s.length();
						ms=s;
					}		
				}
				int x1 = ms.indexOf("*");
				int start =0;
				int end=0;
				int mid=0;
				if(x1==ms.length()-1) {
				    start=1;
				}
				else if(x1==0) {
					end=1;
				}
				else {
					mid=1;
				}
				String ms5=ms;
				ms=ms.substring(0,x1)+ms.substring(x1+1,ms.length());
				//System.out.println(ms5+" "+ms);
				int count=0;
				for(int k=0; k<l.size(); k++) {
					
					
						String s1=l.get(k);
						int len= s1.length();
						int x= (s1.indexOf('*'));
						if(x==0 && (end==1 || mid==1)) {
							if(end==1) {
								String s2 = s1.substring(1,s1.length());
								//System.out.println(s2+""+ms);
								String ms1 =ms.substring(ms.length()-s2.length(),ms.length());
								//System.out.println(s2+" "+ms1);
								if(ms1.equals(s2)) {
									count+=1;
								}
							}
							else if(mid==1) {
								String ms1 = ms5.substring(x1+1,ms5.length());
								String s2 = s1.substring(1,ms1.length()+1);
								//System.out.println(ms1+" "+s2);
								if(ms1.equals(s2)) {
									//System.out.println("yes");
									count+=1;
								}
							}
							
						}
						else if(x==s1.length()-1 && (start==1 || mid==1)) {
							if(start==1) {
								String s2 = s1.substring(0,s1.length()-1);
								String ms1 = ms.substring(0,s2.length());
								//System.out.println(s2+" "+ms1);
								if(ms1.equals(s2)) {
									count+=1;
								}
							}
							else if(mid==1) {
								String ms1 = ms5.substring(0,x1);
								String s2 = s1.substring(0,ms1.length());
								//System.out.println(ms1+" "+s2);
								if(ms1.equals(s2)) {
									//System.out.println("yes");
									count+=1;
								}
							}
							
						}
						else {
							String s3 = s1.substring(0,x);
							String s4 = s1.substring(x+1,s1.length());
							
							String ms1 =ms.substring(0,s3.length());
							//System.out.println(s3+" "+ms1);
							if(ms1.equals(s3)) {
								ms1=ms.substring(ms.length()-s4.length(),ms.length());
								//System.out.println(s4+" "+ms1);
								if(ms1.equals(s4)) {
									count+=1;
								}
							}
						
							
						}
						
							
					}
					
					
				//System.out.println(count);
				if(count==l.size()) {
					System.out.println("Case #"+(tt+1)+": "+ms);
				}
				else {
					System.out.println("Case #"+(tt+1)+": *");
				}
					
			}
				
        }
    }
 }		

