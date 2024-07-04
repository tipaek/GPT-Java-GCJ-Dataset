import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner input = new Scanner(System.in);
        int numCases = input.nextInt();
        for (int n = 0; n < numCases; n++) {
            int N = input.nextInt();
            int[][] array=new int[N][N];
            List<Map<Integer , Integer>> myMap  = new ArrayList<Map<Integer,Integer>>();
            List<Map<Integer , Integer>> myMap2  = new ArrayList<Map<Integer,Integer>>(N);
            for(int i=0;i<N;i++){
            	myMap2.add(new HashMap<Integer,Integer>());
            }
            int rowcount=0;
            int columnCount=0;
            int trace=0;
            for(int i=0;i<N;i++){
            	Map<Integer,Integer> myMap1 = new HashMap<Integer, Integer>();
            	for(int j=0;j<N;j++){
            		array[i][j]=input.nextInt();
            		myMap1.put(array[i][j]-1, 1);
            		myMap2.get(j).put(array[i][j]-1, 1);
            	}
            	myMap.add(myMap1);
            }
            
            for(int column=0;column<N;column++){
            	trace+=array[column][column];
            	if(myMap.get(column).size()!=N){
            		rowcount++;
            	}
            	if(myMap2.get(column).size()!=N){
            		columnCount++;
            	}
            }
            System.out.printf("Case #%d: "+trace+" "+rowcount+" "+columnCount, n + 1);
            System.out.println();
        }
    }

}
