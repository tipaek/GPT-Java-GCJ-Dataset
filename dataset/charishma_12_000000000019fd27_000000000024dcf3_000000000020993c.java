import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner in=new Scanner(System.in);
        int t=in.nextInt();
        for(int tc=1;tc<=t;tc++){
            int n=in.nextInt();
            int a[][]=new int[n][n];
            int trace=0,row=0,col=0;
            HashMap<Integer,Integer> hm=new HashMap<>();
            for(int i=0;i<n;i++){
                int flag=0;
                for(int j=0;j<n;j++){
                    a[i][j]=in.nextInt();
                    int x=a[i][j];
                    if(i==j){
                        trace+=x;
                    }
                    if(hm.containsKey(x)){
                        if(flag==0){
                            row++;
                            flag=1;
                        }
                    }
                    else{
                        hm.put(x,1);
                    }
                    
                }
                hm.clear();
                flag=0;
            }
            hm.clear();
            for(int j=0;j<n;j++){
                int flag=0;
                for(int i=0;i<n;i++){
                    int x=a[i][j];
                    if(hm.containsKey(x)){
                        if(flag==0){
                            col++;
                            flag=1;
                        }
                        
                    }
                    else{
                        hm.put(a[i][j],1);
                    }
                }
                flag=0;
                hm.clear();
            }
            System.out.println("Case #"+tc+": "+trace+" "+row+" "+col);
        }
    }
}