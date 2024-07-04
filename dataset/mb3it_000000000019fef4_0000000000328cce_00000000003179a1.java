import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Solution {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
        int numTestCase = in.nextInt();
        int []U = new int[numTestCase];
        long [][]Q = new long[numTestCase][10000];
        String [][]R = new String[numTestCase][10000];
        
        for (int i = 0; i < numTestCase; ++i) {
        	U[i] = in.nextInt();
        	for (int j = 0; j < 10000; j++) {
        		Q[i][j] = in.nextLong();
            	R[i][j] = in.next();
			}        	
        }
        in.close();
        
        for (int i = 0; i < numTestCase; i++) {
        	System.out.print("Case #" + (i + 1) + ": ");
        	run(U[i], Q[i], R[i]);
        }
	}
	
	static void run(int U, long []Q, String []R) {
		char []D = new char[10];
		int value = 0;
		int ch = 0;
		HashSet<Integer> set = new HashSet<>();
		HashMap<Integer, Integer> positionMap = new HashMap<>();
		
		for(int i = 0; i < 10000; i++){
			char []query = String.valueOf(Q[i]).toCharArray();
			char []result = R[i].toCharArray();
			
			for (int j = 0; j < result.length; j++) {
				set.add((int)result[j]);
			}
			
			if(query.length == result.length){
				ch = (int)result[0];
				if(positionMap.containsKey(ch)){
					value = positionMap.get(ch);					
					if(value > query[0]){
						positionMap.put(ch, (int)query[0]);
					}
				}
				else{
					positionMap.put(ch, (int)query[0]);
				}
				
			}
		}
		
		TreeMap<Integer, Integer> indexMap = new TreeMap<>();
		for(Map.Entry<Integer, Integer> entry : positionMap.entrySet()){
			indexMap.put(entry.getValue(), entry.getKey());
		}
		
		int i = 9;
		for(Map.Entry<Integer, Integer> entry : indexMap.entrySet()){
			value = entry.getValue();
			D[i] = (char)value;
			set.remove(value);
			i--;
		}
		
		for (Integer item : set) {
			value = item;
			D[i] = (char)value;
			i--;
		}
		
		System.out.print(String.valueOf(D));
	}
}