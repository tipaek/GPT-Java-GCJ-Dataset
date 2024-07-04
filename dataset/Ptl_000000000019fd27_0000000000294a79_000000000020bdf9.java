import java.util.*;

public class Solution
{
    public static void main(String [] args){
        Scanner kb=new Scanner(System.in);
        int t=kb.nextInt();
        for(int i=1;i<=t;i++)
        {
            int n=kb.nextInt();
            int [][] mat1=new int[n][2];
            int [][] mat2=mat1.clone();
            char p='J';
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
                public int compare(int[] a, int[] b){
                    return a[0]-b[0];
                }
            });
            
            for(int j=0;j<mat2.length;j++)
            {
                arr[map1.get(mat2[j])]=p;
                
                if(j<mat2.length-1&&doesOverlap(mat2[j],mat2[j+1])){
                    if (p=='J'){
                        JStack.push(mat2[i]);
                        p=getPerson(p);
                        
                        if(!CStack.isEmpty()&&doesOverlap(CStack.peek(),mat2[j+1])){
                            imp=true;
                            break;
                        }
                    } else {
                        CStack.push(mat2[j]);
                        p=getPerson(p);
                        
                        if(!JStack.isEmpty()&&doesOverlap(JStack.peek(),mat2[j+1])){
                            imp=true;
                            break;
                        }
                    }
                } else {
                    if(p=='J'){
                        JStack.push(mat2[j]);
                        
                    }else {
                        CStack.push(mat2[j]);
                    }
                }
            }
            System.out.println("Case #" + (t) + ": " + (imp? "IMPOSSIBLE" : new String(arr)));
            
        }
        
        
    }
    private static boolean doesOverlap(int[] a, int[] b){
        return a[1]>b[0];
    }
    
    private static char getPerson(char q)
    {
        return q=='J'?'C':'J';
    }
}
    