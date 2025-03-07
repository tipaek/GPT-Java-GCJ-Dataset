
import java.util.HashMap;
import java.util.Scanner;

public class Solution{
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        outer:for(int i=1;i<=t;i++){
            int n = in.nextInt();
            int[][] times = new int[n][2];
            for(int j=0;j<n;j++){
                times[j][0]=in.nextInt();
                times[j][1]=in.nextInt();
            }
            HashMap<Integer,String> map = new HashMap<>();
            StringBuilder ans = new StringBuilder();
            ans.append("C");
            map.put(0,"C");
            for(int j=1;j<n;j++){
                String crespo =overlaps(j,times,map);
                if(crespo.equals("im")){
                    System.out.println("Case #"+i+": IMPOSSIBLE");
                    continue outer;
                }else if(crespo.equals("c")){
                    ans.append("J");
                    map.put(j,"J");
                }else if(crespo.equals("j")){
                    ans.append("C");
                    map.put(j,"C");
                }else{
                    ans.append(ans.charAt(ans.length()-1)+"");
                    map.put(j,ans.charAt(ans.length()-1)+"");
                }
            }
            System.out.println("Case #"+i+": "+ans);
        }
    }
    public static String overlaps(int j,int[][] times,HashMap<Integer,String> map) {
        int ostart = times[j][0];int oend = times[j][1];
        boolean foundC=false;
        boolean foundJ=false;
        for(int k=j-1;k>=0;k--){
             int s = times[k][0];int e = times[k][1];
            boolean overlap = (ostart>=s && ostart<e)||(oend>s&&oend<e)||(ostart<=s&&oend>=e);
             if(map.get(k).equals("C")&&overlap){
                foundC=true;
            }if(map.get(k).equals("J")&&overlap){
                foundJ=true;
            }
        }
        if(foundC&&foundJ)
            return "im";
        else if(foundC){
            return "c";
        }else if(foundJ){
            return "j";
        }
        return "cont";
    }
}
