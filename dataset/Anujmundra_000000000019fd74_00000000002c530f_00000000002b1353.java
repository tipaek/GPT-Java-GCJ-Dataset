import java.util.*;
public class Solution {
    public static void main(String[] args) {
     Scanner sc=new Scanner(System.in);
     int test=sc.nextInt();
     for(int i=1;i<=test;i++)
     {
         int n=sc.nextInt();
         System.out.println("Case #"+i+":");
         ArrayList<Integer>al1=new ArrayList<>();
         al1.add(1);
         al1.add(1);
             n=n-1;
             System.out.println("1 1");
             int k=2;
         if(n>0)
         {
             n=n-1;
             System.out.println("2 1");
             while(n>0)
             {
                ArrayList<Integer>al2=new ArrayList<>();
                k=k+1;
                al2.add(1);
                for(int j=0;j<al1.size()-1;j++)
                {
                    int sum=al1.get(j)+al1.get(j+1);
                    al2.add(sum);
                }
                al2.add(1);
                for(int j=0;j<al2.size();j++)
                {
                    if(n>=al2.get(j))
                    {
                        n=n-al2.get(j);
                        System.out.println(k+" "+(j+1));
                    }
                    else
                        break;
                }
                al1.clear();
                al1=(ArrayList<Integer>) al2.clone();
             }
             
         }
     }
    }
}
