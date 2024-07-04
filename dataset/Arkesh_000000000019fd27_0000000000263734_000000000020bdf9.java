import java.util.*;

class Solution
{
    public static void main(String args[])
    {
        Scanner scr = new Scanner(System.in);
        int T = scr.nextInt();
        
        if(T<1 || T>100)
            return;
        
        for(int i=0;i<T;i++)
        {
            int N = scr.nextInt();
            if(N<2 || N>1000)
                return;
        
            String output_str="";
            
            Integer S[] = new Integer[N];
            Integer E[] = new Integer[N];
            Integer I[] = new Integer[N];

            for(int j=0;j<N;j++)
            {
                S[j] = scr.nextInt();
                E[j] = scr.nextInt();
                I[j] = j;
                if((S[j]<0 || S[j]>1440) || (E[j]<0 || E[j]>1440)||(S[j]>E[j]))
                    break;
            }

            
            for(int k=0;k<N-1;k++)
            {
                
                for(int z=k+1;z<N;z++)
                {
                    if(S[z] < S[k])
                    {
                        int temp1 = S[k];
                        S[k] = S[z];
                        S[z] = temp1;

                        int temp2 = E[k];
                        E[k] = E[z];
                        E[z] = temp2;

                        int temp3 = I[k];
                        I[k] = I[z];
                        I[z] = temp3;
                    }

                }
            
            }
            //System.out.println(S[N-1]+" "+E[N-1]);

            char out[] = new char[N];
            int divide_count = 0; //if 0 to C else to J
            int C_track =0, J_track=-1;
            String on_going = "";
            for(int j=0;j<N;j++)
            {
                if(j==0)
                {
                    out[I[j]] = 'C';
                    output_str += "C";
                    C_track=j;
                    on_going="C";
                    continue;
                }
               
                if(S[j] < E[j-1]) 
                {
                
                    if(on_going=="J")
                    {

                        if(E[C_track]  <= S[j])
                        {
                            out[I[j]] = 'C';
                            output_str +="C";
                            on_going="C";
                            C_track = j;
                        }
                        else
                        {
                            output_str = "IMPOSSIBLE";
                            break;
                        }
                    }
                    else
                    {
                        if(J_track!=-1)
                        {
                            if(E[J_track]  <= S[j])
                            {
                                out[I[j]] = 'J';
                                output_str +="J";
                                on_going="J";
                                J_track = j;
                            }
                            else
                            {
                                output_str = "IMPOSSIBLE";
                                break;
                            }
                        }
                
                        else
                        {
                            out[I[j]] = 'J';
                            output_str +="J";
                            on_going = "J";
                            J_track = j;
                        }
                    }
                }
                else
                {
                    
                    output_str += on_going;
                    if(on_going == "J"){
                        J_track = j;
                        out[I[j]] = 'J';
                    }
                    else{
                        C_track = j;
                        out[I[j]] = 'C';
                    }
                }
                    
                
            }
        if(output_str!="IMPOSSIBLE")
        {
            output_str = "";
        
            for(int x=0;x<N;x++)
            {
                
                    output_str += out[x];
            }
        }

         System.out.println("Case #"+(i+1)+": "+output_str);
          
        }
    }
}