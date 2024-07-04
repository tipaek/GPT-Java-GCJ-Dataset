import java.util.Scanner;
public class Solution {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N;
        int K;
        int SUM;
        StringBuilder ans = new StringBuilder();
        StringBuilder ansNum;
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
                ansNum= new StringBuilder();
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
                int first = 0;
                int index = N;
                for(int k = 0; k<N;k++){
                    first = Integer.parseInt(String.valueOf(num[k].charAt(0)));
                    if((first)==SUM){
                        index = k;
                    } 
                    if(k>=index){                        
                        ans.append(num[k]);
                    }
                    else {
                        ansNum.append(num[k]);
                    }
                }
                ans.append(ansNum);
                
            } else{
                ans.append("IMPOSSIBLE\n");
            }
        }
        System.out.print(ans.toString());
    }

}