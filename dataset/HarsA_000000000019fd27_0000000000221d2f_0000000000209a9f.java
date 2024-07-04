import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for(int tt=1;tt<=t;tt++) {
            String s = sc.next();
            char[] carr = s.toCharArray();
            int[] arr = new int[s.length()];
            for(int i=0; i< s.length(); i++) {
                arr[i] = Integer.parseInt(String.valueOf(carr[i]));
            }

            int count  = 0;
            StringBuilder sb = new StringBuilder();
            for(int i=0; i< s.length(); i++) {
                if(i==0 && arr[i] == 0) {
                    sb.append(arr[i]);
                    continue;
                }

                if(i==0) {
                    for(int j =0 ; j< arr[i] ; j++) {
                        sb.append('(');
                        count++;
                    }
                    sb.append(arr[i]);
                    continue;
                }

                if(arr[i] == arr[i-1]) {
                    sb.append(arr[i]);
                } else if(arr[i] > arr[i-1]) {
                    for(int j =0 ; j< arr[i] - arr[i-1]; j++) {
                        sb.append('(');
                        count++;
                    }
                    sb.append(arr[i]);
                } else {
                    for(int j =0 ; j< arr[i-1] - arr[i]; j++) {
                        sb.append(')');
                        count--;
                    }
                    sb.append(arr[i]);
                }
            }

            while (count-- >0) sb.append(')');
            System.out.println("Case #" + tt + ": " + sb.toString());
        }
    }
}
