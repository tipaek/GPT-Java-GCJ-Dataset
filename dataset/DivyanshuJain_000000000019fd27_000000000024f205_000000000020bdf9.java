import java.util.*;
import java.lang.*;
import java.io.*;
public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		int x,i,n;
		for(x=1;x<=T;x++){
		    n = sc.nextInt();
		    char result[]= new char[n];
		    int A[][]=new int[n][3];
		    int C=0,J=0;
		    for(i=0;i<n;i++){
		        A[i][1]=sc.nextInt();
		        A[i][2]=sc.nextInt();
		        A[i][0]=i;
		    }
		    Arrays.sort(A, new Comparator<int[]>() { 
          @Override              
          public int compare(final int[] e1,final int[] e2) {
            if (e1[1] > e2[1]) 
                return 1; 
            else
                return -1; 
          } 
        });
        int flag=0;
        for(i=0;i<n;i++){
            int index=A[i][0];
             if(A[i][1]>=J)
            {
                J=A[i][2];
                result[index]='J';
            }
             else if(A[i][1]>=C)
            {
                C=A[i][2];
                result[index]='C';
            }
           
            else{
                flag=1;
                break;
            }
        }
        if(flag==1)
        System.out.println("Case #" + x + ": IMPOSSIBLE");
        else
        System.out.println("Case #" + x + ": " + String.valueOf(result));
        
	}
}
}
