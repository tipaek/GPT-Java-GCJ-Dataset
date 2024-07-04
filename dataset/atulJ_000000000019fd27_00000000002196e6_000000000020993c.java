import java.io.*;
import java.util.*;

class news
{
    public static Boolean count(int[] l)
    {
        Boolean d=true;

        for (int i = 0; i < l.length; i++) 
        {
            for (int j = 0; j < l.length; j++) 
            {
                if (l[i]==l[j] && i!=j)  
                {
                    d=false;
                    break;
                }              
            }    

            if(!d) break;
        }
        if (i==l.length) return false;
        else return true;
    }
    public static void main(String args[])
{
    Scanner in= new Scanner(System.in);
    int t=in.nextInt();
    
    for (int h = 0; h < t; h++)
    {
        int n=in.nextInt();
        int M=new int[n][n];

        String inp;

        for(int j=0;j<n;j++)
        {
            inp=in.nextLine();
            
            String ar[]= inp.split(" ");
            for (int i = 0; i < ar.length; i++) 
            {
                M[j][i]=Integer.parseInt(ar[i]);
            }   
        }

        

        int trace=0;

         for (int i = 0; i < n; i++)
         trace+=M[i][i];

         int r=0,c=0;
         for(int j = 0; j < n; j++)
        {

         for (int i = 0; i < n; i++)
         {
             if ( !count(M[i]) )
             {
                 r++;
             }
         }

         int b[]= new int[n];
        for (int k = 0; k < b.length; k++) 
        {
            b[k]= M[k][j];
        }

         for (int i = 0; i < n; i++)
         {
             //int re=m[i][ind++];

             if ( !count(b) )
             {
                 c++;
             }
         }        
        }
        System.out.println("Case #"+h+": "+trace+" "+r+" " +c);

                 
             
    }
}
}

