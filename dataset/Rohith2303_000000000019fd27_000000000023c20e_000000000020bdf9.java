import java.util.*;
public class Solution{
    int end;
    char ch;
    int ind;
    Solution(char c,int e,int i){
        ch=c;
        end=e;
        ind=i;
    }
    static HashMap<Character,Integer>mapp=new HashMap<>();
    public static String getstr(int intr[][],int n){
        char res[]=new char[n];
        int start=intr[0][0],end=intr[0][1],ind=intr[0][2];
        mapp.put('J',1);
        mapp.put('C',0);
        PriorityQueue<Solution>stk=new PriorityQueue<>((a,b)->(a.end-b.end));
        stk.add(new Solution('J',end,ind));
        res[ind]='J';
        for(int i=1;i<n;i++){
            int ts=intr[i][0],te=intr[i][1],tind=intr[i][2];
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
                    res[tind]=temp;
                    stk.add(new Solution(temp,te,ind));
                }
        }
        String fin="";
        for(int i=0;i<n;i++)
            fin=fin+res[i];
        return fin;
    }
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=1;i<=t;i++)
        {
            int n=sc.nextInt();
            int intr[][]=new int[n][3];
            for(int j=0;j<n;j++){
                intr[j][0]=sc.nextInt();
                intr[j][1]=sc.nextInt();
                intr[j][2]=j;
            }
            Arrays.sort(intr,(a,b)->(a[0]-b[0]));
            System.out.println("Case #"+i+": "+getstr(intr,n));
        }
    }
}