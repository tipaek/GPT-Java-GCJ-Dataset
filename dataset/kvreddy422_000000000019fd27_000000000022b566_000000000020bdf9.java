import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;
class Person {
	int count;
	char name;
	public Person(int count, char name) {
		this.count = count;
		this.name = name;
	}
}

public class Solution {
	
      public static void main(String[] args) {
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
          }
          Arrays.sort(intervals,new Comparator<int []>() {
            public int compare(int [] a, int [] b) {
                return a[0] - b[0];
            }    
        });
        
        PriorityQueue<Person> pQ = new PriorityQueue<>(new Comparator<Person>() {
            public int compare(Person a, Person b) {
                return a.count-b.count;
            }    
        });
        StringBuilder sb = new StringBuilder();
        Person p = new Person(intervals[0][1],'C'); 
        pQ.add(p);
        sb.append("C");
        int max = 1;
        for(int z=1; z<intervals.length; z++) {
            while(!pQ.isEmpty() && pQ.peek().count<=intervals[z][0]) {
                pQ.poll();
            }
            if(pQ.isEmpty()) {
            	pQ.add(new Person(intervals[z][1],'C'));
                sb.append("C");
            }
            else if(pQ.peek().name=='C') {
            	pQ.add(new Person(intervals[z][1],'J'));
            	sb.append("J");
            }
            else {
            	pQ.add(new Person(intervals[z][1],'C'));
                sb.append("C");
            }
            max = Math.max(max,pQ.size());
        }
        if(max>2)
            System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
        else   
            System.out.println("Case #" + i + ": " + sb.toString());
        }
      }
    }