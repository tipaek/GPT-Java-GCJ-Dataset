import java.util.Scanner;


public class Solution {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int t =1; t<=T; t++){
            int N = sc.nextInt();
            String out = "C";
            int[] s = new int[N];
            int[] e = new int[N];
            for(int i=0; i< N; i++){
                s[i] = sc.nextInt();
                e[i] = sc.nextInt();
            }
            for(int i=0; i< N-1; i++){
                if((s[i] > s[i+1] || e[i] < e[i+1]) == true){
                    if (e[i] == s[i+1]){
                        if(out.charAt(out.length()-1) == 'C'){
                            out = out + 'C';
                        }
                        else if (out.charAt(out.length()-1) == 'J'){
                            out = out + 'J';
                        }
                    }
                    else{
                        if(out.charAt(out.length()-1) == 'C'){
                            out = out + 'J';
                        }
                        else if (out.charAt(out.length()-1) == 'J'){
                            out = out + 'C';
                        }
                    }

                }

            }
            if (out.length() !=N){
                out = "IMPOSSIBLE";
            }
            System.out.println("Case #"+t+": "+out);
        }
    }
}
