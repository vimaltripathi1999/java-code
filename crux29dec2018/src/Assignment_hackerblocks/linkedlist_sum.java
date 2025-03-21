package Assignment_hackerblocks;

import java.util.ArrayList;
//import java.util.LinkedList;
import java.util.Scanner;



public class linkedlist_sum {
	
		private static  class node {

			int data;
			node next;

		}

		private node head;
		private node tail;
		private int size;

		public int size() {
			return this.size;
		}

		public int getfirst() throws Exception {
			if (isempty()) {
				throw new Exception("ll is empty");
			}
			return this.head.data;

		}

		public int getlast() throws Exception {
			if (isempty()) {
				throw new Exception("ll is empty");
			}
			return this.tail.data;
		}

		public boolean isempty() {
			return this.size == 0;
		}

		public int getat(int idx) throws Exception {
			if (isempty()) {
				throw new Exception("ll is empty");
			}
			if (idx < 0 || idx >= size) {
				throw new Exception("invalid index");
			}
			node temp = this.head;
			int ans = 0;

			for (int i = 1; i <= idx; i++) {
				temp = temp.next;
				ans = temp.data;

			}

			return ans;
		}

		public void display() throws Exception {
			if (isempty()) {
				throw new Exception("ll is empty");
			}

			node temp = this.head;
			while (temp != null) {
				System.out.print(temp.data + ",");
				temp = temp.next;

			}
			System.out.println();
		}

		public void addatlast(int item) {

			node nn = new node();
			nn.data = item;
			nn.next = null;
			if (isempty()) {
				this.head = nn;
				this.tail = nn;
				size = 1;

			} else {
				this.tail.next = nn;
				this.tail = nn;
				this.size++;
			}
		}

		public void addfirst(int item) {
			node nn = new node();
			nn.data = item;
			nn.next = null;
			if (isempty()) {
				this.head = nn;
				this.tail = nn;
				this.size++;

			} else {
				nn.next = this.head;
				this.head = nn;
				;
				size++;
			}

		}

		public node getnodeat(int idx) throws Exception {
			if (isempty()) {
				throw new Exception("ll is empty");
			}
			if (idx < 0 || idx >= this.size) {
				throw new Exception("invalid index");
			}
			node temp = this.head;
			node ans = null;

			for (int i = 1; i <= idx; i++) {
				temp = temp.next;

			}

			return temp;
		}

		public void addat(int item, int idx) throws Exception {

			if (isempty()) {
				throw new Exception("ll is empty");
			}
			if (idx < 0 || idx > this.size) {
				throw new Exception("invalid index");
			}
			if (idx == 0) {
				addfirst(item);
			} else if (idx == this.size) {
				addatlast(item);
			} else {

				node nn = new node();
				nn.data = item;
				nn.next = null;
				node nm1 = getnodeat(idx - 1);
				node np1 = getnodeat(idx);
				nm1.next = nn;
				nn.next = np1;
				this.size++;

			}
		}

		public int removefirst() throws Exception {
			if (isempty()) {
				throw new Exception("ll is empty");
			}
			if (this.size == 1) {
				int val = this.head.data;
				this.head = null;
				this.tail = null;
				this.size = 0;
				return val;

			} else {
				int val = this.head.data;
				this.head = this.head.next;
				this.size--;
				return val;
			}
		}

		public int removelast() throws Exception {
			if (isempty()) {
				throw new Exception("ll is empty");
			}

			if (this.size == 1) {
				int val = this.tail.data;
				this.head = null;
				this.tail = null;
				this.size = 0;
				return val;
			} else {

				int val = this.tail.data;
				node nm2 = this.getnodeat(size - 2);
				nm2 = this.tail;
				size--;
				return val;

			}
		}

		public int removeat(int idx) throws Exception {
			if (isempty()) {
				throw new Exception("ll is empty");
			}

			if (idx < 0 || idx >= this.size) {
				throw new Exception("invalid index");

			}
			if (idx == 0) {
				int val = removefirst();
				return val;
			} else if (idx == this.size - 1) {
				int val = removelast();
				return val;
			} else {
				node nm1 = getnodeat(idx - 1);
				node nm = getnodeat(idx);
				int val = nm.data;
				node np1 = nm.next;
				nm1.next = np1;
				this.size--;
				return val;

			}
		}
		public void addTwoLists(node second)
		{
			addTwoLists(this.head,second.head);
			
		}
		 private  node  addTwoLists(node first, node second) { 
		        node res = null; 
		        node prev = null; 
		        node temp = null; 
		        int carry = 0, sum; 
		  
		        while (first != null || second != null) 
		        { 
		           
		            sum = carry + (first != null ? first.data : 0) 
		                    + (second != null ? second.data : 0); 
		  
		           
		            carry = (sum >= 10) ? 1 : 0; 
		  
		        
		            sum = sum % 10; 
		  
		            // Create a new node with sum as data 
		            temp = new node(); 
		                temp.data=sum; 
		            
		            if (res == null) { 
		                res = temp; 
		            } else  
		            { 
		                prev.next = temp; 
		            } 
		  
		            
		            prev = temp; 
		  
		           
		            if (first != null) { 
		                first = first.next; 
		            } 
		            if (second != null) { 
		                second = second.next; 
		            } 
		        } 
		  
		        if (carry > 0) { 
		            temp.next = new node(); 
		        } 
		  
		        
		        return res; 
		    } 
		   
		  
		    void printList(node head) { 
		        while (head != null) { 
		            System.out.print(head.data + " "); 
		            head = head.next; 
		        } 
		        System.out.println(""); 
		    } 
		  
		   
		  

	public static void main(String[] args) {
		Scanner scn=new Scanner(System.in);
		int a=scn.nextInt();
		int b=scn.nextInt();
		linkedlist_sum first=new linkedlist_sum();
		linkedlist_sum second=new linkedlist_sum();
		for(int i=0;i<a;i++)
		{
			first.addatlast(scn.nextInt());
			
		}
		for(int i=0;i<a;i++)
		{
			second.addatlast(scn.nextInt());
			
		}
		
		addTwoLists(first.head,second.head);
	
			
	}
	
}
