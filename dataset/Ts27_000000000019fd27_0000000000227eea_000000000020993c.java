import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner s=new Scanner(System.in);
        int test=s.nextInt();
        int count=1;
        while(test-->0) {
            int n=s.nextInt();
            int a[][]=new int[n][n];
            HashMap<Integer,Integer> mr=new HashMap<>();;
            HashMap<Integer,Integer> mc=new HashMap<>();;
            int row=0;
            int column=0;
            int trace=0;
            Integer cr,cc;
            for(int i=0;i<n;i++) {
                mr.clear();
                for(int j=0;j<n;j++) {
                    a[i][j]=s.nextInt();
                    if(i==j)
                        trace+=a[i][i];
                    
                }
            }
            for(int i=0;i<n;i++) {
                mc.clear();
                for(int j=0;j<n;j++) {
                    cc=mc.get(a[j][i]);
                    if(cc==null)
                        mc.put(a[j][i],0);
                    else if(cc==0){
                        column++;
                        mc.put(a[j][i],1);
                        break;
                    }
                }
            }
            for(int i=0;i<n;i++) {
                mr.clear();
                for(int j=0;j<n;j++) {
                    cr=mr.get(a[i][j]);
                    if(cr==null) 
                        mr.put(a[i][j], 0);
                    else if(cr==0){
                        row++;
                        mr.put(a[i][j], 1);
                        
                        break;
                    }
                }
            }
            
        
             System.out.println("Case #"+(count++)+": "+trace+" "+row+" "+column);
            }
       }
       
       
}