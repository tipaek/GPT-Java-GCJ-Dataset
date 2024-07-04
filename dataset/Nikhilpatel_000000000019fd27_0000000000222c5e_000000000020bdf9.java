import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int size = in.nextInt();
    ArrayList<Integer[][]> tests = new ArrayList<Integer[][]>();
    for (int i = 0; i < size; i++) {
        int jobs = in.nextInt();
        Integer[][] test = new Integer[jobs][3];
        for (int j = 0; j < jobs; j++) {
            Integer[] job = new Integer[3];
            job[0] = in.nextInt();
            job[1] = in.nextInt();
            job[2] = j;
            test[j] = job;
        }
        tests.add(test);
    }
    ArrayList<String> output = new ArrayList<String>(size);
    for (Integer[][] test : tests) {
        boolean flag = false;
        Arrays.sort(test, (a, b) -> Integer.compare(a[0], b[0]));
        ArrayList<Integer> Cjobs = new ArrayList<Integer>();
        ArrayList<Integer> Jjobs = new ArrayList<Integer>();
        
        int C = 0;
        int J = 0;
        for (Integer[] job : test) {
            if (C <= job[0]) {
                C = job[1];
                Cjobs.add(job[2]);
            }
            else if (J <= job[0]) {
                J = job[1];
                Jjobs.add(job[2]);
            }
            else {
                output.add("IMPOSSIBLE");
                flag = true;
                break;
            }
        }
        if (flag) {
            continue;
        }
        else {
            output.add(format(Cjobs, Jjobs));
        }
        
    }
    
    for (int i = 0; i < size; i++) {
        int j = i + 1;
        System.out.println("Case #" + j + ": " + output.get(i));
    }
  }
  
  public static String format(ArrayList<Integer> c, ArrayList<Integer> j) {
      ArrayList<String> order = new ArrayList<String>();
      Collections.sort(c);
      Collections.sort(j);
      while (c.size() > 0 || j.size() > 0) {
          if (c.size() == 0) {
              order.add("J");
              j.remove(0);
          }
          else if (j.size() == 0) {
              order.add("C");
              c.remove(0);
          }
          else {
              if (c.get(0) < j.get(0)) {
                  order.add("C");
                  c.remove(0);
              }
              else {
                  order.add("J");
                  j.remove(0);
              }
          }
      }
      StringBuilder sb = new StringBuilder();
      for (String s : order) {
          sb.append(s);
      }
      return sb.toString();
      
  }
}