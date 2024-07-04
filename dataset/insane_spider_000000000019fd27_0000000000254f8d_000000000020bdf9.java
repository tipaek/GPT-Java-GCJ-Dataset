import java.util.*;
public class Solution {
    public static void main(String args[] ) throws Exception {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        //s.nextLine();
        int cas=1;
        while(t!=0)
        {
            int n = s.nextInt();
            int time[][]=new int[3][n];
            for(int i=0;i<n;i++)
            {
                 time[0][i] = s.nextInt();
                 time[1][i] = s.nextInt();
                 time[2][i]=i+1;
            }
            int j=0;
            for(int i=1;i<n;i++)
            {
                int index=time[0][i];
                int index1=time[1][i];
                int index2=time[2][i];
                for(j=i-1;j>=0;j--)
                {
                    if(time[0][j]>index)
                    {
                        time[0][j+1]=time[0][j];
                        time[1][j+1]=time[1][j];
                        time[2][j+1]=time[2][j];
                    }
                    else
                        break;
                }
            time[0][j+1]=index;
            time[1][j+1]=index1;
            time[2][j+1]=index2;
            }
            //String stnew=new String();
            char array[]=new char[n];
            char last='C';
            int clast=0;
            int jlast=-1;
            //stnew.charAt(time[2][0]-1)=last;
            array[time[2][0]-1]=last;
            int flag=0;
            for(int i=1;i<n;i++)
            {
                if(time[0][i]>=time[1][i-1])
                {
                    //stnew.charAt(time[2][i]-1)=last;
                	array[time[2][i]-1]=last;
                    if(last=='C')
                        clast=i;
                    else
                        jlast=i;
                }
                else
                {
                    if(last=='C')
                    {
                        if(jlast==-1)
                    	{
                    		last='J';
                            jlast=i;
                    	}
                    	else if(time[0][i]>=time[1][jlast])
                        {
                            last='J';
                            jlast=i;
                        }
                        else
                        {
                            flag=1;
                            break;
                        }
                    } 
                    else
                    {
                        if(time[0][i]>=time[1][clast] )
                        {
                            last='C';
                            clast=i;
                        }
                        else
                        {
                            flag=1;
                            break;
                        }
                    }
                    //stnew.charAt(time[2][i]-1)=last;
                    array[time[2][i]-1]=last;
                }
            
            }
        String stnew=new String(array);
        if(flag==1)
            stnew="IMPOSSIBLE";
        System.out.println("Case #"+cas+": "+stnew);
        t--;  
        cas ++;
        }
    }
}