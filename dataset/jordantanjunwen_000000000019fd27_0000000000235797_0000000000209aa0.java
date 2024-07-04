import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class Solution {
 static int[] rotateLeftOnce(int[] a) {
    int temp,lastNum;
    lastNum=a[0];
        for(int i=0;i<a.length-1;i++){
            a[i]=a[i+1];
        }
    a[a.length-1]=lastNum;
    return a;
    }
    
    static void naturalLatinSquares(int[] n) 
	{ 
		int diagonalNum=n[1]/n[0];
	    int replacedNum=0;
    	for(int i=0;i<n[0];i++){
    	 for(int j=0;j<n[0];j++){
    	     if(j==i){
    	         System.out.print(diagonalNum+" ");
    	         if(j+1!=diagonalNum){
    	             replacedNum=j+1;
    	         }
    	     }else{
    	         if(j==diagonalNum-1){
    	             System.out.print(replacedNum+" ");
    	         }else{
    	             System.out.print((j+1)+" ");
    	         }
    	     }
    	 } 
    	 System.out.println();
    	}
	}

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int t = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
        
        for (int i =1 ; i <= t; i++) {
            String[] qItems = scanner.nextLine().split(" ");
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[] qItem=new int[2];
            qItem[0]=Integer.parseInt(qItems[0]);
            qItem[1]=Integer.parseInt(qItems[1]);
            
            if(qItem[1]%qItem[0]>0){
                System.out.println("Case #"+i+": IMPOSSIBLE");
            }else{
            System.out.println("Case #"+i+": POSSIBLE");
            naturalLatinSquares(qItem);
            }
        }
        scanner.close();
    }
}
