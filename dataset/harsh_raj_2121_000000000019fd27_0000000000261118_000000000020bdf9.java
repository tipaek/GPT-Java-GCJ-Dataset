import java.util.*;
class Solution
{
    public static void main(String args[] )  {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),j=0,i,i1,k,k1=0,m,min=24*60,l=0,m1=0,f=0,t=0;
   String s="";     
        for(k=0;k<n;k++)
        {s="";t=0;min=1441;l=0;f=0;
            j=sc.nextInt();k1=0;
            int a[][]=new int[j][2];
            //int b[]=new int[j];
            char a1[]=new char[j];
            for(i=0;i<j;i++)
            {
                for(m=0;m<2;m++)
                a[i][m]=sc.nextInt();
                if(a[i][0]<=min)
                {min=a[i][0];l=i;}}
              //b[k1]=a[i][0];//k1++}
             a1[l]='C';
            //sort(b);
            a[l][0]=-1;t++;
            for(k1=0;k1<1;k1++)
            {
               for(i=1;i<=j;i++)
               {min=1441;
                  m1=a[l][1];a[l][1]=-1; 
                   for(i1=0;i1<j;i1++)
                   {
                       if(a[i1][0]>=m1)
                       {
                           if(a[i1][0]<=min)
                           {min=a[i1][0];
                           l=i1;}}
                       //else
                       //f=1;
                         }//i1
                         if(a1[l]=='\0')
                         {a1[l]='C';t++;a[l][0]=-1;}
                         //if(f==1)
                         //break;
                }//i inside
            }//k1
            f=0;min=1441;
            if(t<j)
            {
            for(i=0;i<j;i++)
            {
                if(a[i][0]<min&&a[i][0]>=0)
                {min=a[i][0];l=i;}}
                
            
                
                
                
                a1[l]='J';
            //sort(b);
            a[l][0]=-1;t++;
            for(k1=0;k1<1;k1++)
            {
               for(i=1;i<=j;i++)
               {
                  m1=a[l][1];a[l][1]=-1; min=1441;
                   for(i1=0;i1<j;i1++)
                   {
                       if(a[i1][0]>=m1)
                       {
                            if(a[i1][0]<=min)
                           {min=a[i1][0];
                           l=i1;}}
                           
                           
                       //else
                       //f=1;
                         }//i1
                        // if(f==1)
                        // break;
                        if(a1[l]=='\0'){
                        a1[l]='J';t++;a[l][0]=-1;}
                }//i inside
            }//k1
            
            
            
            
            
            
            
            
            
            
            
            
            
            
        }//t if
        if(t==j){
            for(i=0;i<j;i++)
            s=s+a1[i];
            
            System.out.println("Case #"+(k+1)+": "+s);}
            else
            System.out.println("Case #"+(k+1)+": "+"IMPOSSIBLE");
        }//n
    }}