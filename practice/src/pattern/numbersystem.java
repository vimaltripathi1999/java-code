package pattern;

import java.util.Scanner;

public class numbersystem {
public static void main(String[] args) {
	Scanner scn=new Scanner(System.in);
	int n =scn.nextInt();
	//decimaltobinary(n);
	//binarytodecimal(n);
	rotate(n,14);
	
}
public static void  decimaltobinary(int n)
{int ans=0;
int i=0;
int  multip=0;
	while(n!=0)
	{   int rem=n%2;
		n=n/2;
		ans=ans+(int)(rem*Math.pow(10, i));
		
		i++;
	}
		
		System.out.println(ans);
		
		
		
		
	}
	
	public static void binarytodecimal(int n)
	{
		int ans=0;
		int i=0;
		while(n!=0)
		{
			int rem=n%10;
			n=n/10;
			ans=ans+(int)(rem*Math.pow(2, i));
			i++;
			
			
			
		}
		System.out.println(ans);
	}
	public static void rotate(int n,int r)
	{
		int temp=n;
		int count=0;
		while(temp!=0)
		{
		   	temp=temp/10;
		   	count++;
		  
		}
		
		if(r>count)
		{
			r=r%count;
			
		}
		int rem=(int) (n%Math.pow(10,r));
		int no=n/(int)(Math.pow(10, r));
		int ans=rem*(int)(Math.pow(10,count-r))+no;
		System.out.println(ans);
		
	}
}

