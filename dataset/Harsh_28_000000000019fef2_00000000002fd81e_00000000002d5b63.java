import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner sc;
        sc = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        
        try {
            int T = sc.nextInt();
            
            for(int i=0;i<T;i++){
                
                int count=0;
                int n=sc.nextInt();
                int p[] = new int[n];
                
                for(int j=0;j<p.length;j++){
                    p[j]=sc.nextInt();
                }
                
                Boolean t[]=new Boolean[n];
                
                for(int j=0;j<t.length;j++){
                    t[j]=false;
                }
                
//                int max=p[0];
//                for(int j=1;j<p.length;j++){
//                    if(p[j]>max){
//                        max=p[j];
//                    }
//                }
                
                if(p.length>1){
                    if(p.length==3){
                        if(p[1]>p[0] && p[1]>p[2]){
                            count++;
                        }
                    }
                    else{
                        for(int k=1;k<p.length-1;k++){
                            if( (p[k]>p[k-1] && p[k]>p[k+1]) ){
                                t[k]=true;
                                count++;
                            }
                        }
                    }
                }
                
                System.out.println("Case #" + (i+1) + ": " + count);
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }
}
