package Assignment_hackerblocks;

import java.util.ArrayList;
import java.util.Scanner;

public class recursion_codes_of_string {

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);		String str=scn.nextLine();
		//int no=Integer.parseInt(str);
		//codesstring(no);
	System.out.println(codesstring(str));

	}

	public static ArrayList<String> codesstring(String str) {
		if(str.length()==0)
		{
			ArrayList<String> br=new ArrayList<>();
			br.add("");
			return br;
			
			
		}
		String res = str.substring(0,1);
		int no = Integer.valueOf(res);
		char ch = (char) (no + 'a' - 1);
		String ros = str.substring(1);
		ArrayList<String> mr = new ArrayList<>();
		ArrayList<String> rr = codesstring(ros);
		for (String val : rr) {
			mr.add(ch+val);

		}
		if (str.length() >=2) {
			String res1 = str.substring(0, 2);
			int no1 = Integer.valueOf(res1);
			if (no1<= 26) {

				char ch1 = (char) (no1 + 'a' - 1);
				String ros1 = str.substring(2);
				ArrayList<String> rr1 = codesstring(ros1);
				for (String val : rr1) {
					mr.add(ch1+val);

				}

			}

		}
		return mr;
	}
}
