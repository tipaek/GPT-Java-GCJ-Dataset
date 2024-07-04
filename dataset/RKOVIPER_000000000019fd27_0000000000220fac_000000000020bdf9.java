import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        Scanner sc1 = new Scanner(System.in);
        int T = sc.nextInt();
        for(int i=1;i<=T;i++){
            int N = sc.nextInt();
            int a [][] = new int[N][2];
            int C[]=new int[]{0,0};
            int J[]=new int[]{0,0};
            String s=new String("");
            int flag=0;
            //input
            for(int j=0;j<N;j++){
                for(int k=0;k<2;k++){
                    a[j][k] = sc.nextInt();
                }
            }
            for(int j=0;j<N;j++){
                if(a[j][0]>=C[1]){
                    s+="C";
                    C[0] = a[j][0];
                    C[1] = a[j][1];
                }else if(a[j][0]>=J[1]){
                    s+="J";
                    J[0] = a[j][0];
                    J[1] = a[j][1];
                }else if(a[j][1]<=C[0]){
                    s+="J";
                    C[0] = a[j][0];
                    C[1] = a[j][1];
                }else if(a[j][1]<=J[0]){
                    s+="C";
                    J[0] = a[j][0];
                    J[1] = a[j][1];
                }else{
                    flag=1;
                    System.out.println("Case #"+i+": IMPOSSIBLE");
                    break;
                }
            }
            if(flag==0)
                System.out.println("Case #"+i+": "+s);
        }
    }
}