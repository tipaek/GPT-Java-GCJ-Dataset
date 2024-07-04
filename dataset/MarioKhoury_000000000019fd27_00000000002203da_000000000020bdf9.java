
import java.util.*;
import java.io.IOException;
    
class Solution {
    public static boolean can(int n1 ,int n2,boolean[] J){
        for(int i=n1;i<n2;i++){
            if (J[i] == true) {
                return false;
            }
        }
        return true;
    }
    public static boolean[] J = new boolean[1440];
    public static boolean[] C = new boolean[1440];
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for(int i =1 ;i<=t;i++){
            int n = sc.nextInt();
            String res = "";
            int n1 = 0;
            int n2 = 0;
            for(int j = 0;j<n;j++){
                n1 = sc.nextInt();
                n2 = sc.nextInt();
                boolean is = true;
                if(can(n1,n2,J)){
                    for(int b = n1;b<n2;b++){
                        J[b] = true;
                    }
                    res+="J";
                }else{
                    for(int b = n1;b< n2;b++){
                        if(C[b] == true){
                            is = false;
                            break;
                        }
                        C[b] = true;
                    }
                    res+="C";
                }
                if (!is){
                    res = "IMPOSSIBLE";
                    break;
                }
            }
            System.out.println("Case #" + i + ": "+ res );
            for(int j = 0;j<1440;j++){
                J[j] = false;
                C[j] = false;
            }
        }
    }
}
	