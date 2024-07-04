import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        int t,n;
        Scanner sc=new Scanner(System.in);
        t=sc.nextInt();
        for(int k=0;k<t;k++){
            n=sc.nextInt();
            int l1 = 0,l2=0,l3=0;
            int m[][]=new int[n][n];
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    m[i][j]=sc.nextInt();
                    if(i==j){
                        l1+=m[i][j];
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
                        l2++;
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
                        l3++;
                        break;
                    }
                }
            }
            System.out.print("Case #"+k+": "+l1+" "+l2+" "+l3+"\n");
        }
    }
    
}
