import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) throws FileNotFoundException {
        File text = new File("src/test.txt");

        Scanner myScanner = new Scanner(text);

        int testCases = myScanner.nextInt();
        for(int i=0; i<testCases; i++){
            int rowdup = 0;
            int coldup = 0;
            int diag = 0;
            int N = myScanner.nextInt();
            ArrayList<HashSet<Integer>> list = new ArrayList<HashSet<Integer>>();
            for(int p=0; p<N; p++){
                list.add(new HashSet<Integer>());
            }
            for(int row=0; row<N; row++){
                HashSet<Integer> rowSet = new HashSet<Integer>();
                for(int col=0; col<N; col++){
                    int el = myScanner.nextInt();
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
            int trial = i+1;
            System.out.println("Case #"+trial+": "+diag+" "+rowdup+" "+coldup);
        }
        myScanner.close();
    }
}