import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int tests = scanner.nextInt();
            for(int i = 0;i<tests;i++){
                System.out.println("Case #" + (i+1) + ": " + solve(scanner));
            }
    }

    public static String solve(Scanner scanner){
        int dim = scanner.nextInt();
        int data[] = new int[dim*dim];
        //fill array
        for(int i = 0;i<dim*dim;i++){
            data[i] = scanner.nextInt();
        }
        int sum = 0;
        int rows = 0;
        int cols = 0;
        HashSet<Integer> rowSet = new HashSet<>();
        HashSet<Integer> colSet = new HashSet<>();
        for(int i = 0;i<dim;i++){
            sum += data[dim*i+i];
            //check for duplicate
            rowSet.clear();
            colSet.clear();
            boolean r = false;
            boolean c = false;
            for(int x = 0;x<dim;x++) {
                int rdigit = data[i*dim+x];
                int cdigit = data[x*dim+i];
                if (rowSet.contains(rdigit))
                    r = true;
                else
                    rowSet.add(rdigit);
                if(colSet.contains(cdigit))
                    c = true;
                else
                    colSet.add(cdigit);
            }
            if(r == true) rows++;
            if(c == true) cols++;
        }
        return sum + " " + rows + " " + cols;
    }
}
