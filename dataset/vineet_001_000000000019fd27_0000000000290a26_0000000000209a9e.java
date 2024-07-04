import java.util.Scanner;

public class Solution {
  public static void main(String args[]) {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
     int b = sc.nextInt();
    for (int ks = 1; ks <= T; ks++) {
      
     
     // int n = input.nextInt();
      int sum=0;
      //int arr[][]=new int[10][10];
      String str="";
      int i=0;
      int pp=1;
      int qq=10;
      while(str.length()!=b)
      {
          for(int j=pp;j<=qq;j++)
          {
                    
            System.out.println(j);
            System.out.flush();
            char a=sc.next().charAt(0);
            if(i==3 || i==7)
            {
                str+=a;
            }
          }
          if(str.length()==10)
          {
              pp=11;
              qq=20;
          }
          i++;
      }
       
      System.out.println(str);
      System.out.flush();
      char ch=sc.next().charAt(0);
      if(ch=='Y')
      continue;
      else if(ch=='N')
      System.exit(0);
      
      
      
    //   if(flag==1)
    //   count=1;
    //   else
    //   {
    //       for(int i=0;i<10;i++)
    //       {
    //           if(arr[0][i]!=arr[3][i])
    //           flag=1;
    //           else flag=0;
    //       }
    //       if(flag==1)
    //       count=
          
    //   }
    }
  }
}