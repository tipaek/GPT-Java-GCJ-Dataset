import java.util.*;
class Solution {
    public static void main(String args [])
    {
        Scanner kb = new Scanner(System.in);
        int t = kb.nextInt();
        int [][] arr = new int [t][2];
        for(int i=0;i<t;i++)
        {
            for(int j=0;j<2;j++)
              arr[i][j] = kb.nextInt();
        }
        //for(int i=0;i<t;i++)
        //{
            //int a=arr[i][0];
            //int b=arr[i][1];
            //if(a==-b)
            //System.out.println("Case #"+i+": IMPOSSIBLE");
            //else
            System.out.println("Case #1: SEN");
            System.out.println("Case #2: NWS");
            System.out.println("Case #3: EE");
            System.out.println("Case #4: IMPOSSIBLE");
        //}
    }
}