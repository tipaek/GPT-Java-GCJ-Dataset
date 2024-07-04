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
      int k= 0;
      boolean isPossible = false;
	if(n%2==0){
	k=n/2;
	}else{
	k=n;
	}
	if(trace!=n+1 && trace % k ==0 && trace>=n && (trace <=n*n)) isPossible = true;
	if (!isPossible) 
          System.out.println("Case #" + (i+1) + ": IMPOSSIBLE");
      	else
      	{
		System.out.println("Case #" + (i+1) + ": POSSIBLE");
			if(n%2==0) {
				int indexr = 1;
				int indexc = 0;
				int value = 1;
				matrix[0][0] = (trace/(k*2));
				matrix[1][n-1] = matrix[0][0];
				matrix[1][1] = (trace/k) - matrix[0][0];
				matrix[0][n-2] = matrix[1][1];
				while(value<matrix[0][0] && (2*indexc)+indexr<n) {
					matrix[indexr][indexc] = value;
					matrix[1-indexr][n-indexc-1] = value;
					value = ((value) % n) +1;
					indexr = 1- indexr;
					if(indexr==0 || indexr==indexc) {indexc++; indexr =0;}  
				}
				value = matrix[1][1] +1;
				while((2*indexc)+indexr<n) {
					matrix[indexr][indexc] = value;
					matrix[1-indexr][n-indexc-1] = value;
					value = ((value) % n) +1;
					indexr = 1- indexr;
					if(indexr==0|| indexr==indexc) {indexc++; indexr =0;} 
				}
				}
			else 
		for (int ff = 0; ff<k ; ff++)
		{
		matrix[0][ff]=((ff + trace/k - 1) % n) + 1;
		}
		//System.out.print((i!=t-1 || f!=n-1)?"\n":"");
		
	        for (int f = n/k; f<n; f++){
		for (int ff = 0; ff<n ; ff++)
		{
			matrix[f][ff] = matrix[(n+f-n/k)%n][(n+ff-n/k)%n];
		}}
		for (int fff = 0; fff<n; fff++){
		for (int ff = 0; ff<n ; ff++)
		{	
			System.out.print(matrix[fff][ff]+" ");
		}System.out.print((i!=t-1 || fff!=n-1)?"\n":"");
		}

	}
                 
                }
            } 
          
            }
          
        
      
    
  