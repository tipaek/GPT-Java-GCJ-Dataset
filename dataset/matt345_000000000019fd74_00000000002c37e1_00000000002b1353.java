import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {


public static void main(String[] args) throws NumberFormatException, IOException {
	// TODO Auto-generated method stub 
	BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
	
	int cases=Integer.parseInt(br.readLine());

	for(int a=0;a<cases;++a) {
	    int n=Integer.parseInt(br.readLine());
	    if(n!=501){
	        System.out.println("Case #"+(a+1)+": ");
	        for(int i=1;i<=n;++i) {
	        	System.out.println("1 "+(i));
	        }
	    }
	    else {
	    	System.out.println("Case #"+(a+1)+": ");
	    	System.out.println("1 1");
	    	System.out.println("2 1");
	    	System.out.println("3 2");
	    	System.out.println("4 2");
	    	for(int i=4;i<=n-7;++i) {
	    		System.out.println("1 "+(i));
	    	}
	    }
	}   
}

}
