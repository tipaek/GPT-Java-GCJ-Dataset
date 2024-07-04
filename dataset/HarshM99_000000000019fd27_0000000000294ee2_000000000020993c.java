import java.util.*;
public class Solution
{
    public static String getAnswer(int n,int mat[][],int case_no)
    {
        int row = 0,col=0,tr=0; 
        for (int i = 0; i < n; i++) 
        { 
            tr += mat[i][i];
            HashMap<Integer,Integer> hm = new HashMap<>(); 
            for (int j = 0; j < n; j++) 
            { 
                if(hm.containsKey(mat[i][j]))
                {
                    row++;
                    break;
                }
                else
                {
                    hm.put(mat[i][j],1);
                }
            }
        }
        for (int i = 0; i < n; i++) 
        { 
            HashMap<Integer,Integer> hm = new HashMap<>(); 
            for (int j = 0; j < n; j++) 
            { 
                if(hm.containsKey(mat[j][i]))
                {
                    col++;
                    break;
                }
                else
                {
                    hm.put(mat[j][i],1);
                }
            } 
        }
        return ("Case #"+case_no+": "+tr+" "+row+" "+col);
    }
    public static void main(String args[])
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int x = t;String ans ="";
        while(t!=0)
        {
            int n = sc.nextInt();
            int mat[][] = new int[n][n];
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    mat[i][j] = sc.nextInt();
                }
            }
            ans += getAnswer(n,mat,(x-t+1))+"\n";
            t--;
        } 
        System.out.print(ans);
    }
}