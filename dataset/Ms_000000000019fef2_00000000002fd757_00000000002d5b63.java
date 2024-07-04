import java.util.*;
class Solution{
    public static void main(String args[]){
        int t = sc.nextInt();
        for(int k=1;k<=t;k++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int r = sc.nextInt();
            int x = sc.nextInt();
            int y = sc.nextInt();
            String s = sc.next();
            if(s=="MISS"){
            System.out.print(-1000000000+" ");
            System.out.println(1000000000);
            }
            else if(s=="HIT"){
                System.out.print(0);
                System.out.println(0);
            }
            else if(s=="CENTER"){
                System.out.println(x+" "+y);
            }
            else{
                System.out.print(-1234567890);
                System.out.println(1234567890);
                System.exit();
            }
        }
    }
}