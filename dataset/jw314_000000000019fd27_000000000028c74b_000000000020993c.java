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
                    if(checkUnique(set, square[i][j])){
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
                    if(checkUnique(set, square[j][i])){
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
    public static boolean checkUnique(List<Integer> set, int num){
        for(int i = 0; i < set.size(); i++){
            if(set.get(i) == num){
                return false;
            }
        }
        return true;
    }
   
}

