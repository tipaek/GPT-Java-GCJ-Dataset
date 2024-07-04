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
				Map<Integer, List<Integer>> m = new HashMap<>();
				List<Integer> start = new ArrayList<>();
				List<Integer> nlist = new ArrayList<>();
				List<Integer> nlist2 = new ArrayList<>();
				List<Integer> ck = new ArrayList<>();
				Stack<Integer> cv = new Stack<>();
				List<Integer> jk = new ArrayList<>();
				Stack<Integer> jv = new Stack<>();
				for(int i=0; i<n; i++) {
					List<Integer> list = new ArrayList<>();
					m.put(i,list);
					int no=sc.nextInt();
					m.get(i).add(no);
					m.get(i).add(sc.nextInt());
					start.add(no);
					nlist.add(no);
					nlist2.add(no);
				}
				//nlist2=nlist;
				//System.out.println(m);
				Collections.sort(start);
				//System.out.println(start);
				int flag=0;
				for(int i=0; i<n; i++) {
					int key = start.get(i);
					//System.out.println(key);
					int index = nlist.indexOf(key);
					//System.out.println(index);
					int val = m.get(index).get(1);
					nlist.set(index,-1);
					//System.out.println(key+" "+val);
					//System.out.println(nlist);
					if(i==0) {
						ck.add(key);
						cv.add(val);
					}
					else {
						//System.out.println("top"+cv.peek());
						if(key<cv.peek()) {
							if(jv.size()>0 && key<jv.peek()) {
								System.out.println("Case #"+(tt+1)+": "+"IMPOSSIBLE");
								flag=1;
								break;
							}
							else {
								jk.add(key);
								jv.add(val);
							}
						}
						else {
							ck.add(key);
							cv.add(val);
						}
					}
						
				}
				if(flag==0) {
					String ans="";
					for(int i=0; i<n; i++) {
						int no = nlist2.get(i);
						nlist2.set(i, -1);
						int val = m.get(i).get(1);
						//System.out.println("no is"+no+"val is"+val+" ");
						if(ck.contains(no) ) {
							int in = ck.indexOf(no);
							if(cv.get(in)==val) {
								ans+="C";
								ck.set(in, -1);
							}
							
						}
						else if(jk.contains(no) ) {
							int in = jk.indexOf(no);
							if(jv.get(in)==val) {
								ans+="J";
								jk.set(in, -1);
							}
							
						}
					}
					System.out.println("Case #"+(tt+1)+": "+ans);
				}
				//System.out.println(ck);
				//System.out.println(cv);
				//System.out.println(jk);
				//System.out.println(jv);
				
				
			}
			
        }
    }
 }