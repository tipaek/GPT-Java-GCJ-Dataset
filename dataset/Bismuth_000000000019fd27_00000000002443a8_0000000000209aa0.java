import java.util.Scanner;
public class Solution {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N;
        int K;
        int SUM;
        StringBuilder ans = new StringBuilder();
        StringBuilder num[];
        int last = 0;
        for(int i =0; i<T; i++){
            ans.append("Case #"+(i+1)+": ");
            N = sc.nextInt();
            K = sc.nextInt();
            SUM  = K/N;
            if(K%N == 0 && (SUM<=N)){
                ans.append("POSSIBLE\n");
                num = new StringBuilder[N];
                for(int j = 0; j<N; j++){
                    num[j] = new StringBuilder();
                    if(j==0){
                        for(int k = 1; k <=N; k++){
                            num[0].append(k+" ");
                        }
                        last = N;
                    } else{
                        num[j].append(num[j-1]);
                        num[j].delete(num[j].length()-3, num[j].length());
                        num[j].insert(0, last+" ");
                        last --;
                    }
                    num[j].append("\n");
                }
                ans.append(num[SUM-1]);
                for(int k = 0; k<N;k++){
                    if((k+1)!=SUM){
                        ans.append(num[k]);
                    }
                }
                
            } else{
                ans.append("IMPOSSIBLE\n");
            }
        }
        System.out.print(ans.toString());
    }

}