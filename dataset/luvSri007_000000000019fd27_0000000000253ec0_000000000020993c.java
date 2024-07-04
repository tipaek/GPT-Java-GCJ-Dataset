import java.util.Scanner;
import java.util.*;
 class newgrg 
 {
    public static void main(String[] args)
    {
     Scanner inpt= new Scanner(System.in);
     int testcase=inpt.nextInt();
   int t=1;
     String out="";
     while(t<=testcase)
     {
         int i = 0,j=0;
        int dc=0;int dr=0;
           int chk=0;      
         int n=inpt.nextInt();
         int arrt[][]=new int[n+1][n];
         int arr[][]=new int[n][n];
         int trace = 0;
        String s="";
         for(int ki=0;ki<=n;++ki)
           {
              s=inpt.nextLine();
             for(int l=0;l<s.length();l++)
             {
                char ch=s.charAt(l);
                 if(Character.isDigit(ch))
                 {
                     arrt[i][j]=Integer.valueOf(Character.toString(ch));
                     ++j;
                 }
             }

             s="";
             j=0;
             ++i;
           }
            i=0;j=0;
            for(int h=1;h<=n;h++)
         {
             for(int u=0;u<n;u++)
             {
                 arr[i][j]=arrt[h][u];
                  ++j;
             }
             j=0;++i;
        }
        
         //checking double rows
         String d="";
         for(int b=0;b<n;b++)
         {
             boolean tu=false;
             for(int a=0;a<n;a++)
             {
                 //checking repeatted digits in single row
                 d=d+Integer.toString(arr[b][a]);
             }
             for(int q=0;q<d.length();q++)
                 {
                     char g=d.charAt(q);
                     for(int y=0;y<d.length();y++)
                     {
                     if(d.charAt(y)==g&&q!=y)
                         {
                             tu=true;
                         }
                        
                     }
                 }
                 if(tu)
                 {++dr;}
                 d="";
         }
         d="";
         
         for(int b=0;b<n;b++)
         {
             boolean tu=false;
             for(int a=0;a<n;a++)
             {
                 //checking repeatted digits in single row
                 d=d+Integer.toString(arr[a][b]);
             }
             
             for(int q=0;q<d.length();q++)
                 {
                     char g=d.charAt(q);
                     for(int y=0;y<d.length();y++)
                     {
                         if(d.charAt(y)==g&&q!=y)
                         {
                             tu=true;
                         }
                     }
                 }
                 if(tu)
                 {++dc;}
                 d="";
         }
        for(int li=0;li<n;li++)
         {
             trace=trace+arr[li][li];
         }
         out=out+"case #"+t+": "+trace+" "+dr+" "+dc+"\n";
         
         ++t;
     }
     System.out.println(out);
    }
    
}
