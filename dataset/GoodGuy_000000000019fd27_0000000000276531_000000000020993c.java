import java.util.*;

public class Solution{

  public static void mazesolution(int[][] maze,int sizeofmaze,int nooftest){
    int sum = 0;
    int reptrow=0;
    int reptcol=0;
    for(int i=0;i<sizeofmaze;i++){
      sum += maze[i][i];
    }
    for(int i=0;i<sizeofmaze;i++){
      HashSet<Integer>  row = new HashSet<>();
      HashSet<Integer> col = new HashSet<>();
      for(int j = 0;j<sizeofmaze;j++){
        row.add(maze[i][j]);
        col.add(maze[j][i]);

      }
      if(row.size() != sizeofmaze){
        reptrow++;
      }
       if(col.size() != sizeofmaze){
         reptcol++;
       }
    }

    System.out.println("Case #"+nooftest+": "+sum+" "+reptrow+" "+reptcol);
  }

  public static void main(String args[]){
    Scanner sc = new Scanner(System.in);

    int nooftests = sc.nextInt();
    for(int t = 0;t<nooftests; t++ ){
      int sizeofmaze = sc.nextInt();
      int maze[][] = new int[sizeofmaze][sizeofmaze];
      for(int i=0;i<sizeofmaze;i++){
        for(int j=0;j<sizeofmaze;j++){
          maze[i][j] = sc.nextInt();
        }
      }
      mazesolution(maze,sizeofmaze,t+1);
      
    }

  }
}
