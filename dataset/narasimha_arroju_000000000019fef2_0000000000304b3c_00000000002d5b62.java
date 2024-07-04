import java.util.*;
class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt(),t1=1;
        while(t-->0){
            int x=sc.nextInt(),y=sc.nextInt();
            System.out.print("Case #"+t1+": ");
            t1++;
            if((Math.abs(x)+Math.abs(y))%2==0)
                System.out.println("IMPOSSIBLE");
        }
    }
}