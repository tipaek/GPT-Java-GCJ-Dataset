import java.io.*;
import java.util.*;
class Solution
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T,N,S[],E[],CameronS,JamieS,CameronE,JamieE;
        int i,j,k,temp,cntV,minS,p;
        String Output;
        char out[];
        Boolean flag=true;
        T=sc.nextInt();
        for(i=1;i<=T;i++,S=null,E=null)
        {
            N=sc.nextInt();
            S=new int[N];
            E=new int[N];
            out=new char[N];
            Output="";
		CameronS=0; JamieS=0; CameronE=0; JamieE=0;
            for(j=0;j<N;j++)
            {
                S[j]=sc.nextInt();
                E[j]=sc.nextInt();
            }
            for(cntV=0,p=0;cntV<N;S[p]=1441,E[p]=1441,cntV++)
            {
                for(j=0,minS=1441;j<N;j++)
                {
                    if(S[j]<=minS)
                    {
                        minS=S[j];
                        p=j;
                    }
                }
                if(S[p]>=CameronE)
                {
                    out[p]='C';
                    CameronE=E[p];
                }
		        else if(E[p]<=CameronS)
		        {
		            out[p]='C';
                    CameronS=S[p];
		        }
                else if(S[p]>=JamieE)
                {
                    out[p]='J';
                    JamieE=E[p];
                }
		        else if(E[p]<=JamieS)
		        {
		            out[p]='J';
                    JamieS=S[p];
		        }
                else
                {
                    Output="IMPOSSIBLE";
		flag=false;
                    break;
                }
                
            }
		if(flag){
            for(j=0;j<N;j++)
            {
                Output+=out[j];
            }}
            System.out.println("Case #"+i+": "+Output);
        }
    }
}