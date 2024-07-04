import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Stack;

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
        
        PriorityQueue<Integer> pQ = new PriorityQueue<>(new Comparator<Integer>() {
            public int compare(Integer a, Integer b) {
                return a-b;
            }    
        });
        StringBuilder sb = new StringBuilder();
        pQ.add(intervals[0][1]);
        sb.append("C");
        Stack<Character> person = new Stack<Character>();
        person.push('C');
        int max = 1;
        for(int z=1; z<intervals.length; z++) {
            while(!pQ.isEmpty() && pQ.peek()<=intervals[z][0]) {
                pQ.poll();
                person.pop();
            }
            if(person.isEmpty()) {
                person.push('C');
                sb.append("C");
            }
            else {
                if(person.peek()=='C') {
                    person.push('J');
                    sb.append("J");
                }
                else {
                    person.push('C');
                    sb.append("C");
                }
            }
            pQ.add(intervals[z][1]);
            max = Math.max(max,pQ.size());
        }
        if(max>2)
            System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
        else   
            System.out.println("Case #" + i + ": " + sb.toString());
        }
      }
    }