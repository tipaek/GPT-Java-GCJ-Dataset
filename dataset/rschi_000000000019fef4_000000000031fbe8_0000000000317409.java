import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {
    Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
    /*Scanner in = new Scanner("5\n"
        + "4 4 SSSS\n"
        + "3 0 SNSS\n"
        + "2 10 NSNNSN\n"
        + "0 1 S\n"
        + "2 7 SSSSSSSS\n");*/
    int cases = in.nextInt();
    for (int a = 1; a <= cases; ++a) {
      int x = in.nextInt();
      int y = in.nextInt();

      final String movement = in.next();

      final Parade game = new Parade(a, x, y, movement.toCharArray());
      game.solve();

      System.out.println(game.print());

    }

  }
}

class Parade {

  int x;
  int y;
  char[] movement;
  int stepcounter = 0;

  int caseId;
  final String output;
  boolean impossible =false;


  public Parade(int caseId, int x, int y, char[] movement) {
    this.x = x;
    this.y = y;
    this.caseId = caseId;
    this.movement = movement;
    output = "CASE #" + caseId + ": ";
  }

  public void solve(){
    int distance= Math.abs(x) + Math.abs(y);
    if(!sanityCheck(distance)) {
      impossible = true;
      return;
    }

    if(check(distance)){
      return;
    }else{
      move();
      solve();

      return;
    }
  }

  private void move() {
    final char dir = movement[stepcounter];
    switch (dir){
      case 'N':
        y=y+1;
        break;
        case 'S':
        y=y-1;
        break;
        case 'E':
        x=x+1;
        break;
        case 'W':
        x=x-1;
        break;
      default:
        throw new RuntimeException("INVALID");
    }
    stepcounter++;
  }

  public boolean check(final int distance){
    if(distance > stepcounter)
     return false;
    else {
      return true;
    }
  }

  public boolean sanityCheck(int distance){

    return (distance-stepcounter) - (2*(movement.length-stepcounter)) <= 0;
  }

  public String print() {
    if(impossible){
      return output + "IMPOSSIBLE";
    }

    return output +stepcounter;
  }
}