package practice_oops.inheritance;

import java.util.ArrayList;
import java.util.Scanner;



public class generic_trees {
	Scanner scn = new Scanner(System.in);

	private class node {
		int data;
		ArrayList<node> children = new ArrayList<>();
	}

	private node root;

	public generic_trees() {

		this.root=construct(null, -1);
	}
static int ct=0;
	private node  construct(node parent, int ith) {
//		if (parent == null) {
//			System.out.println("enter the data fore");
//		} else {
//			System.out.println("enter the data for" + ith + "child of" + parent.data);
//		}
		int item = scn.nextInt();
		node nn=new node();
		nn.data=item;
		//System.out.println("eneter the no of children"+nn.data);
		int noc=scn.nextInt();
		if(noc==0)
		{
			count=count+1;
		}
		for(int i=0;i<noc;i++)
		{
			node child=construct(nn,i);
			ct=ct+1;
			nn.children.add(child);
			
		}
		return nn;
	}
	public void display()
	{
		 display(this.root,0);
		
		
	}

	private void display(node Node,int ct) {
		String str="";
		str=str+ct+" => ";
		
		for(node  child:Node.children)
		{
			str=str+( ct + 1)+", ";
			
		}
		
		System.out.println(str+" END");
		for(node child:Node.children)
		{
			display(child,ct+1);
		}
	}
	public int size()
	{
		return size(this.root);
	}

	private int  size(node Node) {
		int size=0;
		for(node child:Node.children)
		{
			size+=size(child);
		}
		return size+1;
	}
	public int max()
	{
		return max(this.root);
	}

	private int max(node Node) {
		int max=0;
		for(node child:Node.children)
		{
			max=max(child);
			
		}
		return Math.max(max, Node.data);
	}
	public boolean find(int item)
	{
		return find(this.root,item);
	}

	private boolean  find(node Node,int item) {
		if(Node.data==item)
		{
			return true;
		}
		boolean bn=false;
		for(node child:Node.children)
		{
		   
			bn=find(child, item);
		}
		return bn;
	}
	public int sum()
	{
		return sum(this.root);
	}
	private int  sum(node Node) {
		int sum=0;
		for(node child:Node.children)
		{
			sum+=sum(child);
		}
		return sum+Node.data;
	}
	public boolean structurallyidentical(generic_trees gt2)
	{
		return structurallyidentical(this.root,gt2.root);
	}
	private boolean  structurallyidentical(node Node1,node Node2 ) {
		
		if(Node1.data!=Node2.data)
		{
			return false;
		}
		boolean bn=true;
		for(node child:Node1.children)
		{
			bn=structurallyidentical(child,child);
		}
		return bn;
	}
	
	static int count=0;
	

	public static void main(String[] args) {
		//10 3 20 2 50 0 60 0 30 1 70 0 40 2 80 0 90 0
		generic_trees gt=new generic_trees();
		//gt.display();
		//System.out.println(gt.size());
		//System.out.println(gt.size());
		//System.out.println(gt.max());
		//System.out.println(gt.find(900));
		generic_trees gt2=new generic_trees();
		//System.out.println(gt.sum());
		System.out.println(gt.structurallyidentical(gt2));
		///gt.leaf();
		//System.out.println(count);

	}

}
