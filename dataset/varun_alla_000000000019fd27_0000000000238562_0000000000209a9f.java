import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int count =1;
        while(t-->0){
            String k = sc.next();
            char c[] = k.toCharArray();
            String s = "";
            boolean o = false;
            for(int i=0;i<c.length ;i++){
                if(c[i]=='1'){
                    if(!o){
                        s+="(";
                        o=true;
                    }
                    s+="1";
                }
                if(c[i]=='0'){
                    if(o)
                    {
                        s+=")";
                        o=false;
                    }
                    s+="0";
                }
            }
            if(o)
            s+=')';
            System.out.println("Case #"+count+++": "+s);
        }
    }
}