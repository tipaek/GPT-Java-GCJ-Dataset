import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Solution {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		int testcase=Integer.parseInt(sc.nextLine());
		for(int test=1;test<=testcase;test++)
		{
			String S[]=sc.nextLine().split(" ");
			int N=Integer.parseInt(S[0]);
			int K=Integer.parseInt(S[1]);
			int A[][]=new int[N][N];
			for(int i=0;i<N;i++)
			{
				int x=1;
				for(int j=0;j<N;j++)
				{
					A[i][j]=x;
					x++;
				}
			}
			
			 System.out.print("Case #" + test + ": ");
			 
			 boolean flag = false;
			 int rotate=0;
			 if(N!=1)
			 if(K<=check1(A))
			 for(int i=0;i<N;i++)
			 {
				 rotate=0;
				 for(int j=0;j<N;j++)
				 {
					 
					 for(int k=0;k<rotate;k++)
					 {
						 
						 A=rotateRow(A,rotate);
					 }
					 
					 if(check(A,K))
					 {
						 flag = true;
						 break;
					 }
					 rotate++;
					 
				 }
				 if(flag)
					 break;
			 }
			 if(flag)
			 {
				 System.out.println("POSSIBLE");
				 for(int i=0;i<N;i++)
				 {
					 for(int j=0;j<N;j++)
					 {
						 if(j==N-1)
						 {
							 System.out.print(A[i][j]);
						 }
						 else
						 {
							 System.out.print(A[i][j] +" ");
						 }
					 }
					 System.out.println();
				 }
			 }
			 else
			 {
				 System.out.println("IMPOSSIBLE");
			 }
			
				
			}
		}
	
	public static int check1(int A[][])
	{
		int sum=0;
		 for (int i = 0; i < A.length; i++) 
	        { 
	            for (int j = 0; j < A.length; j++) 
	            { 
	               
	                if (i == j) 
	                    sum += A[i][j]; 
	            } 
	        } 
		 return sum;
	}
	
	
	private static boolean check(int[][] a,int K) {
		// TODO Auto-generated method stub
		int count1=countdiag(a);
		int count2=countDuplicateRow(a);
		int count3=countDuplicateCol(a);
			boolean flag=false;
			if(count1==K )
			{
				if(count3==0)
				{
					flag=true;
				}
			}
		return flag;
	}

	private static int countDuplicateCol(int[][] square) {
		int count=0;
		int x=0;
		for(int i=0;i<square.length;i++)
		{
			HashMap<Integer, Integer> map = new HashMap<>();
			for(int j=0;j<square.length;j++)
			{
				if(map.get(square[j][x]) == null)
				{
					map.put(square[j][x], 1);
				}
				else
				{
					map.put(square[j][x], map.get(square[j][x])+1);
				}
			}
			x++;
			 for(Entry<Integer, Integer> entry : map.entrySet()) 
		        {
				 	if(entry.getValue() > 1){ 
				 		count++;
				 		break;
				 	}
		        }
		}
		return count;
		
	}
	public static int countDuplicateRow(int square[][])
	{
		int count=0;
		int x=0;
		for(int i=0;i<square.length;i++)
		{
			HashMap<Integer, Integer> map = new HashMap<>();
			for(int j=0;j<square.length;j++)
			{
				if(map.get(square[x][j]) == null)
				{
					map.put(square[x][j], 1);
				}
				else
				{
					map.put(square[x][j], map.get(square[x][j])+1);
				}
			}
			x++;
			 for(Entry<Integer, Integer> entry : map.entrySet()) 
		        {
				 	if(entry.getValue() > 1){ 
				 		count++;
				 		break;
				 	}
		        }
		}
		return count;
	}
	public static int countdiag(int square[][])
	{
		int count =0;
		for (int i = 0; i < square.length; i++) { 
            count += square[i][i];   
        } 
		return count;
		
	}
	 public static int[][] rotateRow(int mat[][],int r)
	 {	 int N=mat.length;
		 int rotate[]=new int[N];
		 
		 for(int i=0;i<N;i++)
		 {
			 rotate[i]=mat[r][i];
		 }
		 rotate=leftRotate(rotate,1, N); 
		 for(int i=0;i<N;i++)
		 {
			 mat[r][i]=rotate[i];
		 }
		return mat;
	}

	public static int[] leftRotate(int arr[], int d, int n) 
	    { 
	        int i, j, k, temp; 
	        int g_c_d = gcd(d, n); 
	        for (i = 0; i < g_c_d; i++) { 
	            /* move i-th values of blocks */
	            temp = arr[i]; 
	            j = i; 
	            while (true) { 
	                k = j + d; 
	                if (k >= n) 
	                    k = k - n; 
	                if (k == i) 
	                    break; 
	                arr[j] = arr[k]; 
	                j = k; 
	            } 
	            arr[j] = temp; 
	        } 
	        return arr;
	    } 
		
	
	 
	 public static int gcd(int a, int b) 
	    { 
	        if (b == 0) 
	            return a; 
	        else
	            return gcd(b, a % b); 
	    } 

}