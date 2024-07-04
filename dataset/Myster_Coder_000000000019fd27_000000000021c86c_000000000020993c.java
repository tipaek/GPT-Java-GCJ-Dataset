import java.awt.*;
import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t,n;
        t=Integer.parseInt(in.readLine());
        for(int a=0;a<t;a++){
            n=Integer.parseInt(in.readLine());
            int ar[][]=new int[n][n];
            long k=0;
            int row=0, col=0;
            for(int b=0;b<n;b++){
                String str[]=in.readLine().split(" ");
                ArrayList<Integer> elements=new ArrayList<>();
                boolean isComputed=false;
                for(int c=0;c<n;c++){
                    ar[b][c]=Integer.parseInt(str[c]);
                    if(b==c)
                        k+=ar[b][c];
                    if(elements.contains(ar[b][c]) && !isComputed){
                        row++;
                        isComputed=true;
                    }
                    else
                    {
                        elements.add(ar[b][c]);
                    }
                }
            }

            for(int b=0;b<n;b++){
                ArrayList<Integer> elements=new ArrayList<>();
                for(int c=0;c<n;c++){
                    if(elements.contains(ar[c][b])){
                        col++;
                        break;
                    }
                    else
                    {
                        elements.add(ar[c][b]);
                    }
                }
            }
            System.out.println("Case #"+(a+1)+": "+k+" "+row+" "+col);
        }
    }
}

