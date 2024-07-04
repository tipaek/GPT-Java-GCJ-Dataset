import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class CodeJam
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();//test cases
              
        for(int p=1;p<t+1;p++){
            // int cho=sc.nextInt();//number chocolates
            int n=sc.nextInt(); 
            int arr[][]=new int[n][n];
            int countr=0,countc=0;
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
            System.out.println("Case #"+p+":"+sum+" "+countr+" "+countc);
            
        }
        sc.close();
    }
    
}
