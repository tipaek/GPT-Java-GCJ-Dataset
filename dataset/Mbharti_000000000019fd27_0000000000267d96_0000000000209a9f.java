import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author 
 * @date 04/04/20
 */
public class Solution {
    public static void main(String[] args) throws Exception{
        InputStreamReader r=new InputStreamReader(System.in);
        BufferedReader br=new BufferedReader(r);
        int t = Integer.valueOf(br.readLine());
        String res="";
        int tc=1;
        while(t>0){
            if(res.length()>0){
                res+="\n";
            }
            String v =br.readLine();
            res += getFormatString(v, tc);
            tc++;
            t--;
        }
        System.out.println(res);
    }

    private static String getFormatString(String v, int tc) {
        String s="";
        boolean iso = false;
        int i;
        for(i=0;i<v.length();i++){
            if(v.charAt(i)=='1'){
                if(!iso) {
                    s += "(";
                }
                s+='1';
                iso=true;
            }else{
                if(iso){
                    s+=')';
                }
                s+='0';
                iso=false;
            }
        }
        if(iso){
            s+=")";
        }
        return String.format("Case #%d: %s",tc, s);
    }
}
