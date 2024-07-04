import java.util.Scanner;
import java.util.*;
public class Solution {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int cas = sc.nextInt(); 
        for (int c=0; c<cas; c++) {
            int hor = sc.nextInt();
            int ver = sc.nextInt();
            int[][] floor = new int[ver][hor];
            for (int i = 0; i<ver; i++) {
                for (int j = 0; j<hor; j++) {
                    floor[i][j]=sc.nextInt();
                }
            }
            int[][] floorElim = new int[ver][hor];
            for (int i = 0; i<ver; i++) {
                for (int j = 0; j<hor; j++) {
                    floorElim[i][j]=1;
                }
            }
            int totalPeople = ver*hor+1;
            int score = 0;
            while (true) {
                int people = 0;
                for (int[] row: floorElim) {
                    for (int i: row) {
                        if (i==1) {
                            people++;
                        }
                    }
                }
                if (people==totalPeople) {
                    break;
                }
                totalPeople=people;

                for (int i = 0; i<ver; i++) {
                    for (int j = 0; j<hor; j++) {
                        score+=floor[i][j]*floorElim[i][j];
                    }
                }
                ArrayList<Integer> one = new ArrayList<Integer>();
                ArrayList<Integer> two = new ArrayList<Integer>();
                for (int i = 0; i<ver; i++) {
                    for (int j = 0; j<hor; j++) {
                        if (floorElim[i][j]==1) {
                            int found = 0;
                            int running = 0;
                            boolean br1=false;
                            boolean br2=false;
                            boolean br3=false;
                            boolean br4=false;
                            for (int start = i-1; start>=0; start--) {
                                if (start<0) {
                                    continue;
                                }
                                if ((floorElim[start][j]==1)&&(!br1)) {
                                    found++;
                                    running+=floor[start][j];
                                    br1=true;
                                }
                                
                            }
                            

                            for (int start = i+1; start<ver; start++) {
                                if (start>ver) {
                                    continue;
                                }
                                if ((floorElim[start][j]==1)&&(!br2)) {
                                    found++;
                                    running+=floor[start][j];
                                    br2=true;
                                }
                            }

                            
                            for (int start = j-1; start>=0; start--) {
                                if (start<0) {
                                    continue;
                                }
                                if ((floorElim[i][start]==1)&&(!br3)) {
                                    found++;
                                    running+=floor[i][start];
                                    br3=true;
                                }
                            }

                            for (int start = j+1; start<hor; start++) {
                                if (start>hor) {
                                    continue;
                                }
                                if ((floorElim[i][start]==1)&&(!br4)) {
                                    found++;
                                    running+=floor[i][start];
                                    br4=true;
                                }
                                
                            }
                            
                            double average = 0;
                            if (found!=0) {
                                average=(double)running/found;
                            }
                            if (average>(double)floor[i][j]) {
                                one.add(i);
                                two.add(j);
                            }
                        }
                    }
                }
                for (int i = 0; i<one.size(); i++) {
                    floorElim[one.get(i)][two.get(i)]=0;
                }
                System.out.println("Case #"+(c+1)+": "+score);
            }
        }
    }
}
