package lec_22;

import java.util.Arrays;
import java.util.Scanner;

public class Dynamic_prog {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		//int t = scn.nextInt();
//		while (t > 0) {
//			int i=scn.nextInt();
//			int d=scn.nextInt();
//			int r=scn.nextInt();
//			int e=scn.nextInt();
//		
//			String str1 = scn.next();
//			String str2 = scn.next();

		
//			System.out.println(editdistanceTD(str1,str2,i,d,r,e,new int[str1.length()+1][str2.length()+1]));
//			System.out.println(editdistance(str1,str2,i,d,r,e));
//			
//		}
//		System.out.println(fibonaccitd(10, new int[10 + 1]));
//		fibonaccibu(10);
//		storageeff(10);
		// System.out.println(boardpathtd(0, 10, new int[10]));
		// boardpathbu(0, 10);
		// System.out.println(mazepathtd(0, 0, 2, 2, new int[4][4]));
		// mazepathBu(0, 0, 3, 3, new int[5][5]);
		// mazepathBUSED(0, 0, 3, 3);
		// LCSBU(str1, str2);
//		String str1 = "sunday";
//		String str2 = "saturday";
//editdistanceBU(str1,str2);
		int n=scn.nextInt();
		int cap=scn.nextInt();
		int wt[]=new int[n];
		for(int i=0;i<n;i++)
		{
			wt[i]=scn.nextInt();
			
		}
		int val[]=new int[n];
		for(int i=0;i<n;i++)
		{
			val[i]=scn.nextInt();
		}
		
		
		
//		int arr[] = { 40, 60, 20 };
//		int wt[] = { 1, 3, 4, 5 };
//		int price[] = { 1, 4, 5, 7 };

