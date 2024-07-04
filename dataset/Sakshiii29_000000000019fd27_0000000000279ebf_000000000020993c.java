import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Solution {

    public static void main(String[] args) {
        int t,n;
        Scanner sc=new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        t=sc.nextInt();
        for(int k=0;k<t;k++){
            n=sc.nextInt();
            int r1 = 0,r2=0,r3=0;
            int m[][]=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    m[i][j]=sc.nextInt();
                    if(i==j){
                        r1+=m[i][j];
                                    }
                }
            }
            for(int i=0;i<n;i++){
                Map<Integer,Integer> m1=new HashMap<Integer,Integer>();
                for(int j=0;j<n;j++){
                    Integer val=m1.get(m[i][j]);
                    if(val==null){
                        m1.put(m[i][j],1);
                    }else{
                        r2++;
                        break;
                    }
                }
            }
            for(int i=0;i<n;i++){
                Map<Integer,Integer> m1=new HashMap<Integer,Integer>();
                for(int j=0;j<n;j++){
                    Integer val=m1.get(m[j][i]);
                     if(val==null){
                        m1.put(m[j][i],1);
                    }else{
                        r3++;
                        break;
                    }
                }
            }
            System.out.println("Case #"+(k+1)+": "+r1+" "+r2+" "+r3);
        }
    }
    
}