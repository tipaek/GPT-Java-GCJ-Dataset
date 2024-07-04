import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Indicium {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
                 int t=Integer.parseInt(in.nextLine().split("\\s+")[0]);
         for (int i = 1; i <= t ; i++) 
         {
            String[] l0 =in.nextLine().split("\\s+");
            int n = Integer.parseInt(l0[0]);
            int k = Integer.parseInt(l0[1]);
            int center = k / n;
            List<List<Integer>> matrix  = new ArrayList<>(n);
            int j,m;
            for (j = 0; j < n; j++) 
            {
                List<Integer> row = new ArrayList<>(n);
                for (m = 0; m < n; m++) 
                {
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
        if(trace == k)
        {
           System.out.println("Case #"+i+": POSSIBLE");
            matrix.stream()
                        .map(val -> val.stream()
                                .map(st -> st.toString())
                                .collect(Collectors.joining(" ")))
                        .forEach(System.out::println);
            }
            else
            {
                System.out.println("Case #"+i+": IMPOSSIBLE");
            }

        }
    }

}