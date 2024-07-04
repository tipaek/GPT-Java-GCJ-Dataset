import java.util.*;

public class Solution{
    public static void main(String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int cases = sc.nextInt();

        for(int x=1;x<=cases;x++)
        {   
            int sum=0, row=0, col=0;
            int t = sc.nextInt();
            int [][] arr = new int[t][t];
            
            for(int i=0;i<t;i++)
            {
                for(int j=0;j<t;j++)
                {
                    arr[i][j] = sc.nextInt();
                }
            }
            for(int i=0;i<t;i++)
            {
                for(int j=0;j<t;j++)
                {
                    if(i==j) sum+=arr[i][j];
                }
            }

            for(int i=0;i<t;i++)
            {
                int ans[] = new int[t+1];
                for(int j=0;j<t;j++)
                {
                    ans[arr[i][j]]++;

                }
    
                for(int k =1;k<=t;k++){
                    if(ans[k]!=1) {
                        row++;
                        break;
                    }
                }
            }
            
            for(int j=0;j<t;j++)
            {
                int [] ansc = new int[t+1];
                for(int i=0;i<t;i++)
                {
                    ansc[arr[i][j]]++;
                }
                for(int k =1;k<=t;k++){
                    if(ansc[k]!=1) {
                        col++;
                        break;
                    }
                }
            }
            System.out.println("Case #" +x +": " +sum + " " + row +" "+col);
        }
        
    }
}