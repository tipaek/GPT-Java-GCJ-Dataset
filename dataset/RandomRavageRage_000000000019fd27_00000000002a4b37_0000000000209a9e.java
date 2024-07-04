import java.util.*;
import java.io.*;
public class Solution {
	public static BufferedReader br;
    public static void main(String[] args) throws NumberFormatException, IOException {
    	br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
    	int t = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        do{
        	//each case
        	testCase(b);
        	t--;
        }while(br.readLine().equals("Y") && t != 0);
        br.close();
    }
    
    public static void testCase(int b) throws NumberFormatException, IOException{
    	int n = Integer.parseInt(br.readLine());
    	if(b == 10){
    		String ret = "";
    		for(int i = 1; i <= 10; i++){
    			System.out.println(i);
            	System.out.flush();
            	int value = Integer.parseInt(br.readLine());
            	ret += value;
    		}
    		System.out.println(ret);
    	}
    	/*int[] bits = new int[b];
    	boolean beginning = true;
    	int i = 1, j = b;
    	while(i < j){
    		int value;
    		if(i % 10 == 1 && beginning){
        		beginning = false;
        	}else if(j % 10 == 1 && !beginning){
        		beginning = true;
        	}
    		if(beginning){
    			//start from 1
        		System.out.println(i);
            	System.out.flush();
            	value = Integer.parseInt(br.readLine());
            	bits[i - 1] = value;
            	i++;
    		}else{
    			//start from end
            	System.out.println(b - i + 1);
            	System.out.flush();
            	bits[b - i] = value;
            	j--;
    		}
    		//do testing
    		if(b - j == i - 1){
    			for(int k = 0; k < 10; k++){
    				
    			}
    		}
    	}*/
    	
        
        //System.out.println("Case #" + x + ": " + ret);
        //System.out.flush();
    }
}