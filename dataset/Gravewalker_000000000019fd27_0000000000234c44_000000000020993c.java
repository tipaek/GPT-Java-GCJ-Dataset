import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Solution {
    static String arraySolve(List<List<Integer>> m, int n, int t){
        int sum = 0;
        int rows = 0;
        int cols = 0;

        for(int i = 0; i < n; i++){
            sum += m.get(i).get(i);

            List<Integer> arr = m.get(i);

            r:
            for (int j = 0; j < n; j++){
                int a = arr.get(j);
                for(int k = j + 1; k < n; k++){
                    if(a == arr.get(k)){
                        rows += 1;
                        break r;
                    }
                }
            }

            List<Integer> arr2 = new ArrayList<>();
            for(int j = 0; j < n; j++){
                arr2.add(m.get(j).get(i));
            }

            r2:
            for (int j = 0; j < n; j++){
                int a = arr2.get(j);
                for(int k = j + 1; k < n; k++){
                    if(a == arr2.get(k)){
                        cols += 1;
                        break r2;
                    }
                }
            }
        }

        return "Case #"+t+": "+sum+" "+rows+" "+cols;
    }

    public static void main(String[] args) {
        Scanner sc =  new Scanner(System.in);

        int t = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < t; i++){
            int n = Integer.parseInt(sc.nextLine());
            List<List<Integer>> m = new ArrayList<>();
            for (int j = 0; j < n; j++){
                String rowStr = sc.nextLine();
                List<Integer> r = Arrays.stream(rowStr.split(" ")).map(Integer::parseInt).collect(Collectors.toList());
                m.add(r);
            }
            System.out.println(arraySolve(m, n,i+1));
        }
    }
}
