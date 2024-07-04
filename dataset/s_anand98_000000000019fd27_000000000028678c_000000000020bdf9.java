import java.io.*;
import java.util.*;

class Pair{
    int s;
    int e;
    Pair(int a, int b){
        s=a;e=b;
    }
}
class Solution{
    public static void main(String args[])throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer sb = new StringBuffer();
        int t = Integer.parseInt(br.readLine().trim());
        for(int test = 1; test<=t;test++){
            ArrayList<Pair> list = new ArrayList<Pair>();
            int n = Integer.parseInt(br.readLine().trim());
            for(int i=0;i<n;i++){
                String str[] = br.readLine().trim().split(" ");
                int a = Integer.parseInt(str[0]);
                int b = Integer.parseInt(str[1]);
                list.add(new Pair(a,b));
            }
            
            Collections.sort(list, new Comparator<Pair>(){
               
               public int compare(Pair a, Pair b){
                   if(a.s==b.s)
                        return (int)(a.e-b.e);
                    return (int)(a.s-b.s);  
               } 
            });
            
            int c=0,j=0;
            String ans = "";
            for(int i=0;i<n;i++){
                Pair X = list.get(i);
                
                if(X.s>=c){c=X.e;ans+='C';}
                else if(X.s>=j){j=X.e;ans+='J';}
                else{
                    ans = "IMPOSSIBLE";
                    break;
                }
            }
            
            sb.append("Case #"+test+": "+ans+"\n");
        }
        System.out.print(sb);
    }
}