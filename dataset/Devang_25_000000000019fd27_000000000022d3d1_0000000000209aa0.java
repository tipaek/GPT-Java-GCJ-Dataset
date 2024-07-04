import java.io.*;
import java.util.*;
import java.util.stream.IntStream; 
import java.util.stream.Collectors; 


public class Solution {

    public static void main(String[] args) {
        String possble = "POSSIBLE";
        String impossble = "IMPOSSIBLE";
        Scanner in = new Scanner(System.in);
        
        int t = in.nextInt();
        for (int i = 1; i <= t ; i++) 
        {
        
            int n = in.nextInt();
            int k = in.nextInt(); // trace
            int center = k / n;

                List<List<Integer>> matrix  = new ArrayList<>(n);

                for (int j = 0; j < n; j++) {
                    List<Integer> row = new ArrayList<>(n);
                    for (int m = 0; m < n; m++) {
                        int p = n - j;
                        int val = ((p + m) % n) + center;
                        if(val > n){
                            val = val - n;
                        }
                        row.add(val);

                    }

                    matrix.add(row);
                }
                
                int trace = IntStream.range(0, n).map(r -> matrix.get(r).get(r)).sum();
            if(trace == k){
                System.out.println("Case #"+i+": "+possble);
                matrix.stream()
                        .map(val -> val.stream()
                                .map(st -> st.toString())
                                .collect(Collectors.joining(" ")))
                        .forEach(System.out::println);
            }else {
                System.out.println("Case #"+i+": "+impossble);
            }

        }
    }

}