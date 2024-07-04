import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.swing.plaf.SliderUI;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		
		for(int i = 0; i < t; ++i)
		{
			int n = sc.nextInt();
			func(i, n, sc);
		}
		
	}
	static void func(int tcase, int n, Scanner sc) {
        
		int trace = 0;
		int row=0,col=0;
		int arr[][] = new int[n][n];
		for(int i = 0; i < n; i++)
		{
			List<Integer> list = new ArrayList<>();
			boolean present = false;
			for(int j = 0; j < n; j++)
			{
				int el = sc.nextInt();
				arr[i][j] = el;
				if(i==j)
					trace += el;
				if(list.contains(el))
				{
					present = true;
				}
				else
					list.add(el);
				
			}
			if(present)
				row++;
		}
		for(int j = 0; j<n;j++)
		{

			List<Integer> list = new ArrayList<>();
			for(int i=n-1;i>=0;i--)
			{
				int el = arr[i][j];
				if(list.contains(el))
				{
					col++;
					break;
				}
				else
				{
					list.add(el);
				}
			}
			
			
		}
		System.out.println("Case #" + tcase + ": " + trace + " "+ row + " " + col);
    }

}