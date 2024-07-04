 import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          String[] resultArr = new String[n];
          String result = "";
          List<Integer> check = new ArrayList<Integer>();
          List<Integer> starts = new ArrayList<Integer>();
          List<Integer> ends = new ArrayList<Integer>();
          for(int j=0; j<n; j++){
              int s = in.nextInt();
              int e = in.nextInt();
             starts.add(s);
             ends.add(e);
             check.add(s);
    
          }
          Collections.sort(starts);
          int ce=0,je=0;
          while(!starts.isEmpty()){
              
              int s = starts.get(0);
              starts.remove(0);
              int ind = check.indexOf(s);
              check.set(ind,-1);
              int e = ends.get(ind);
              //System.out.println(s+" "+ind+" "+e);
              if(ce<=s){
                  resultArr[ind]="C";
                  ce = e;
              }else if(je<=s){
                  resultArr[ind]="J";
                  je = e;
              }else
              {
                  result = "IMPOSSIBLE";
                  break;
              }
          }
          if(!result.equals("IMPOSSIBLE"))
                result = String.join("", resultArr);
          System.out.println("Case #" + i + ": " + result);
        }
      }
    } 