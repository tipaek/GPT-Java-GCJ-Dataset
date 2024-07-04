import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        int f = 0;
        while (f++ < t){
            int n = scan.nextInt();
            List<int[]> list = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                int x = scan.nextInt();
                int y = scan.nextInt();
                list.add(new int[]{x,y,i});
            }
            String[] result = new String[n];
            list.sort((Comparator.comparingInt(o -> o[1])));
            int[] C = new int[2];
            int[] J = new int[2];
            result[list.get(0)[2]] = "C";
            C[0] = list.get(0)[0];
            C[1] = list.get(0)[1];
            J[0] = -1;
            J[1] = -1;
            boolean isImpossible = false;
            for (int i = 1; i < list.size(); i++) {
                int[] ints = list.get(i);
                if(ints[0] >= C[1]){
                    result[ints[2]]="C";
                    C[0] = ints[0];
                    C[1] = ints[1];
                }else if(J[0] == -1 || (ints[0] >= J[1])){
                    result[ints[2]]="J";
                    J[0] = ints[0];
                    J[1] = ints[1];
                }else{
                    isImpossible = true;
                    break;
                }
            }
            System.out.println(isImpossible?"IMPOSSIBLE": String.join("", result));
        }
    }
}
