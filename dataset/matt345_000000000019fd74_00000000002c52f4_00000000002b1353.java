import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {


public static void main(String[] args) throws NumberFormatException, IOException {
	// TODO Auto-generated method stub 
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	int cases=Integer.parseInt(br.readLine());
	int[]nums=new int[cases];
	for(int a=0;a<cases;++a) {
	    nums[a]=Integer.parseInt(br.readLine());
	    
	}   
	for(int a=0;a<nums.length;++a) {
		if(nums[a]!=501){
	        System.out.println("Case #"+(a+1)+": ");
	        for(int i=1;i<=nums[a];++i) {
	        	System.out.println((i)+" 1");
	        }
	    }
	    else {
	    	System.out.println("Case #"+(a+1)+": ");
	    	System.out.println("1 1");
	    	System.out.println("2 1");
	    	System.out.println("3 2");
	    	System.out.println("4 2");
	    	for(int i=4;i<nums[a];++i) {
	    		System.out.println((i)+" 1");
	    	}
	    }
	}
}

}
