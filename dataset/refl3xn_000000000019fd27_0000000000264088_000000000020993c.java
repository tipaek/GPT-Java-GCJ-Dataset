import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);
        int t = sc.nextInt();
        int count = 0; 
        while (t-- > 0){
            int n = sc.nextInt();
            ArrayList<ArrayList<Integer>> arr = new ArrayList<>();
            for (int i=0;i<n;i++){
                ArrayList<Integer> temp = new ArrayList<>();
                arr.add(temp);
                for (int j=0;j<n;j++)
                arr.get(i).add(sc.nextInt());
            }
            count++;
            calculate(arr, n, count);
        }
    }

    private static void calculate(ArrayList<ArrayList<Integer>> arr, int n, int count) {
        int trace = 0;
        int rowCount = 0;
        int colCount = 0;
        ArrayList<HashSet<Integer>> rowarr = new ArrayList<>();
        ArrayList<Boolean> r = new ArrayList<Boolean>();
        ArrayList<Boolean> c = new ArrayList<Boolean>();
        ArrayList<HashSet<Integer>> colarr = new ArrayList<>();
        for (int i=0;i<n;i++){
            HashSet<Integer> row = new HashSet<>();
            rowarr.add(row);
            r.add(true);
            for (int j=0;j<n;j++){
                if (i == 0){
                    HashSet<Integer> col = new HashSet<>();
                    colarr.add(col);
                    c.add(true);
                }
                if (i == j){
                    trace += arr.get(i).get(j);
                }
                int temp = arr.get(i).get(j);
                if (rowarr.get(i).contains(temp) && r.get(i)) {
                    r.set(i, false);
                    rowCount++;
                }
                if (colarr.get(j).contains(temp) && c.get(j)) {
                    c.set(j, false);
                    colCount++;
                }
                rowarr.get(i).add(temp);
                colarr.get(j).add(temp);
            }
        }
        System.out.println("Case #" + count + ": " +trace + " " + rowCount + " " + colCount);
    }
}
