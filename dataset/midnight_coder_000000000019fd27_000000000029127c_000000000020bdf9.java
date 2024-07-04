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
        int [][] matSorted= mat.clone();
        char person='J';
        char[] chars= new char[n];
        StringBuilder sb= new StringBuilder();
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
        Arrays.sort(matSorted,new Comparator<int[]>(){
         @Override
         public int compare(int[]a, int[] b)
         {
          return a[0]-b[0];
         }
        });
        
        for(int i=0;i<matSorted.length;i++)
        {
            chars[map.get(matSorted[i])]=person;
            if(i<matSorted.length-1 && doesOverlap(matSorted[i],matSorted[i+1]))
            {
                if(person=='J')
                {
                    Jamie.push(matSorted[i]);
                    person= getPerson(person);
                    
                    if(!Cameron.isEmpty() && doesOverlap(Cameron.peek(),matSorted[i+1])){
                        impossible=true;
                        break;
                    }
                }
                else
                {
                    Cameron.push(matSorted[i]);
                    person= getPerson(person);
                    if(!Jamie.isEmpty() && doesOverlap(Jamie.peek(),matSorted[i+1])){
                        impossible=true;
                        break;
                    }
                }
            }
            else
            {
             if(person=='J')
                {
                    Jamie.push(matSorted[i]);
                }
                else
                {
                    Cameron.push(matSorted[i]);
                }   
            }
        }
        System.out.println("Case #"+(tn++)+": "+(impossible? "IMPOSSIBLE" : new String(chars)));
    }   
        
        
        private static char getPerson(char p)
        {
            return p=='J' ? 'C':'J';
        }
 
    private static boolean doesOverlap(int[] a,int[] b)
    {
        return a[1] > b[0];
    }
}