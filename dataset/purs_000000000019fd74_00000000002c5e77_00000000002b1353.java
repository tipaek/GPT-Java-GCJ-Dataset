import static java.lang.Math.*;
import static java.util.Arrays.*;
import static java.util.Collections.*;
import java.math.*;
import java.util.*;
import java.io.*;

public class Solution{
    static Scanner sc;
    public static void main(String[] args){
        sc = new Scanner(System.in);
        int cases = sc.nextInt();
        for(int casenum = 1; casenum <= cases; casenum++) {
            int value = sc.nextInt();
            findPath(casenum, value);
        }
    }
    
    static List<String> result = new ArrayList<>();
    static List<List<Integer>> pascal = new ArrayList<>();
    static int size;
    static int[] row_df = {-1,-1,0,0,1,1};
    static int[] col_df = {-1,0,-1,1,0,1};
    
    public static void findPath(int casenum, int n){
        HashSet<String> set = new HashSet<>();
        //System.out.println("calling backtr");
        backtracking("",1,1,n,set);
        System.out.println("result size: "+ result.size());
        System.out.println(result.get(0));
        System.out.println("Case #"+casenum+":");
        String[] values = (result.get(0)).split(",");
        System.out.println(values.length);
        for(int i=0; i<values.length; i++){
            System.out.println("inside for");
            String ss = values[i];
            System.out.println("inside for2");
            String[] x_y = ss.split("-");
            System.out.println("inside for3 "+x_y.length);
            System.out.println(x_y[0]+ " "+ x_y[1]);
        }
    }
    
    public static void createPascal(int level){
        //System.out.println("creating pascal for row "+ level);
        pascal.add(new ArrayList<Integer>());
        pascal.get(level-1).add(1);
        if(level>1){
            for(int i=1; i<level-1; i++){
                int prev1 = pascal.get(level-2).get(i-1);
                int prev2 = pascal.get(level-2).get(i-2);
                pascal.get(level-1).add(prev1+prev2);
            }
            pascal.get(level-1).add(1);
        }
        
    }
    
    public static void backtracking(String path, int row, int col, int value, HashSet<String> set){
        System.out.println("backtrack call, row: "+ row+ " col: "+col );
        System.out.println("value: "+ value);
        if(result.size() == 1){
            //System.out.println("path found");
            return;
        } 
        if(value == 0){
            //System.out.println("adding path to result");
            result.add(path);
            return;
        }
        
        if(row<1||col<1||col>row){
            //System.out.println("out of range row: "+ row+" col: "+ col);
            return;
        } 
        
        if(pascal.size()<row){
            //System.out.println("pascal row not found");
            createPascal(row);
        } 
        
        int sub = pascal.get(row-1).get(col-1);
        String add_str = row+"-"+col;
        set.add(add_str);
        for(int k=0; k<6; k++){
            int new_row = row + row_df[k];
            int new_col = col + col_df[k];
            String check = new_row+"-"+new_col;
            if(!set.contains(check)){
                backtracking(path + ","+add_str, new_row, new_col, value - sub, set);
                if(result.size()==1) return;
            }
        }
        System.out.println("not good for, row: "+ row + "col: "+col);
        set.remove(add_str);
        return;
    }
}