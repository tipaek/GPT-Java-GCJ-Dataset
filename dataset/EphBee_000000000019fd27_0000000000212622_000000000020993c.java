import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int count = in.nextInt();
    int caseID = 1;
    for(int e=0;e<count;e++) {
        int N = in.nextInt();
        
        int trace = 0;
        ArrayList <HashSet<Integer>> columns = new ArrayList<HashSet<Integer>>();
        ArrayList <HashSet<Integer>> rows = new ArrayList<HashSet<Integer>>();
        for(int i=0;i<N;i++) {
            columns.add(new HashSet<Integer>());
            rows.add(new HashSet<Integer>());
        }
        for(int i=0;i<N;i++) {
            for(int j=0;j<N;j++) {
                int value = in.nextInt();
                if(i==j) trace += value;
                columns.get(j).add(value);
                rows.get(i).add(value);
            }
        }
        int rowsWithDuplicate = 0;
        int columnsWithDuplicate = 0;
        for(int i=0;i<N;i++) {
            columnsWithDuplicate += (columns.get(i).size() != N) ? 1 : 0;
            rowsWithDuplicate += (rows.get(i).size() != N) ? 1 : 0;
        }
        System.out.println("Case #" + caseID + ": " + trace + " " + rowsWithDuplicate + " " + columnsWithDuplicate);
        caseID += 1;
    }
  }
}