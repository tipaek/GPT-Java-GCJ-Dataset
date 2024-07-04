import java.util.*;
import javax.swing.text.html.CSS;
public class Solution
{
    public static void main(String [] args){
        Scanner kb=new Scanner(System.in);
        int t=kb.nextInt();
        for(int y=1;y<=t;y++)
        {
            int n=kb.nextInt();
            int [][] mat1=new int[n][2];
            int [][] mat2=mat1.clone();
            char paa='J';
            char[] arr=new char[n];
            Stack<int[]> JStack=new Stack<>();
            Stack<int[]> CStack=new Stack<>();
            boolean imp=false;
            
            Map<int[], Integer> map1=new HashMap<>();
            
            for(int j=0; j<mat1.length; j++)
            {
                for(int k=0;k<mat1[j].length;k++)
                {
                    mat1[j][k]=kb.nextInt();
                }
                map1.put(mat1[j],j);
            }
            
            Arrays.sort(mat2, new Comparator<int[]>(){
                @Override
                public int compare(int[] Aa, int[] Bb){
                    return Aa[0]-Bb[0];
                }
            });
            
            for(int j=0;j<mat2.length;j++)
            {
                arr[map1.get(mat2[j])]=paa;
                
                if(j<(mat2.length)-1 && doesOverlap(mat2[j],mat2[j+1])){
                    if (paa=='J'){
                        JStack.push(mat2[j]);
                        paa=getPerson(paa);
                        
                        if(!CStack.isEmpty() && doesOverlap(CStack.peek(),mat2[j+1])){
                            imp=true;
                            break;
                        }
                    } else {
                        CStack.push(mat2[j]);
                        paa=getPerson(paa);
                        
                        if(!JStack.isEmpty() && doesOverlap(JStack.peek(),mat2[j+1])){
                            imp=true;
                            break;
                        }
                    }
                } else {
                    if(paa=='J'){
                        JStack.push(mat2[j]);
                        
                    }else {
                        CStack.push(mat2[j]);
                    }
                }
            }
            System.out.println("Case #" + (y) + ": " + (imp? "IMPOSSIBLE" : new String(arr)));
            
        }
        
        
    }
    private static boolean doesOverlap(int[] Aa, int[] Bb){
        return Aa[1]>Bb[0];
    }
    
    private static char getPerson(char q)
    {
        return q=='J'?'C':'J';
    }
}