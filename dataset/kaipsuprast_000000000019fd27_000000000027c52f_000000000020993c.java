import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int test = Integer.parseInt(input.nextLine());
        for(int i = 0; i<test; i++){
            int n = Integer.parseInt(input.nextLine());
            List <List<Integer>> matrix = new ArrayList<>();
            int trace = 0;
            int repR = 0;
            int repC = 0;
            int inc = 0;
            for(int j = 0; j<n; j++){
                boolean repeatedR = false;
                String [] r = input.nextLine().split(" ");
                List <Integer> row = new ArrayList<>();
                for(int k = 0; k<r.length; k++){
                    int v = Integer.parseInt(r[k]);
                    if(row.contains(v)){
                        repeatedR = true;
                    }
                    row.add(v);
                }
                matrix.add(row);
                trace = trace + row.get(inc++);
                if(repeatedR == true){
                    repR++;
                }
            }
            for(int b = 0; b<matrix.get(0).size(); b++){
                boolean repeatedC = false;
                List <Integer> cols = new ArrayList<>();
                for(int c = 0; c<matrix.size(); c++){
                    if(cols.contains(matrix.get(c).get(b))){
                        repeatedC = true;
                    }
                    cols.add(matrix.get(c).get(b));
                }
                if(repeatedC == true){
                    repC++;
                }
            }
            int t = i+1;
            System.out.println("Case #" + t + ": " + trace + " " + repR + " " + repC);
        }
    }
}
