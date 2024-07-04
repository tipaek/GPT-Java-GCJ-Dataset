import java.util.Scanner;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        for (int i = 0; i<num; i++) {
            int size = sc.nextInt();
            int[][] mat = new int[size][size];
            for (int r = 0; r<size; r++) {
                for (int c = 0 ; c<size; c++) {
                    mat[r][c]=sc.nextInt();
                }
            }
            int run = 0;
            for (int j = 0; j<size; j++) {
                run+=mat[j][j];
            }
            int rows = 0;
            int cols = 0;
            for (int j = 0; j<size; j++) {
                ArrayList<Integer> arr = new ArrayList<Integer>();
                for (int c = 0; c<size; c++) {
                    if (arr.contains(mat[j][c])) {
                        rows++;
                        break;
                    }
                    else {
                        arr.add(mat[j][c]);
                    }
                }
            }
            for (int j = 0; j<size; j++) {
                ArrayList<Integer> arr = new ArrayList<Integer>();
                for (int c = 0; c<size; c++) {
                    if (arr.contains(mat[c][j])) {
                        cols++;
                        break;
                    }
                    else {
                        arr.add(mat[c][j]);
                    }
                }
            }
            System.out.println("Case #"+(i+1)+": "+run+" "+rows+" "+cols);
        }
    }
}