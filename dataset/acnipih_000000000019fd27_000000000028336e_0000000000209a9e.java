import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws Exception {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Scanner in = new Scanner(reader);

        int t = in.nextInt();
        int b = in.nextInt();
        for (int i = 1; i <= t; i++) {
            int [] arr = new int[b];
            Arrays.fill(arr, -1);
            int [] res = process(arr, in);
            String toJudge = Arrays.stream(res)
                    .mapToObj(String::valueOf)
                    .collect(Collectors.joining(""));
            System.out.println(toJudge);
            String result = in.next();
            if(result.equals("N")) return;
//            System.out.println("Case #" + i + ": " + res);
        }
    }

    private static int[] process(int[] arr, Scanner in) {
        int start = 0;
        int end = arr.length -1;
        int step = 1;
        int n = arr.length;
        while(true){
            if(start > end) {
                boolean solution = true;
                for(int i =0; i < n; i++){
                    if(arr[i] == -1){
                        if(step % 10 == 1) {
                            solution = false;
                            break;
                        }
                        System.out.println(i + 1);
                        arr[i] = in.nextInt();
                        step++;
                    }
                }
                if(solution)
                    return arr;
            }
            if(step > 1 && step % 10 == 1){
                int x = -1;
                int y = -1;
                for(int i = 0; i < end; i++){
                    if(arr[i] == arr[n - i - 1] && arr[i] != -1 && x == -1) x = i;
                    if(y == -1 && arr[i] != -1 && arr[n -i - 1] != -1 && arr[i] != arr[n-i-1]) y =i;
                    if(x >= 0 && y >=0 )break;
                }
                if(y == -1){
                    System.out.println(x + 1);
                    int val = in.nextInt();
                    if(val != arr[x]){
                        for(int i = 0; i < n; i++){
                            if(arr[i] != -1) arr[i] = (arr[i] + 1) % 2;
                        }
                    }
//                    step++;
                } else if (x == -1) {
                    System.out.println(y + 1);
                    int val = in.nextInt();
                    if(val != arr[y]){
                        for(int i = 0; i < n; i++){
                            if(arr[i] != -1) arr[i] = (arr[i] + 1) % 2;
                        }
                    }
//                    step++;
                } else {
                    System.out.println(x + 1);
                    int val = in.nextInt();
                    System.out.println(y + 1);
                    int val2 = in.nextInt();
                    boolean flip = val != arr[x];
                    boolean reverse = (val2 == arr[y] && flip) || (val2 != arr[y] && !flip);
                    if(flip) {
                        for (int i = 0; i < n; i++) {
                            if (arr[i] != -1) arr[i] = (arr[i] + 1) % 2;
                        }
                    }
                    if(reverse){
                        for (int i = 0; i < n / 2; i++) {
                           int t = arr[i];
                           arr[i] = arr[n - i - 1];
                           arr[n -i - 1] = t;
                        }
                    }

                    step++;
                }
            } else {
                if(step % 2 == 1){
                    System.out.println(start + 1);
                    int val = in.nextInt();
                    arr[start] = val;
                    start++;
                } else {
                    System.out.println(end + 1);
                    int val = in.nextInt();
                    arr[end] = val;
                    end--;
                }
            }
            step++;
        }
    }
}
