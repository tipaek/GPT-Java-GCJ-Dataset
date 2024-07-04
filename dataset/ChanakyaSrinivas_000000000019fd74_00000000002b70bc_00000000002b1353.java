import java.util.Scanner;

public class Solution {
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int T=sc.nextInt(),pos=1;
        int array[][]=new int[500][];
        array[0]=new int[1];
        array[0][0]=1;
        for(int t=1;t<=T;t++){
            int N=sc.nextInt()-2;
            System.out.println("Case #"+t+": ");
//            for(int i=0;i<pos;i++){
//                for(int j=0;j<=i;j++){
//                    if(N>=array[i][j]){
//                        N-=array[i][j];
//                        System.out.println((i+1)+" "+(j+1));
//                    }
//                    else if(j<=1&&j>=i-1)
//                        break;
//                }
//            }
//            while(N>array[pos-1][pos-2]){
//                array[pos]=new int[pos+1];
//                for(int i=0;i<=pos/2;i++){
//                    int cons=1;
//                    if(i!=0)
//                        cons=array[pos-1][i-1]+array[pos-1][i];
//                    array[pos][i]=cons;
//                    array[pos][pos-i]=cons;
//
//                }
//            }
            int i=3,cons=2;
            System.out.println(1+" "+1);
            if(N>=0)
                System.out.println(2+" "+1);
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
