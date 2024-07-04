import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int N = in.nextInt();
      
      int[][] intervals = new int[N][2];
      
      Integer[] orders = new Integer[N];
      
      char[] assign = new char[N];
      
      for(int  n = 0; n < N; n++) {
          orders[n] = n;
      }
      
      for(int j = 0; j < N; j++) {
          intervals[j][0] = in.nextInt();
          intervals[j][1] = in.nextInt();
      }
      
      Arrays.sort(orders, (Integer a, Integer b) -> {
         if(intervals[a][0] == intervals[b][0])  {
             return intervals[a][1] - intervals[b][1];
         }
         return intervals[a][0] - intervals[b][0];
      });
      
      PriorityQueue<Person> queue = new PriorityQueue<>(2, (Person a, Person b) -> a.endTime-b.endTime);
      
      queue.add(new Person('C'));
      queue.add(new Person('J'));
      boolean possible = true;
      String answer = "";
      for(int k = 0; k < N; k++) {
          int n = orders[k];
          Person p = queue.poll();
          if(p.endTime > intervals[n][0]) {
              possible = false;
              break;
          }
          p.endTime = intervals[n][1];
          assign[n] = p.person;
          queue.add(p);
      }
      
      
      if(!possible) {
          System.out.println("Case #" + i + ": IMPOSSIBLE");
      } else {
          for(int n = 0; n < N; n++) {
            answer += assign[n];
          }
          System.out.println("Case #" + i + ": " + answer);
      }
    }
  }
  
}

class Person {
    char person;
    int endTime;
    
    public Person(char person) {
        this.person = person;
    }
}