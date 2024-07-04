        
import java.util.*;
import java.io.*;
public class Solution
{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int count=1;
        String res="";
        String out="";
        int t=sc.nextInt();
        
        while(t>0){
            int ctop=0,jtop=0;
        t--;
        res="J";
        
        
        int n=sc.nextInt();
        int j[][]=new int[n][2];
        int c[][]=new int[n][2];
        for(int i=0;i<n;i++)
        {
        if(i==0){
        j[i][0]=sc.nextInt();
        j[i][1]=sc.nextInt();
        jtop++;
        continue;
        }
        boolean s=true;
        
        int l1=sc.nextInt();
        int h1=sc.nextInt();
       
        boolean itr=true;
        int l,h;
        for (int k[] : j){
            l=k[0];
            h=k[1];
            if( (l1>=l && l1<h) || (h1>l && h1<=h) || (l1<l && h1>h))
            {    itr =false;
          // System.out.println("J "+l+" "+h+" "+l1+" "+h1);
            }
        }
        
        for( int o[] : c){
            l=o[0];
            h=o[1];
            if(l==0 && h==0)
            break;
            if ((l1>=l && l1<h) || (h1>l && h1<=h) || (l1<=l && h1>=h)){
                s =false;
                
          //System.out.println("C "+l+" "+h+" "+l1+" "+h1);
break;            }
          
        }
        
        //System.out.println(l1+" "+h1+itr+s);
        if (!s && !itr){
            res="IMPOSSIBLE";
            break;
          }
        else if( s && !itr){
            c[ctop][0]=l1;
            c[ctop][1]=h1;
            ctop++;
            res+="C";
        }
        else if( itr && !s){
            j[jtop][0]=l1;
            j[jtop][1]=h1;
            res+="J";
            jtop++;
            }
        else{
          //  System.out.println(res+"  "+res.charAt(res.length()-1));
            if ("J".equals(""+res.charAt(res.length()-1))){
            j[jtop][0]=l1;
            j[jtop][1]=h1;
            res+="J";
            jtop++;
            }
            else{
             c[ctop][0]=l1;
            c[ctop][1]=h1;
            res+="C";
            ctop++;
    		}
    	}
        
	}
        out+="Case #"+count+": "+res+"\n";
    		count+=1;
        
        }
        System.out.println(out);
	}
}
