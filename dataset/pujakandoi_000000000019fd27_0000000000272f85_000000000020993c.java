import java.util.*;
public class Solution{
    public static void main(String[] args){
        Scanner s=new Scanner(System.in);
        int t=s.nextInt();
        for(int k=1;k<=t;k++){
            int n=s.nextInt();
            int[] r=new int[n];
            int[] c=new int[n];
            int row=0;
            int col=0;
            int dia=0;
            HashSet<Integer>[] set=new HashSet[n];
            for(int i=0;i<n;i++){
            	
                HashSet<Integer> ss=new HashSet<Integer>();
                for(int j=0;j<n;j++){
                	if(i==0) {
                		set[j]=new HashSet<Integer>();
                	}
                	
                    int num=s.nextInt();
                    if(set[j].contains(num)){
                        c[j]=1;
                    }
                    else{
                        set[j].add(num);
                    }
                    if(i==j){
                        dia+=num;
                    }
                    if(ss.contains(num)){
                        r[i]=1;
                    }
                    else{
                        ss.add(num);
                    }
                    
                }
                
            }
            for(int i=0;i<n;i++){
                row+=r[i];
                col+=c[i];
            }
            
            System.out.println("Case #"+k+": "+dia+" "+row+" "+col);
        }
    }
}