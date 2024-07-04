import java.util.Scanner;
public class Solution{
   static int factorial(int n) {
      int f;

      for(f = 1; n > 1; n--){
         f *= n;
      }
      return f;
   }
   static int ncr(int n,int r) {
      return factorial(n) / ( factorial(n-r) * factorial(r) );
   }
   public static void main(String args[]){
	   int t;
       Scanner sc=new Scanner(System.in);
       int sum,sum1;
       t=sc.nextInt();
	   for(int d=0;d<t;d++)
	   {   sum1=sc.nextInt();
	   System.out.println("Case #"+(d+1));
      int n, i, j;
      n = 4;
      sum=sum1-1;
	  
      for(i = 0; i <= n;) {
         for(j = 0; j <= n-i; j++){
            //System.out.print(" ");
         }
         for(j = 0; j <= i; j++){
            //System.out.print(" "+ncr(i, j));
            if(sum==0)
            {
                System.out.println(i+1+" "+(j+1));
                i=100;
                j=100;
               
            }
            else if(sum==ncr(i+1,j+1))
            {
                if(i!=j)
                {System.out.println(i+1+" "+(j+1));
                System.out.println(i+2+" "+(j+2));
                i=20;
                j=20;
                }
                else
                {
                    System.out.println(i+1+" "+(j+1));
                    System.out.println(i+" "+(j)); 
                    i=20;
                j=20;
                }
            }
            else if(sum>ncr(i+1,j+1))
            {
                if((i+1)%2==0)
                {
                    j=i+1/2;
                    System.out.println(i+1+" "+(j));
                    sum=sum-ncr(i,j-1);
                    i++;
                }
                else
                {
                    j=i/2;
                    System.out.println(i+1+" "+(j+1));
                    sum=sum-ncr(i,j);
                    if(i!=4)
                        i++;
                    else
                    {
                        System.out.println(i+1+" "+(i-j));
                        sum=sum-ncr(i,j+1);
                        if(j+1==i)
                        {i--;
                         j--;
                        }
                    }
                }
            }
            
         }
      } 
   }
   }
}
