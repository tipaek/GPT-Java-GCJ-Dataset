import java.util.Scanner;

//********************************************************************************************
//Vestigium
//https://codingcompetitions.withgoogle.com/kickstart/round/000000000019ffc7/00000000001d3f56
//********************************************************************************************
class Solution {
  static Scanner scanner = new Scanner(System.in);

  static int t;
  static int num;

  static char[] line;
  static int lsz;

  static char[] pLine = new char[1900];
  static int psz;

  public static void main(String[] args) {
    t = scanner.nextInt();
    scanner.nextLine();

    num = 0;
    while (num != t) {
      num++;
      prb();
    }
  }

  static void prb() {
    line = scanner.nextLine().toCharArray();
    lsz = line.length;

    psz = 0;
    int cpt = 0;
    for (int i = 0; i != lsz; i++) {
      int current = line[i] - '0';

      if (current < cpt) {
        addChar(cpt - current, ')'); 
      } else {
        addChar(current - cpt, '(');
      }
      
      addChar(1, line[i]);
      cpt = current;
    }
    addChar(cpt, ')');
    
    System.out.printf("Case #%d: ", num);
    for(int i = 0; i != psz; i++) {
      System.out.print(pLine[i]);
    }
    System.out.println();
  }

  static void addChar(int nbr, char c) {
    for (int i = 0; i != nbr; i++) {
      pLine[psz] = c;
      psz++;
    }
  }
}