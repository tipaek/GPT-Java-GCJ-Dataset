import java.util.*;

public class Solution{
    public static void main(String as[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int tt=1;tt<=t;tt++){
            int n=sc.nextInt();
            System.out.println("Case #"+tt+":");
            if(n>997){
                for(int i=1;i<=498;i++)
                {
                    if(n-994==i)
                System.out.println(i+" "+(i-1));
                    if(498==i)
                System.out.println(i+" "+(i-1));
                    
                System.out.println(i+" "+i);
                }
            }
            else if(n>500)
            for(int i=1;i<=499;i++)
            {
                if(n-499+1==i)
            System.out.println(i+" "+(i-1));
                
            System.out.println(i+" "+i);
            }else
            for(int i=1;i<=n;i++){
            
            System.out.println(i+" "+i);
            }
        }
    }
}