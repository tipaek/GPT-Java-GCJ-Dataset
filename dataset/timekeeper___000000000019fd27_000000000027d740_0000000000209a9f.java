import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

    public static void main(String[] a){
        InputStream is = System.in;
        try (Scanner scanner = new Scanner(new BufferedReader(new InputStreamReader(is)))) {
            int testCount = scanner.nextInt();
            for (int testNumber = 1; testNumber <= testCount; testNumber++) {
                String input = scanner.next();
                char[] ch = input.toCharArray();
                int size = ch.length;
                int[] arr = new int[size];
                for(int i=0; i<size; i++) {
                    arr[i] = ch[i] - '0';
                }
                int global_depth = arr[0];
                StringBuilder s = new StringBuilder();
                for(int i=0;i<global_depth; i++){
                    s.append("(");
                }
                s.append(arr[0]);
                for(int i=1; i<arr.length; i++){
                    int diff = arr[i] - arr[i-1];
                    if(diff>0){
                        for(int j=0; j<diff; j++){
                            s.append("(");
                        }
                    } else if (diff<0) {
                        for(int j=0; j<Math.abs(diff); j++){
                            s.append(")");
                        }
                    }
                    s.append(arr[i]);
                    global_depth += diff;
                }
                for(int i=0; i<global_depth; i++){
                    s.append(")");
                }
                System.out.println("Case #"+testNumber+": "+s.toString());
            }
        }
    }
}