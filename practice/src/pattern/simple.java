package pattern;

import java.util.Scanner;

public class simple {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int nst = 1;
		int nsp = n - 1;
		int rows = 1;
		pyramid(n);
		patt6(n);
		while (rows <= 2 * n - 1) {
//			
			for (int csp = nsp; csp > 0; csp--) {
				// System.out.print(" ");
			}
			for (int cst = 1; cst <= nst; cst++) {
				// System.out.print("*");
			}

			// nsp--;
			if (rows >= n) {
				nst--;
				nsp++;
			} else {
				nst++;
				nsp--;
			}
			rows++;
			// System.out.println();

		}

	}

	public static void pyramid(int n) {
		int row = 0;
		int nst = 1;
		int nsp = n - 1;
		int ln = 1;
		while (row < n) {
			int i = 0;
			int csp = 1;
			int j = n - 1;
			while (csp <= nsp) {

				System.out.print(" ");
				csp++;
			}
			int cst = 1;
			while (cst <= nst) {
				if (cst == (nst + 1) / 2) {
					System.out.print("0");
					i = 0;
				} else if (cst <= nst / 2) {
					System.out.print(n - row + i);

					i++;
				} else if (cst > nst / 2)

				{

					System.out.print(j - i);
					i++;
				}
				cst++;
			}
			System.out.println();
			row++;
			nst = nst + 2;
			nsp--;
		}

	}

	public static void patt2(int n) {

		int row = 1;
		int nst = n;
		int nsp = 0;
		while (row <= 2 * n - 1) {
//			for(int csp=1;csp<=nsp;csp++)
//			{
//				System.out.print(" ");
//			}
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*");
			}

			if (row <= n) {
				// nsp=nsp+2;
				nst = nst - 1;
			} else {
				// nsp=nsp-2;
				nst = nst + 1;
			}
			System.out.println();
			row++;

		}

	}

	public static void patt3(int n) {
		int row = 1;
		int nst = n / 2;
		int nsp = 2;
		while (row <= n) {
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*");
			}
			for (int csp = 1; csp <= nsp; csp++) {
				System.out.print(" ");
			}
			for (int cst = 1; cst <= nst; cst++) {
				System.out.print("*");
			}
			if (row <= n / 2) {
				nst--;
				nsp = nsp + 2;
			} else {
				nst++;
				nsp = nsp - 2;
			}
			System.out.println();
			row++;
		}

	}

	public static void patt4(int n) {
		int row = 1;
		int nsp=n-1;
		int nst=1;
		int val=1;
		while (row <= n) {
			val=row;
      for(int csp=1;csp<=nsp;csp++ )
      {
    	  System.out.print(" ");
    	  
      }
		for(int cst=1;cst<=nst;cst++)
		{
			System.out.print(val);
			if(cst<row)
			val++;
			else 
				val--;
		}
		nst=nst+2;
		nsp--;
		row++;
		System.out.println();
		}
	}
	public static void patt5(int n)
	{
		int row=1;
		int nst=5;
		while(row<=n)
		{int val=5;
			for(int cst=1;cst<=n;cst++ )
			{
				if(cst==nst)
				{
					System.out.print("*");
				}
				else
					System.out.print(val);
				val--;
			}
			
			row++;
			nst--;
			System.out.println();
		}
	}
		public static void patt6(int n)
		{
			int row=1;
			int col=1;
			int nst=1;
			int val=1;
			while(row<=2*n-1)
			{
				int i=1;
				for(int cst=1;cst<=nst;cst++)
				{
					if(i%2==0)
					{
						System.out.print(" * ");
					}
					else
					{
						
						System.out.print(val+" ");
					}
					i++;
				}
				
				row++;
				if(row<=n)
				{
				nst=nst+2;
				val=val+1;
				
				}
				else 
				{
					nst=nst-2;
					val=val-1;
				}
				System.out.println();
			}
			
			
		}
	
}
