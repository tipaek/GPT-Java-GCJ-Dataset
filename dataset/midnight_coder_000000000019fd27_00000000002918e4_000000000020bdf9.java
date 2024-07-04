import java.util.*;
import java.io.*;
public class Solution {
    private static Scanner sc;
    static int tn=1;
    
    public static void main(String args[]) {
        
      sc = new Scanner(System.in);
      int t= sc.nextInt();
      sc.nextLine();
      while(t-- >0)
      {
          solve();
      }

    }
    
    private static void solve()
    {
        int n= sc.nextInt();
        int [][] mat= new int[n][2];
        int [][] sorted= mat.clone();
        char p='J';
        char[] chares= new char[n];
        StringBuilder ans= new StringBuilder();
        Stack<int[]> Jamie= new Stack<>();
        Stack<int[]> Cameron= new Stack<>();
        boolean impossible=false;
        Map<int[],Integer> map= new HashMap();
        
        
        for(int i=0;i<mat.length;i++)
        {
            for(int j=0;j<mat[i].length;j++)
            {
                mat[i][j]= sc.nextInt();
            }
            map.put(mat[i],i);
        }
        Arrays.sort(sorted,new Comparator<int[]>(){
         @Override
         public int compare(int[]a, int[] b)
         {
          return a[0]-b[0];
         }
        });
        
        for(int i=0;i<sorted.length;i++)
        {
            chares[map.get(sorted[i])]=p;
            if(i<sorted.length-1 && doesOverlap(sorted[i],sorted[i+1]))
            {
                if(p=='J')
                {
                    Jamie.push(sorted[i]);
                    p= getP(p);
                    
                    if(!Cameron.isEmpty() && doesOverlap(Cameron.peek(),sorted[i+1])){
                        impossible=true;
                        break;
                    }
                }
                else
                {
                    Cameron.push(sorted[i]);
                    p= getP(p);
                    if(!Jamie.isEmpty() && doesOverlap(Jamie.peek(),sorted[i+1])){
                        impossible=true;
                        break;
                    }
                }
            }
            else
            {
             if(p=='J')
                {
                    Jamie.push(sorted[i]);
                }
                else
                {
                    Cameron.push(sorted[i]);
                }   
            }
        }
        System.out.println("Case #"+(tn++)+": "+(impossible? "IMPOSSIBLE" : new String(chares)));
    }   
        
        
        private static char getP(char a)
        {
            return a=='J' ? 'C':'J';
        }
 
    private static boolean doesOverlap(int[] a,int[] b)
    {
        return a[1] > b[0];
    }
}