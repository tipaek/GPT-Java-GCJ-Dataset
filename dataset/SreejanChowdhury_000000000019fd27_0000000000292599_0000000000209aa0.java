import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
    	int testCount = in.nextInt();
    	in.nextLine();
        for (int t = 1; t <= testCount; t++) {
        	
        	String a[] = in.nextLine().split(" ");
    		findLatinMatrix(Integer.parseInt(a[0]), Integer.parseInt(a[1]), t);
        }
		
	}
	
	
	private static void findLatinMatrix(int n,int sum,int t) {
		
		//if sum of N is equal to the given sum or given sum is multiple of any number from 1 to N
		//it is possible
		int nSum = (n * (n+1))/2;
		//find perfect divisible number and quotient is n
		int perfectDivisible = 0;
		for(int i = 1; i <=n ;i++ ) {
			if(i * n == sum) {
				perfectDivisible = i;
				break;
			}
		}
		if(nSum == sum && n >2) {
			System.out.println("Case #"+t+": POSSIBLE");
			//print with distinct diagonal elements
			printLatinMatrix(n);
			
		}
		else if(perfectDivisible > 0 && n > 2) {
			System.out.println("Case #"+t+": POSSIBLE");
			//print with diagonal elements as perfectDivisible
			printLatinMatrix(n, perfectDivisible);
		}
		else if( n == 2 ) {
			
			//print with diagonal elements as 2 or 1
			if(sum == 2) {
				System.out.println("Case #"+t+": POSSIBLE");
				printLatinMatrix(n, 1);
			}
				
			else if(sum == 4) {
				System.out.println("Case #"+t+": POSSIBLE");
				printLatinMatrix(n, 2);
			}
				
			else {
				System.out.println("Case #"+t+": IMPOSSIBLE");
			}
		}
		else {
			System.out.println("Case #"+t+": IMPOSSIBLE");
		}
		
		return;
	}
	
	//distinct diagonal
	private static void printLatinMatrix(int n) {
		//create a double linkedlist
		int start =1;
		StringBuffer s = new StringBuffer();
		for(int row =1 ; row <= n ; row++) {
			int t = row;
			while(t <= n) {
				s.append(t++);
				s.append(" ");
			}
			
			while(start < row) {
				s.append(start++);
				s.append(" ");
			}
			start=1;
			s.delete(s.length() -1, s.length());
			System.out.println(s.toString());
			s.delete(0, s.length());
		}
		
	}
	
	private static void printLatinMatrix(int n,int diagonalElement) {
		int [] nums = new int[n];
		for(int i = 0; i <n ;i++ )
			if(diagonalElement + i <= n)
				nums[i] = diagonalElement + i;
			else
				nums[i] = diagonalElement + i - n;
		
		StringBuffer s = new StringBuffer();
		for(int row = 0; row < n ; row++) {
			for(int i : nums) {
				s.append(i);
				s.append(" ");
			}
			s.delete(s.length() -1, s.length());
			System.out.println(s.toString());
			s.delete(0, s.length());
			rightRotate(nums);
		}
		
	}
	
	static void rightRotate(int [] arr) {
		
        for(int i = 0; i < 1; i++){    
            int j, last;    
            last = arr[arr.length-1];    
            
            for(j = arr.length-1; j > 0; j--){    
                arr[j] = arr[j-1];    
            }    
            arr[0] = last;    
        }    
	}
	
}
