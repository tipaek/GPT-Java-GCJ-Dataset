import java.util.*;
public class Solution
{
    private static Scanner sc;
    static int tn=1;
    public static void main(String args[])
    {
    
        sc=new Scanner(System.in);
        int te=sc.nextInt();
        sc.nextLine();
        while(te-->0)
        {
            solve();
        }
    }
    public static void solve()
    {
       int ne=sc.nextInt();
        int kmat[][]=new int[ne][2];
        int kmatSorted[][]=kmat.clone();
        char person='J';
        char chars[]=new char[ne];
        Stack<int[]> JStack=new Stack<>();
        Stack<int[]> CStack=new Stack<>();
        boolean impossible=false;
        Map<int[],Integer> map=new HashMap<>();
        for(int i=0;i<kmat.length;i++)
        {
            for(int j=0;j<kmat[i].length;j++)
            {
                kmat[i][j]=sc.nextInt();
            }
            map.put(kmat[i],i);
        }
        Arrays.sort(kmatSorted,new Comparator<int[]>(){
            @Override
            public int compare(int a[],int b[])
            {
                return a[0]-b[0];
            }
        });
        for(int i=0;i<kmatSorted.length;i++)
        {
            chars[map.get(kmatSorted[i])]=person;
            if(i< kmatSorted.length-1 && doesOverlap(kmatSorted[i],kmatSorted[i+1]))
            {
                if(person=='J')
                {
                    JStack.push(kmatSorted[i]);
                    person=getPerson(person);
                    if(!CStack.isEmpty() && doesOverlap(CStack.peek(),kmatSorted[i+1]))
                    {
                        impossible=true;
                        break;
                    }
                }else{
                    CStack.push(kmatSorted[i]);
                    person=getPerson(person);
                    
                    if(!JStack.isEmpty() && doesOverlap(JStack.peek(),kmatSorted[i+1]))
                    {
                        impossible=true;
                        break;
                    }
                    
                }
            }else{
                if(person == 'J'){
                    JStack.push(kmatSorted[i]);
                }else{
                    CStack.push(kmatSorted[i]);
                }
            }
            
        }
        System.out.println("Case #"+(tn++)+": "+(impossible ? "IMPOSSIBLE" : new String(chars)));
    }
    private static char getPerson(char p)
    {
        return p=='J' ? 'C' : 'J';
    }
    private static boolean doesOverlap(int a[],int b[])
    {
        return a[1]>b[0];
        }
    
    
}