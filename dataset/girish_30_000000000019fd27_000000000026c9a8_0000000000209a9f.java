import java.util.*;

class Test
{
    public static void main(String [] args)
     {
         Scanner s=new Scanner(System.in);
         int t=s.nextInt();
         for(int k=1;k<=t;k++)
          {
              String str=s.next();
              int count=0,value;
              System.out.print("Case #"+String.valueOf(k)+":");
              for(int i=0;i<str.length();i++)
               {
                   temp=Integer.valueOf(str.charAt(i));
                    if(temp>count)
                     {
                         while(count<temp)
                          {
                              System.out.print("(");
                              count=count+1;
                          }
                     }
                else if(temp<count)
                  {
                      while(count>temp)
                       {
                           System.out.print(")");
                           count=count-1;
                       }
                  }
               }
              System.out.print(str.charAt(i));
          }
          while(count--)
           {
               System.out.print(")");
           }
         System.out.print("\n");  
           
     }
    
}