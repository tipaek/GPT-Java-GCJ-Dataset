import java.util.*;
//import org.javatuples.Pair; 

public class Solution{

    
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            HashMap<ArrayList<Integer>,Integer> hs=new HashMap<>();
            int n=sc.nextInt();
            int s[]=new int[n];
            int e[]=new int[n];
            //int in[]=new int[n];
            for(int j=0;j<n;j++)
            {
                s[j]=sc.nextInt();
                e[j]=sc.nextInt();
                ArrayList<Integer> ln=new ArrayList<>();
                ln.add(s[j]);
                ln.add(e[j]);
                hs.put(ln,j);
            }
            //Stack<Integer> s1= new Stack<>();
            //Stack<Integer> s2= new Stack<>();
            boolean v[]=new boolean[n];

            int dp[][]=sort(s,e,n);
            for(int j=0;j<n;j++)
            {
                s[j]= dp[j][0];
                e[j]= dp[j][1];
                //in[j]=dp[j][2];
                
            }
            //System.out.println(hs);
            HashSet<Integer> h=Ac(s,e,n);
            int s1[]=new int[n-h.size()];
            int e1[]=new int[n-h.size()];
            HashMap<Integer,Integer> map=new HashMap<>();

            int k=0,fl=0;
            for(int j=0;j<n;j++){
                if(!h.contains(j))
                {
                    s1[k]= s[j];
                    map.put(j,k);
                    //ind[k]=j;
                    e1[k++]= e[j];
                    

                }


            }
            HashSet<Integer> h1=Ac(s1,e1,n-h.size());
            //System.out.println(h);
            for(int j=0;j<n;j++)
            if(!h1.contains(map.get(j))&&!h.contains(j))
            {
                System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
                fl=1;
                break;
            }
            for(int j=0;j<n;j++)
            if(h.contains(j))
            v[j]=true;


            
            char ch[]=new char[n];
            if(fl==0){
                for(int j=0;j<n;j++){
                    ArrayList<Integer> l=new ArrayList<>();
                    l.add(s[j]);
                    l.add(e[j]);
                    int p=hs.get(l);
                    ch[p]= v[j]?'J':'C';
                    //System.out.print(ch[p]);
                }
                String m= "";
                for(int j=0;j<n;j++)
                m+=ch[j];
                System.out.println("Case #"+(i+1)+": "+m);
            }
            
        }


        sc.close();
    }
    public static int[][] sort(int s[],int e[],int n){
        //Pair<Integer,Integer> p=new Pair();
        int dp[][]=new int[n][2];
        //int in[]=new int[n];
        // for(int i=0;i<n;i++)
        // hs.put(i,i);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<i;j++)
            if(s[i]<s[j])
            {
                int t= s[i];
                s[i]=s[j];
                s[j]=t;
                t=e[i];
                e[i]=e[j];
                e[j]=t;
                //hs.put(i,j);
                //hs.put(j,i);
            }
        }
        for(int i=0;i<n;i++)
        {
            dp[i][0] = s[i];
            dp[i][1] = e[i];
            //dp[i][2] = in[i];
        }

        return dp;

    }
    public static HashSet<Integer> Ac(int s[], int f[], int n) 
    { 
    int i, j; 
       
    //System.out.print("Following activities are selected : n"); 
    HashSet<Integer> h= new HashSet<>();
       
    i = 0; 
    h.add(0);
       
    for (j = 1; j < n; j++) 
    { 
         
         if (s[j] >= f[i]) 
         { 
              h.add(j);
              i = j; 
          } 
     } 
     return h;
    } 
    
    
}