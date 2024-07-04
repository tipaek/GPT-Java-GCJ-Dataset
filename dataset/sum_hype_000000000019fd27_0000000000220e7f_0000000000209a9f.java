import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int N;
        N = Integer.parseInt(scan.nextLine());
        String[] ans = new String[N];
        for(int i = 0; i < N; i++){
            String input = scan.nextLine();
            int M = input.length();
            int[] digits = new int[input.length()];
            int[][] count = new int[input.length()+1][2];
            for(int k = 0; k < input.length(); k++){
                digits[k] = Integer.parseInt(input.substring(k, k+1));
            }

            while(true){
                int startInd = -1;
                boolean anyFound = false;

                for(int k = 0; k < M; k++){
                    if(startInd == -1 && digits[k] > 0){
                        startInd = k;
                        digits[k] --;
                        anyFound =  true;
                    } else if (digits[k] > 0){
                        digits[k] --;
                    } else if (startInd != -1){
                        count[startInd][0]++;
                        count[k][1]++;
                        startInd = -1;
                    }
                }
                if(startInd!=-1){
                    count[startInd][0] ++;
                    count[M][1] ++;
                }

                if(!anyFound)
                    break;
            }

            String output = "";
            for(int k = 0; k < M; k++){
                for(int j = 0; j < count[k][1]; j++)
                    output += ")";
                for(int j = 0; j < count[k][0]; j++)
                    output += "(";
                output += input.charAt(k);
            }
            for(int j = 0; j < count[M][1]; j++)
                output += ")";
            ans[i] = ("Case #" + (i+1) + ": " + output);
        }

        for(String i: ans)
            System.out.println(i);
    }
}