import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) throws Exception {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int n = in.nextInt();
            int k = in.nextInt();
            solve(i, n, k);
        }
    }
    
    private static void solve(int index, int n, int k) {
        List<List<Integer>> avaiables = new ArrayList<>();
        findAvaiables(n, k, avaiables, new ArrayList<>(), new ArrayList<>());
        
        String result = "IMPOSSIBLE";
        if (avaiables.size() > 0) {
            List<Integer> list = avaiables.get(0);
//            System.out.println(list);
            StringBuilder stringBuilder = new StringBuilder("POSSIBLE");
            for (int i = 0; i < n; i++) {
                stringBuilder.append("\n");
                for (int j = 0; j < n; j++) {
                    stringBuilder.append(list.get(i * n + j));
                    if (j < n - 1)
                        stringBuilder.append(" ");
                }
            }
            result = stringBuilder.toString();
        }
        System.out.println("Case #" + index + ": " + result);
    }
    
    private static void findAvaiables(final int n, final int k, List<List<Integer>> avaiables, List<Integer> contructingList, List<Integer> items) {
        if (avaiables.size() > 0) {
//            System.out.println("return 1");
            return;
        }
        
        int contructingSize = contructingList.size();
        
        if (contructingSize == n * n) {
            int trace = 0;
            for (int i = 0; i < n; i++) {
                trace += contructingList.get(i*n+i);
            }
//            System.out.println("trace: " + trace + " on " + contructingList);
            if (trace == k) {
                avaiables.add(contructingList);
            }
//            System.out.println("return 2");
            return;
        }
        
        if (items.isEmpty()) {
            for (int i = 0; i < n; i++) {
                items.add(i+1);
            }
        }
        
//        System.out.println(contructingList);
        
        for (int i = 0, count = items.size(); i < count; i++) {
            int item = items.get(i);
            
            // check if same in columns
            boolean colDup = false;
            for (int j = contructingSize - n; j >= 0; j -= n) {
                if (contructingList.get(j) == item) {
                    colDup = true;
                }
            }
            if (colDup) {
//                System.out.println("colDup if add " + item + " " + contructingList);
                continue;
            }
            
            List<Integer> avaiableContructingList = new ArrayList<>(contructingList);
            avaiableContructingList.add(item);
            
            List<Integer> avaiableItems = new ArrayList<>(items);
            avaiableItems.remove(i);
            
            findAvaiables(n, k, avaiables, avaiableContructingList, avaiableItems);
        }
    }
}
