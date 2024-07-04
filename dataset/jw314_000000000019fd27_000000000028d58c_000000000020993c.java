import java.util.*;
import java.io.*;

public class Problem{
    public static void main(String args[]){
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int tests = scan.nextInt();
        for(int testNum = 0; testNum < tests; testNum++){
            int n = scan.nextInt();
            int[][] square = new int[n][n];
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    square[i][j] = scan.nextInt();
                }
            }
            //find trace
            int k = 0;
            for(int i = 0; i < n; i++){
                k+=square[i][i];
            }
            //find repeating rows
            int r = 0;
            for(int i = 0; i < n; i++){
                List<Integer> set = new ArrayList<Integer>();
                for(int j = 0; j < n; j++){
                    boolean match = false;
                    for(int l = 0; l < set.size(); l++){
                        if(set.get(l) == square[i][j]){
                            match = true;
                        }
                    }
                    if(!match){
                        set.add(square[i][j]);
                    }else{
                        r++;
                        break;
                    }
                }
            }
            int c = 0;
            for(int i = 0; i < n; i++){
                List<Integer> set = new ArrayList<Integer>();
                for(int j = 0; j < n; j++){
                    boolean match = false;
                    for(int l = 0; l < set.size(); l++){
                        if(set.get(l) == square[j][i]){
                            match = true;
                        }
                    }
                    if(!match){
                        set.add(square[j][i]);
                    }else{
                        c++;
                        break;
                    }
                }
            }
            System.out.println("Case #"+(testNum+1)+": "+k+" "+r+" "+c);
        }
    }
   
}

