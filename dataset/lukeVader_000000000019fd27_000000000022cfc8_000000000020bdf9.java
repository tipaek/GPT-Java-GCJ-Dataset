import java.util.*;

public class Solution{


    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i = 1; i <= t; i++) {
            int x = sc.nextInt();
            int[] arr = new int[x];
            int[] arr2 = new int[x];
            TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
            for (int j = 0; j < x; j++) {
                arr[j] = sc.nextInt();
                arr2[j] = sc.nextInt();
                map.put(arr[j], arr2[j]);
            }
            Boolean isPos = true;
            Arrays.sort(arr);
            Arrays.sort(arr2);
            int total = 1;
            for (int j = 1, k =0; j < arr.length && k < arr2.length;) {
                if (arr[j] < arr2[k]) {
                    total++;
                    j++;
                } else {
                    total--;
                    k++;
                }
                if (total > 2) {
                    System.out.println("Case #" + i + ": IMPOSSIBLE");
                    isPos = false;
                    break;
                }
            }
            if(isPos) {
                StringBuilder sb = new StringBuilder();
                int turn = 0, end;

                for (int j = 0; j < arr.length;) {
                    sb.append('C');
                    end = map.get(arr[j++]);
                    while (j < arr.length && arr[j] < end) {
                        sb.append('J');
                        j++;
                    }
                }
                System.out.println("Case #" + i + ": "+sb.toString());
            }
        }
    }
}