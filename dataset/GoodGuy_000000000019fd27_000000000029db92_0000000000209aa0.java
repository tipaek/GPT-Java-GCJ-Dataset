import java.util.*;

public class Solution {

  public static void makematrix(int latins,int mazed){
    int[][] matrix = new int[mazed][mazed];
    int temp = latins/mazed;
      for(int i=0;i<mazed;i++){
        
        if(temp>mazed){
            temp = 1;
          }
        for(int j=0;j<mazed;j++){
          matrix[i][j] = temp;
          temp--;
          if(temp==0){
          temp = mazed;
        }
        }
        temp++;
      }

    for(int i=0;i<mazed;i++){
      for(int j=0;j<mazed;j++){
        System.out.print(matrix[i][j]+" ");
      }
      System.out.println();
    }

  }

  public static void calculatepossibility(int mazed,int latins,int testnumber){
    String reply ="IMPOSSIBLE";
    HashSet hs = new HashSet<Integer>();
    int temp=0;
    for(int i=1;i<mazed+1;i++){
      hs.add(i*mazed);
    }
    for(int i=1;i<=mazed;i++){
      temp +=i;
    }
    hs.add(temp);
    //System.out.println(hs);

    if(mazed ==2 && hs.contains(3)){
      hs.remove(3);
    }

    if(hs.contains(latins)){
      reply = "POSSIBLE";
    }
    
    if(mazed == 2 && latins == 3){
      reply = "IMPOSSIBLE";
    }
    System.out.print("Case #"+testnumber+": "+reply);
    if(reply.equals("POSSIBLE")){
      System.out.println();
      makematrix(latins,mazed);
    }
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int nooftests = sc.nextInt();
    for(int i=0;i<nooftests;i++){
      int mazedimention = sc.nextInt();
      int latinsum = sc.nextInt();
      calculatepossibility(mazedimention,latinsum,i+1);
    }
  }
}