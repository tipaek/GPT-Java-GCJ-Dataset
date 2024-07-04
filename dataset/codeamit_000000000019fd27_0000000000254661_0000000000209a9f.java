import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

class ND {

    public static final PrintStream out = System.out;
  public static final BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
    public int numCases;
  //  File file = new File("test.txt");
/*
   BufferedReader in;

    {
        try {
            in = new BufferedReader(new FileReader(file));
        } catch (FileNotFoundException e) {
           e.printStackTrace();
       }
    }

*/
    public static void main(String[] args) throws IOException {
        try {
            new ND().run();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void run() throws Exception {
        numCases = Integer.parseInt(in.readLine().trim());
        for (int i = 1; i <= numCases; i++) {
            doCase(i);
        }
    }

    public void doCase(int caseNumber) throws Exception {
     //  String line = in.readLine();
      // Scanner scan = new Scanner(line);
     //   long N = Long.parseLong(in.readLine());
   //    System.out.println(N);
     //   char result [] = new char[(int) N];
     //   LinkedList<Integer> J = new LinkedList();
      //  LinkedList<Integer> C = new LinkedList();
     //   Map m1= new HashMap();
     //   boolean flag = true;
        String str1 = in.readLine();
      //  System.out.println("STR1="+str1);
      //  System.out.println(str1);
        //char[] array1 = str1.;
        Stack st = new Stack();

        int openCounter=0;
        int closedCounter=0;
        for(int i=0;i<str1.length();i++){
       //     System.out.println("iiiii = "+i);
            int input = Integer.parseInt(Character.toString(str1.charAt(i)));
        if(openCounter==0 && closedCounter==0){
      //      System.out.println("Debug = 1 ="+input);
            for(int j=0;j<input;j++)
            st.push("("); st.push(input);
            closedCounter=closedCounter+input;
        //    System.out.println("closedCounter = "+closedCounter);
          // System.out.println("intermediateClosedCounter = "+intermediateClosedCounter);
           // System.out.println("intermediateOpenCounter = "+intermediateOpenCounter);
      //      System.out.println("openCounter = "+openCounter);
        }else{
            int intermediateOpenCounter = openCounter-input ;
            int intermediateClosedCounter = closedCounter-input;
            if(intermediateOpenCounter>0){
           //     System.out.println("Debug = 2");

                for(int j=0;j<intermediateOpenCounter;j++)
                    st.push("(");
                st.push(input);
                closedCounter=closedCounter+intermediateClosedCounter;
              //  System.out.println("closedCounter = "+closedCounter);
               // System.out.println("intermediateClosedCounter = "+intermediateClosedCounter);
            //    System.out.println("intermediateOpenCounter = "+intermediateOpenCounter);
             //   System.out.println("openCounter = "+openCounter);
            } else
            if(intermediateClosedCounter>0){
             //   System.out.println("Debug = 3");

                for(int j=0;j<intermediateClosedCounter;j++)
                    st.push(")");
                st.push(input);
                closedCounter=closedCounter-intermediateClosedCounter;
        //        System.out.println("closedCounter = "+closedCounter);
         //       System.out.println("intermediateClosedCounter = "+intermediateClosedCounter);
       //         System.out.println("intermediateOpenCounter = "+intermediateOpenCounter);
        //        System.out.println("openCounter = "+openCounter);

            }else {
                //  int interCounter = ;
                st.push(input);
            }
            }
          //  st.push("(");
          //  st.push(")");

        }
        for(int j=0;j<closedCounter;j++)
            st.push(")");

        st.forEach(k->{
            System.out.print(""+k);
        });
        System.out.println();
    //    System.out.println(st.toString());
        //PrintStack(st);
        }

    static void PrintStack(Stack s)
    {
        // If stack is empty then return
        if (s.isEmpty())
            return;

        String x = String.valueOf(s.peek());

        // Pop the top element of the stack
        s.pop();

        // Recursively call the function PrintStack
        PrintStack(s);

        // Print the stack element starting
        // from the bottom
        System.out.print(x + " ");

        // Push the same element onto the stack
        // to preserve the order
        s.push(x);
    }
}



