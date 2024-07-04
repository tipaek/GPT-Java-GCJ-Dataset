import java.io.*;
import java.util.*;

class Solution {

    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        StringBuffer sb = new StringBuffer();

        int t = Integer.parseInt(br.readLine().trim());
        for(int test=1;test<=t;test++){
           
            int u = Integer.parseInt(br.readLine().trim());
            ArrayList<Pair> list = new ArrayList<Pair>();
            for(int i=0;i<10000;i++){
                String s[] = br.readLine().trim().split(" ");
                list.add(new Pair(Integer.parseInt(s[0]), s[1]));
            }

            Collections.sort(list, new Comparator<Pair>(){
                public int compare(Pair a, Pair b){
                    return a.value-b.value;
                }
            });

            char ans[] = new char[10];
            for(int i=0;i<10000;i++){

                Pair X = list.get(i);
                if(X.value>10)break;

                for(int k=0;k<X.res.length();k++){
                    char vv = X.res.charAt(k);
                    int flag=0;
                    for(int j=X.value-1;j>=0;j--){
                        if(ans[j]==vv){flag=1;break;}
                    }

                    if(X.value==10)X.value=0;
                    if(flag==0)ans[X.value] = vv;
                }
                


            }

            sb.append("Case #"+test+": "+new String(ans)+"\n");

        }
            
        System.out.print(sb);
    }
}

class Pair{

    int value;
    String res;
    Pair(int a, String b){
        value = a;
        res = b;
    }
}