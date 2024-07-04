import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;
class Person {
	int start;
	char name;
	int end;
	public Person(int start,int end, char name) {
		this.start = start;
		this.end = end;
 		this.name = name;
	}
}

public class Solution {
	
      public static void main(String[] args) {
    	Map<String,Integer> map = new HashMap<>();  
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int s_e = in.nextInt();
          int[][] intervals = new int[s_e][2];
          for(int j=0; j<s_e; j++) {
            int m = in.nextInt();
            int n = in.nextInt();
            intervals[j][0] = m;
            intervals[j][1] = n;
            map.put(String.valueOf(m)+"#"+String.valueOf(n),j);
          }
          Arrays.sort(intervals,new Comparator<int []>() {
            public int compare(int [] a, int [] b) {
                return a[0] - b[0];
            }    
        });
        
        PriorityQueue<Person> pQ = new PriorityQueue<>(new Comparator<Person>() {
            public int compare(Person a, Person b) {
                return a.end-b.end;
            }    
        });
        char getStr [] = new char[s_e];
        Person p = new Person(intervals[0][0],intervals[0][1],'C'); 
        pQ.add(p);
        getStr[map.get(String.valueOf(p.start)+"#"+String.valueOf(p.end))] = 'C';
        int max = 1;
        for(int z=1; z<intervals.length; z++) {
            while(!pQ.isEmpty() && pQ.peek().end<=intervals[z][0]) {
                pQ.poll();
            }
            if(pQ.isEmpty()) {
            	p = new Person(intervals[z][0],intervals[z][1],'C'); 
                pQ.add(p);
                getStr[map.get(String.valueOf(p.start)+"#"+String.valueOf(p.end))] = 'C';
            }
            else if(pQ.peek().name=='C') {
            	p = new Person(intervals[z][0],intervals[z][1],'J'); 
                pQ.add(p);
                getStr[map.get(String.valueOf(p.start)+"#"+String.valueOf(p.end))] = 'J';
            }
            else {
            	p = new Person(intervals[z][0],intervals[z][1],'C'); 
                pQ.add(p);
                getStr[map.get(String.valueOf(p.start)+"#"+String.valueOf(p.end))] = 'C';
            }
            max = Math.max(max,pQ.size());
        }
        if(max>2)
            System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
        else {
        	StringBuilder sb = new StringBuilder();
        	for(int low=0; low<s_e; low++)
        		sb.append(getStr[low]);
        	System.out.println("Case #" + i + ": " + sb.toString());
        }
        }
      }
    }