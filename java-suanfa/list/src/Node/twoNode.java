package Node;

import java.util.Stack;

public class twoNode {

	public static class Node {
		public int value;
		public Node left;
		public Node right;
		public Node(int data) {
			this.value = data;
		}
	}
	
	public static void f(Node head) {
		if (head== null ) {
			return;
		}
		//递归一次
		f(head.right);
		//递归三次
		f(head.left);
		//递归三次
	}
	public static void inorder(Node head) {
		if (head == null) {
			return;
		}
		//中序打印（左头右）
		inorder(head.left);
		System.out.println(head.value + " ");
		inorder(head.right);
		//先序打印（头左右）
		System.out.println(head.value + " ");
		inorder(head.left);
		inorder(head.right);
		//后序打印（左右头）
		inorder(head.left);
		inorder(head.right);
		System.out.println(head.value + " ");
	}
	public static void preorderunrecur(Node head) {
		System.out.println("pre-order :");
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			stack.add(head);
			while (!stack.isEmpty()) {
				head = stack.pop();
				System.out.println(head.value + " ");
				if (head.right != null) {
					stack.push(head.right);
				}
				if (head.left != null) {
					stack.push(head.left);
				}
			}
		}
		System.out.println();
	}
	
	public static void preorderunrecur1(Node head) {
		System.out.println("pre-order :");
		if (head != null) {
			Stack<Node> stack = new Stack<Node>();
			Stack<Node> stack2 = new Stack<Node>();
			stack.add(head);
			while (!stack.isEmpty()) {
				head = stack.pop();
				stack2.push(head);
				if (head.right != null) {
					stack.push(head.right);
				}
				if (head.left != null) {
					stack.push(head.left);
				}
			}
			while (!stack2.isEmpty()) {
				System.out.println(stack2.pop().value + "");
			}
		}
		System.out.println();
	}
	
}
