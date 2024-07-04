/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Problem1
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		for(int init = 1; init <= t ; init++){
		    int n = sc.nextInt();
		    int trace = 0;
		    int[][] arr = new int[n][n];
		    int i=0,j=0;
		    for(i=0;i<n;i++){
		        for(j=0;j<n;j++){
		            arr[i][j] = sc.nextInt();
		            if(i == j){
		                trace +=arr[i][j];
		            }
		        }
		    }
		    int row =0,col =0,temp = 0;
		    for(i=0;i<n;i++){
		        for(j=0;j<n;j++){
		            temp =0;
		            for(int k=j+1;k<n;k++){
		                if(arr[i][j] == arr[i][k])
		                    temp ++;
		                if(temp > 0 )
		                    break;
		            }
		            if(temp > 0 ){
		                row ++;
		                break;
		            }
		        }
		    }
		    for(i=0;i<n;i++){
		        for(j=0;j<n;j++){
		            temp =0;
		            for(int k=j+1;k<n;k++){
		                if(arr[j][i] == arr[k][i])
		                    temp ++;
		                if(temp > 0 )
		                    break;
		            }
		            if(temp > 0 ){
		                col ++;
		                break;
		            }
		        }
		    }
		    System.out.println("Case #"+ init + ": " + trace +" " + row +" " + col);
		}
	}
}
