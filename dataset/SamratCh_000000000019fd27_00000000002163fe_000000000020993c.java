import java.util.*;

import static java.lang.System.*;

public class Solution{public static void main(String... args){
    try(Scanner sc  = new Scanner(in)){
        int T = Integer.parseInt(sc.nextLine());
        for(int t = 1 ; t <= T ; t++){
            int n = Integer.parseInt(sc.nextLine());
            int[][] arr = new int[n][n];
            int sum = (n*(n+1))/2;
            for(int i = 0 ; i < n ; i++) {
            	String[] strArr = sc.nextLine().split(" ");
                int j = 0;
                for(String s : strArr)
                    arr[i][j++] = Integer.parseInt(s);
            }
            int trace = 0, row = 0, col = 0;
            for(int i = 0 ; i < n ; i++)
                trace+=arr[i][i];
            for(int i = 0 ; i < n ; i++){
                int rowSum = 0, colSum = 0;
                Set<Integer> tempRow = new HashSet<>(), tempCol = new HashSet<>();
                for(int j = 0 ; j < n ; j++){
                    rowSum+=arr[i][j];
                    tempRow.add(arr[i][j]);
                    colSum+=arr[j][i];
                    tempCol.add(arr[j][i]);
                }
                if(rowSum != sum || tempRow.size() != n) row++;
                if(colSum != sum || tempCol.size() != n) col++;
            }
            System.out.println(String.format("Case #%d: %d %d %d",t,trace,row,col));
        }
    }catch (Exception ex){
        err.println("Runtime Error");
        ex.printStackTrace();
    }
}}
