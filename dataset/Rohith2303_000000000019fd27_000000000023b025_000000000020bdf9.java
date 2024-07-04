import java.util.*;
public class Solution{
    int end;
    char ch;
    Solution(char c,int e){
        ch=c;
        end=e;
    }
    static HashMap<Character,Integer>mapp=new HashMap<>();
    public static String getstr(int intr[][],int n){
        String res="";
        int start=intr[0][0],end=intr[0][1];
        mapp.put('J',1);
        mapp.put('C',0);
        PriorityQueue<Solution>stk=new PriorityQueue<>((a,b)->(a.end-b.end));
        stk.add(new Solution('J',end));
        res=res+"J";
        for(int i=1;i<n;i++){
            int ts=intr[i][0],te=intr[i][1];
                while(!stk.isEmpty()&&ts>=stk.peek().end)
                {
                    char temp=stk.peek().ch;
                    mapp.put(temp,0);
                    stk.poll();
                }
                if(stk.isEmpty()||ts<stk.peek().end)
                {
                    char temp=mapp.get('J')==0?'J':mapp.get('C')==0?'C':'X';
                    if(temp=='X')
                    return "IMPOSSIBLE";
                    mapp.put(temp,1);
                    res=res+temp;
                    stk.add(new Solution(temp,te));
                }
        }
        return res;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
            int n=sc.nextInt();
            int intr[][]=new int[n][2];
            for(int j=0;j<n;j++){
                intr[j][0]=sc.nextInt();
                intr[j][1]=sc.nextInt();
            }
            Arrays.sort(intr,(a,b)->(a[0]-b[0]));
            System.out.println("Case #"+i+": "+getstr(intr,n));
        }
    }
}