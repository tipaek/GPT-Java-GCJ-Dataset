import java.io.*;
import java.util.*;

class Solution{
    public static void main(String args[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int T=1;
        while(T<=t){
            int n=sc.nextInt(),ch=0,jh=0,cl=0,jl=0,cs=0,js=0,ce=0,je=0;
            int a[][]=new int[n][2],flag=0;
            StringBuffer s=new StringBuffer();
            for(int i=0;i<n;i++){
            	flag=0;
                a[i][0]=sc.nextInt();
                a[i][1]=sc.nextInt();
                if(a[i][0]>=ch)
                    {
                        s.append('C');
                        ch=a[i][1];
                        cl=a[i][0];
                        cs=cl;
                        ce=ch;
                    }
                else if(a[i][0]>=jh)
                    {
                        s.append('J');
                        jh=a[i][1];
                        jl=a[i][0];
                        js=jl;
                        je=jh;
                    }
                else if(a[i][0]<=cs && a[i][1]<=cs && a[i][1]<=cl ){
                	 s.append('C');
                     	ce=a[i][1];
                     	cs=a[i][0];
                }
                else if(a[i][0]<=js && a[i][1]<=js && a[i][1]<=jl ){
               	 s.append('J');
                    	je=a[i][1];
                    	js=a[i][0];
               }
               else if(a[i][0]>=ce && a[i][1]<=cl)
                    {
                        s.append('C');
                        ce=a[i][1];
                        cs=a[i][0];
                    }
                else if(a[i][0]>=je && a[i][1]<=jl)
                    {
                        s.append('J');
                        je=a[i][1];
                    }
                else{
                    flag=1;
                    break;
                }
            }
            if(flag==1)
            System.out.println("Case #"+T+": "+"IMPOSSIBLE");
            else
            System.out.println("Case #"+T+": "+s.toString());
            T++;
        }
        sc.close();
    }
}