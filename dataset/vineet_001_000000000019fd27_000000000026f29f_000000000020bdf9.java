
import java.util.*; 
class Solution{ 
  
 
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
      
 
    public static void main(String args[]) 
    { 
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int aa=1;aa<=t;aa++)
        {
            int n=sc.nextInt();
            int ar1[][]=new int[n][2];
            int ar2[][]=new int[n][2];
            int arr[]=new int[1441];
            for(int x=0;x<n;x++)
            {
                for(int y=0;y<2;y++)
                {
                    ar1[x][y]=sc.nextInt();
                    ar2[x][y]=ar1[x][y];
                }
            }
            sortbyColumn(ar2,1); 
            for(int i=0;i<n-1;i++)
            {
                    if(ar2[i][1]==ar2[i+1][1])
                    {
                        if(ar2[i][0]>ar2[i+1][0])
                        {
                            int temp=ar2[i][0];
                            ar2[i][0]=ar2[i+1][0];
                            ar2[i+1][0]=temp;
                        }
                        
                    }
                
            }
            for(int x=0;x<n;x++)
            {
                for(int y=0;y<2;y++)
                {
                    //System.out.print(ar2[x][y]);
                    if(y==0)
                    arr[ar2[x][y]]++;
                    else arr[ar2[x][y]]--;
                }
            }
            int flag=0;
            int sum=0;
            for(int i=0;i<1440;i++)
            {
               sum+=arr[i];
               if(sum>2 || sum<-2)
               {
               flag=1;
               break;
               }
            }
            String str="";
            if(flag==1)
            str="IMPOSSIBLE";
            else 
            {
                String a[][]=new String[1441][1441]; 
                String temp1="C";
                String temp2="J";
                int endtime=ar2[0][1];
                a[ar2[0][0]][ar2[0][1]]=temp1;
                 for(int i=1;i<n;i++)
                 {
                    // System.out.println(ar2[i][0]+ "  "+ar2[i][1]);
                     if(ar2[i][0]>=endtime)
                     {
                     
                   a[ar2[i][0]][ar2[i][1]]=temp1;
                     
                     endtime=ar2[i][1];
                     }
                     else
                     {
                        a[ar2[i][0]][ar2[i][1]]=temp2;                  
                        }
                 }
                 
                 for(int x=0;x<n;x++)
                 {
                    str+= a[ar1[x][0]][ar1[x][1]];
                    if(a[ar1[x][0]][ar1[x][1]].equals("C")==true)
                    a[ar1[x][0]][ar1[x][1]]="J";
                    else a[ar1[x][0]][ar1[x][1]]="C";
                 }
                
            }
            System.out.println("Case #"+aa+": "+str);
           
    } 
}
}

