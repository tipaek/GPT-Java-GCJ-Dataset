import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class CodeJam
{
	public static void main (final String[] args) throws java.lang.Exception
	{
		// your code goes here
        final Scanner sc=new Scanner(System.in);
        final int t=sc.nextInt();//test cases
              
        for(int p=1;p<t+1;p++){
            // int cho=sc.nextInt();//number chocolates
            final int n=sc.nextInt(); 
            final int arr[][]=new int[n][n];
            for(int j=0;j<n;j++){
                for(int k=0;k<n;k++){
                    arr[j][k]=sc.nextInt();
            
                }
            }

            int sum=0;
            for(int j=0;j<arr.length;j++){
                for(int k=0;k<arr.length;k++){
                    if(j==k){
                        sum += arr[j][k];
                        // System.out.print(j+""+k+"next");

                    }
                }
            }
            for(int o = 0; o < arr.length; o++){
                for(int q = 1; q < arr[o].length; q++){
                    if( arr[o][0]==arr[o][q]){
                        System.out.println("Yes"); 
                        countr+=1;
                    }
                }
            }

          
            System.out.println("Case #"+p+":"+sum+" "+countr+" "+countc);
            
        }
        sc.close();
    }
    
}
