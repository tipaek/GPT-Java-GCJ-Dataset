import java.io.*;
import java.util.*;

public class Solution {
public static void sortbyColumn(int arr[][], int col)
    {
      
        Arrays.sort(arr, new Comparator<int[]>() {

            @Override
            
            public int compare(final int[] entry1,
                               final int[] entry2) {

                
                if (entry1[col] >=entry2[col])
                    return 1;
                else
                    return -1;
            }
        });  
    }
   
   

    public static void main(String[] args) throws IOException {
        Scanner scan = new Scanner(System.in);
        int a=scan.nextInt();
        for(int i=0;i<a;i++){
            int n=scan.nextInt();
            int rui[][]=new int[n][2];
            ArrayList<int[][]> ruiindex=new ArrayList<>();
            for(int j=0;j<n;j++){
                int ti=scan.nextInt();
                int tf=scan.nextInt();
                rui[j][0]=ti;
                rui[j][1]=tf;
                int[][] x =new int[1][2];
                x[0][0]=ti;
                x[0][1]=tf;
                ruiindex.add(x);
            }
            sortbyColumn(rui,0);
            ArrayList<int[][]> C=new ArrayList<>();
            ArrayList<int[][]> J=new ArrayList<>();
            Set<Integer> posset=new HashSet<>();
            char[] anser=new char[n];
            int cc=0;
            int jc=0;
            boolean anst=false;
            for(int j=0;j<n;j++){
                int ti=rui[j][0];
                int tf=rui[j][1];
                boolean cf=false;
                boolean jf=false;
                for(int[][] o:C){
                    if(((ti>=o[0][0])&&ti<o[0][1])||((tf>o[0][0])&&tf<=o[0][1]))
                    {
                        cf=true;
                        break;
                    }
                }
                if(!cf){
                            int[][] x=new int[1][2];
                            x[0][0]=ti;
                            x[0][1]=tf;
                            C.add(x);
                            int pos=0;
                            for(int[][] o:ruiindex){
                                if(o[0][0]==ti&&o[0][1]==tf) {
                                    if(!posset.contains(pos))
                                    {
                                        posset.add(pos);
                                        break;
                                    }
                                }
                                pos++;
                            }
                            
                            anser[pos]='C';
                            cc++;
                    }
                else{
                    for(int[][] o:J){
                        if(((ti>=o[0][0])&&ti<o[0][1])||((tf>o[0][0])&&tf<=o[0][1]))
                        {
                            jf=true;
                            break;
                        }
                    }
                    if(!jf){
                        int[][] x=new int[1][2];
                        x[0][0]=ti;
                        x[0][1]=tf;
                        J.add(x);
                        int pos=0;
                        for(int[][] o:ruiindex){
                            if(o[0][0]==ti&&o[0][1]==tf) {
                                if(!posset.contains(pos)) {
                                    posset.add(pos);
                                    break;
                                }
                            }
                            pos++;
                        }
                        
                        anser[pos]='J';
                        jc++;
                    }
                    else {
                        anst=true;
                    }
                }
            }
            if(anst)
                System.out.println("Case #"+(i+1)+": IMPOSSIBLE");
            else{
                StringBuilder ans=new StringBuilder("");
                for(int j=0;j<n;j++)
                    ans.append(anser[j]);
                System.out.println("Case #"+(i+1)+": "+ans);
            }

        }
       
    }
}