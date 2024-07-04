
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int n[] = new int[t];
        List<Integer[][]> listList = new ArrayList<>();
        int sum1[] = new int[t];
        int sum2[] = new int[t];
        int sum3[] = new int[t];
        for(int i = 0; i < t; i++){
            n[i] = sc.nextInt();
            sum1[i] = 0;
            sum2[i] = 0;
            sum3[i] = 0;
            Set<Integer> set = new HashSet<>();
            Integer mat[][] = new Integer[n[i]][n[i]];
            for(int j = 0; j < n[i]; j++){
                for(int k = 0; k < n[i]; k++) {
                    int m = sc.nextInt();
                    mat[j][k] = m;
                    if(k == j){
                        sum1[i] += m;
                    }
                    set.add(m);
                }
                if(n[i] > set.size()){
                    sum2[i]++;
                }
                set.clear();
            }
            listList.add(mat);
        }
        for(int i = 0; i < t; i++){
            Set<Integer> set = new HashSet<>();
            for(int j = 0; j < n[i]; j++){
                for(int k = 0; k < n[i]; k++) {
                    int m = listList.get(i)[k][j];
                    set.add(m);
                }
                if(n[i] > set.size()){
                    sum3[i]++;
                }
                set.clear();
            }
        }
        for(int i = 0; i < t; i++){
            System.out.println("Case #" + (i + 1) + ": " + sum1[i] + " " + sum2[i] + " " + sum3[i]);
        }
    }
}
