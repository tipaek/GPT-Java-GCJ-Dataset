import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
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
    	int U = Integer.parseInt(br.readLine());
    	int[] letterFrequency = new int[26];
    	
    	StringTokenizer st;
    	for(int i = 0; i < 10000; i++){
    		st = new StringTokenizer(br.readLine());
    		long Q = Long.parseLong(st.nextToken()); //Integer query
    		String R = st.nextToken(); //String result
    		for(int j = 0; j < R.length(); j++){
    			letterFrequency[R.charAt(j) - 'A']++;
    		}
    	}
    	
    	StringBuilder sb = new StringBuilder();
    	
    	ArrayList<Integer> frequency = new ArrayList<Integer>();
    	HashMap<Integer, Character> freqToChar = new HashMap<Integer, Character>();
    	//first find smallest, this is 0
    	for(int i = 0; i < 26; i++){
    		if(letterFrequency[i] != 0){
    			frequency.add(letterFrequency[i]);
    			freqToChar.put(letterFrequency[i], (char) (i + 'A'));
    		}
    	}
    	Collections.sort(frequency);
    	
    	sb.append(freqToChar.get(frequency.get(0)));
    	for(int i = 9; i > 0; i--){
    		sb.append(freqToChar.get(frequency.get(i)));
    	}
    	
        System.out.println("Case #" + x + ": " + sb.toString());
    }
}
