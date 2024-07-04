/*package whatever //do not write package name here */

import java.util.*;

class fun implements Comparable<fun>{
    int a;
    int b;
    int i;
    public fun(int a,int b,int i)
    {
        this.a=a;
        this.b=b;
        this.i=i;
    }
    public int compareTo(fun o){
        if(this.a==o.a)
        return this.b-o.b;
        return this.a-o.a;
    }
}

class Solution {
	public static void main (String[] args) {
 
          Scanner s=new Scanner(System.in);
          int t=s.nextInt();
          int k=1;
          while(t-->0){
              int n=s.nextInt();
              fun a[]=new fun[n];
              for(int i=0;i<n;i++)
                {
                    int b=s.nextInt();
                    int c=s.nextInt();
                    a[i]=new fun(b,c,i);
                }
                Arrays.sort(a);
                char e[]=new char[n];
                e[a[0].i]='C';
                int b=a[0].a;
                int c=a[0].b;
                int f=1,r=0;
                for(int i=1;i<n;i++){
                    if(a[i].a>=c)
                     {
                         e[a[i].i]='C';
                         b=a[i].a;
                         c=a[i].b;
                     }
                     else if(r==0){
                         r=i;
                     }
                    //  f++;
                }
                int p=0;
                if(r!=0){
                    e[a[r].i]='J';
                    int y=a[r].a;
                    int u=a[r].b;
                    int o=r+1;
                    for(int j=o;j<n;j++){
                    if(e[a[j].i]!='C'&&a[j].a>=u){
                        e[a[j].i]='J';
                        y=a[j].a;
                        u=a[j].b;
                    }else if(e[a[j].i]!='C')
                    {
                        p=1;
                        break;
                    }
                }
                }
                String q="";
                if(p==1){
                    q="IMPOSSIBLE";
                // System.out.println("IMPOSSIBLE");
                }
                else{
                    for(int i=0;i<n;i++)
                    q+=e[i];
                    // System.out.print(e[i]);
                    // System.out.println();
                }
             
              System.out.println("Case #"+k+": "+q);//tr+" "+r+" "+c);
              k++;
          }
          
	}
}