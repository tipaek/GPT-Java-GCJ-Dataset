import java.io.*;
import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t = 1 ; t <= T; t++){
            int N = sc.nextInt();
            String[] P = new String[N];
            String[] P1 = new String[N];
            String largestString = "";
            int maxLength = 0;
            for(int i = 0 ; i < N ; i++){
                String s = sc.next();
                P[i] = s;
                P1[i] = s.replace("*","");
                if(maxLength < P1[i].length()){
                    largestString = P1[i];
                    maxLength = P1[i].length();
                }
            }
            Arrays.sort(P1);
            System.out.print("Case #" + t + ": ");
            boolean flag = false;
            for(int i = 0 ; i < N ; i++){
                if(!largestString.contains(P1[i])){
                    flag = true;
                    break;
                }
            }
            if(flag){
                System.out.println("*");
            }else{
                System.out.println(largestString);
            }
        }
    }
}