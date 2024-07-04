import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.*;

public class Solution {

    static ArrayList<String> permutations = new ArrayList<String>();

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        in.nextLine();
        for (int i = 1; i <= t; i++) {
            permutations = new ArrayList<String>();
            String[] NK = in.nextLine().split("\\s+");

            int n = Integer.parseInt(NK[0]);
            int k = Integer.parseInt(NK[1]);

            String nums = "";
            for(int j = 0; j < n; j++){
                nums+=(j+1);
            }
            permutations(nums, "");
            boolean found = false;
            ArrayList<Matrix> list = new ArrayList<Matrix>();
            for(String p : permutations){
                for(int incr = 0; incr < n; incr++){
                    int first = (p.charAt(0)-'0');
                    int last = (p.charAt(n-1)-'0');
                    int lastIncremented = (last+incr)%n;
                    if( first != lastIncremented && !((last == n && incr == 0 && first ==1) || (last == 1 && incr ==1 && first ==n))){
                        Matrix m = new Matrix(p, incr);
                        if(m.sum == k) {
                            found = true;
                            System.out.println("Case #" + i + ": POSSIBLE");
                            m.print();
                            break;
                        }
                    }
                }
                if(found){
                    break;
                }
            }
            if(!found){
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
        }
    }

    static void permutations(String str, String remaining) 
    { 
  
        if (str.length() == 0) { 
            permutations.add(remaining);
            return; 
        } 
  
        for (int i = 0; i < str.length(); i++) { 
            char ch = str.charAt(i); 
            String ros = str.substring(0, i) +  
                         str.substring(i + 1); 
  
            permutations(ros, remaining + ch); 
        } 
    } 
  
    static class Matrix{
        int[][] grid;
        int sum = 0;
        public Matrix(String p, int incr){
            // System.err.println("String to matrix "+p);
            int n= p.length();
            grid = new int[n][n];
            int current = 0;
            for(int r = 0; r< n; r++){
                for(int c = 0; c< n; c++){
                    grid[r][c] = p.charAt(current)-'0';
                    if(r == c){
                        this.sum += grid[r][c];
                    }
                    int inc = 1;
                    if (c + 1 == n) {
                        inc = incr;
                    }
                    current = (current + inc) % n;
                } 
            }
        }

        public void print() {
            int n = grid.length;
            for(int r = 0; r< n; r++){
                for(int c = 0; c< n; c++){
                    System.out.print(grid[r][c] + " ");
                }
                System.out.println();
            }
        }
    }

}
