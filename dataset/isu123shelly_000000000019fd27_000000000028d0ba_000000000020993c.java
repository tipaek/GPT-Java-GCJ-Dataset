
import java.util.Scanner;

class CodeJam {
	
	static int[] printRepeating(int arr[][], int size)  
	    { 
	        int i, j,sumr,sumc,k; 
	        int duplir=0;
	        int duplic=0;
	        int arr1[]=new int[2];
	         
	        for(k=0;k<size;k++) {
	        	sumr=0;
	        	sumc=0;
	        for (i = 0; i < size; i++)  
	        { 
	            for (j = i + 1; j < size; j++)  
	            { 
	                if (arr[k][i] == arr[k][j]) { 
	                     sumr++;
	                }
	                if (arr[i][k] == arr[j][k]) { 
	                     sumc++;
	                }
	                
	            } 
	        } 
	        if(sumr>0) {
	        	duplir++;
	        }
	        if(sumc>0) {
	        	duplic++;
	        }
	        arr1[0]=duplir;
	        arr1[1]=duplic;
	        }
	        return arr1;
	    }
	
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		int n=input.nextInt();
		for(int i=0;i<n;i++) {
			int sum=0;
			int size=input.nextInt();
			int a[][] = new int[size][size];
			for (int k = 0; k < size; k++) 
            {
                for (int j = 0; j < size; j++) 
                {
                    a[k][j] = input.nextInt();
                    if(k==j) {
                    	sum = sum + (a[k][j]);
                    }
                }
            }
			int result[]=printRepeating(a, size);
			System.out.println("Case #"+i+": "+sum+" "+result[0]+" "+result[1]);
		}
		input.close();
	}

}
