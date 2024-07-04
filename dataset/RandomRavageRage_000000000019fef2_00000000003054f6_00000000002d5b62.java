import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static BufferedReader br;
    public static void main(String[] args) throws NumberFormatException, IOException {
    	br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        for(int i = 1; i <= t; i++){
        	//each case
        	testCase(i);
        }
        br.close();
    }
    
    public static void testCase(int x) throws NumberFormatException, IOException{
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	int X = Integer.parseInt(st.nextToken());
    	int Y = Integer.parseInt(st.nextToken());
    	
    	int xMult = X >= 0 ? 1 : -1;
    	int yMult = Y >= 0 ? 1 : -1;
    	
    	int absX = Math.abs(X);
    	int absY = Math.abs(Y);
    	
    	if(absX % 2 == absY % 2){
    		System.out.println("Case #" + x + ": IMPOSSIBLE");
    		return;
    	}
    	
    	int bigSum, smallSum;
    	for(int i = 0; i < Math.max(absY, absX) * 1; i++){
    		List<Integer> xBits = new ArrayList<Integer>(); 
    		// bigSum - smallSum = x
    		bigSum = i + absX;
    		smallSum = i;
    		//generate number
    		while(bigSum != 0){
        		int digit1 = bigSum % 2;
        		int digit2 = smallSum % 2;
        		if(digit1 == digit2){
        			xBits.add(0);
        		}else{
        			if(digit1 == 1){
        				xBits.add(1);
        			}else{
        				xBits.add(-1);
        			}
        		}
        		
        		bigSum /= 2;
        		smallSum /= 2;
        	}
    		
    		for(int j = 0; j < Math.max(absY, absX) * 1; j++){
    			List<Integer> yBits = new ArrayList<Integer>(); 
        		// bigSum - smallSum = x
        		bigSum = j + absY;
        		smallSum = j;
        		//generate number
        		while(bigSum != 0){
            		int digit1 = bigSum % 2;
            		int digit2 = smallSum % 2;
            		if(digit1 == digit2){
            			yBits.add(0);
            		}else{
            			if(digit1 == 1){
            				yBits.add(1);
            			}else{
            				yBits.add(-1);
            			}
            		}
            		
            		bigSum /= 2;
            		smallSum /= 2;
            	}
        		
        		if(!isConflict(xBits, yBits)){
        			StringBuilder sb = new StringBuilder();
        			if(xBits.size() < yBits.size()){
        	    		for(int k = 0; k < yBits.size(); k++){
        	        		if(yBits.get(k) != 0){
        	        			sb.append(yBits.get(k) * yMult > 0 ? 'N' : 'S');
        	        		}else{
        	        			sb.append(xBits.get(k) * xMult > 0 ? 'E' : 'W');
        	        		}
        	        	}
        	    	}else{
        	    		for(int k = 0; k < xBits.size(); k++){
        	    			if(xBits.get(k) != 0){
        	    				sb.append(xBits.get(k) * xMult > 0 ? 'E' : 'W');
        	        		}else{
        	        			sb.append(yBits.get(k) * yMult > 0 ? 'N' : 'S');
        	        		}
        	        	}
        	    	}
        			System.out.println("Case #" + x + ": " + sb.toString());
        			return;
        		}
        		
    		}
    	} 
    	
        System.out.println("Case #" + x + ": IMPOSSIBLE");
    }
    
    public static boolean isConflict(List<Integer> xBits, List<Integer> yBits){
    	if(Math.abs(xBits.size() - yBits.size()) > 1){
    		return true;
    	}
    	
    	if(xBits.size() < yBits.size()){
    		for(int i = 0; i < xBits.size(); i++){
    			int xBit = xBits.get(i);
    			int yBit = yBits.get(i);
        		if((xBit != 0 && yBit != 0) || (xBit == 0 && yBit == 0)){
        			return true;
        		}
        	}
    	}else{
    		for(int i = 0; i < yBits.size(); i++){
    			int xBit = xBits.get(i);
    			int yBit = yBits.get(i);
        		if((xBit != 0 && yBit != 0) || (xBit == 0 && yBit == 0)){
        			return true;
        		}
        	}
    	}
    	
    	return false;
    }
}
