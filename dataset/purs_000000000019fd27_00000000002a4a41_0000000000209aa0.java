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
        int n = sc.nextInt();
        for(int casenum = 1; casenum <= n; casenum++) {
            int size = sc.nextInt();
            int trace = sc.nextInt();
            createMatrix(size, trace, casenum);
        }
    }
    
    static List<String> result = new ArrayList<>();
    static int size;
    public static void createMatrix(int n, int t, int casenum){
        size = n;
        result.clear();
        HashSet<String> set = new HashSet<>();
        backtrack("",0,0,t,set);
        if(result.size() == 0){
            System.out.println("Case #"+casenum+": IMPOSSIBLE");
        }
        else{
            System.out.println("Case #"+casenum+": POSSIBLE");
            String[] values = result.get(0).split(",");
            for(int i=0; i<size; i++){
                StringBuilder sb = new StringBuilder();
                for(int j=0; j<size; j++){
                    sb.append(values[i*size+j+1]);
                    sb.append(" ");
                }
                System.out.println(sb.toString());
            }
            
        }
    }
    public static void backtrack(String str, int row, int col, int trace, HashSet<String> set){
        if(col>=size && row>=size-1){
            if(trace == 0){
                result.add(str);
                return;
            }
            else{
                return;
            } 
        }
        if(result.size() == 1){
            return;
        } 
        if(trace<=0){
            return;
        } 
        if(col>=size){
            backtrack(str, row+1, 0, trace, set);
        }
        else{
            boolean next = false;
            String col_str = "-col-"+ col;
            String row_str = "-row-"+row;
            for(int i=1; i<=size; i++){
                if(!set.contains(i+row_str) && !set.contains(i+col_str)){
                    set.add(i+row_str);
                    set.add(i+col_str);
                    if(row == col){
                        if(trace-i>=0){
                            backtrack(str+","+i,row, col+1,trace-i, set);
                        }
                    }
                    else{
                        backtrack(str+","+i,row, col+1, trace, set);
                    }
                    
                    if(result.size() == 1) return;
                    set.remove(i+row_str);
                    set.remove(i+col_str);
                }
            }
        }
        return;
    }
}