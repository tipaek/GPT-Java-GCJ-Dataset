 import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          String result = "";
          HashMap<Integer,Integer> sten = new HashMap<Integer,Integer>();
          List<Integer> starts = new ArrayList<Integer>();
          for(int j=0; j<n; j++){
              int s = in.nextInt();
              int e = in.nextInt();
             starts.add(s);
             sten.put(s,e);
    
          }
          Collections.sort(starts);
          int cs=0,ce=0,js=0,je=0;
          while(!starts.isEmpty()){
              
              int s = starts.get(0);
              starts.remove(0);
              int e = sten.get(s);
              if(ce<=s){
                  result+="C";
                  ce = e;
              }else if(je<=s){
                  result+="J";
                  je = e;
              }else
              {
                  result = "IMPOSSIBLE";
                  break;
              }
          }
          
          System.out.println("Case #" + i + ": " + result);
        }
      }
    } 