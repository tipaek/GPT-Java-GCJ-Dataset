import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Solution {


    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int[] tc = Arrays.stream(s.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        int b = tc[1];

        for (int t=0; t < tc[0]; t++) {
            StringBuilder tb = new StringBuilder();
            for(int i=1;i<=b;i++){
                System.out.println(i);
                tb.append(s.next());
            }
            System.out.println(tb);
            String result = s.next();
            if(result.equals("N")){
                break;
            }
        }

    }
}
