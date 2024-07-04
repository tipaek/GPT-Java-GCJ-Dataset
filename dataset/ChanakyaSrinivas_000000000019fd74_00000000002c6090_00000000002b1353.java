import java.util.Scanner;

public class Solution {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt();
        for(int t=1;t<=T;t++){
            int N=sc.nextInt()-1;
            System.out.println("Case #"+t+": ");
            int i=2,cons=1;
            System.out.println(1+" "+1);
            while(N>=cons){
                System.out.println(i+" "+2);
                N-=cons;
                cons++;i++;
            }
            while(N>0){
                System.out.println(i+" "+1);
                N-=1;
                i++;
            }
        }
    }
}
