package Assignment_hackerblocks;

import java.util.Scanner;

public class next_permutation {
public static void main(String[] args) {
	Scanner scn=new Scanner(System.in);
	int t=scn.nextInt();
	while(t>0)
	{
	int n=scn.nextInt();
	int arr[]=new int[n];
	for(int i=0;i<arr.length;i++)
	{
		arr[i]=scn.nextInt();
	}
	permutation(arr,n);
	}
}
public static void permutation(int arr[],int n)
{   int temp=arr[arr.length-1];
int d=-1;
int pos=0;
int posj=0,flag=-1;
	for(int i=arr.length-2;i>=0;i--)
	{
		if(arr[i]<temp)
		{ flag=1;
			d=arr[i];
			pos=i;
			break;
		}
		
	}
	for(int i=arr.length-1;i>pos;i--)
	{
		if(arr[i]>d&&d!=-1)
		{
			flag=1;
			posj=i;
			
			reverse(arr,pos);
			break;
			
		}
		
	}
	
	if(flag==-1)
	{
		reverse(arr,pos);
	}
}
public static void reverse(int arr[],int pos)
{  int i=pos;
   int j=arr.length-1;
   while(i<j)
   {
	   int temp=arr[i];
	   arr[i]=arr[j];
	   arr[j]=temp;
	   j--;
	   i++;
	   
   }
	
	for( i=0;i<arr.length;i++)
	{
		
		System.out.print(arr[i]+" ");
	}
}
}
