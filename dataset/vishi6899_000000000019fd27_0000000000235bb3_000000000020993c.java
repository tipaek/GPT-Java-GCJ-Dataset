import java.util.*;
class solution{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int x=1;x<=t;x++){
            int n=s.nextInt();
            int m[][]=new int[n][n];
            int k=0,r=0,c=0;
            for(int i=0;i<n;i++){
                for(int j=0;j<n;j++){
                    m[i][j]=s.nextInt();
                    if(i==j){
                        k+=m[i][j];
                    }
                }
            }
            
            int mr=0;
            int maxr;
            for(int i=0;i<n;i++){
                HashMap<Integer,Integer> hm=new HashMap<>();
                for(int j=0;j<n;j++){
                    if(hm.containsKey(m[i][j])){
                        hm.put(m[i][j],hm.get(m[i][j])+1);
                    }
                    
                    else{
                        hm.put(m[i][j],1);
                    }
                }
                
                maxr=Collections.max(hm.values());
                if(maxr>mr){
                    mr=maxr;
                    if(mr==1)
                    mr=0;
                }
                
                
            }
            
            int mc=0,maxc;
            for(int i=0;i<n;i++){
                HashMap<Integer,Integer> hm=new HashMap<>();
                for(int j=0;j<n;j++){
                    if(hm.containsKey(m[j][i])){
                        hm.put(m[j][i],hm.get(m[j][i])+1);
                    }
                    
                    else{
                        hm.put(m[j][i],1);
                    }
                }
                
                maxc=Collections.max(hm.values());
                if(maxc>mc){
                    mc=maxc;
                    if(mc==1)
                    mc=0;
                }
                
                
            }
            c=mc;
            r=mr;
            System.out.println("Case #"+x+":"+" "+k+" "+r+" "+c);
            
            
        }
    }
}