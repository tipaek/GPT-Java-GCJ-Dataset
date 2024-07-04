import java.util.*;
import java.lang.*;
import java.io.*;
class Solution
 {
	public static void main (String[] args) throws IOException
	 {
	    BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	    int t=Integer.parseInt(br.readLine());
	    int count=1;
	    while(t!=0)
	    {
	        t--;
	        
	        int n=Integer.parseInt(br.readLine());
	        int matrix[][]=new int[n][n];
	        for(int i=0;i<n;i++){
	        String data[]=br.readLine().trim().split(" ");
	        for(int j=0;j<n;j++)
	        {
	            matrix[i][j]=Integer.parseInt(data[j]);
	        }
	        }
	        Solution obj=new Solution();
	        obj.findTrace(matrix,n,count);
	        count++;
	        
	    
	     }
	     
	 }
	 public void findTrace(int matrix[][],int n,int count){
	     int trace=0;
	     int row=0,col=0;
	     for(int i=0;i<n;i++){
	         trace+=matrix[i][i];
	         if(checkRow(matrix,i)==false)
	            row++;
	        if(checkCol(matrix,i)==false)
	            col++;
	     }
	     System.out.println("case #"+count+": "+trace+" "+row+" "+col);
	 }
	 public boolean checkRow(int[][] matrix,int row){
	     HashSet<Integer> s=new HashSet<>();
	     int n=matrix.length;
	     for(int i=0;i<n;i++)
	        s.add(matrix[row][i]);
	   return s.size()==n?true:false;
	 }
	 public boolean checkCol(int[][] matrix,int col){
	     HashSet<Integer> s=new HashSet<>();
	     int n=matrix.length;
	     for(int i=0;i<n;i++)
	        s.add(matrix[i][col]);
	   return s.size()==n?true:false;
	 }
}