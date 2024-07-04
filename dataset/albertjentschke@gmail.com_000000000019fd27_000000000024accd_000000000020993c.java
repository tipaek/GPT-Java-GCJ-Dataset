import java.util.*;
import java.io.*;

public class Solution {
	
    public static void vestigium() {
        int T; //Number of test-cases

        Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        T = scanner.nextInt();
        ArrayList<String> outputs = new ArrayList<String>();
        for(int k = 0; k < T; k++) {
            int N = scanner.nextInt(); //Size of matrix
            ArrayList<HashMap<Integer, Boolean>> rowsList = new ArrayList<HashMap<Integer, Boolean>>();
            boolean[] corruptedColumns = new boolean[N];
            int diagonal = 0;
            int rows = 0;
            int columns = 0;
            for(int i = 0; i < N; i++) {
                HashMap<Integer, Boolean> nextLine = new HashMap<Integer, Boolean>();
                boolean corrupted = false;
                for(int j = 0; j < N; j++) {
                    if(i == 0) {
                        rowsList.add(new HashMap<Integer, Boolean>());
                    }
                    int m = scanner.nextInt(); //Read entry
                    if(i == j) {
                        diagonal += m;
                    } //Count diagonal
                    if(nextLine.get(m) != null && !corrupted) {
                        corrupted = true;
                        rows++;
                    }
                    if(!corrupted) {
                        nextLine.put(m, true);
                    } //Row operations
                    if(!corruptedColumns[j] && rowsList.get(j).get(m) != null) {
                        corruptedColumns[j] = true;
                        columns++;
                    }
                    if(!corruptedColumns[j]) {
                        rowsList.get(j).put(m, true);
                    }
                }
            }
            String output = "Case #" + (k + 1) + ": " + diagonal + " " + rows + " " + columns;
            outputs.add(output);
        }

        for(int k = 0; k < T; k++) {
            System.out.println(outputs.get(k));
        }
		scanner.close();
    }
	
	public static void main(String[] args) {
		vestigium();
	}
}