import java.util.*;
import java.io.*;

public class Solution{
    public static void main(String[] args){
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int T = in.nextInt();
        for(int i = 1; i < T; i++){
            solve(in, T);
        }
    }
    
    static void solve(Scanner in, int T){
        Hashtable<String, Integer> dic = new Hashtable<String, Integer>();
        int u = in.nextInt();
        int counter = 0;
        Boolean[][] y = new Boolean[10][10];
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                y[i][j] = false;
            }
        }
        for(int i = 0; i < 10000; i++){
            int m = in.nextInt();
            String r = in.next();
            if(r.length() != length(m)) break;
            m = firstNum(m);
            r = r.substring(0, 1);
            
            if(!dic.containsKey(r)){
                dic.put(r, counter);
                for(int j = 0; j < m; j++){
                    y[counter][i] = true;
                }
                counter++;
            } else{
                int place = dic.get(r);
                for(int j = 9; j >= m; j--){
                    if(y[place][i] = true){
                        y[place][i] = false;
                    }
                }
            }
        }
       
        Set<String> a = dic.keySet();
        String[] sol = new String[10];
        for(int i = 0; i < 10; i++){
            for(int j = 0; j < 10; j++){
                if(y[i][j] = false){
                    for(String b : a) {
    		            if(dic.get(b) == j-1){
    		                sol[j-1] = b;
    		            }
    	            }
                }
            }
        }
        System.out.print("Case #" + T + ": ");
        for(int i = 0; i < 10; i++){
            System.out.print(sol[i]);
        }
        System.out.println();
    }
    
    static int length(int m) {
    	int l = 1;
    	while(m >= 10) {
    		m /= 10;
    		l++;
    	}
    	return l;
    	
    }
    static int firstNum(int m){
        while(m >= 10){
            m /= 10;
        }
        return m;
    }
}