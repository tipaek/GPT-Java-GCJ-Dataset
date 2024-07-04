import java.util.*;

public class Solution {
    public void vestigium() {
        int T; //Number of test-cases

        Scanner scanner = new Scanner(System.in);
        T = scanner.nextInt();
        ArrayList<String> outputs = new ArrayList<String>();
        for(int k = 0; k < T; k++) {
            int N = scanner.nextInt(); //Size of matrix
            ArrayList<HashMap<Integer, Boolean>> rows = new ArrayList<HashMap<Integer, Boolean>>();
            boolean[] corruptedColumns = new boolean[N];
            int diagonal = 0;
            int rows = 0;
            int columns = 0;
            for(int i = 0; i < N; i++) {
                HashMap<Integer, Boolean> nextLine = new HashMap<Integer, Boolean>();
                boolean corrupted = false;
                for(int j = 0; j < N; j++) {
                    if(i == 0) {
                        rows.add(new HashMap<Integer, Boolean>());
                    }
                    int m = scanner.nextInt(); //Read entry
                    if(i == j) {
                        diagonal += m;
                    } //Count diagonal
                    if(nextLine.get(m) == true && !corrupted) {
                        corrupted = true;
                        rows++;
                    }
                    if(!corrupted) {
                        nextLine.put(m, true);
                    } //Row operations
                    if(!corruptedColumns[j] && rows.get(j).get(m) == true) {
                        corruptedColumns[j] = true;
                        columns++;
                    }
                    if(!corruptedColumns[j]) {
                        rows.get(j).put(m, true);
                    }
                }
            }
            String output = "Case #" + (k + 1) + ": " + diagonal + " " + rows + " " + columns;
            outputs.add(output);
        }

        for(int k = 0; k < T; k++) {
            System.out.println(outputs.get(k));
        }   
    }
}