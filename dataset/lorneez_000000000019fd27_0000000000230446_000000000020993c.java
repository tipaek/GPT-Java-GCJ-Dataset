import java.util.*;
import java.io.*;
public class Vestigium {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner myScanner = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
                int cases = myScanner.nextInt();
        for(int i=1; i<=cases; i++){
            int rowCount = 0;
            int colCount = 0;
            int diagSum = 0;
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
                        diagSum += el;
                    }
                }
                if(rowSet.size() != N){
                    rowCount ++;
                }
            }
            for(HashSet<Integer> d : list){
                if(d.size() != N){
                    colCount ++;
                }
            }
            int trial = i+1;
            System.out.println("Case #"+trial+": "+diagSum+" "+rowCount+" "+colCount);
        }
        myScanner.close();
    }
}