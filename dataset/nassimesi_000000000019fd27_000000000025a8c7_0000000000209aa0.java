import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 0; i < t; i++) {
      int n = in.nextInt();
      int matrix[][] = new int [n][n];
      int trace = in.nextInt();
      if (trace % n !=0 || (trace / n) <=0 || ((trace / n) >=n+1)) 
          System.out.println("Case #" + (i+1) + ": IMPOSSBLE");
      else
      {
          System.out.println("Case #" + (i+1) + ": POSSBLE");
                for (int f = 0; f<n; f++){
		for (int ff = 0; ff<n ; ff++)
		{
			matrix[f][ff]=((ff -f + trace / n + n - 1) % n) + 1;
			System.out.print(matrix[f][ff]+(ff!=n-1?" ":""));
		}
		System.out.print((i!=t-1 || f!=n-1)?"\n":"");
		}

                 
                }
            } 
          
            }
          
        }
      
    
  