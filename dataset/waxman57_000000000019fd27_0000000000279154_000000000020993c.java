import java.util.ArrayList;
import java.util.HashSet;
import java.util.Scanner;

public class Vestigium {

	public static void main(String[] args){
        Scanner s = new Scanner(System.in);
        int T = s.nextInt();
        int N;
        int trace;
        int rowDup = 0;
        int colDup = 0;
        for(int x = 0; x < T; x++){
        	N = s.nextInt();
            trace = 0;
            rowDup = 0;
            colDup = 0;
            ArrayList<HashSet<Integer>> col = new ArrayList<>();
            boolean[] colDuped = new boolean[N];
            for(int y = 0; y < N; y++){
                col.add(new HashSet<Integer>());
            }
            for(int y = 0; y < N; y++){
                HashSet<Integer> row = new HashSet<Integer>();
                boolean rowDuped = false;
                for(int z = 0; z < N; z++){
                    int in = s.nextInt();
                    if(y == z){
                        trace += in;
                    }
                    if(row.contains(in) && !rowDuped){
                        rowDup++;
                        rowDuped = true;
                    }
                    if(col.get(z).contains(in) && !colDuped[z]){
                        colDup++;
                        colDuped[z] = true;
                    }
                    row.add(in);
                    col.get(z).add(in);
                }
            }
            System.out.println("Case #" + (x + 1) + ": " + trace + " " + rowDup + " " + colDup);
        }
    }

}