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


public class Solution {
    public static void main(String[] args) throws IOException {
    	Scanner sc =  new Scanner(System.in);
		if(sc.hasNext()) {
			long t =sc.nextLong();
			for(long tt =0; tt<t; tt++) {
				int n = sc.nextInt();
				int[][] c = new int[n][2];
				int[][] j = new int[n][2];
				int[][] ar = new int[n][2];
				Map<Integer,Integer> m = new TreeMap<>();
				List<Integer> l = new ArrayList<>();
				for(int i=0; i<n; i++) {
						int no1=sc.nextInt();
						int no2=sc.nextInt();
						ar[i][0]=no1;
						ar[i][1]=no2;
						m.put(no1,no2);
						l.add(no1);
				}
				
				Collections.sort(l);
				//System.out.println(l);
				int ccount =1;
				int jcount=0;
				int flag=0;
				
				for(int i=0;i <n; i++) {
					
					int key = l.get(i);
					int val = m.get(key);
					if(i==0) {
						c[i][0]=key;
						c[i][1]=val;
					}
					else {
						if(key<c[ccount-1][1]) {
							int jcount1=0;
							if(jcount!=0) {
								jcount1=jcount-1;
							}
							else {
								 jcount1=0;
							}
							if(key<j[jcount1][1]) {
								System.out.println("Case #"+(tt+1)+": "+"IMPOSSIBLE");
								flag=1;
								break;
							}
							else {
								j[jcount][0]=key;
								j[jcount][1]=val;
								jcount+=1;
							}
						}
						else {
							c[ccount][0]=key;
							c[ccount][1]=val;
							ccount+=1;
						}
					}
					
				}
				String ans="";
				
				if(flag==0) {
					
					for(int i=0; i<n; i++) {
						int aflag=0;
						int key = ar[i][0];
						for(int j1=0; j1<ccount+1; j1++) {
							if(key==c[j1][0] && c[j1][1]!=0) {
								ans+="C";
								aflag=1;
								break;
							}
						}
						
						for(int j1=0; j1<jcount+1; j1++) {
							if(key==j[j1][0] && j[j1][1]!=0) {
								ans+="J";
								break;
							}
						}
					}
					System.out.println("Case #"+(tt+1)+": "+ans);
				}
				
				
			}
        }
    }
 }
