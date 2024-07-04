import java.util.*;
public class Solution{
    
    public static void sortbyColumn(int arr[][], int col) 
    {  
        Arrays.sort(arr, new Comparator<int[]>() { 
          public int compare(final int[] entry1,  
                             final int[] entry2) { 

            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });
    }
    
    public static void main(String args[])
    {
    Scanner sc = new Scanner(System.in);
    int  t=sc.nextInt();
    for(int  z=0;z<t;z++)
    {
       Integer  n=sc.nextInt(); 
       boolean flag=true;
       int a[][]=new int [n][3];
       for(int  i=0,m=0;i<n;i++,m++)
       {
           a[i][0]=sc.nextInt();
           a[i][1]=sc.nextInt();
           a[i][2]=m;
       }
       ArrayList<Integer> js=new ArrayList<>();
       ArrayList<Integer> je=new ArrayList<>();
       ArrayList<Integer> cs=new ArrayList<>();
       ArrayList<Integer> ce=new ArrayList<>();
       
       sortbyColumn(a,0);
       int temp;
       for(int i=1;i<n;i++)
       {
           if(a[i][0]==a[i-1][0])
           {
               if(a[i-1][1]>a[i][1])
               {
                   temp=a[i][1];
                   a[i][1]=a[i-1][1];
                   a[i-1][1]=temp;
                   
                   temp=a[i][0];
                   a[i][0]=a[i-1][0];
                   a[i-1][0]=temp;
                   
                   temp=a[i][2];
                   a[i][2]=a[i-1][2];
                   a[i-1][2]=temp;
                   
               }
           }
       }
       int y=z+1;
       System.out.print("Case #"+y+": ");
       char r[]=new char[n];
       for(int  i=0;i<n;i++)
       {
           if(js.isEmpty()==true)
           {
               js.add(a[i][0]);
               je.add(a[i][1]);
               r[a[i][2]]='J';
           }
           else if(a[i][0]>=je.get(js.size()-1))
           {
               js.add(a[i][0]);
               je.add(a[i][1]);
               r[a[i][2]]='J';
           }
           else if(cs.isEmpty()==true)
           {
               cs.add(a[i][0]);
               ce.add(a[i][1]);
               r[a[i][2]]='C';
           }
           else if(a[i][0]>=ce.get(js.size()-1))
           {
               cs.add(a[i][0]);
               ce.add(a[i][1]);
               r[a[i][2]]='C';
           }
           else
           {
           System.out.print("IMPOSSIBLE\n");
           flag=false;
           break;
           }
               
       }
       if(flag==true)
       {
       for(int  i=0;i<r.length;i++)
       {
           System.out.print(r[i]);
       }
       System.out.println();
       }
    }
    
    }
}