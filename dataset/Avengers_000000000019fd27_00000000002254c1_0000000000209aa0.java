import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Solution {
     public static void main(String[] args) throws IOException {

        BufferedReader in = new BufferedReader((new InputStreamReader(System.in)));

        int t = Integer.parseInt(in.readLine());
        for (int i = 1; i <= t; i++) {
            List<Integer> input = Arrays.stream(in.readLine().split(" ")).map(num -> Integer.parseInt(num)).collect(Collectors.toList());
            int n = input.get(0);
            int k = input.get(1);
            if(k%n!=0 ) {
                System.out.println("Case #" + i + ": IMPOSSIBLE");
            }
            else {
                System.out.println("Case #" + i + ": POSSIBLE");

                List<Integer> list = IntStream.rangeClosed(1, n).boxed().collect(Collectors.toList());
                 int r = (k / n);
                 int factor =0;
                if(r == n) {
                    factor = r - 1;}
                else{
                    factor = r;}
                for(int j=1;j<=n;j++) {
                    int s =r;
                    List<Integer> list1 = new ArrayList<>();
                    for(int l=0;l<n;l++)
                    {list1.add(s);
                        s = s + 1;
                        if (s > n) {
                            s = 1;
                        }
                    }
                    System.out.println(list1.stream().map(String::valueOf).collect(Collectors.joining(" ")));;

                    r = r - 1;
                    if (r == 0) {
                        r = n;
                    }
                }
//                Collections.rotate(list, -((input.get(1) / input.get(0))-1));
//                for (int j = 0; j < n; j++) {
//                    System.out.println(list.stream().map(Object::toString).collect(Collectors.joining(" ")));
//                    Collections.rotate(list, 1);
//
//                }
            }

        }
    }
    
}
