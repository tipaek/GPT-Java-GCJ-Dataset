/* package whatever; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Ideone
{
	public static void main (String[] args) throws java.lang.Exception
	{
	int T,N;
        Scanner sc=new Scanner(System.in);
        T=sc.nextInt();
        int k=1;
        while(k<=T){
            int trace=0;
            N=sc.nextInt();
            int[][] ar=new int[N][N];
            for(int i=0;i<N;i++){
                for(int j=0;j<N;j++){
                    ar[i][j]=sc.nextInt();
                }
            }
            for(int i=0;i<N;i++)
                trace+=ar[i][i];
            HashSet<Integer> set=new HashSet<>();
            int row=0;
            for(int i=0;i<N;i++)
            {   set.clear();
                for(int j=0;j<N;j++){
                    if(set.contains(ar[i][j])){
                        row++;break;
                    }
                    set.add(ar[i][j]);
                }
            }
 
 
 
 
            int col=0;
            for(int j=0;j<N;j++)
            {   set.clear();
                for(int i=0;i<N;i++){
                    if(set.contains(ar[i][j])){
                        col++;break;
                    }
                    set.add(ar[i][j]);
                }
            }
 
            System.out.println("Case #"+k+": "+trace+" "+row+" "+col);
			k++;
 
        }
	}
}