

import java.io.*;
import java.util.Arrays;

public class Solution {
    public static void main(String[] args) throws IOException {
        Solution  obj = new Solution ();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int t=1; t<=T; t++) {
            String[] input = br.readLine().split(" ");
            int N = Integer.parseInt(input[0]);
            int B = Integer.parseInt(input[1]);
            String[] inputArr = br.readLine().split(" ");
            int[] arr = new int[N];
            for( int i=0;i<inputArr.length;i++) {
                arr[i] = Integer.parseInt(inputArr[i]);
            }
            Arrays.sort(arr);
            int count = 0;
            long sum = 0;
            for( int i=0; i<N;i++) {
                sum = sum+arr[i];
                if( sum <= B) {
                    count++;
                }
            }
            System.out.println("Case #"+t+": "+count);
        }
    }
}