		// System.out.println(wineproblemtd(arr, 0, arr.length - 1, new
		// int[arr.length][arr.length]));
		// matrixchainBU(arr);
		// wineproblembu(arr);
		//System.out.println(knapsack(wt, val, 1, cap));
	System.out.println(knapsacktd(wt,val, 0, cap, new int[wt.length][cap+1]));
	//knapsackBu(val,wt, cap);
//		System.out.println(mixture(arr, 0, arr.length - 1));
		// int prices[] = { 0, 1, 5, 8, 9, 10, 17, 17, 20 };
//		rodbu(8, prices);

	}

	public static int fibonaccitd(int n, int[] strg) {
		if (n == 0 || n == 1)
			return n;
		if (strg[n] != 0) {
			return strg[n];
		}
		int fbn1 = fibonaccitd(n - 1, strg);
		int fbn2 = fibonaccitd(n - 2, strg);
		int fn = fbn1 + fbn2;
		strg[n] = fn;
		return fn;

	}

	public static void fibonaccibu(int n) {
		int str[] = new int[n + 1];
		str[0] = 0;
		str[1] = 1;
		for (int i = 2; i < str.length; i++) {
			str[i] = str[i - 1] + str[i - 2];
		}
		System.out.println(str[str.length - 1]);
	}

	public static void storageeff(int n) {
		int str[] = new int[2];
		str[0] = 0;
		str[1] = 1;
		for (int i = 2; i <= n; i++) {
			int sum = str[0] + str[1];
			str[0] = str[1];
			str[1] = sum;

		}
		System.out.println(str[1]);
	}

	public static int boardpathtd(int curr, int end, int[] arr) {
		if (curr == end) {

			// System.out.println(ans);
			return 1;

		}
		if (arr[curr] != 0) {
			return arr[curr];
		}
		int res = 0;
		for (int i = 1; i <= 6 && curr + i <= end; i++) {
			// char ch=str.charAt(i);
			// String res=str.substring(i+1);
			res += boardpathtd(curr + i, end, arr);
			// ans=ans+ch;

		}
		arr[curr] = res;

		return res;
	}

	public static void boardpathbu(int curr, int end) {

		int arr[] = new int[end + 6];
		arr[end] = 1;
		int sum = 0;

		for (int i = end - 1; i >= 0; i--) {
			sum = arr[i] + arr[i + 1] + arr[i + 2] + arr[i + 3] + arr[i + 4] + arr[i + 5] + arr[i + 6];
			arr[i] = sum;
		}
		System.out.println(arr[0]);

	}

	public static int mazepathtd(int cr, int cc, int er, int ec, int maize[][])

	{
		if (cr == er && cc == ec) {
			// System.out.println(str);

			return 1;
		}

		if (cr > er || cc > ec)
			return 0;
		if (maize[cr][cc] != 0) {
			return maize[cr][cc];
		}

		int ch = mazepathtd(cr, cc + 1, er, ec, maize);

		int cv = mazepathtd(cr + 1, cc, er, ec, maize);
		maize[cr][cc] = ch + cv;
		return ch + cv;

	}

	public static void mazepathBu(int cc, int cr, int ec, int er, int[][] arr) {
		arr[er][ec] = 1;

		for (int val[] : arr) {
			for (int item : val) {
				System.out.print(item + " ");
			}
			System.out.println();
		}
		System.out.println();
		for (int i = er; i >= 0; i--) {
			for (int j = ec; j >= 0; j--) {
				if (i == er && j == ec) {
					arr[i][j] = 1;
				} else {

					arr[i][j] = arr[i + 1][j] + arr[i][j + 1];
				}
			}
		}

//		for (int val[] : arr) {
//			for (int item : val) {
//				System.out.print(item + " ");
//			}
//			System.out.println();
		// }
		System.out.println(arr[0][0]);

	}

	public static void mazepathBUSE(int cc, int cr, int ec, int er) {
		int arr[] = new int[er + 1];

		Arrays.fill(arr, 1);

		for (int i = er - 1; i >= 0; i--) {
			for (int j = ec; j >= 0; j--) {
				if (j == er) {
					arr[j] = 1;
				} else {

					arr[j] = arr[j] + arr[j + 1];
				}
			}
		}

//		for (int val[] : arr) {
//			for (int item : val) {
//				System.out.print(item + " ");
//			}
//			System.out.println();
		// }
		System.out.println(arr[0]);

	}

	public static void mazepathBUSED(int cc, int cr, int ec, int er) {
		int arr[] = new int[er + 1];

		Arrays.fill(arr, 1);
		int diag;

		for (int i = er - 1; i >= 0; i--) {
			diag = 1;
			for (int j = ec; j >= 0; j--) {

				if (j == er) {
					arr[j] = 1;
				} else {

					int sum = arr[j] + arr[j + 1] + diag;
					diag = arr[j];
					arr[j] = sum;
				}
			}
		}

//		for (int val[] : arr) {
//			for (int item : val) {
//				System.out.print(item + " ");
//			}
//			System.out.println();
		// }
		System.out.println(arr[0]);

	}

	static int count = 0;

	public static void reduce(int n) {
		if (n % 3 == 0) {
			n = n / 3;
			count++;
		} else if (n % 2 == 0) {
			n = n / 2;
			count++;
		}

		reduce(n);

	}

	public static int LCS(String s1, String s2) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		int ans;
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		String roq1 = s1.substring(1);
		String roq2 = s2.substring(1);
		if (ch1 == ch2) {
			ans = LCS(roq1, roq2) + 1;

		} else {
			int f = LCS(s1, roq2);
			int s = LCS(roq1, s2);
			ans = Math.max(f, s);

		}
		return ans;
	}

	public static void LCSBU(String s1, String s2) {
		int arr[][] = new int[s1.length() + 1][s2.length() + 1];
		for (int i = s1.length() - 1; i >= 0; i--) {
			for (int j = s2.length() - 1; j >= 0; j--) {
				if (s1.charAt(i) == s2.charAt(j)) {
					arr[i][j] = arr[i + 1][j + 1] + 1;
				} else {
					int f = arr[i + 1][j];
					int s = arr[i][j + 1];
					arr[i][j] = Math.max(f, s);

				}
			}

		}
		System.out.println(arr[0][0]);
	}

	public static int LCSTD(String s1, String s2, int[][] strg) {
		if (s1.length() == 0 || s2.length() == 0) {
			return 0;
		}
		int ans;
		if (strg[s1.length()][s2.length()] != 0) {
			return strg[s1.length()][s2.length()];
		}
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		String roq1 = s1.substring(1);
		String roq2 = s2.substring(1);
		if (ch1 == ch2) {
			ans = LCSTD(roq1, roq2, strg) + 1;

		} else {
			int f = LCSTD(s1, roq2, strg);
			int s = LCSTD(roq1, s2, strg);
			ans = Math.max(f, s);

		}
		strg[s1.length() - 1][s2.length() - 2] = ans;
		return ans;
	}

	public static int editdistance(String s1, String s2,int i,int d,int r,int e) {
		if (s1.length() == 0 ) {
			int ma=Math.min(s2.length()*d,s2.length()*e);
			return ma;
		}
		if(s2.length()==0)
		{
			int na=Math.min(s1.length()*d,s1.length()* e);
			return na;
		}
		int ans = 0;
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		String roq1 = s1.substring(1);
		String roq2 = s2.substring(1);
		if (ch1 == ch2) {
			ans = editdistance(roq1, roq2,i,d,r,e);

		} else {
			int in = editdistance(roq1,s2,i,d,r,e);
			int dn = editdistance(roq1,roq2,i,d,r,e);
			int rn = editdistance(s1,roq2,i,d,r,e);
			int en = editdistance(roq2,roq1,i,d,r,e);
			//System.out.println(in+" "+dn+" "+rn+" "+en);
			ans = Math.min(Math.min(in,en),Math.min(dn, rn));

		}
		return ans;
	}

	public static int editdistanceTD(String s1, String s2,int i,int r,int s,int e, int[][] strg) {
		if(s1.length()==0)
		{
			return s2.length()*r;
		}
		if(s2.length()==0)
		{
			return s1.length()*r;
		}
		if (strg[s1.length()][s2.length()] != 0) {
			return strg[s1.length()][s2.length()];
		}
		int ans = 0;
		char ch1 = s1.charAt(0);
		char ch2 = s2.charAt(0);
		String roq1 = s1.substring(1);
		String roq2 = s2.substring(1);
		if (ch1 == ch2) {
			ans = editdistanceTD(roq1, roq2,i,r,s,e,strg);
		} else {
			int in = editdistanceTD(roq1, s2,i,r,s,e,strg)+i;
			int dn = editdistanceTD(roq1, roq2,i,r,s,e,strg)+r;
			int rn = editdistanceTD(s1, roq2,i,r,s,e,strg)+s;
			int en=editdistanceTD(roq2, roq1,r,i,s,e,strg)+e;
			//System.out.println(in+" "+dn+" "+rn+" "+en);
			ans=Math.min(Math.min(in,dn),Math.min(rn,en));
        
		}
		
		strg[s1.length()][s2.length()] = ans;
		return ans;

	}

	public static void editdistanceBU(String s1, String s2) {
		int arr[][] = new int[s1.length() + 1][s2.length() + 1];
		for (int i = s1.length(); i >= 0; i--) {

			for (int j = s2.length(); j >= 0; j--) {
				if (i == s1.length()) {
					arr[i][j] = s2.length() - j;
					continue;
				}
				if (j == s2.length()) {
					arr[i][j] = s1.length() - i;
					continue;

				}

				if (s1.charAt(i) == s2.charAt(j)) {

					arr[i][j] = arr[i + 1][j + 1];

				} else {
					int I = arr[i + 1][j];
					int D = arr[i][j + 1];
					int R = arr[i + 1][j + 1];
					arr[i][j] = Math.min(D, Math.min(R, I)) + 1;

				}
			}
		}
		System.out.println(arr[0][0]);

	}

	public static int matrixchain(int[] arr, int si, int ei) {
		if (si + 1 == ei) {
			return 0;
		}
		int min = Integer.MAX_VALUE;

		for (int k = si + 1; k <= ei - 1; k++) {

			int fp = matrixchain(arr, si, k);
			int sp = matrixchain(arr, k, ei);
			int sw = arr[si] * arr[ei] * arr[k];
			int total = fp + sp + sw;

			if (total < min) {
				min = total;
			}

		}

		return min;

	}

	public static int matrixchainTD(int[] arr, int si, int ei, int[][] strg) {
		if (si + 1 == ei) {
			return 0;
		}
		int min = Integer.MAX_VALUE;

		for (int k = si + 1; k <= ei - 1; k++) {

			int fp = matrixchainTD(arr, si, k, strg);
			int sp = matrixchainTD(arr, k, ei, strg);
			int sw = arr[si] * arr[ei] * arr[k];
			int total = fp + sp + sw;

			if (total < min) {
				min = total;
			}

		}

		return min;

	}

	public static void matrixchainBU(int arr[]) {
		int n = arr.length;
		int strg[][] = new int[n][n];
		for (int slide = 1; slide <= n - 2; slide++) {
			for (int si = 0; si <= n - slide - 2; si++) {
				int ei = si + slide + 1;

				int min = Integer.MAX_VALUE;

				for (int k = si + 1; k <= ei - 1; k++) {

					int fp = strg[si][k];
					int sp = strg[k][ei];
					int sw = arr[si] * arr[ei] * arr[k];
					int total = fp + sp + sw;

					if (total < min) {
						min = total;
					}

				}
				strg[si][ei] = min;

			}

		}

		System.out.println(strg[0][n - 1]);
	}

	public static int wineproblem(int arr[], int si, int ei, int year) {
		if (si == ei) {
			return arr[si] * year;
		}
		int s = wineproblem(arr, si + 1, ei, year + 1) + arr[si] * year;
		int e = wineproblem(arr, si, ei - 1, year + 1) + arr[ei] * year;
		int ans = Math.max(s, e);
		return ans;

	}

	public static int wineproblemtd(int arr[], int si, int ei, int[][] strg) {
		int year = arr.length - (ei - si);
		if (si == ei) {
			return arr[si] * year;
		}
		if (strg[si][ei] != 0) {
			return strg[si][ei];
		}
		int s = wineproblemtd(arr, si + 1, ei, strg) + arr[si] * year;

		int e = wineproblemtd(arr, si, ei - 1, strg) + arr[ei] * year;

		int ans = Math.max(s, e);
		strg[si][ei] = ans;
		return ans;

	}

	public static void wineproblembu(int narr[]) {
		int arr[][] = new int[narr.length][narr.length];
		int n = arr.length - 1;
		for (int s = 0; s <= n - 1; s++) {
			for (int si = 0; si <= n - s - 1; si++) {
				int ei = si + s;
				int year = arr.length - (ei - si);
				if (si == ei) {
					arr[si][ei] = arr[si][ei] * year;
				}

				int se = arr[si + 1][ei];
				int e = arr[si][ei - 1];

				int ans = Math.max(se, e);

				arr[si][ei] = ans;
				// return ans;

			}
		}
		System.out.println(arr[0][n]);
	}

	public static int knapsack(int arr[], int price[], int si, int tc) {
		if (si == arr.length) {
			return 0;
		}

		int f = knapsack(arr, price, si + 1, tc);
		int s = 0;
		if (tc >= arr[si])
			s = knapsack(arr, price, si + 1, tc - arr[si]) + price[si];
		int ans = Math.max(f, s);
		return ans;
	}

	public static int knapsacktd(int arr[], int price[], int si, int tc, int[][] strg) {
		if (si == arr.length) {
			return 0;
		}
		if (strg[si][tc] != 0) {
			return strg[si][tc];
		}
		int f = knapsacktd(arr, price, si + 1, tc, strg);
		int s = 0;
		if (tc >= arr[si])
			s = knapsacktd(arr, price, si + 1, tc - arr[si], strg) + price[si];
		int ans = Math.max(f, s);
		strg[si][tc] = ans;
		return ans;
	}

	public static void knapsackBu(int wt[], int price[], int cap) {
		int nr = wt.length+1;
		int nc = cap+1;
		int arr[][] = new int[nr][nc ];
		//int in = 0;
		int ex = 0;
		for (int row = 1; row < nr; row++) {

			for (int col = 1; col < nc; col++) {
int in=0;
				if (col >= wt[row - 1]) {
					in = arr[row - 1][col - wt[row - 1]] + price[row - 1];
				} else {
					ex = arr[row - 1][col];

				}
				int ans = Math.max(in, ex);
				arr[row][col] = ans;
			}
		}
		System.out.println(arr[nr - 1][nc-1]);
	}

	public static int mixture(int arr[], int si, int ei) {
		if (si == ei)
			return 0;
		int min = Integer.MAX_VALUE;
		for (int k = si; k < ei; k++) {

			int fp = mixture(arr, si, k);
			int sp = mixture(arr, k + 1, ei);
			int sw = color(arr, si, k) + color(arr, k + 1, ei);
			int ans = fp + sp + sw;
			if (ans < min) {
				min = ans;
			}
		}
		return min;
	}

	private static int color(int[] arr, int si, int ei) {
		int c = 0;
		for (int i = si; i <= ei; i++) {
			c += arr[i];
		}
		return c % 100;
	}

	public static boolean wildcard(String src, String patt) {
		if (src.length() == 0 && patt.length() == 0) {
			return true;
		}
		if (src.length() == 0 && patt.length() != 0) {
			for (int i = 0; i < patt.length(); i++) {
				if (patt.charAt(i) != '*')
					return false;
			}
			return true;
		}
		if (src.length() != 0 && patt.length() == 0) {
			return false;
		}
		char ch1 = src.charAt(0);
		String roq1 = src.substring(1);
		char ch2 = patt.charAt(0);
		String roq2 = patt.substring(1);
		boolean ans = false;
		if (ch1 == ch2 || ch2 == '?') {
			ans = wildcard(roq1, roq2);

		}
		if (ch1 == '*') {

			ans = wildcard(roq1, patt) || wildcard(src, roq2);
		}
		return ans;
	}

	public static void wildcardBu(String src, String patt) {
		boolean strg[][] = new boolean[src.length() + 1][patt.length() + 1];
		for (int row = strg.length - 1; row >= 0; row--) {
			for (int col = strg[0].length - 1; col >= 0; col--) {
				if (row == strg.length && col == strg[0].length) {
					strg[row][col] = true;
				}

			}

		}

	}

	public static int rod(int n, int[] prices) {

		int max = prices[n];
		int left = 1;
		int right = n - 1;
		while (left <= right) {
			int fp = rod(left, prices);
			int sp = rod(right, prices);
			int total = fp + sp;
			if (total > max) {
				max = total;
			}

			left++;
			right--;

		}
		return max;
	}

	public static void rodbu(int n, int[] prices) {

		int strg[] = new int[n + 1];
		for (int i = 1; i < strg.length; i++) {
			int max = prices[i];
			int left = 1;
			int right = i - 1;
			while (left <= right) {
				int fp = strg[left];
				int sp = strg[right];
				int total = fp + sp;
				if (total > max) {
					max = total;
				}

				left++;
				right--;

			}
			strg[i] = max;

		}
		System.out.println(strg[strg.length - 1]);
	}
}