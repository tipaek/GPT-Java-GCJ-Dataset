import java.util.Scanner;

public class Solution{
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        int N = 10000;
        for(int x = 1; x<=T;x++){
            int U = sc.nextInt();
            String[] R = new String[N];
            String Q = "";
            int[] fjoldi = new int[10];
            char[] stafur = new char[10];
            int k = 0;
            boolean[] zero = new boolean[10];
            for(int i = 0; i<10; i++) zero[i] = true;
            for(int i = 0; i<N;i++){
                Q = sc.next();
                R[i] = sc.next();
                for(int m = 0; m<R[i].length();m++){
                    char a = R[i].charAt(m);
                    boolean sed = false;
                    for(int j = 0; j<k;j++){
                        if(a == stafur[j]){
                            fjoldi[j]+=R[i].length()-m;
                            sed = true;
                            if(m == 0) zero[j] = false;
                        }
                    }
                    if(!sed) {
                        stafur[k] = a;
                        fjoldi[k]+=R[i].length()-m;
                        if(m == 0) zero[k] = false;
                        k++;
                    }
                }
            }
            String y = "";
            for(int i = 0; i<10;i++){
                if(zero[i]){
                    y+= stafur[i];
                    fjoldi[i] = -1;
                }
            }
            for(int i = 1; i<10; i++){
                int mest = -1;
                int stadur = -1;
                for(int j = 0; j<10; j++){
                    if(mest<fjoldi[j]){
                        mest = fjoldi[j];
                        stadur = j;
                    }
                    
                }
                if(stadur != -1) y+= stafur[stadur];
                fjoldi[stadur] = -1;
            }
            System.out.println("Case #"+x+": "+y);
        }
    }
}
