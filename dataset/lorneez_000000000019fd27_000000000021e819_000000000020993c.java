import java.util.*;
import java.io.*;
public class Solution {
  public static void main(String[] args) {
    Scanner myScanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    int testCases = Integer.parseInt(myScanner.nextLine());
    for(int i=0; i<testCases; i++){
        int rowdup = 0;
        int coldup = 0;
        int diag = 0;
        int N = Integer.parseInt(myScanner.nextLine());
        ArrayList<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>();
        for(int row=0; row<N; row++){
            String line[] = myScanner.nextLine().split(" ");
            HashSet<Integer> rowSet = new HashSet<Integer>();
            for(int col=0; col<N; col++){
                int el = Integer.parseInt(line[col]);
                list.get(col).add(el);
                rowSet.add(el);
                if(row == col){
                    diag += el;
                }
            }
            if(rowSet.size() != N){
                rowdup ++;
            }
        }
        for(HashSet<Integer> d : list){
            if(d.size() != N){
                coldup ++;
            }
        }
        System.out.println("Case #"+i+" "+diag+" "+rowdup+" "+coldup);
    }
  }
}