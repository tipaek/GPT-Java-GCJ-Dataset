import java.util.*;
    import java.io.*;
    public class Solution {
        
      public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        int t = in.nextInt(); // Scanner has functions to read ints, longs, strings, chars, etc.
        for (int i = 1; i <= t; ++i) {
           int A=in.nextInt();
           int act[][]=new int[A][3];
           for(int q=0;q<A;q++){
            act[q][0]=q;
            act[q][1]=in.nextInt();
            act[q][2]=in.nextInt();
            }
            Arrays.sort(act,new Comparator<int[]>(){
                @Override
                public int compare(final int[] entry1,final int[] entry2){
                if(entry1[1]>entry2[1]) return 1;
                else return -1;
                }
            });
            String Result="";
            char ans[]=new char[A];
            int Cs=0,Ce=0,Js=0,Je=0;
            boolean C=false,J=false; 
            for(int q=0;q<A;q++){
            
            
            if(Ce<=act[q][1]){
                Cs=act[q][1];
                 Ce=act[q][2];
                 ans[act[q][0]]='C';
                 
                
                }
            else if(Je<=act[q][1]){
                Js=act[q][1];
                Je=act[q][2];
                 ans[act[q][0]]='J';
                }
             else {
                Result="IMPOSSIBLE";
                break;
                }
            
            }
            if(!Result.equals("IMPOSSIBLE"))
            Result=new String(ans);
          System.out.println("Case #" + i + ": " +Result );
        }
      }
    }