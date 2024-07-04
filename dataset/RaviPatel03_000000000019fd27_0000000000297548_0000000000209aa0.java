import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int test=sc.nextInt();
        for(int i=0;i<test;i++){
            int N=sc.nextInt();
            int K=sc.nextInt();
            boolean flag=false;
            int j=0;
            for(;j<N;j++){
                if(N*(j+1) ==K){
                    flag=true;
                    break;
                }
            }
            if(flag){
                int temp=j+1;
                System.out.println("Case #"+(i+1)+": POSSIBLE");
                //  int temp=j+1;
                StringBuilder sb=new StringBuilder();
                for(int k=0;k<N;k++){
                    if(temp > N){
                        temp=1;
                    }
                    sb.append(temp+" ");
                    temp=temp+1;
                }
                for(int k=0;k<N;k++){
                    System.out.println(sb.toString());
                    String[] str =sb.toString().split(" ");
                    String s=str[0];
                    sb.setLength(0);
                    for(int l=1;l<str.length;l++){
                        sb.append(str[l]+" ");
                    }
                    sb.append(s);
                }
                // System.out.println("Case #"+(i+1)+": POSSIBLE");
            }else{
                System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
            }
        }
    }
}
