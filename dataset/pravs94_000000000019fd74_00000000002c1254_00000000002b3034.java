import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner sc  = new Scanner(System.in);
        int cases = sc.nextInt();
        for(int i = 0; i<cases; i++){
            int inputs = sc.nextInt();
            sc.nextLine();
            String[] ans = new String[3];
            boolean pass = true;            
            for(int j = 0; j<inputs; j++){
                String current = sc.nextLine();
                current = "&" + current + "&";
                String[] sp = current.split("\\*");
                if(ans[0] == null)
                    ans[0] = sp[0];
                else{
                    if(!sp[0].contains(ans[0]) && !ans[0].contains(sp[0])){
                        pass = false;
                        break;
                    }else if(sp[0].contains(ans[0])) {
                        ans[0] = sp[0];
                    }
                }
                if(ans[2] == null)
                    ans[2] = sp[sp.length-1];
                else{
                    if(!sp[sp.length-1].contains(ans[2]) && !ans[2].contains(sp[sp.length-1])){
                        pass = false;
                        break;
                    }else if(sp[sp.length-1].contains(ans[2])) {
                        ans[2] = sp[sp.length-1];
                    }
                }
                if(ans[1]==null){
                  ans[1] = "";
                }
                if(sp.length>2){
                        for(int k = 1; k<sp.length-1; k++){
                            if(!ans[1].contains(sp[k]))
                                ans[1]+=sp[k];
                        }
                }
            }
            String result = "";
            if(pass){
                for(int l = 0; l<3; l++){
                  if(ans[l]!=null)
                    result+=ans[l];
                }
                result = result.substring(1, result.length()-1);
            }else{
                result = "*";
            }
            System.out.printf("Case #%d: %s", i+1, result);
            System.out.println();
        }
    }
}