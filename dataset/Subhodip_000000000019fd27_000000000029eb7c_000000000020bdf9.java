import java.io.*;
import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T,N,S[],E[],CameronS,JamieS,CameronE,JamieE;
        int i,j,k,temp;
        String Output;
        T=sc.nextInt();
        for(i=1;i<=T;i++,S=null,E=null)
        {
            N=sc.nextInt();
            S=new int[N];
            E=new int[N];
            Output="";
            for(j=0;j<N;j++)
            {
                S[j]=sc.nextInt();
                E[j]=sc.nextInt();
            }
            CameronS=S[0]; Output+="C"; CameronE=E[0];
	    JamieS=0; JamieE=0;
            for(j=1;j<N;j++)
            {
                if(S[j]>=CameronE)
                {
                    Output+="C";
                    CameronE=E[j];
                }
		else if(E[j]<=CameronS)
		{
		    Output+="C";
                    CameronS=S[j];
		}
                else if(S[j]>=JamieE)
                {
                    Output+="J";
                    JamieE=E[j];
                }
		else if(E[j]<=JamieS)
		{
		    Output+="J";
                    JamieS=S[j];
		}
                else
                {
                    Output="IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #"+i+": "+Output);
        }
    }
}