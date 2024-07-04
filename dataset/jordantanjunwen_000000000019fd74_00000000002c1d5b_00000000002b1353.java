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
  int count=0,tempInt,lengthLimit=0;
  System.out.println("Case #"+pos+":");
  
    for (int i = 0; i < n; i++) {
		if(i%2==0){//Odd Number
		  for (int j = i/2; j <= i; j++) {
		  tempInt=pascal(i, j);
		  if(j==i/2){
			if(count+tempInt<=n){
				count+=tempInt;
				System.out.println((i+1)+" "+(j+1));
				if(++lengthLimit==500){
				return;
				}else{
				lengthLimit++;
				}
			}
		  }else{
			if(count+tempInt<=n){
				count+=tempInt;
				System.out.println((i+1)+" "+(j+1));
				if(++lengthLimit==500){
				return;
				}else{
				lengthLimit++;
				}
			}
			
			if(tempInt+count>n){
				continue;
				}else{
				break;
				}
				
			if(count+tempInt<=n){
				count+=tempInt;
				System.out.println((i+1)+" "+(i-j+1));
				if(++lengthLimit==500){
				return;
				}else{
				lengthLimit++;
				}
			}
		  }
		}
		}else{//Even Number
			for (int j = i/2; j >= 0; j--) {
			  tempInt=pascal(i, j);
				if(count+tempInt<=n){
					count+=tempInt;
					System.out.println((i+1)+" "+(j+1));
					if(++lengthLimit==500){
				return;
				}else{
				lengthLimit++;
				}
				}
				
				if(tempInt+count>n){
				continue;
				}else{
				break;
				}
				
				if(count+tempInt<=n){
					count+=tempInt;
					System.out.println((i+1)+" "+(i-j+1));
					if(++lengthLimit==500){
				return;
				}else{
				lengthLimit++;
				}
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