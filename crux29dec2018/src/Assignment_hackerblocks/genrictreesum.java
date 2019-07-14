package Assignment_hackerblocks;
import java.util.ArrayList;
import java.util.Scanner;
public class genrictreesum {
	
		Scanner scn = new Scanner(System.in);

		private class node {
			int data;
			ArrayList<node> children = new ArrayList<>();
		}

		private node root;

		public genrictreesum() {

			this.root=construct(null, -1);
		}

		private node  construct(node parent, int ith) {
//			if (parent == null) {
//				System.out.println("enter the data fore");
//			} else {
//				System.out.println("enter the data for" + ith + "child of" + parent.data);
//			}
			int item = scn.nextInt();
			node nn=new node();
			nn.data=item;
			//System.out.println("eneter the no of children"+nn.data);
			int noc=scn.nextInt();
			for(int i=0;i<noc;i++)
			{
				node child=construct(nn,i);
				nn.children.add(child);
				
			}
			return nn;
		}
		public void display()
		{
			 display(this.root);
			
			
		}

		private void display(node Node) {
			String str="";
			str=str+Node.data+"-->";
			
			for(node  child:Node.children)
			{
				str=str+child.data+",";
				
			}
			System.out.println(str);
			for(node child:Node.children)
			{
				display(child);
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
		

		public static void main(String[] args) {
			//10 3 20 2 50 0 60 0 30 1 70 0 40 2 80 0 90 0
			genrictreesum gt=new genrictreesum();
			gt.display();
			//System.out.println(gt.size());
			//System.out.println(gt.size());
			//System.out.println(gt.max());
			//System.out.println(gt.find(900));
			System.out.println(gt.sum());

		}

	}


