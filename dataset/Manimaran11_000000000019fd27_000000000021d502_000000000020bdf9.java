

import java.io.*;
import java.util.*;

public class Solution{
   
    public static class partner{
        int index;
        int st,en;
        partner(int index,int st,int en){
            this.index = index;
            this.st = st;
            this.en = en;
        }
    }

    public static void main(String[] args)  throws Exception{

    
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    int t = Integer.parseInt(br.readLine());
    int y=1;
    while(t>0){
        System.out.print("Case #"+y+": ");
        int n = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();  
        List<partner> l = new ArrayList<partner>();
        for(int i=0;i<n;i++){
            sb.append("C");
            String []s = br.readLine().split(" ");
           l.add(new partner(i,Integer.parseInt(s[0]),Integer.parseInt(s[1])));
        }
        Collections.sort(l,((i1,i2)->i1.st-i2.st));
        int ce,je=0;
        ce =l.get(0).en;
        for(int i=1;i<n;i++){
            if(ce<=l.get(i).st){
                ce = l.get(i).en;
            }
            else if(je<=l.get(i).st){
               je = l.get(i).en;
                sb.setCharAt(l.get(i).index,'J'); 
            }
            else{
                sb.setLength(0);
                sb.append("IMPOSSIBLE");
                break;
            }
        }
        System.out.print(sb.toString());
        System.out.println();
        t--;
        y++;
    }
}
}