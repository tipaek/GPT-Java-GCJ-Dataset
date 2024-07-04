import java.util.*;
public class Solution{
    public static void main(String args[]){
    Scanner s=new Scanner (System.in);
    int t=s.nextInt();
    int no=0;
    while(t>0){
        int n=s.nextInt();
        int m[][]=new int[n][n];
        int sum=0;
        int rowcount=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                m[i][j]=s.nextInt();
                if(i==j)
                sum+=m[i][j];
            }
        }
        for(int i=0;i<n;i++){
            HashMap<Integer,Integer> map1=new HashMap<>();
            for(int j=0;j<n;j++){
                if(map1.containsKey(m[i][j])){
                    rowcount++;
                    break;
                }
                map1.put(m[i][j],1);
            }
        }
            int colcount=0;
        for(int j=0;j<n;j++){
            HashMap<Integer,Integer> map=new HashMap<>();
            for(int i=0;i<n;i++){
                if(map.containsKey(m[i][j])){
                    colcount++;
                    break;
                }
                map.put(m[i][j],1);
            }
        }
        System.out.println("Case #"+(++no)+":"+" "+sum+" "+rowcount+" "+colcount);
        t--;
    }
}
}