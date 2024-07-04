import java.util.*;
import java.io.*;

class Pair{
    int x;
    int y;
    Pair(int a, int b){
        x=a;
        y=b;
    }
    // @Override
    public boolean equals(Pair p) 
    {
        if(p.x == this.x && p.y==this.y)
            return true;
        return false;
    }
}


public class Solution{

    public static int f(int[][] arr, int r, int c){
        int sum = 0;
        HashMap<Pair,ArrayList> mmap = new HashMap<Pair,ArrayList>();
        ArrayList<Pair> marked = new ArrayList<Pair>();
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                sum += arr[i][j];
                double cur = 0;
                int count=0;
                if(j>0){
                    cur += arr[i][j-1];
                    count++;
                }
                if(j<c-1){
                    count++;
                    cur+= arr[i][j+1];
                }
                if(i<r-1){
                    count++;
                    cur+= arr[i+1][j];
                }
                if(i>0){
                    count++;
                    cur += arr[i-1][j];
                }
                if(cur/count > arr[i][j] ){
                    marked.add(new Pair(i,j));
                }
            }
        }
        for(Pair p:marked){
            arr[p.x][p.y]=-1;
        }
        

        // initialise
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(arr[i][j]!= -1){
                    mmap.put(new Pair(i,j), findpair(arr,i,j));
                }
            }
        }
        // System.out.println("sum is"+Integer.toString(sum));
        // main loop
        while(marked.size()!=0){
            marked.clear();
            // System.out.println(mmap.size());

            for(Pair p:mmap.keySet()){
                sum += arr[p.x][p.y];
                // System.out.println("map"+Integer.toString(p.x)+" "+Integer.toString(p.y));
                double temp = 0;
                ArrayList<Pair> aaaa = mmap.get(p);
                for(Pair nbr:aaaa){
                    temp += arr[nbr.x][nbr.y];
                }
                temp = temp/mmap.get(p).size();
                if(arr[p.x][p.y]<temp){
                    marked.add(p);
                }
            }
            // System.out.println(Arrays.deepToString(arr));
            for(Pair p:marked){
                // System.out.println(Integer.toString(p.x)+" "+Integer.toString(p.y));
                arr[p.x][p.y]=-1;
                ArrayList<Pair> bbb = mmap.get(p);
                // System.out.println(bbb.size());
                for(Pair nbr:bbb){
                    if(arr[nbr.x][nbr.y]!=-1){
                        ArrayList<Pair> temp = mmap.replace(nbr, findpair(arr, nbr.x, nbr.y));
                    }
                }
                mmap.remove(p);
            }
            // System.out.println("sum is"+Integer.toString(sum));

        }
        return sum;
    }
    public static ArrayList<Pair> findpair(int[][] arr,int a, int b){
        ArrayList<Pair> toreturn = new ArrayList<Pair>();
        int k=a+1;
        while(k<arr.length){
            if(arr[k][b]!= -1){
                toreturn.add(new Pair(k,b));
                break;
            }
            k++;
        }
        k=a-1;
        while(k>=0){
            if(arr[k][b]!= -1){
                toreturn.add(new Pair(k,b));
                break;
            }
            k--;
        }
        k=b+1;
        while(k<arr[0].length){
            if(arr[a][k]!= -1){
                toreturn.add(new Pair(a,k));
                break;
            }
            k++;
        }
        k=b-1;
        while(k>=0){
            if(arr[a][k]!= -1){
                toreturn.add(new Pair(a,k));
                break;
            }
            k--;
        }
        return toreturn;
    }
    public static void main(String[] args){
        Scanner s= new Scanner(System.in);
        int T = s.nextInt();
        for(int t=0;t<T;t++){
            int r = s.nextInt();
            int c = s.nextInt();
            int[][] arr = new int[r][c];
            for(int i=0;i<r;i++){
                for(int j=0;j<c;j++){
                    arr[i][j] = s.nextInt();
                }
            }
            int toreturn = f(arr,r,c);
            System.out.println("Case #"+Integer.toString(t+1)+": "+toreturn);
        }
        
    }
}