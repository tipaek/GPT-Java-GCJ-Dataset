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
					s=(s.substring(1,s.length()));
					l.add(s);
					if(s.length()>max) {
						max = s.length();
						ms=s;
					}		
				}
				//System.out.println(ms);
				int count=0;
				for(int k=0; k<l.size(); k++) {
					String s1=l.get(k);
					int len= s1.length();
					String ms1 =ms.substring(ms.length()-len,ms.length());
					//System.out.println(ms1+" "+s1);
					if(ms1.equals(s1)) {
						count+=1;
					}
						
				}
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

