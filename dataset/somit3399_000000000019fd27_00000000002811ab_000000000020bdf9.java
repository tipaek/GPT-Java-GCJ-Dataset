import java.util.Scanner;
 
public class Solution {
    public static void main(String...args){
        Scanner scan = new Scanner(System.in);
        int t = scan.nextInt();
        for (int i = 0; i < t; i++){
            String str="C";
            int n = scan.nextInt();
            int s[] = new int[n];
            int e[] = new int[n];
            for(int j = 0; j < n; j++){
                s[j] = scan.nextInt();
                e[j] = scan.nextInt();
            }
            int cS = s[0];
            int cE = e[0];
            int jS=0,jE=0;
            
            for(int j = 1; j < n; j++){
                if((s[j]>cS && s[j]<cE) || (e[j]>cS && e[j]<cE)){
                    if(jS == 0 && jE == 0){
                        jS = s[j];
                        jE = e[j];
                        str = str+"J";
                    }else
                    if(((s[j]>jS && s[j]<jE) && (s[j]>cS && s[j]<cE)) || ((e[j]>jS && e[j]<jE) && (e[j]>cS && e[j]<cE)) ){
                        str = "IMPOSSIBLE"; break;
                        
                    }else {
                        if(s[j]<jS){
                            jS = s[j];
                        }
                        if(jE > e[j]){
                            jE = e[j];
                        }
                        str = str+"J";
                    }
                }else{
                str = str +"C";
                if(s[j]<cS){
                    cS = s[j];
                }
                if(e[j]>cE){
                    cE = e[j];
                }
                }
            }
            System.out.println("Case #"+(i+1)+": " + str);
        }
        
    }
}
