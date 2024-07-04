import java.util.*;
import java.util.stream.Collectors;
import java.io.*;

public class Solution {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    
    int t = Integer.parseInt(scanner.nextLine().trim());
    
    for (int i = 0; i < t; i++) {
      int n = Integer.parseInt(scanner.nextLine().trim());
      
      Integer[][] mat = new Integer[n][n];
      
      for(int j=0; j<n; j++) {
    	  String[] line = scanner.nextLine().trim().split("\\s+");
    	  mat[j] = Arrays.stream(line).map(Integer::parseInt).collect(Collectors.toList()).toArray(mat[j]);
      }
      
      calcMat(mat, n, i+1);
    }
    
    scanner.close();
  }
  
  public static void calcMat(Integer[][] mat, int n, int t) {
	  int sum = 0, row = 0, col = 0;
	  HashSet<Integer> nums;
	  for (int i = 0; i < mat.length; i++) {
		  nums = new HashSet<>(); boolean rowCounted = false;
		  for (int j = 0; j < mat.length; j++) {
			  if(i==j)	sum += mat[i][j];
			  if(nums.contains(mat[i][j]) && !rowCounted)	{row++; rowCounted = true;}
			  nums.add(mat[i][j]);
		  }
	  }
	  
	  for (int i = 0; i < mat.length; i++) {
		  nums = new HashSet<>();
		  for (int j = 0; j < mat.length; j++) {
			  if(nums.contains(mat[j][i]))	{col++; break;}
			  nums.add(mat[j][i]);
		  }
	  }
	  
	  System.out.println("Case #" + t + ": " + sum + " " + row + " " + col);
  }
  
}
