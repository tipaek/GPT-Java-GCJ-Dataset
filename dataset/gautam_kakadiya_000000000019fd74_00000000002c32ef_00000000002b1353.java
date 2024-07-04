import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution {
    
    static int[][] pas = new int[500][500];
    
    public static void main(String[] args){
        int T=0;
        Scanner sc = new Scanner(System.in);
        T = sc.nextInt();
        int count=1;
        pas[0][0] = 1;
        for(int i=0;i<500;++i){
            pas[0][i] = 1;
            pas[i][0] = 1;
        }
        for(int i=1;i<499;++i){
            for(int j=1;j<=i;++j){
                pas[i][j] = pas[i-1][j]+pas[i][j-1];
                pas[j][i] = pas[i-1][j]+pas[i][j-1];
            }
        }
        
        /*for(int i=0;i<8;++i){
        	for(int j=0;j<8;++j){
        		System.out.print(pas[i][j]+" ");
        	}
        	System.out.println();
        }*/
        while((T--)!=0){
           int N=0;
           N = sc.nextInt();
           if(N<=500){
               System.out.println("Case #"+count+":");
               for(int i=1;i<=N;++i){
                    System.out.println(i+" 1");
               }
           }else{
               System.out.println("Case #"+count+":");
               int steps = 500;
               Stack<String> st = new Stack<>();
               st.push("1 1");
               HashSet<String> hash = new HashSet<>(); 
               backtrack(1,1,N-1,steps,st,hash);
               while(st.size()!=1){
                   String cur = st.pop();
                   System.out.println(cur);
               }
           }
           count++;
        }
    }
    
    public static boolean backtrack(int i,int j,int sum,int steps,Stack<String> st,HashSet<String> hash){
		//System.out.println("sum:"+sum+"	steps="+steps);
		if(i<0 || i>=500 || j<0 || j>=500 || sum<0){
			return false;
		}
		hash.add(""+i+" "+j);
		if(sum==0){
			st.push(new String(""+i+" "+j));
			return true;
		}
        if(steps==1 && sum>0){
            return false;
        }else if(steps >=1 && sum==0){
            return true;
        }else{
            if(!hash.contains(""+(i+1)+" "+j) && backtrack(i+1,j,sum-pas[i-1][j-1],steps-1,st,hash)){
                st.push(new String(""+i+" "+j));
                return true;
            }else if(!hash.contains(""+i+" "+(j+1)) && backtrack(i,j+1,sum-pas[i-1][j-1],steps-1,st,hash)){
                st.push(new String(""+i+" "+j));
                return true;
            }else if(!hash.contains(""+(i-1)+" "+j) && backtrack(i-1,j,sum-pas[i-1][j-1],steps-1,st,hash)){
                st.push(new String(""+i+" "+j));
                return true;
            }else if(!hash.contains(""+i+" "+(j-1)) && backtrack(i,j-1,sum-pas[i-1][j-1],steps-1,st,hash)){
                st.push(new String(""+i+" "+j));
                return true;
            }else if(!hash.contains(""+(i+1)+" "+(j-1)) && backtrack(i+1,j-1,sum-pas[i-1][j-1],steps-1,st,hash)){
                st.push(new String(""+i+" "+j));
                return true;
            }else if(!hash.contains(""+(i-1)+" "+(j+1)) && backtrack(i-1,j+1,sum-pas[i-1][j-1],steps-1,st,hash)){
                st.push(new String(""+i+" "+j));
                return true;
            }
        }
        hash.remove(""+i+" "+j);
        return false;
    }
}