import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; ++i) {
      int n = in.nextInt();
      int arr[][] = new int[n][n];
      int sumdiag =0,row=0,col=0;
      for(int j=0;j<n;j++){
      	int kar[] = new int[n+1];
      	boolean rdone =false;
      	for(int k=0;k<n;k++){
      		arr[j][k]=in.nextInt();
      		if(j==k)
      			sumdiag += arr[j][k];
      		if(kar[arr[j][k]]!= arr[j][k])
      			kar[arr[j][k]] = arr[j][k];
      		else if(!rdone)
      		{
      			rdone = true;
      			row++;
      		}
      	}
      }
      for(int j=0;j<n;j++){
      	int kar[] = new int[n+1];
      	boolean cdone =false;
      	for(int k=0;k<n;k++){
      		if(kar[arr[k][j]]!= arr[k][j])
      			kar[arr[k][j]] = arr[k][j];
      		else if(!cdone)
      		{
      			cdone = true;
      			col++;
      		}
      	}
      }
      System.out.println("Case #" + i + ": " + sumdiag + " " + row + " " + col);
    }
  }
}