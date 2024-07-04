 import java.util.*;
 import java.io.*;
 class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int n = in.nextInt();
          int s[] = new int[n];
          int e[] = new int[n];
          
          for(int j=0;j<n;j++){
              
              s[j] = in.nextInt();
              e[j] = in.nextInt();
              
          }
          for(int x = 0;x<n-1;x++){
              int flag =0;
              for(int y= 0;y<n-x-1;y++){
                  
                  if(s[y]>s[y+1]){
                      
                      flag=1;
                      int t1 = s[y]; int t2 = e[y];
                      s[y] = s[y+1]; e[y] = e[y+1];
                      s[y+1] = t1; e[y+1] = t2;
                  }
              }
              if(flag == 0)
              break;
          }
          
          String s1 = "";
          s1 = s1+"CJ";
          int f = 0;
          int ca = 0;
          int je = 1;
          for(int k = 2; k<n; k++){
              
            if(e[ca] <= s[k])
            {
                s1 = s1+'C';
                ca = k;
            }
            else if(e[je] <= s[k])
            {
                s1 = s1+'J';
                je = k;
            }
            else{
               f = 1; 
            }
          }
          if(f == 0)
          {
              System.out.println("Case #" + i + ": " + s1);
          }
          else{
               System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
          }
        }
      }
  }
    