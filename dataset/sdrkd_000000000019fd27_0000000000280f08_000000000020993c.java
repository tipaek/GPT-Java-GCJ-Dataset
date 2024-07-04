import java.util.*;
class Vestigium
{public static int ap(int n)
{
    return (n*(n+1))/2;
}
    public static void main(String args[])throws Exception
{int t,n,i,j,k,tr=0,r=0,c=0,s=0;
Scanner sc=new Scanner(System.in);
    t=sc.nextInt();
    ArrayList<Integer> list1=new ArrayList<Integer>(t);
     ArrayList<Integer> list2=new ArrayList<Integer>(t);
      ArrayList<Integer> list3=new ArrayList<Integer>(t);
    k=t;
    while(t-->0)
    {tr=0;r=0;c=0;
       n=sc.nextInt(); 
       int m[][]=new int[n][n];
       for(i=0;i<n;i++)
       {s=0;
           for(j=0;j<n;j++)
           {
               m[i][j]=sc.nextInt();
               s+=m[i][j];
             if(i==j)
               tr+=m[i][j];
           }
           if(s!=ap(n))
           r++;
           
       }
       for(i=0;i<n;i++)
       {s=0;
           for(j=0;j<n;j++)
           {
           
               s+=m[j][i];
         
           }
           if(s!=ap(n))
           c++;
           
       }
      
      list1.add(tr);
           list2.add(r);
           list3.add(c); 
    }
     for(i=0;i<k;i++)
       
       System.out.println("Case #"+(i+1)+": "+list1.get(i)+" "+list2.get(i)+" "+list3.get(i));
}
}