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
          int index[] = new int[n];
          
          for(int j=0;j<n;j++){
              
              s[j] = in.nextInt();
              e[j] = in.nextInt();
              index[j] = j;
              
          }
          for(int x = 0;x<n-1;x++){
              int flag =0;
              for(int y= 0;y<n-x-1;y++){
                  
                  if(s[y]>s[y+1]){
                      
                      flag=1;
                      int t1 = s[y]; int t2 = e[y]; int t3 = index[y];
                      s[y] = s[y+1]; e[y] = e[y+1]; index[y] = index[y+1];
                      s[y+1] = t1; e[y+1] = t2; index[y+1] = t3;
                  }
              }
              if(flag == 0)
              break;
          }
          
        //   
        //   s1 = s1+"CJ";
            
          int f = 0;
          int ca = 0;
          int je = 1;
          char s2[] = new char[n];
          s2[index[0]] = 'C';
          s2[index[1]] = 'J';
          for(int k = 2; k<n; k++){
              
            if(e[ca] <= s[k])
            {
                s2[index[k]] = 'C';
                ca = k;
            }
            else if(e[je] <= s[k])
            {
                s2[index[k]] = 'J';
                je = k;
            }
            else{
               f = 1; 
            }
          }
          if(f == 0)
          {   
              
              System.out.print("Case #" + i + ": ");
              for(int p =0;p<n;p++)
               System.out.print(s2[p]);
              System.out.println(); 
          }
          else{
               System.out.println("Case #" + i + ": " + "IMPOSSIBLE");
          }
        }
      }
  }
    