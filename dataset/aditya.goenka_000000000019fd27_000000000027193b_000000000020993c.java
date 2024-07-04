
import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int q = 1; q <= t; ++q) {
            int size = in.nextInt();
            in.nextLine();
            int array[][] = new int [size][size];
            for(int i=0; i<size; i++) {
                String ss = in.nextLine();
                String[] numbers = ss.split(" ");
                for(int j=0; j<numbers.length; j++) {
                    array[i][j] = Integer.parseInt(numbers[j]);
                }
            }
            int sum = 0;
            for(int i=0; i<size; i++) {
                sum += array[i][i];
            }

            int rowC = 0;
            for(int i=0; i<size; i++) {
                HashSet<Integer> row=new HashSet<Integer>();
                for(int j=0; j<size; j++) {
                    row.add(array[i][j]);
                }
                if(row.size() != size) {
                    rowC++;
                }
            }

            int colC = 0;
            for(int i=0; i<size; i++) {
                HashSet<Integer> col=new HashSet<Integer>();
                for(int j=0; j<size; j++) {
                    col.add(array[j][i]);
                }
                if(col.size() != size) {
                    colC++;
                }
            }

            System.out.println("Case #" + q + ": " + sum + " " + rowC + " " + colC);
        }
    }
}