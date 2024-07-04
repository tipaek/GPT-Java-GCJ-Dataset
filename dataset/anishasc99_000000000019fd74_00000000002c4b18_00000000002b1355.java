import java.util.*;
public class Solution{
    public static boolean check(int[][]arr,int i,int j)
    {
        int i1=i-1,j1=j-1;
        while(i1>=0)
        {
            if(arr[i1][j]==-1)
            {
            i1--;
            continue;
            }
            if(arr[i1][j]>arr[i][j])
            return false;
            else
            break;
        }
        i1=i+1;
        while(i1<arr.length)
        {
            if(arr[i1][j]==-1)
            {
                i1++;
            continue;
            }
            if(arr[i1][j]>arr[i][j])
            return false;
            else
            break;
        }
        while(j1>=0)
        {
            if(arr[i][j1]==-1)
            {
                j1--;
            continue;
            }
            if(arr[i][j1]>arr[i][j])
            return false;
            else
            break;
            
        }
        j1=j+1;
        while(j1<arr[0].length)
        {
            if(arr[i][j1]==-1)
            {
            j1++;
            continue;
            }
            
            if(arr[i][j1]>arr[i][j])
            return false;
            else
            break;
        }
        return true;
        
    }
     public static void main(String []args){
         Scanner sc=new Scanner(System.in);
         int t=sc.nextInt();
         int m=1;
         while(t>0)
         {
             int r=sc.nextInt();
             int c=sc.nextInt();
             int[][]a=new int[r][c];
             int skill=0;
             for (int i=0;i<r;i++)
             {
                 for(int j=0;j<c;j++)
                 {
                     a[i][j]=sc.nextInt();
                     skill+=a[i][j];
                 }
             }
             int no=r*c;
             int prev=0;
             while(no>1)
             {
              no=0;
              int k=0;
              int[][]b=new int[r*c][2];
              int sum=0;
              for (int i=0;i<r;i++)
             {
                 for(int j=0;j<c;j++)
                 {
                     if(check(a,i,j))
                     {
                         skill+=a[i][j];
                         sum+=a[i][j];
                         no++;
                     }
                     else
                     {
                         b[k][0]=i;
                         b[k][1]=j;
                         k++;
                         
                     }
                     //System.out.print(a[i][j]+" ");
                     
                 }
                 //System.out.println();
             }
                 
    
       for (int i=0;i<k;i++)
       {
           //System.out.println("b[0]:"+b[i][0]+"b[1]:"+b[i][1]);
           a[b[i][0]][b[i][1]]=-1;
       }
       if(no==prev)
       {
           skill-=sum;
       break;
       }
       else
       {
           prev=no; 
       }  
             }
        System.out.println("Case #"+m+": "+skill);
             
             t--;
             m++;
         }
     }
}