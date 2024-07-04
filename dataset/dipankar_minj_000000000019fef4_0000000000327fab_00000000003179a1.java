import java.util.*;
import java.io.*;
class Solution {
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
          int u = in.nextInt();
          int arr[][] = new int[26][10];
          Arrays.fill(arr,0);
          for(int j =1;j<=10000;j++){
              
              Long m =  in.nextInt();
              String s = in.next();
              HashSet<Integer> h = new HashSet<Integer>();
              HashSet<String> h1 = new HashSet<String>(); 
              int l = s.length();
              if(l != u){
                  continue;
              }
              else{
                  
                  int y = u-1;
                  Long x = m;
                  while(x>0){
                      
                      int rem = x%10;
                      char c = s.charAt(y);
                      int n = c - 'A';
                      h.add(n);
                      h1.add(c);
                      arr[n][rem]++;
                      x = x/10;
                      y--;
                  }
                  
                  Iterator<Integer> k = h.iterator();
                  Iterator<Integer> k1 = h1.iterator();
                  char b [] = new char[10];
                  while(k.hasNext()){
                      
                      int f = k.next();
                      int max = 0,index = 0;
                      for(int g=0;g<10;g++)
                      {
                          if(arr[f][g]>max)
                          {
                              max = arr[f][g];
                              index  = g;
                          }
                      }
                      b[index] = k1.next();
                      
                  }
                  System.out.print("Case #" + i + ": " );
                  for(int q =0;q<10;q++){
                      System.out.print(b[q]);
                  }
                  System.out.println();
                  
                  
              }
              
          }
          
        }
      }
    }