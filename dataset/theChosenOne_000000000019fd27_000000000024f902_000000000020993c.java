import java.util.Set;
import java.util.HashSet;
import java.util.Scanner;
public class Solution{
public static void main(String args[]){
    Scanner in = new Scanner(System.in);
    int testCases = 0;
    int cases = 0;
    testCases = Integer.parseInt(in.nextLine());
    while(testCases-- > 0){
        cases++;
        int num = 0;
        int trace = 0,numRows = 0,numCols = 0;
        num = Integer.parseInt(in.nextLine());
        int arr[][] = new int[num][num];
        for(int i=0;i<num;i++){
            for(int j=0;j<num;j++){
                arr[i][j] = in.nextInt();
            }
        }
        int u = 0;
        int v = 0;
        while(u < num || v < num){
            trace += arr[u][v];
            u++;
            v++;
        }
    
        
        for(int i=0;i<num;i++){
            Set<Integer> rep = new HashSet<Integer>();
            {
                for(int j=0;j<num;j++){
                    if(!rep.add(arr[i][j])){
                        numRows++;
                        break;
                    }
                }
                
            }
        }
        for(int i=0;i<num;i++){
            Set<Integer> rep = new HashSet<Integer>();
            {
                for(int j=0;j<num;j++){
                    if(!rep.add(arr[j][i])){
                        numCols++;
                        break;
                    }
                }
                
            }
        }
        
        System.out.println("Case #"+cases+": "+trace+" "+numRows+" "+numCols);
    }
    
    
    
}
}