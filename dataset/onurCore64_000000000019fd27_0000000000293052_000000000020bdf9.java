import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
class Solution{
  public static String isBipartite(Node[] node) throws NullPointerException{
    ArrayList<Integer> first = new ArrayList<Integer>();
    ArrayList<Integer> sec = new ArrayList<Integer>();
    int n = 0;
    String s = new String();
   
    while(n < node.length){
      if(node[n].getBool() == 0){
        node[n].setBool(1);
      }else if(node[n].getBool() == 1){
        for(int j = 0; j < node[n].getNode().length;j++){
           if(node[node[n].getNode()[j]].getBool() == 0){
            node[node[n].getNode()[j]].setBool(2);
          }else if(n < node[n].getNode()[j] && node[node[n].getNode()[j]].getBool() == 1){
           return "IMPOSSIBLE";
          }
         
        }
        n++;
      }else if(node[n].getBool() == 2){
        for(int j = 0; j < node[n].getNode().length;j++){
          if(node[node[n].getNode()[j]].getBool() == 0){
            node[node[n].getNode()[j]].setBool(1);
          }else if(n < node[n].getNode()[j] && node[node[n].getNode()[j]].getBool() == 2){
            return "IMPOSSIBLE";
          }
        }
        n++;
      }
    }
    for(int t = 0;t < node.length;t++){
      if(node[t].getBool() == 1){
        s = s + "C";
        first.add(t);
      }else if(node[t].getBool() == 2){
        s = s + "J"; 
        sec.add(t);
      }
      
    }
    return s;
  }
  public static NodeArray Graphizer(int[][] a) throws NullPointerException{
    Node[] node = new Node[a.length];
    ArrayList<Integer> nodes = new ArrayList<Integer>();
    DoubleInt di;
    int[] nodesInt;
    int first = 0;
    int k = 0;
    ArrayList<DoubleInt> array = new ArrayList<DoubleInt>();
    for(int i = 0;i < a.length;i++){
      di = new DoubleInt(a[i][0],a[i][1],i);
      array.add(di);
    }
    array = quickSort(array);
    ArrayList<Integer> list = new ArrayList<Integer>();
    int[][] arr = new int[a.length][2];
    for(int j = 0;j < a.length;j++){
      arr[j][0] = array.get(j).first;
      arr[j][1] = array.get(j).second;
      list.add(array.get(j).third);
    }
    for(int t = 0;t < a.length;t++){
      nodes = new ArrayList<Integer>();
      first = arr[t][1];
      k = t + 1;
      while(k < arr.length && arr[k][0] < first){
        nodes.add(k);
        k++;
      }
     
      nodesInt = new int[nodes.size()];
      
      for(int r = 0;r < nodes.size();r++){
        nodesInt[r] = nodes.get(r); 
      }
      node[t] = new Node();
      node[t].setNode(nodesInt);
    }
    NodeArray nd = new NodeArray(node,list);
    return nd;
  }
  public static ArrayList<DoubleInt> quickSort(ArrayList<DoubleInt> b){
    if(b.size() == 1 || b.size() == 0){
      return b;
    }else{
      int temp = b.size() / 2;
      ArrayList<DoubleInt> part_1 = new ArrayList<DoubleInt>();
      ArrayList<DoubleInt> part_2 = new ArrayList<DoubleInt>();
      for(int i = 0;i < temp;i++){
        if(b.get(i).first <= b.get(temp).first){
          part_1.add(b.get(i));
        }else{
          part_2.add(b.get(i));
        }
      }
      for(int i = temp + 1;i < b.size();i++){
        if(b.get(i).first <= b.get(temp).first){
          part_1.add(b.get(i));
        }else{
          part_2.add(b.get(i));
        }
      }
      ArrayList<DoubleInt> sorted_1 = quickSort(part_1);
      ArrayList<DoubleInt> sorted_2 = quickSort(part_2);
      sorted_1.add(b.get(temp));
      sorted_1.addAll(sorted_2);
      return sorted_1;
    }
  }
  public static void main(String[] arg) throws NullPointerException {
    Scanner in = new Scanner(System.in);
    ArrayList<Integer> map = new ArrayList<Integer>();
    String rep = new String();
    int n = in.nextInt();
    int l = 0;
    int[][] a;
    String re;
    for(int i = 0;i < n;i++){
      l = in.nextInt();
      a = new int[l][2];
      for(int j = 0;j < l;j++){
        a[j][0] = in.nextInt();
        a[j][1] = in.nextInt();
      }
      NodeArray nd = Graphizer(a);
      rep = new String();
      re = isBipartite(nd.n);
      map = nd.a;
      if(!re.equals("IMPOSSIBLE")){
        for(int m = 0;m < map.size();m++){
          rep = rep + "a";
        }
        for(int t = 0;t < map.size();t++){
          rep = rep.substring(0,map.get(t)) + re.substring(t,t + 1) + rep.substring(map.get(t) + 1,rep.length());
         
        }
      }else{
        rep = "IMPOSSIBLE";
      }
      System.out.println("Case #" + (i + 1) +": " + rep);
    }
    in.close();
  }
}
class Node{
  private int[] node;
  private int bool = 0;
  public void setBool(int b){
    this.bool = b;
  }
  public void setNode(int[] node){
    this.node = node;
  }
  public int[] getNode(){
    return node;
  }
  public int getBool(){
    return this.bool;
  }
}
class Boolean{
  public boolean b;
  public void setBoolean(boolean b){
    this.b = b;
  }public boolean getBoolean(){
    return this.b;
  }
  
}
class DoubleInt{
    public int first;
    public int second;
    public int third;
    public DoubleInt(int i,int j,int k){
      first = i;
      second = j;
      third = k;
    }
  }
class NodeArray{
public Node[] n;
public ArrayList<Integer> a;
NodeArray(Node[] ni,ArrayList<Integer> ai){
  n = ni;
  a = ai;
}
}