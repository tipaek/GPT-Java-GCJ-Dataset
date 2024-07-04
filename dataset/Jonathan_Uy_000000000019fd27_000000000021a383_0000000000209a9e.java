import java.io.*;
import java.util.*;

public class Solution {
    public static void main(String[] args) throws IOException {
        Scanner in = new Scanner(System.in);
        int T = in.nextInt();
        
        for(int t = 1; t <= T; t++){
            int B = in.nextInt();
            if(B == 10){
                String answer = "";
                for(int i = 1; i <= 10; i++){
                    System.out.println(i);
                    answer += in.next();
                }
                System.out.println(answer);
                in.next();
            }
        }
    }
}