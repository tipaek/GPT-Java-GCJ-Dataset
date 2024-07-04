import java.util.*;

public class Main
{
    public static void sortbyColumn(int arr[][], int col) 
    { 
        Arrays.sort(arr, new Comparator<int[]>() { 
            
          @Override              
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
  
             
            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });  
    }
    
    public static void main(String arg[])
    {
        int i,j,n,t;
        int endt;
        Scanner sc=new Scanner(System.in);
        t=sc.nextInt();
        for(j=0;j<t;j++)
        {
            n=sc.nextInt();
            int sch[][]=new int[n][4];
            for(i=0;i<n;i++)
            {
                sch[i][0]=sc.nextInt();
                sch[i][1]=sc.nextInt();
                sch[i][2]=i;
                sch[i][3]=-1;
            }
            sortbyColumn(sch,0);
            endt=0;
            for(i=0;i<n;i++)
            {
                if(sch[i][3]==-1 && sch[i][0]>=endt)
                {
                    sch[i][3]=0;
                    endt=sch[i][1];
                }
            }
            endt=0;
            for(i=0;i<n;i++)
            {
                if(sch[i][3]==-1 && sch[i][0]>=endt)
                {
                    sch[i][3]=1;
                    endt=sch[i][1];
                }
                else if(sch[i][3]==-1 && sch[i][0]<endt)
                {
                    sch[i][3]=2;
                    break;
                }
            }
            for(i=0;i<n;i++)
            {
                if(sch[i][3]==2)
                    break;
            }
            if(i!=n)
            {
                System.out.println("Case #"+(j+1)+": IMPOSSIBLE");
            }
            else
            {
                String ans="";
                for(i=0;i<n;i++)
                {
                    if(sch[i][3]==0)
                    {
                        ans=ans+"C";
                    }
                    else
                    {
                        ans=ans+"J";
                    }
                }
                System.out.println("Case #"+(j+1)+": "+ans);
            }
        }
        
    }
}