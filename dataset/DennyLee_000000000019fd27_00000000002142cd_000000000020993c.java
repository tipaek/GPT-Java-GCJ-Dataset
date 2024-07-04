import java.util.*;
public class Solution{
    public static void main(String [] args){
        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++){
            int rRepeats = 0;
            int cRepeats = 0;
            int trace = 0;
            int n = scanner.nextInt();
            int [][] matrix = new int [n][n];
            int scanned = 0;
            for(int r = 0; r < n; r++){
                for(int c = 0; c < n; c++){
                    if(scanner.hasNextInt())
                        matrix[r][c] = scanner.nextInt();
                    else{
                        matrix[r][c] = 3;
                    }
                }
            }
            for(int r = 0; r < n; r++){
                ArrayList<Integer> rows = new ArrayList<>();
                for(int c = 0; c < n; c++){
                    if(!rows.contains(matrix[r][c])) {
                        rows.add(matrix[r][c]);
                    }
                    else {
                        rRepeats++;
                        break;
                    }
                }
            }
            for(int c = 0; c < n; c++){
                ArrayList<Integer> repeats = new ArrayList<>();
                for(int r = 0; r < n; r++){
                    int row = 0;
                    if(!repeats.contains(matrix[r][c]))
                        repeats.add(matrix[r][c]);
                    else {
                        cRepeats++;
                        break;
                    }
                }
            }
            for(int k = 0; k < n; k++){
                trace += matrix[k][k];
            }
            System.out.println("");
            System.out.println("Case #" + (i + 1) + ": " + trace + " " + rRepeats + " " + cRepeats);
        }
    }
}