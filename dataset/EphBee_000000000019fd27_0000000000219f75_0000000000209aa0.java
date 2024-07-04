import java.util.*;
import java.io.*;
public class Solution {
    
    
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int count = in.nextInt();
    int caseID = 1;
    for(int e=0;e<count;e++) {
        int N = in.nextInt();
        int trace = in.nextInt();
        
        //if trace < N, return impossible
        
        int [][]matrix = new int[N][N];
        ArrayList <HashSet<Integer>> rows = new ArrayList<HashSet<Integer>>();
        ArrayList <HashSet<Integer>> columns = new ArrayList<HashSet<Integer>>();
        for(int i=0;i<N;i++) {
            columns.add(new HashSet<Integer>());
            rows.add(new HashSet<Integer>());
            for(int j=1;j<=N;j++) {
                columns.get(i).add(j);
                rows.get(i).add(j);
            }
        }
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                matrix[i][j] = 0;
            }
        }
        
        int tempTrace = trace;
        int newTrace = 0;
        // System.out.println("Size of 1: " + columns.get(0).size());
        for(int i=0;i<N;i++) {
            tempTrace = (int)((tempTrace / 2.0) + 0.5);
            int newValue = tempTrace;
            matrix[i][i] = newValue;
            columns.get(i).remove(newValue);
            rows.get(i).remove(newValue);
            newTrace += newValue;
        }
        
        boolean isImpossible = false;
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                if(i==j) continue;
                int selectedValue = 0;
                while(!columns.get(j).contains(selectedValue) || !rows.get(i).contains(selectedValue)) {
                    selectedValue++;
                    if(selectedValue > N || columns.get(j).size() == 0 || rows.get(i).size() == 0) {
                        isImpossible = true;
                        break;
                    }
                }
                if(isImpossible == true) {
                    break;
                }
                columns.get(j).remove(selectedValue);
                rows.get(i).remove(selectedValue);
                
                matrix[i][j] = selectedValue;
            }
        }
        
        if(isImpossible == true) {
            System.out.println("Case #" + caseID + ": IMPOSSIBLE");
            caseID += 1;
            continue;
        }
        
        System.out.println("Case #" + caseID + ": POSSIBLE");
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
        
        caseID += 1;
    }
  }
}