import java.util.*;

class Solution {

  public static void nesteddepth(String input,int nooftest){
    int prevcounterval=0;
    int leftcounter;
    int rightcounter;
    String solution = "";
    //System.out.println("length"+input.length());
    for(int len=0;len<input.length();len++){
      int value = Character.getNumericValue(input.charAt(len));

      //System.out.println("Value : " + value);
      if (value != 0){
        for(int i=0;i<value-prevcounterval;i++){
          solution += "(";
          prevcounterval++;
        }
        //prevcounterval++;
        solution +=input.charAt(len); 
      }
      if(value==0 || len == input.length()-1){
        for(int t=0;t<prevcounterval;t++){
          solution += ")";  
        }
        if (value == 0 ){
        prevcounterval=0;
        solution +=0;
        }
      }
    }
    System.out.println("Case #"+ nooftest +": "+ solution);
  }

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);

    //System.out.println("Enter nooftests: ");
    int nooftests = sc.nextInt();
    sc.nextLine();
    for(int i=0;i<nooftests;i++){
      String input = sc.nextLine();
      nesteddepth(input,i+1);
    }


  }
}