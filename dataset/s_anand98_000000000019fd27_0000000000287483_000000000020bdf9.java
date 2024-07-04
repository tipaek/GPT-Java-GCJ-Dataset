import java.io.*;
import java.util.*;

class Pair{
    int id;
    int s;
    int e;
    Pair(int a, int b, int c){
        s=a;e=b;
        id = c;
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
                list.add(new Pair(a,b,i));
            }
            
            Collections.sort(list, new Comparator<Pair>(){
               
               public int compare(Pair a, Pair b){
                   if(a.s==b.s)
                        return (int)(a.e-b.e);
                    return (int)(a.s-b.s);  
               } 
            });
            
            int c=0,j=0;
            char ans[] = new char[n];
            int flag=0;
            for(int i=0;i<n;i++){
                Pair X = list.get(i);
                //System.out.println(X.s+" "+X.e);
                if(X.s>=c){c=X.e;ans[X.id]='C';}
                else if(X.s>=j){j=X.e;ans[X.id]='J';}
                else{
                    flag=1;
                    break;
                }
            }
            //System.out.println("====================");
            String A = new String(ans);
            if(flag==1)A = "IMPOSSIBLE";
            sb.append("Case #"+test+": "+A+"\n");
        }
        System.out.print(sb);
    }
}