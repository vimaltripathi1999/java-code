package practice_oops.inheritance;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

public class binarytree {
	Scanner scn = new Scanner(System.in);

	private class node {
		node left;
		node right;
		int data;
	}

	private node root;

	public binarytree() {
		this.root = binarytree(null, false);
	}

	private node binarytree(node parent, boolean ilc) {

		if (parent == null)

		{
			// System.out.println("enter the data for root node");
		} else {
			if (ilc) {
				// System.out.println("Enter the data for left child of "+parent .data);
			} else {
				// System.out.println("Enter the data for right child of"+parent.data);
			}
		}
		int item = scn.nextInt();
		node nn = new node();
		nn.data = item;
		// System.out.println("is left child of"+nn.data);
		boolean lc = scn.nextBoolean();
		if (lc) {
			nn.left = binarytree(nn, lc);
		}
		// System.out.println("is right child of"+nn.data);
		boolean rc = scn.nextBoolean();
		if (rc) {
			nn.right = binarytree(nn, rc);
		}

		return nn;
	}

	public void display()

	{
		display(this.root);
	}

	private void display(node Node) {
		if (Node == null) {
			return;
		}
		String str = "";
		if (Node.left == null) {
			str += ".";
		} else {
			str += Node.left.data;
		}
		// System.out.println(Node.data);
		str = str + "-->" + Node.data + "-->";

		if (Node.right == null) {
			str += ".";
		} else {
			str += " " + Node.right.data;
		}
		System.out.println(str);
		System.out.println();
		display(Node.left);
		display(Node.right);

	}

	public int size() {
		return size(this.root);
	}

	private int size(node Node) {
		if (Node == null) {
			return 0;
		}
		int size = 0;
		size += size(Node.left);
		size += size(Node.right);
		return size + 1;

	}

	public int height() {
		return height(this.root);
	}

	private int height(node Node) {

		if (Node == null) {
			return -1;
		}
		int rht = height(Node.left);
		int lht = height(Node.right);
		return Math.max(lht, rht) + 1;

	}

	public class balpair {
		int height = -1;
		boolean bal = true;
	}

	public boolean isbalanced() {
		balpair bp = new balpair();
		return isbalanced(this.root).bal;
	}

	private balpair isbalanced(node Node) {
		if (Node == null) {
			return new balpair();
		}
		balpair lbp = isbalanced(Node.left);
		balpair rbp = isbalanced(Node.right);
		int sp = Math.abs(lbp.height - rbp.height);
		balpair bp = new balpair();
		if (lbp.bal && rbp.bal && sp <= 1) {
			bp.bal = true;
		} else {
			bp.bal = false;
		}
		bp.height = (lbp.height + rbp.height) + 2;
		return bp;
	}

	public boolean isstructurally(binarytree bt2) {
		return isstructurally(this.root, bt2.root);
	}

	private boolean isstructurally(node one, node oth) {
		if (one == null && oth == null) {
			return true;
		}
		if (one == null || oth == null) {
			return false;
		}

		return (isstructurally(one.left, oth.left) && isstructurally(one.right, oth.right));
	}

	public void sibling() {
		this.sibling(this.root);
	}

	private void sibling(node Node) {
		if (Node == null) {
			return;
		}
		if (Node.left != null && Node.right != null) {
			sibling(Node.left);
			sibling(Node.right);
		} else if (Node.left != null) {
			System.out.print(Node.left.data + " ");
			sibling(Node.left);
		} else if (Node.right != null) {
			System.out.print(Node.right.data + " ");
			sibling(Node.right);
		}

	}

	public void levelorder() {
		levelorder(this.root);
	}

	private void levelorder(node Node) {
		Queue<node> queue = new LinkedList<node>();
		queue.add(Node);
		while (true) {
			int ct = queue.size();
			if (ct == 0) {
				break;
			}
			while (ct > 0) {
				node temp = queue.poll();

				System.out.print(temp.data + " ");
				if (temp.left != null) {
					queue.add(temp.left);
					// System.out.print(temp.left.data + " ");
				}
				if (temp.right != null) {
					queue.add(temp.right);
					// System.out.print(temp.right.data + " ");

				}
				ct--;
			}
			System.out.println();
		}

	}

	public void levelorderzz() {
		levelorderzz(this.root);
	}

	private void levelorderzz(node Node) {
		if(Node==null)
		{
			return;
		}
		Stack<node> stack = new Stack();
		Stack<node> nstack = new Stack();
		stack.push(Node);
		int ct = 0;
		while (!stack.isEmpty()) {
			node temp = stack.pop();
			if (temp != null) {
				System.out.print(temp.data+" ");
				if (ct % 2 != 0) {
					if (temp.right != null)
						nstack.push(temp.right);

					if (temp.left != null)
						nstack.push(temp.left);

				} else {

					if (temp.left != null)
						nstack.push(temp.left);
					if (temp.right != null)
						
					nstack.push(temp.right);
				}
			}
			
			if(stack.isEmpty())
			{
				Stack<node>ntemp=stack;
				stack=nstack;
				nstack=ntemp;
				ct++;
			}
		}

	}

	public static void main(String[] args) {
		// 10 true 20 true 40 false false true 50 false false true 30 false true 70
		// false false
		binarytree bt = new binarytree();
		// bt.display();
//		System.out.println(bt.find(110));
//		System.out.println(bt.max());
		// System.out.println(bt.size());
		// System.out.println(bt.height());
//		System.out.println(bt.diameter());
//		System.out.println(bt.diameter2());
//

		// System.out.println(bt.isbalanced());
		// binarytree bt2=new binarytree();
		// System.out.println(bt.isstructurally(bt2));
		// bt.sibling();
		// bt.levelorder();
		bt.levelorderzz();
	}
}
