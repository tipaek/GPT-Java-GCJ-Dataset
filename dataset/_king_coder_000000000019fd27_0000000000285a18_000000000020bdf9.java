import java.util.*;
public class Solution{
    private static Scanner sc;
    static int tn=1;
    public static void main(String[] args)
    {
        sc=new Scanner(System.in);
        int testCase=sc.nextInt();
        sc.nextLine();
        while(testCase--> 0)
        {
            solvefun();
        }
    }
    private static void solvefun()
    {
        int n=sc.nextInt();
        int[][] matt=new int[n][2];
        int[][] matSorted=matt.clone();
        char person='J';
        char[] chars=new char[n];
        Stack<int[]> JS=new Stack<>();
        Stack<int[]> CS=new Stack<>();
        Map<int[],Integer>map=new HashMap<>();
        boolean impossible=false;
        for(int i=0;i<matt.length;i++)
        {
            for(int j=0;j<matt[i].length;j++)
            {
                matt[i][j]=sc.nextInt();
            }
            map.put(matt[i],i);
        }
        Arrays.sort(matSorted,new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b)
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
                    JS.push(matSorted[i]);
                    person=getPerson(person);
                    if(!CS.isEmpty() && doesOverlap(CS.peek(),matSorted[i+1]))
                    {
                        impossible=true;
                        break;
                    }
                }else{
                    CS.push(matSorted[i]);
                    person=getPerson(person);
                    if(!JS.isEmpty() && doesOverlap(JS.peek(),matSorted[i+1])){
                        impossible=true;
                        break;
                    }
                }
            }else{
                if(person=='J'){
                    JS.push(matSorted[i]);
                }else{
                    CS.push(matSorted[i]);
                }
            }
        }
        System.out.println("Case #"+(tn++)+": "+(impossible ? "IMPOSSIBLE":new String(chars)));
        
    }
    
    
    private static char getPerson(char P)
    {
        return P=='J'?'C':'J';
    }
    private static boolean doesOverlap(int[]a , int[] b)
    {
        return a[1]>b[0];
    }
        
        
        
        
        
        
        
        
}