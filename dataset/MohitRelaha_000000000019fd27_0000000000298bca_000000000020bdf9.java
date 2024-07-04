import java.util.*;
public class Solution{
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t;
        t = sc.nextInt();
        for(int i = 0; i<t; i++)
        {
            int n = sc.nextInt();
            int start[] = new int[n];
            int end[] = new int[n];
            int max = Integer.MIN_VALUE;
            for(int j = 0; j<n ; j++)
            {
                start[j] = sc.nextInt();
                end[j] = sc.nextInt();
                if( end[j] > max )
                max = end[j];
            }
            int arr[] = new int[max+1];
            for(int j = 0; j<=max ; j++)
            {
                arr[j] = 0;
            }
            for(int j = 0; j<n ; j++)
            {
                arr[start[j]]++;
                arr[end[j]]--;
            }
            
            int prev=0,flag=0;
            for(int j = 0;j<=max;j++){
                if(prev + arr[j] > 2){
                    flag = 1;
                    break;
                }
                arr[j] += prev;
                prev = arr[j];
            }
            if(flag == 1)
                {
                    System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
                    continue;
                }
            
            int myarr[][] = new int[2][2];
            myarr[0][0] = myarr[0][1] = myarr[1][0] = myarr[1][1] = 0;
            String s="", turn="C";
            for(int j=0;j<n;j++){
                int st = start[j];
                int en = end[j];
                
                if( (myarr[0][0] >= st && myarr[0][0] >= en ) || (myarr[0][1] <= st && myarr[0][1] <= en )  )
                {
                    myarr[0][0] = st;
                    myarr[0][1] = en;
                    s = s + "C" ;
                }
                else
                {
                    myarr[1][0] = st;
                    myarr[1][1] = en;
                    s = s + "J" ;
                }
                
            }
            
            
            System.out.println("Case #"+(i+1)+": "+s);
            
        }
    }
}