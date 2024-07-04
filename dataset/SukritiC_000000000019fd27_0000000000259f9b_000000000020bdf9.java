import java.util.*;
class Solution{
    public static void main(String as[]){
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++){
            int n=sc.nextInt();
            int ts[][]=new int[n][2];
            int m[]=new int[2];
            Integer m1[]=new Integer[n];
            char ch[]=new char[n];
            //int c=0,jj=0; // state of both people
            for(int j=0;j<n;j++){
                ts[j][0]=sc.nextInt();
                ts[j][1]=sc.nextInt();
                m1[j]=ts[j][0];
            }
            
            
            String fs="";
            m[0]=ts[0][1];            
            fs="C";
            ch[0]='C';
            for(int j=1;j<n;j++){
               if(j==1){
                   if(ts[j][0]<ts[j-1][1]){
                        m[1]=ts[j][1];                        
                        fs+="J";
                        ch[j]='J';
                    }else{
                        fs+="C";
                        ch[j]='C';
                    }
                }else{
                    if(ts[j][0]>=m[1]){
                        fs+="J";
                        ch[j]='J';
                        m[1]=ts[j][1];
                    }else if(ts[j][0]>=m[0]){
                        fs+="C";
                        ch[j]='C';
                        m[0]=ts[j][1];
                    }else{
                        int max=Collections.max(Arrays.asList(m1));
                        if(max==ts[j][0]){
                            fs="IMPOSSIBLE";
                        }else{
                            Arrays.sort(m1);                            
                            int k=0,x=0;
                            while(k<n){
                                if(m1[k]==ts[j][0]){
                                    
                                    break;
                                }
                                k++;    
                            }
                            x=m1[k+1];
                            k=j-1;
                            while(k>=0){
                                if(x==ts[k][0]){
                                    fs+=ch[k];
                                    ch[j]=ch[k];
                                }
                                k--;
                            }
                        }
                    }
                }
            }
            System.out.println("Case #"+(i+1)+": "+fs);
        }
    }
}