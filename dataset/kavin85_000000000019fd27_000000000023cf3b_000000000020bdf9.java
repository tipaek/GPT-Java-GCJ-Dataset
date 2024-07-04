import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        for (int n = 0; n < numCases; n++) {
        	int activiy = input.nextInt();
        	Map<Integer, Integer> map = new HashMap<>(); 
        	for(int i=0;i<activiy;i++){
        		map.put(input.nextInt(), input.nextInt());
        	}
        	ArrayList<Integer> sortedKeys =new ArrayList<Integer>(map.keySet()); 
        	Collections.sort(sortedKeys);
        	
        	String output="";
        	int endtimec=0;
        	int endtimeJ=0;
        	 for(int i=0;i<sortedKeys.size();i++)  {
        		 if(endtimec<=sortedKeys.get(i)){
        			 output+="C";
        			 endtimec=map.get(sortedKeys.get(i));
        		 }
        		 else if(endtimeJ<=sortedKeys.get(i)){
        			 output+="J";
        			 endtimeJ=map.get(sortedKeys.get(i));
        		 }
        		 else{
        			 output="IMPOSSIBLE";
        			 break;
        		 }
        	 }
        	System.out.printf("Case #%d: "+output, n + 1);
            System.out.println();
        }
    }

}