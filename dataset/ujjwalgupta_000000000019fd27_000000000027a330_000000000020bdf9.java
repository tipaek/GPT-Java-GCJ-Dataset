import javax.swing.text.html.CSS;
import java.util.*;
public class Solution 
{ 
    private static Scanner sc;
    static int test=1;
    
    public static void main(String args[])
    {
        sc=new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine();
        
        while(t-- > 0)
        {
            solve();
        }
    }
    
    private static void solve()
    {
        int n=sc.nextInt();
        int mat[][]=new int[n][2];
        int mSorted[][]= mat.clone();
        char prsn='J';
        boolean notpossible=false;
        char[] chars = new char[n];
        Stack<int[]> JS=new Stack<>();
        Stack<int[]> CS=new Stack<>();
        
        Map<int[],Integer> m= new HashMap<>();
        
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[i].length;j++)
            {
                mat[i][j]=sc.nextInt();
            }
            m.put(mat[i],i);
        }
        
        Arrays.sort(mSorted,new Comparator<int[]>()
        {
            @Override
            public int compare(int[] a,int[] b)
            {
                return a[0]-b[0];
            }
        });
        
        for(int i=0;i<mSorted.length;i++)
        {
            chars[m.get(mSorted[i])] = prsn;
            
            if(i<mSorted.length-1 && doesOverlap(mSorted[i],mSorted[i+1]))
            {
                if(prsn=='J')
                {
                    JS.push(mSorted[i]);
                    prsn=getPerson(prsn);
                    
                    if(!CS.isEmpty() && doesOverlap(CS.peek(),mSorted[i+1]))
                    {
                        notpossible=true;
                        break;
                    }
                }
                else
                {
                    CS.push(mSorted[i]);
                    prsn=getPerson(prsn);
                    
                    if(!JS.isEmpty() && doesOverlap(JS.peek(),mSorted[i+1]))
                    {
                        notpossible=true;
                        break;
                    }
                }
            }
            else
            {
                if(prsn=='J')
                JS.push(mSorted[i]);
                else
                CS.push(mSorted[i]);
            }
        }
    System.out.println("Case #" + (test++) + ": " + (notpossible ? "IMPOSSIBLE" : new String(chars)));
    }

    private static char getPerson(char p)
    {
        return p == 'J'? 'C' : 'J';
    }

    private static boolean doesOverlap(int[] a,int[] b)
    {
        return a[1]>b[0];
    }
}