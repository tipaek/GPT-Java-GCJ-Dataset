import java.util.*;
import java.io.*;

public class Solution {
    public static int[][] floor;
    public static int C;
    public static int R;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(in.readLine());
        int t = Integer.parseInt(st.nextToken());
        for (int test = 0; test<t; test++){
            StringTokenizer dimensions = new StringTokenizer(in.readLine());
             R = Integer.parseInt(dimensions.nextToken());
            C = Integer.parseInt(dimensions.nextToken());

             floor = new int[R][C];
            for (int i = 0; i<R; i++){
                StringTokenizer tt = new StringTokenizer((in.readLine()));
                for (int j = 0; j<C; j++){
                    floor[i][j] = Integer.parseInt(tt.nextToken());
                }
            }
            int round = 1;
            int interestLevel =0;
            boolean bingBong = true;
            while (bingBong){
                ArrayList<int[]> badList = new ArrayList<>();
                for (int i = 0; i<R; i++){
                    for (int j = 0; j<C; j++){
                        if (floor[i][j] == 0){
                            continue;
                        }
                        interestLevel+= floor[i][j];
                        ArrayList<Integer> neighbors = determineNeighbors(i,j);
                        if (neighbors.size() == 0){
                            continue;
                        }
                        float avg = findAverage(neighbors);
                        if((float)floor[i][j] < avg){
                            int[] d = {i,j};
                            badList.add(d);
                        }
                    }
                }
                //printarray();
                round++;
                if (badList.size() == 0){
                    bingBong = false;
                }
                for (int[] a : badList){
                    floor[a[0]][a[1]] = 0;
                }
            }
            System.out.println("Case #"+ (test+1)+": " + interestLevel);
        }


        // close the output file
    }

    public static ArrayList<Integer> determineNeighbors(int i, int j){
        ArrayList<Integer> out = new ArrayList<>();
        int r = i+1;
        while(r<R){
            if (floor[r][j] != 0){
                out.add(floor[r][j]);
                break;
            }
            r++;
        }
        int w= i-1;
        while(w>=0){
            if (floor[w][j] != 0){
                out.add(floor[w][j]);
                break;
            }
            w--;
        }
        int q = j+1;
        while(q<C){
            if (floor[i][q] != 0){
                out.add(floor[i][q]);
                break;
            }
            q++;
        }
        int x = j-1;
        while(x>=0){
            if (floor[i][x] != 0){
                out.add(floor[i][x]);
                break;
            }
            x--;
        }
        return out;
    }

    public static float findAverage(ArrayList<Integer> a){
        float sum = 0;
        for (int b : a){
            sum+=b;
        }
        return sum/a.size();
    }
    public static void printarray(){
        for (int[] a : floor){
            for (int b: a){
                System.out.print(" "+b+ " ");
            }
            System.out.println("");
        }
    }
}
