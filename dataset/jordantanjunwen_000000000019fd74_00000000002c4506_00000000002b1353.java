 import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int t = in.nextInt();  // Scanner has functions to read ints, longs, strings, chars, etc.
    for (int i = 1; i <= t; i++) {
      int n = in.nextInt();
      printPascalWalk(n,i);
    }
  }
  
   static void printPascalWalk(int n, int pos) {
  int count=0,tempInt,lengthLimit=0,tempEven=0,tempOdd=0;
  System.out.println("Case #"+pos+":");
  
    for (int i = 0; i < n; i++) {
		if(i%2==0){//Odd Number
		  for (int j = i/2; j <= tempOdd; j++) {
		  tempInt=pascal(i, j);
			if(count+tempInt<=n){
				count+=tempInt;
				System.out.println((i+1)+" "+(j+1));
				tempEven=j;
				if(++lengthLimit==500){
				return;
				}else{
				lengthLimit++;
				}
			}
			if(tempInt+count<n){
				break;
				}
		}
		}else{//Even Number
			for (int j = i/2; j >= tempEven; j--) {
			  tempInt=pascal(i, j);
				if(count+tempInt<=n){
					count+=tempInt;
					System.out.println((i+1)+" "+(j+1));
					tempOdd=j+2;
					if(++lengthLimit==500){
				return;
				}else{
				lengthLimit++;
				}
				}
				
				if(tempInt+count<n){
				break;
				}
			  }
		}
		if(n==count || lengthLimit>=500){break;}
  }
}

  static int pascal(int n, int k) {
    int res = 1; 
          
        if (k > n - k) 
        k = n - k; 
              
        for (int i = 0; i < k; ++i) 
        { 
            res *= (n - i); 
            res /= (i + 1); 
        } 
        return res;
  }
} 