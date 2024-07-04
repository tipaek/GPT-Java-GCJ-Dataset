import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) {
	    //Scanner scan = new Scanner(new File("C:\\Users\\parve\\IdeaProjects\\Vestigium\\src\\file.txt"));
        Scanner scan = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
	    int numTest = scan.nextInt(); scan.nextLine();
	    for(int i = 0; i < numTest; i++)
        {
            int dim = scan.nextInt(); scan.nextLine();
            int[][] array = new int[dim][dim];
            for(int x = 0; x < dim; x++)
            {
                for(int y = 0; y < dim; y++)
                {
                    array[x][y] = scan.nextInt();
                }
                scan.nextLine();
            }
            int trace = 0;
            for(int j = 0; j < dim; j++)
            {
                trace += array[j][j];
            }


            int repeatR  = 0;
            for(int x = 0; x < dim; x++)
            {
                boolean need = false;
                for(int y = 0; y < dim; y++)
                {
                    for(int v = y+1; v < dim; v++)
                    {
                        if(array[x][y] == array[x][v])
                        {
                            repeatR++;
                            need = true;
                        }
                        if(need)
                        {
                            break;
                        }
                    }
                    if(need)
                    {
                        break;
                    }
                }
            }
            int repeatC  = 0;
            for(int y = 0; y < dim; y++)
            {
                boolean need = false;
                for(int x = 0; x < dim; x++)
                {
                    for(int v = x+1; v < dim; v++)
                    {
                        if(array[x][y] == array[v][y])
                        {
                            repeatC++;
                            need = true;
                        }
                        if(need)
                        {
                            break;
                        }
                    }
                    if(need)
                    {
                        break;
                    }
                }
            }
            System.out.println("Case #" + (i+1) + ": " + trace + " " + repeatR + " " + repeatC);
        }

    }
}
