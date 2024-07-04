import java.util.*;
public class Solution{
public static void main(String[] args) {


    Scanner sc = new Scanner(System.in); 
    int testCase = sc.nextInt();
    int number=0;
    ArrayList<Integer[][]> aa= new ArrayList();
    while(number <=testCase-1){
    
    int al= Integer.parseInt(sc.nextLine());

    Integer[][] array = new Integer[al][al];
    
     for(int row = 0; row< array.length; row++){
         String row1 = sc.nextLine();
            for(int col = 0 ;col< array[row].length; col++){
                //System.out.println("enter the elementss for the Matrix");
                array[row][col] = sc.nextInt();


            }
    aa.add(array);
    number++;
    }
}


Integer[][] array;


for(int i = 0; i < aa.size(); i++){


    array = aa.get(i);


int k = 0;

int rep1 = 0;
int rep2 = 0;

for (int j = 0; j < array.length; j++){

    k += array[j][j];
}

for(int row = 0; row < array.length; row ++){

    for(int col = 0; col < array[0].length; col ++){

    int num = array[row][col];

    for (int otherCol = col + 1; otherCol < array.length; otherCol++)
    {
        if (num ==array[row][otherCol])
        {
            rep1++;
        }
    }
    
}   
}


for(int col = 0; col < array[0].length; col ++){

for(int row = 0; row < array.length; row ++){

int num = array[row][col];

for (int row1 = row + 1; row1 < array.length; row1++)
{
    if (num == array[row1][col])
    {
        rep2++;
    }
}

}   
}

System.out.println("Case #" + i + ": " + k + " " + rep1 + " " + rep2);

}

}
}




   