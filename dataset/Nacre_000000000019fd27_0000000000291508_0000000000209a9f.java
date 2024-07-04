import java.util.*;
import java.io.*;
public class Solution {
    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
            StringBuilder sb = new StringBuilder();
            char[] arr = in.next().toCharArray();
            int start = 0;
            int index = 0;
            while(index< arr.length){
                if (arr[index] - '0' == 0) {
                    if(index != 0){
                        sb.append(solve(arr, start, index - 1));
                    }
                    sb.append(0);
                    index++;
                    start = index;

                } else if(arr[index] > arr[start]){
                    sb.append(solve(arr, start, index-1));
                    start = index;
                    index++;
                }else{
                    index++;
                }
            }
            if(start < arr.length){
                sb.append(solve(arr, start, index-1));
            }
            System.out.println("Case #" + i + ": " + (sb.toString()));
        }
    }

    private static String solve(char[] arr, int start, int end) {
        if(end < start){
            return "";
        }
        StringBuilder sbTemp = new StringBuilder();
        int index = start;
        int init = (arr[index]-'0');
        int count = 0;
        for(int i=0; i<init; i++){
            sbTemp.append('(');
            count++;
        }
        sbTemp.append(init);
        index++;
        while(index <= end){
            int num = (int)arr[index]-'0';
            int diff = (arr[index]- arr[index-1]);
            for(int i=0; i<diff; i++){
                sbTemp.append('(');
                count++;
            }
            for(int i=0; i<diff*(-1); i++){
                sbTemp.append(')');
                count--;
            }
            sbTemp.append(num);
            index++;
        }
//        int tmp = arr[start]-'0';
        for(int i=0; i<count; i++){
            sbTemp.append(')');
        }
        return sbTemp.toString();
    }


}