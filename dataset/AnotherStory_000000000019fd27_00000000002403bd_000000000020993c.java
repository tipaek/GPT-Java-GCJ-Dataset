import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        
        for (int ts = 0; ts < t; ts++) {
            int n = in.nextInt();
            int row = 0, col = 0;
            int arr[][] = new int[n][n];
            
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                    arr[i][j] = in.nextInt();
            
            for(int i = 0; i < n; i++) {
                List<Integer> auxList = new ArrayList<>();
                
                for(int j = 0; j < n; j++) {
                    if(!auxList.contains(arr[i][j]))
                        auxList.add(arr[i][j]);
                    else{
                        row++;
                        break;
                    }
                }
            }
            
            for(int i = 0; i < n; i++) {
                List<Integer> auxList = new ArrayList<>();
                
                for(int j = 0; j < n; j++) {
                    if(!auxList.contains(arr[j][i]))
                        auxList.add(arr[j][i]);
                    else{
                        col++;
                        break;
                    }
                }
            }

            int trace = 0;
            
            for(int i = 0; i < n; i++) {
                trace += arr[i][i];
            }
            
            System.out.println("Case #" + (ts+1) + ": " + (trace) + " " + (row) + " " + (col));
        }
    }
}