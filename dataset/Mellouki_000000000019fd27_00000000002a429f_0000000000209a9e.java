import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
	public static void main(String[] args) {
		Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; ++i) {
        	int B = in.nextInt();
        	boolean[][] array;
        	if(B == 10) {
        		String result= "";
        		for (int j = 1; j <= 10; j++) {
        			System.out.println(j);
        			result += in.nextInt();
        		}
        		System.out.println(result);
        		if(in.next() == "N") return;
        	}
        	
        	if(B == 20) {
        		boolean[] result = new boolean[20];
        		
        		boolean[] chunk1 = new boolean[5];
        		boolean[] chunk2 = new boolean[5];
        		boolean[] chunk3 = new boolean[5];
        		boolean[] chunk4 = new boolean[5];
        		
        		boolean[] chunk5 = new boolean[5];
        		boolean[] chunk6 = new boolean[5];
        		
    			for(int b = 1; b <= 5; b++) {
    				System.out.println(b); System.out.flush();
    				chunk1[b-1] = in.nextInt() == 1;
    			}
    			for(int b = 16; b <= 20; b++) {
    				System.out.println(b); System.out.flush();
    				chunk2[b-16] = in.nextInt() == 1;
    			}
    			//
    			for(int b = 6; b <= 10; b++) {
    				System.out.println(b); System.out.flush();
    				chunk3[b-6] = in.nextInt() == 1;
    			}
    			for(int b = 11; b <= 15; b++) {
    				System.out.println(b); System.out.flush();
    				chunk4[b-11] = in.nextInt() == 1;
    			}
    			//
    			for(int b = 1; b <= 5; b++) {
    				System.out.println(b); System.out.flush();
    				chunk5[b-1] = in.nextInt() == 1;
    				result[b-1] = chunk5[b-1];
    			}
    			for(int b = 6; b <= 10; b++) {
    				System.out.println(b); System.out.flush();
    				chunk6[b-6] = in.nextInt() == 1;
    				result[b-1] = chunk6[b-6];
    			}
    			//
    			if(equals(chunk3, chunk6) || equals(chunk3, complementation(chunk6))){
    				if(equals(chunk3, chunk6))
    					for(int j = 10; j < 15; j++)
    						result[j] = chunk4[j - 10];
    				else
    					for(int j = 10; j < 15; j++)
    						result[j] = !chunk4[j - 10];
    			}
    			
    			if(equals(reversal(chunk4), chunk6) || equals(reversal(chunk4), complementation(chunk6))) {
    				if(equals(reversal(chunk4), chunk6))
    					for(int j = 10; j < 15; j++)
    						result[j] = reversal(chunk3)[j - 10];
    				else
    					for(int j = 10; j < 15; j++)
    						result[j] = !reversal(chunk3)[j - 10];
    			}
    			//
    			if(equals(chunk1, chunk5) || equals(chunk1, complementation(chunk6))){
    				if(equals(chunk1, chunk5))
    					for(int j = 16; j < 20; j++)
    						result[j] = chunk2[j - 10];
    				else
    					for(int j = 16; j < 20; j++)
    						result[j] = !chunk2[j - 10];
    			}
    			
    			if(equals(reversal(chunk1), chunk5) || equals(reversal(chunk1), complementation(chunk5))) {
    				if(equals(chunk1, chunk5))
    					for(int j = 16; j < 20; j++)
    						result[j] = reversal(chunk2)[j - 10];
    				else
    					for(int j = 16; j < 20; j++)
    						result[j] = !reversal(chunk2)[j - 10];
    			}
    			String solution = "";
    			for(int j = 0; j < 20; j++)
    				solution += result[j];
    			System.out.println(solution); System.out.flush();
    			if(in.next() == "N") return;
        	}
        	if(B == 100) return;
        	continue;
        }
    }
	
	public static boolean[] complementation(boolean[] table) {
		boolean[] tempTable = clone(table);
 		for(int i = 0; i < table.length; i++) tempTable[i] = !tempTable[i];
		return tempTable;
	}
	
	public static boolean[] reversal(boolean[] table) {
		boolean[] tempTable = clone(table);
		for(int i = 0; i < table.length/2; i++) {
			boolean temp = tempTable[i];
			tempTable[i] = tempTable[tempTable.length-i-1];
			tempTable[tempTable.length-i-1] = temp;
		}
		
		return tempTable;
	}
	
	public static boolean[] clone(boolean[] table) {
		boolean[] tempTable = new boolean[table.length]; 
		for(int i = 0; i < table.length; i++) tempTable[i] = table[i];
		return tempTable;
	}
	
	public static boolean equals(boolean[] table1, boolean[] table2) {
		for(int i = 0; i < table1.length/2; i++) {
			if(table1[i] != table2[i]) return false;
		}
		return true;
	}
}
