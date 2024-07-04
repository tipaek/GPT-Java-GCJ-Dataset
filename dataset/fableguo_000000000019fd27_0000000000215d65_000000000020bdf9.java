import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        String input = "";
        // input = in.nextLine();
        for (int i = 1; i <= t; ++i) {
            int n = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
            int[][] sch = new int[n][3];
            for(int j = 0; j < n; j++){
                sch[j][0] = in.nextInt();
                sch[j][1] = in.nextInt();
                sch[j][2] = j;
            }
            Arrays.sort(sch, (a,b) -> a[1] == b[1]? a[0]-b[0]:a[1]-b[1]);
            String res = "";
            char[] resChar = new char[n];
            int cT = 0;
            int jT = 0;
            for(int j = 0; j < n; j++){
                // System.out.println(sch[j][0]+" "+cT+" "+jT);
                if(sch[j][0] >= cT){
                    cT = sch[j][1];
                    resChar[sch[j][2]]='C';
                }else if(sch[j][0] >= jT){
                    jT = sch[j][1];
                    resChar[sch[j][2]]='J';
                }else{
                    res = "IMPOSSIBLE";
                    break;
                }
            }
          if(res.length() == 0)
            res = new String(resChar);
              
          System.out.println("Case #" + i + ": " + (res));
        }
      }
    }
  