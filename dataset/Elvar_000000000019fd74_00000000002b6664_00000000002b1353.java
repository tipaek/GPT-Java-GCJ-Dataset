import java.util.Scanner;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        for(int x = 1; x<=T;x++){
            int N = sc.nextInt();
            System.out.println("Case #"+x+":");
            if(N<30){
                for(int i = 1; i<=N; i++) System.out.println(i+ " "+1);
            }
            else{
            int M = N;
            if(N>30) M -=30;
            int[] A = binary(M);
            int summa = 0;
            int stadur = 1;
            for(int i = 1; i<=A.length; i++){
                if(A[i-1] == 0){
                    System.out.println(i+" "+stadur);
                    summa += 1;
                    if(stadur != 1) stadur++;
                }
                else{
                    summa += (int) Math.pow(2,i-1);
                    if(stadur == 1){
                        for(int j = 1; j<=i; j++){
                            System.out.println(i+ " "+j);
                        }
                        stadur = i+1;
                    }
                    else{
                        for(int j = i; j>=1; j--){
                            System.out.println(i+" "+j);
                        }
                        stadur = 1;
                    }
                }
            }
            int k = 1;
            while(summa<N){
                if(stadur == 1) System.out.println((A.length+k)+" "+ 1);
                else System.out.println((A.length+k)+" "+(A.length+k));
                summa ++;
                k++;
            }
            }
            
            
        }
        
    }
    public static int[] binary(int n){
        int[] A = new int[(int) Math.ceil(Math.log(n)/Math.log(2))];
        for(int i = 0; i<A.length; i++){
            A[i] = n%2;
            n/= 2;
        }
        return A;
    }
}