
import java.util.ArrayList;
import java.util.Scanner;

public class Solution {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    int t = scanner.nextInt();
    scanner.nextLine();
    int n;
    ArrayList<Tasks> arrayList1=new ArrayList<>(t);
    for (int i=0;i<t;i++){
      n=scanner.nextInt();scanner.nextLine();
      Tasks tasks;
      ArrayList<Pair> arrayList=new ArrayList<>();
      for (int j=0;j<n;j++){
        arrayList.add(new Pair(scanner.nextInt(),scanner.nextInt()));
        scanner.nextLine();
      }
      tasks=new Tasks(n,arrayList);
      arrayList1.add(tasks);
    }
    for (int i=0;i<t;i++) {
      System.out.printf("Case #%d: %s",i,arrayList1.get(i).generate());
      System.out.println();
    }

  }
}

class Tasks{

  private int n;
  private ArrayList<Pair> arrayList;
  private boolean [] C;
  private boolean [] J;

  public Tasks(int n, ArrayList<Pair> arrayList) {
    this.n = n;
    this.arrayList=arrayList;
    C=new boolean[this.biggest()+1];
    J=new boolean[this.biggest()+1];
  }

  public int getN() {
    return n;
  }

  public ArrayList<Pair> getArrayList() {
    return arrayList;
  }

  private int biggest(){
    int biggest=-1,end;
    for (Pair p:this.arrayList) {
      end=p.getEnd();
      if(end>biggest)
        biggest=end;
    }
    return biggest;
  }

  public String generate(){

    String string = "";
    int end,commence;
    for (int i=0;i<n;i++){
      commence=this.arrayList.get(i).getCommence();
      end=this.arrayList.get(i).getEnd();
      if(C[commence]==false && C[end]==false||C[commence+1]==false && C[end]==false) {
        for (int j = commence; j <= end; j++)
          C[j] = true;
        string+="C";
      }
      else if (J[commence] == false && J[end] == false||J[commence+1]==false && J[end]==false) {
          for (int j = commence; j <= end; j++)
            J[j] = true;
          string+="J";
      }
      else {
        string = "IMPOSSIBLE";
        break;
      }
    }
    return string;
  }



}









class Pair{

  private int commence;
  private int end;

  public Pair(int commence, int end) {
    this.commence = commence;
    this.end = end;
  }

  public int getCommence() {
    return commence;
  }

  public int getEnd() {
    return end;
  }
}
