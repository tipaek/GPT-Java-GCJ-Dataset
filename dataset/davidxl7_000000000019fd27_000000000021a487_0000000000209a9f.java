import java.io.*;
import java.util.*;
public class Solution {
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //BufferedReader br = new BufferedReader(new FileReader("Vestigium.in"));
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            System.out.print("Case #"+(i+1)+": ");
            String S = br.readLine();
            int ans = 0;
            int curr = 0;
            for (int j = 0; j < S.length(); j++) {
                int num = Integer.parseInt(S.substring(j, j + 1));
                if(num>curr){
                    for(int k = curr;k<num;k++){
                        System.out.print("(");
                    }
                }
                if(num<curr){
                    for(int k = curr;k>num;k--){
                        System.out.print(")");
                    }
                }
                curr = num;
                System.out.print(num);
            }
            for(int k = curr;k>0;k--){
                System.out.print(")");
            }
            if(i!=N-1)
                System.out.println();
        }
    }
}

