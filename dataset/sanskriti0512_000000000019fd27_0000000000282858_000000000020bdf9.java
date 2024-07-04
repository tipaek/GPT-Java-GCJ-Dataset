import java.io.BufferedReader; 
import java.io.IOException; 
import java.io.InputStreamReader; 
import java.util.StringTokenizer; 
import java.util.*;
 
public class Solution 
{ 
    public static void main(String[] args) throws IOException 
    { 
  
       BufferedReader br = new BufferedReader( 
                              new InputStreamReader(System.in));
                
                int t = Integer.parseInt(br.readLine());
                for(int i=0;i<t;i++){
                    int n = Integer.parseInt(br.readLine());
                    ArrayList<act> arr=new ArrayList<>();
                    char []answer=new char[n+1];
                    for(int j=0;j<n;j++){
                        StringTokenizer s=new StringTokenizer(br.readLine());
                        int x=Integer.parseInt(s.nextToken());
                        int y=Integer.parseInt(s.nextToken());
                        act z= new act(x,y,j);
                        arr.add(z);
                    }
                     Collections.sort(arr, new Sort()); 
                    boolean flag1=true;
                    int cc=0,jj=0;
                    for(int k=0;k<arr.size();k++)
        {
            act x=arr.get(k);
            if(x.s>=cc)
            {
                cc=x.e;
                answer[x.i]='C';
            }
            else if(x.s>=jj)
            {
                jj=x.e;
                answer[x.i]='J';
            }
            else
            {
                flag1=false;
                System.out.println("Case #"+(i+1)+": "+"IMPOSSIBLE");
                break;
            }
        }
        if(flag1==true)
        {
             System.out.print("Case #"+(i+1)+": ");
            for(int l=0;l<n;l++)
            {
              System.out.print(answer[l]);
            }
            System.out.println();
        }
                }
                
                     
    }
    }
class act{
    int s;
    int e;
    int i;
    public act(int x,int y,int z){
        s=x;
        e=y;
        i=z;
    }
}
class Sort implements Comparator<act> 
{ 
    
    public int compare(act a, act b) 
    { 
        if(a.s==b.s)
        return a.e - b.e; 
        else
        return a.s-b.s;
    } 
} 