import java.util.*;
class Solution{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int p=0;p<t;p++)
        {
        
        int n = sc.nextInt();
        int arr[][] = new int[n][n];
        
        for(int i=0;i<n;i++)
            for(int j=0;j<n;j++)
                arr[i][j] = sc.nextInt();
        
        int k = 0;
        for(int i=0;i<n;i++)
            k += arr[i][i];
        
        HashSet<Integer> ele = new HashSet<>();
        int r = 0, c = 0; 
        for(int i=0;i<n;i++)
        {
            ele.clear();
            for(int j=0;j<n;j++)
            {
                if(!ele.contains(arr[i][j]))
                    ele.add(arr[i][j]);
                else{
                    r++;
                    ele.clear();
                    break;
                }
            }
        }
        
        for(int i=0;i<n;i++)
        {
            ele.clear();
            for(int j=0;j<n;j++)
            {
                if(!ele.contains(arr[j][i]))
                    ele.add(arr[j][i]);
                else{
                    c++;
                    ele.clear();
                    break;
                }
            }
        }
        System.out.println("Case #"+(p+1)+": "+k+" "+r+" "+c);
        }
    }  
}