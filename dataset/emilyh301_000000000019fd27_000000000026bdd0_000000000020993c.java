import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
    int sum = 0, row = 0, col =  0;
    Scanner sc = new Scanner(System.in);
    int num = Integer.parseInt(sc.nextLine());
    for(int x = 1; x <= num; x++) {
        int d = Integer.parseInt(sc.nextLine());
        String[][] square = new String[d][d];
        for(int r = 0; r < d; r++){
            square[r] = sc.nextLine().split(" ");
        }
        for(int r = 0; r < d; r++){
            for(int c = 0; c<d-1; c++) {
                for(int c1 = c+1; c1<d; c1++){
                    if(square[r][c].equals(square[r][c1])){
                        row++;
                        break;
                    }
                }
                for(int c1 = c+1; c1<d; c1++){
                    if(square[c][r].equals(square[c1][r])){
                        col++;
                        break;
                    }
                }
                if(r == c)
                    sum += Integer.parseInt(square[r][c]);
            }
        }
        sum += Integer.parseInt(square[d-1][d-1]);
        System.out.println("Case #" + x + ": " + 
        sum + " " + row + " " + col);
    }
    }
}