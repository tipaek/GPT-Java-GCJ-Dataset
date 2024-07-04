import java.util.*;

public class Solution{
    public static void main(String as[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int tt=1;tt<=t;tt++){
            int n=sc.nextInt();
            System.out.println("Case #"+tt+":");
            if(n==501)
            for(int i=1;i<=499;i++)
            {
                if(i==3)
            System.out.println(i+" "+2);
                
            System.out.println(i+" "+i);
            }else
            for(int i=1;i<=n;i++){
            
            System.out.println(i+" "+i);
            }
        }
    }
}