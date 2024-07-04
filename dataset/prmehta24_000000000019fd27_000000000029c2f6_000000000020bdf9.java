import java.util.*; 
class Solution
{
    public static void sortbyColumn(int arr[][], int col) 
    { 
        // Using built-in sort function Arrays.sort 
        Arrays.sort(arr, new Comparator<int[]>() { 
            
          @Override              
          // Compare values according to columns 
          public int compare(final int[] entry1,  
                             final int[] entry2) { 
  
            // To sort in descending order revert  
            // the '>' Operator 
            if (entry1[col] > entry2[col]) 
                return 1; 
            else
                return -1; 
          } 
        });  // End of function call sort(). 
    }
    public static void main(String args[])
    {
        Scanner Sc=new Scanner(System.in);
        int tests = Sc.nextInt();
        for(int i=0;i<tests;i++)
        {
            int N=Sc.nextInt();
            int activities[][]= new int[N][4];
            for(int j=0;j<N;j++)
            {
                activities[j][0]=Sc.nextInt();
                activities[j][1]=Sc.nextInt();
                activities[j][2]=j;
                
                
            }
            sortbyColumn(activities, 0);
            String solution="";
            int impossible=0;
            int c_busy_until=0;
            int j_busy_until=0;
            for(int j=0;j<N;j++)
            {
                int activitystart=activities[j][0];
                if(c_busy_until<=activitystart)
                {
                    activities[j][3]=0;
                    c_busy_until=activities[j][1];
                }
                else if(j_busy_until<=activitystart)
                {
                    activities[j][3]=1;
                    j_busy_until=activities[j][1];
                }
                else
                {
                    impossible=1;
                    break;
                }
                
            }
            if(impossible==1)
            {
                System.out.println("Case #"+(i+1)+": IMPOSSIBLE");  
            }
            else
            {
                sortbyColumn(activities, 2);
                for(int j=0;j<N;j++)
                {   
                    int personassigned=activities[j][3];
                    if(personassigned==0)
                    {
                        solution=solution+"C";
                    }
                    else
                    {
                       solution=solution+"J"; 
                    }
                }
                System.out.println("Case #"+(i+1)+": "+solution);
            }
            
        }
    }
}