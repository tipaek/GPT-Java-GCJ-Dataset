import java.util.*;
//import org.javatuples.Pair; 

public class Solution{

    
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            int s[]=new int[n];
            int e[]=new int[n];
            int in[]=new int[n];
            for(int j=0;j<n;j++)
            {
                s[j]=sc.nextInt();
                e[j]=sc.nextInt();
            }
            Stack<Integer> s1= new Stack<>();
            Stack<Integer> s2= new Stack<>();
            boolean v[]=new boolean[n];

            int dp[][]=sort(s,e,n);
            for(int j=0;j<n;j++)
            {
                s[j]= dp[j][0];
                e[j]= dp[j][1];
                in[j]=dp[j][2];
                //System.out.println(in[j]);
            }

            s1.push(s[0]);
            s1.push(e[0]);
            v[0]=true;
            int fl=0;
            //System.out.println(s1);
            
            for(int j=1;j<n;j++){
                if(s1.peek()>s[j])
                {//overlapping
                    if(s2.isEmpty())
                    {
                        s2.push(s[j]);
                        s2.push(e[j]);
                    }
                    else{
                        if(s2.peek()>s[j])
                        {
                            System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
                            fl=1;
                            break;
                        }
                        else
                        {
                            s2.push(s[j]);
                            s2.push(e[j]);
                        }
                    }

                }
                else{
                    s1.push(s[j]);
                    s1.push(e[j]);
                    v[j]=true;
                }
                
            }
            String m="";
            if(fl==0){
                for(int j=0;j<n;j++)
                m+=v[in[j]]?'C':'J';
                System.out.println("Case #"+(i+1)+": "+m);
            }
            
        }


        sc.close();
    }
    public static int[][] sort(int s[],int e[],int n){
        //Pair<Integer,Integer> p=new Pair();
        int dp[][]=new int[n][3];
        int in[]=new int[n];
        for(int i=0;i<n;i++)
        in[i]=i;
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
                in[j]=i;
                in[i]=j;
            }
        }
        for(int i=0;i<n;i++)
        {
            dp[i][0] = s[i];
            dp[i][1] = e[i];
            dp[i][2] = in[i];
        }

        return dp;

    }
    
    
}