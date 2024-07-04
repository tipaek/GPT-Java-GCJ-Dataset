import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static String OPEN = "(";
    static String CLOSE = ")";

    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        for (int t = 0; t < T; t++){
            char[] nums = br.readLine().toCharArray();
            StringBuilder sb = new StringBuilder();
            for (int c = 0; c < nums.length; c++){
                if (c == 0){
                    for( int q = 0 ; q < nums[c] - '0'; q++ ){
                        sb.append(OPEN);
                    }
                    sb.append(nums[c]);
                }
                else {
                    int dif = nums[c-1] - nums[c];
                    if (dif > 0){
                        for( int q = 0 ; q < dif; q++ ){
                            sb.append(CLOSE);
                        }
                        sb.append(nums[c]);
                    }
                    else if (dif == 0) sb.append(nums[c]);
                    else {

                        for( int q = 0 ; q < -dif; q++ ){
                            sb.append(OPEN);
                        }
                        sb.append(nums[c]);
                    }
                }
            }
            for( int q = 0 ; q < nums[nums.length-1] - '0'; q++ ){
                sb.append(CLOSE);
            }
            System.out.println("Case #"+(t+1) + ": " + sb.toString());
        }
    }
}
