import java.util.*;
public class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
            int n=sc.nextInt(),k=sc.nextInt(),j=1;
            for(j=1;j<=n;j++)
                if(j*n==k)
                break;
            if(j==n+1){
                System.out.println("Case #"+i+": POSSIBLE");
                return;
            }
            System.out.println("Case #"+i+": POSSIBLE");
            ArrayList<Integer>arr=new ArrayList<>();
            for(int h=1;h<=n;h++)
                if(h!=j)
                    arr.add(h);
            int loop=n-1;
            while(loop>=0){
                int start=loop%(n-1);
                for(int h=0;h<n-1;h++){
                    start=(start>=n-1)?start%(n-1):start;
                    if(start==0&&loop!=0)
                        System.out.print(j+" ");
                    System.out.print(arr.get(start++)+" ");
                }
                if(loop==0)
                System.out.print(j+" ");
                System.out.println();
                loop--;
            }
        }
    }
}