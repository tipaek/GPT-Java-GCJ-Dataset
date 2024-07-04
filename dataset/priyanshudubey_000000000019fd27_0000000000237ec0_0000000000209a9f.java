import java.util.Scanner;

public class Solution {
    public static void main(String args[] ) throws Exception {
       Scanner sc = new Scanner(System.in);
       int tc = sc.nextInt();
       for(int t = 1;t <= tc;t++){

        String s = sc.next();
        char[] str = s.toCharArray();
        int n = s.length(),brack[][] = new int[n][2];
        StringBuilder sb = new StringBuilder();
        

        for(int i = 0;i < n;i++){
            if(i == 0){
                brack[i][0] = str[i] - '0';
                brack[i][1] = str[i] - '0';
            }
            else{
                int need = str[i] - '0';
                if(need == 0) continue;
                if(need > brack[i - 1][1]){
                    brack[i][0] = need - brack[i - 1][1];
                    brack[i][1] = need;
                    brack[i - 1][1] = 0;
                }else if(need < brack[i - 1][1]){
                    brack[i][0] = 0;
                    brack[i][1] = need;
                    brack[i - 1][1] = brack[i - 1][1] -  need; 
                }else{
                    brack[i][0] = 0;
                    brack[i][1] = brack[i - 1][1];
                    brack[i - 1][1] = 0;
                }
            }
        }

        for(int i =0;i < n;i++){
            for(int j = 0;j < brack[i][0];j++){
                sb.append('(');
            }
            sb.append(str[i]);
            for(int j = 0;j < brack[i][1];j++){
                sb.append(')');
            }
        }
        System.out.println(sb.toString());
       }
    }
}
