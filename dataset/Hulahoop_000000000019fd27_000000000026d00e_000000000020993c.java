import java.util.*;
class Solution{
    public static void main(String args[]){
        Scanner d = new Scanner(System.in);
        int test = d.nextInt();
        int p=1;
        while(p<=test){
            int n =  d.nextInt();
            int m[][] = new int[n][n];
            int t=0, r=0, c=0, i=0, j=0;
            Map<Integer,Integer> mr = new HashMap<>();
            while(i<n){
                while(j<n){
                    m[i][j] = d.nextInt();
                    if(i==j){
                        t += m[i][j];
                    }
                    j++;
                }  
                i++;
                j=0;
            }
            
            i=0;
            j=0;
            while(i<n){
                while(j<n){
                	if(mr.containsKey(m[i][j]))
                    	mr.put(m[i][j], mr.get(m[i][j])+1);   
                    else
                    	mr.put(m[i][j],1);
                    if(mr.get(m[i][j])>1){
                        r++;
                        j=0;
                        break;
                    }
                    j++;
                }
                mr.replaceAll( (k,v)->v=0 );
                i++;
                j=0;
            }
            
            i=0;
            j=0;
            mr.replaceAll( (k,v)->v=0 );

            while(j<n){
                while(i<n){
                	if(mr.containsKey(m[i][j]))
                    	mr.put(m[i][j], mr.get(m[i][j])+1);   
                    else
                    	mr.put(m[i][j],1);
                    if(mr.get(m[i][j])>1){
                        c++;
                        i=0;
                        break;
                    }
                    i++;
                }
                mr.replaceAll( (k,v)->v=0 );
                j++;
                i=0;
            }
            System.out.println();

            System.out.println("Case #" + p +": " + t + " " + r + " " + c);
            p++;
        }
    }
}