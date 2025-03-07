
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    public static void main(String[] args) {
        String possble = "POSSIBLE";
        String impossble = "IMPOSSIBLE";
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));

        int t = Integer.parseInt(in.nextLine());
        for (int i = 1; i <= t ; i++) {
            List<Integer> numbers = Arrays.stream(in.nextLine().split(" "))
                    .map(val -> Integer.parseInt(val)).collect(Collectors.toList());

            int n = numbers.get(0);
            int k = numbers.get(1);// trace

            if(k % n == 0){
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
