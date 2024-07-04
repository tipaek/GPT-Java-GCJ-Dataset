package testcode;

import java.util.Scanner;

public class test {
	
	int test_cases ;
    int size ;
    int [][]arr;
    int k = 0;
    int r = 0;
    int c = 0;
    int count = 0;
	public static void main(String []args){
		test test = new test();
		Scanner scan = new Scanner (System.in);
	       //System.out.println("Enter the number of test cases");
	       test.test_cases = scan.nextInt();
	       int [][]result=new int[test.test_cases][3];
	       while(test.count<test.test_cases) {
	       //System.out.println("Enter the size of square matrix");
	       test.size = scan.nextInt();
	       test.arr = test.read_matrix(test.size);
	       test.k =test.sum_diagonal(test.arr);
	       result[test.count][0]=test.k;
	       test.r=test.rows(test.arr);
	       result[test.count][1]=test.r;
	       test.c=test.cols(test.arr);
	       result[test.count][2]=test.c;
	       test.count++;
	       //System.out.printf("Case #%d :  %d %d %d\n",test.count,test.k,test.r,test.c);
	       }
	       test.count=0;
	       while(test.count<test.test_cases) {
		       System.out.printf("Case #%d :  %d %d %d\n",test.count+1,result[test.count][0],result[test.count][1],result[test.count][2]);
	    	   test.count++;
	       }
	    }
	    public int[][] read_matrix (int size){
	        //System.out.println("Enter the values of the matrix");
	        Scanner scan = new Scanner (System.in);
	        int [][]arr = new int [size][size];
	        for(int i=0;i<size;i++){
	           for(int j=0;j<size;j++){
	               arr[i][j]=scan.nextInt();
	           }
	       }
	       return arr;
	    }
	    
	    public int sum_diagonal(int [][]arr ){
	        int k = 0;
	        for(int i=0;i<size;i++){
	           for(int j=0;j<size;j++){
	               if(i==j)
	               k+=arr[i][j];
	           }
	       }
	       return k;
	    }
	    
	    public int rows(int [][]arr) {
	    	int flag = 0;
	        for(int i=0;i<size;i++) {
	        	for(int j=0;j<size;j++) {
	        		for(int n=j+1;n<size;n++) {
	        			if(arr[i][j]==arr[i][n]) {
	        				r++;
	        				flag=1;
	        				break;
	        			}
	        		}
	        		if(flag==1)
        				break;
	        	}
	        }
	    	return r;
	    }
	    
	    
	    public int cols(int [][]arr) {
	    	int flag = 0;
	        for(int i=0;i<size;i++) {
	        	for(int j=0;j<size;j++) {
	        		for(int n=j+1;n<size;n++) {
	        			if(arr[j][i]==arr[n][i]) {
	        				c++;
	        				flag=1;
	        				break;
	        			}
	        		}
	        		if(flag==1)
        				break;
	        	}
	        }
	    	return c;
	    }
	    
}	 
