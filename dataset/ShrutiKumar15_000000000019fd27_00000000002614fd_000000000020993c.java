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
			 	for(long tt =1; tt<=t; tt++) {
			 		long n = sc.nextLong();
			 		long sum=0;
			 		int rcount=0;
			 		int ccount =0;
			 		Map<Long,Set<Long>> m = new HashMap<>();
			 		for(long i=0; i<n; i++) {
			 			Set<Long> col = new HashSet<>();
			 			m.put(i,col);
			 		}
			 		for(long i=0; i<n; i++) {
			 			Set<Long> row = new HashSet<>();
			 			
			 			for(long j=0; j<n; j++) {
			 				long no = sc.nextLong();
			 				m.get(j).add(no);
			 				if(i==j) {
			 					sum+=no;
			 				}
			 				row.add(no);
			 			}
			 			if(row.size()<n) {
			 				rcount+=1;
			 			}
			 		}
			 		for(long j=0;j<n; j++) {
			 			if(m.get(j).size()<n) {
			 				ccount+=1;
			 			}
			 		}
			 		System.out.println("Case #"+tt+": "+sum+" "+rcount+" "+ccount);
			 	}
        }
    }
 }
