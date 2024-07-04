import java.util.Scanner;

public class Solution {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=1;t<=T;t++){
            int R=sc.nextInt(),C=sc.nextInt();
            System.out.print("Case #"+t+": ");
            if(R==1||C==1)
                System.out.println(0);
            else
                System.out.println((R-1)*(C-1));
            while(R>1){
                int N=R*C;
                for(int n=1;n<C;n++)
                    System.out.println(R+" "+(N-R-n));
                R--;
            }
        }
    }
}
