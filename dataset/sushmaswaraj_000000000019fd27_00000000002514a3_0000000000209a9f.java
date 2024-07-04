import java.util.*;
class Main
{
    public static void main(String args[])
    {
    Scanner sc=new Scanner(System.in);
    int t=sc.nextInt();
    while(t-->0){
     String str=sc.nextLine();
     int len=str.length();
     for(int i=0;i<len;i++)
     {
         while(i++<len)
         {
           if(str.charAt(i).equals("1"))
           {
            System.out.print("("+str.charAt(i));
            if(str.charAt(i++).equals("1")){
             System.out.print(str.charAt(i));
             i++;
            }
            }else
            {
              System.out.print(str);
            }
           }
      System.out.println();
    }
   }
  }
}