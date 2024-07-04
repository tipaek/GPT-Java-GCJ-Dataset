import java.util.*;
import java.util.List;
class Vestigium
{
    public static void main(String args[])
    {
        Scanner kb=new Scanner(System.in);
        int tc=kb.nextInt();
        for(int i=1;i<=tc;i++)
        {
            int n=kb.nextInt();
            kb.nextLine();
            int [][] arr=new int[n][n];
            for(int j=0;j<n;j++)
            {
              String []str=kb.nextLine().split(" ");
              for(int k=0;k<n;k++)
               arr[j][k]=Integer.parseInt(str[k]);
            }
            int sum=0;
            for(int l=0;l<n;l++)
            {
                for(int m=0;m<n;m++)
                {
                    if(l==m)
                     sum=sum+arr[l][m];
                }
            }
            int row=0;
            for(int w=0;w<n;w++) 
             {
                int count=0;
                 ArrayList<Integer> list;
                  for(int x=0;x<n;x++)
                 {
                    list=new ArrayList<Integer>();
                    list.add(arr[w][x]);
                    if(list.contains(arr[w][x]))
                        count++;
                     
                 }
                 
                if(count>0)
                 row++;
             }
             int column=0;
             for(int y=0;y<n;y++)
             {
                
                 int count=0;
                   ArrayList<Integer> list;
                 for(int z=0;z<n;z++)
                 {
                   
                    list =new ArrayList<Integer>();
                    
                    list.add(arr[z][y]);
                    if(list.contains(arr[z][y]))
                        count++;
                 }
                 if(count>0)
                  column++;
             }
            System.out.println("Case #"+i+": "+sum+" "+row+" "+column);
        }
    }
}