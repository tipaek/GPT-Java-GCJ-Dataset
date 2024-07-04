import java.util.*;
    import java.io.*;
    public class Solution {
      public static void main(String[] args) {
         Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); 
        for (int i = 1; i <= t; ++i) {
        int k = in.nextInt();
        int sum=0;
        int count1=0;
        int count2=0;
        int ar[][] = new int[k][k];
            
            for(int x=0 ; x<k ; x++){
            Set<Integer> lump = new HashSet<Integer>();
            boolean b=true;
                for(int y=0 ; y<k ; y++){
                    ar[x][y]=in.nextInt();
                    if(x==y){
                        sum+=ar[x][y];
                    }

                    if(b){
                        if (lump.contains(ar[x][y])){
                            count1++;
                            b=false;
                            
                        }
                        else{    
                            lump.add(ar[x][y]);
                        }
                    }        
                }
            }

            for(int x=0 ; x<k ; x++){
                Set<Integer> lump = new HashSet<Integer>();
                boolean b=true;
                for(int y=0 ; y<k ; y++){
                    int temp=ar[y][x];
                    if(b){
                        if (lump.contains(temp)){
                            count2++;
                            b=false;
                            
                        }
                        else{    
                            lump.add(temp);
                        }
                    }        
                }
            }    
            System.out.println("Case #" + i + ": "+ sum + " " + count1 + " " + count2);
        }
    }
}  