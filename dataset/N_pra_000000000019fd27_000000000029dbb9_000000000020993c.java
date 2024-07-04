import java.util.ArrayList;
import java.util.Scanner;

public class Vestigium {

  public static void main(String[] args) throws CloneNotSupportedException {

    Scanner scanner=new Scanner(System.in);
    int t=scanner.nextInt();
    scanner.nextLine();
    ArrayList<SsqMatrix> arrayList=new ArrayList<>(t);
    ArrayList<Integer> arrayList1;
    int n;
    SsqMatrix sqMatrix;
    for (int i=0;i<t;i++){
      n=scanner.nextInt();scanner.nextLine();
      arrayList1=new ArrayList<>(n);
      sqMatrix=new SsqMatrix(n);
      for (int j=0;j<n;j++){
        for (int k=0;k<n;k++)
          arrayList1.add(scanner.nextInt());
        scanner.nextLine();
        sqMatrix.setinnerArrayLists(arrayList1);
        arrayList1=new ArrayList<>(n);
      }
      arrayList.add(sqMatrix);
    }
    Ccalculator calculator=new Ccalculator(arrayList);
    for (int i=0;i<t;i++){
      System.out.printf("Case #%d: %d %d %d",i+1,calculator.trace(i),calculator.raw(i),calculator.colomn(i));
      System.out.println();
    }

  }

}

class Calculator {

  private ArrayList<SsqMatrix> arraylist;

  public Calculator(ArrayList<SsqMatrix> arraylist) {
    this.arraylist = arraylist;
  }

  public int trace(int index){

    SsqMatrix sqMatrix=this.arraylist.get(index);
    int n=sqMatrix.getN();
    int trace=0;
    for (int i=0;i<n;i++)
      trace+=sqMatrix.getinnerArrayLists(i).get(i);
    return trace;

  }

  public int raw(int index) throws CloneNotSupportedException {

    int raw=0;
    SsqMatrix sqMatrix=this.arraylist.get(index).clone();
    IinsertSort insertSort;
    ArrayList<Integer> arrayList;
    int n=sqMatrix.getN();
    for (int i=0;i<n;i++){
      arrayList=sqMatrix.getinnerArrayLists(i);
      insertSort = new IinsertSort(arrayList);
      insertSort.getSorted();
      arrayList=sqMatrix.getinnerArrayLists(i);
      for (int j=0;j<n-1;j++) {
        if(arrayList.get(j)==arrayList.get(j+1)) {
          raw++;
          break;
        }
      }
    }
    return raw;

  }

  public int colomn(int index) throws CloneNotSupportedException {

    int colomn=0;
    SsqMatrix sqMatrix=this.arraylist.get(index).clone();
    IinsertSort insertSort;
    ArrayList<Integer> arrayList;
    int n=sqMatrix.getN();
    for (int i=0;i<n;i++){
      arrayList=sqMatrix.colomnGenrater(i);
      insertSort = new IinsertSort(arrayList);
      insertSort.getSorted();
      for (int j=0;j<n-1;j++) {
        if(arrayList.get(j)==arrayList.get(j+1)) {
          colomn++;
          break;
        }
      }
    }
    return colomn;
  }

}

class InsertSort {

  private ArrayList<Integer> a;

  public InsertSort(ArrayList<Integer> a) {
    this.a=a;
  }

  public void getSorted() {

    for (int i = 0; i < this.a.size() - 1; i++) {

      int j = i, temp = a.get(j + 1), in = j;
      boolean depend = false;

      while (a.get(j) >= temp) {

        depend = true;
        a.set(j + 1, a.get(j));
        in = j;
        if (j == 0)
          break;
        j--;

      }

      if (depend == true)
        a.set(in, temp);

    }
  }

}

class SqMatrix implements Cloneable{

  private int n;
  private ArrayList<ArrayList<Integer>> arrayLists;

  public SqMatrix(int n) {
    this.n = n;
    this.arrayLists=new ArrayList<>(n);

  }

  public ArrayList<ArrayList<Integer>> getArrayLists() {
    return arrayLists;
  }

  public void setArrayLists(ArrayList<ArrayList<Integer>> arrayLists) {
    this.arrayLists = arrayLists;
  }

  public ArrayList<Integer> getinnerArrayLists(int index) {
    return arrayLists.get(index);
  }

  public void setinnerArrayLists(ArrayList<Integer> arrayLists) {
    this.arrayLists.add(arrayLists);
  }

  public int getN() {
    return n;
  }

  @Override
  public SsqMatrix clone() throws CloneNotSupportedException{

    SsqMatrix cloned = (SsqMatrix)super.clone();
    cloned.setArrayLists(new ArrayList<>());
    for (int i=0;i<this.n;i++)
      cloned.setinnerArrayLists((ArrayList<Integer>)this.arrayLists.get(i).clone());
    return cloned;

  }

  public ArrayList<Integer> colomnGenrater(int index){

    ArrayList<Integer> arrayList=new ArrayList<>(this.n);
    for (int i=0;i<this.n;i++)
      arrayList.add(this.arrayLists.get(i).get(index));

    return arrayList;

  }

}
