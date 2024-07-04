import java.io.*;
import java.math.BigInteger;
    class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          ArrayList<String> patterns = new ArrayList<String>();
          for (int j = 1; j <= n; j++) {
            patterns.add(in.next());
          }
          
          // Do boundary check
          String start = null;
          String end = null;
          int j = 0;
          //while (start == "" || j < n) {
          //  start = patterns.get(j).substring(0, patterns.get(j++).indexOf('*'));
          //}

          j = 0;
          for (j = 0; j < n; j++) {
            String temp1 = patterns.get(j).substring(0, patterns.get(j).indexOf('*'));
            if (start == null || (temp1.length() < start.length())) {
              start = temp1;
            }

            String temp = patterns.get(j).substring(patterns.get(j).lastIndexOf('*') + 1, patterns.get(j).length());
            if (end == null || (temp.length() < end.length())) {
              end = temp;
            }
          }

          System.out.println("start : " + start);
          System.out.println("end : " + end);

          // if end is empty string this means that it can end on anything. So it is not impossible.
          boolean impossible = false;
 
          for (String pattern : patterns) {
            if (!pattern.startsWith(start) || !pattern.endsWith(end)) {
              impossible = true;
              break;
            }
          }
          
          if (!impossible) {
            // Find the biggest work
            String max = Collections.max(patterns, Comparator.comparing(String::length)); 
            System.out.println(max);
            while(max.indexOf('*') != -1) {
              max = max.substring(0, max.indexOf('*')) + max.substring(max.indexOf('*')+1);
            }
            if (!start.isEmpty() || !end.isEmpty()) {
              for (String pattern : patterns) {
                while(pattern.indexOf('*') != -1) {
                  pattern = pattern.substring(0, pattern.indexOf('*')) + pattern.substring(pattern.indexOf('*')+1);
                }
                if (!max.contains(pattern)) {
                  max = max.concat(pattern);
                }
              }
            }
            System.out.println("Case #" + i + ": " + max);
          } else {
            System.out.println("Case #" + i + ": *");
          }
        }
      }
    }