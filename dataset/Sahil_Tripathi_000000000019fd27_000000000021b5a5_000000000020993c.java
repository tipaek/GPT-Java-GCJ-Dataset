
import java.util.*;
import java.util.Scanner;

 class codejam {
	static Scanner sc=new Scanner(System.in);
	static int  a=sc.nextInt();
	static int mastercount=0;
	public static void main(String[] args) {
		

		
		for(int i=0;i<a;i++) 
		{
			int b=sc.nextInt();
			int array[][]=new int[b][b];
			for(int k=0;k<b;k++)
				for(int l=0;l<b;l++) {
					array[k][l]=sc.nextInt();
				}
			calculate(array,b);
		}

	}
	public static void calculate(int array1[][],int c) { mastercount++;
		int count=0;
		int rowcount=0;
		int columncount=0;
		int arr[]=new int[c];
		for(int k=0;k<c;k++)
			for(int l=0;l<c;l++) {
				  if (k == l) {
					count=count+array1[k][l];  
				  }
			}
		for(int m=0;m<c;m++) {
			for(int n=0;n<c;n++) 
				arr[n]=array1[m][n];
				rowcount =istanbul(arr)+rowcount;	}
		
		for(int m=0;m<c;m++) {
			for(int n=0;n<c;n++) 
				arr[n]=array1[n][m];
			columncount =istanbul(arr)+columncount;	}			
		
	System.out.println("Case #"+mastercount+":"+" "+count+" "+rowcount+" "+columncount);
	}

		
		public static int istanbul(int arr[]) 
		{
			int rowcount=0;
		
			for (int i = 0; i < arr.length; i++)  
	        { 
	            for (int j = i + 1; j < arr.length; j++)  
	            { 
	                if (arr[i] == arr[j])  
	                	{rowcount++; 	
	                		break;}
	            }
	            if(rowcount>0)
	           break; 
	            

	        }
			
			return rowcount;
		}
	}
