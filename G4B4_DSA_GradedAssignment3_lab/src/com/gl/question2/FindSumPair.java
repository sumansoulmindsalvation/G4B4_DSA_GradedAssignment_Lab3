package com.gl.question2;

import java.util.HashSet;
import java.util.Set;

public class FindSumPair {

		static class Node{
			int data;
			Node leftNode, rightNode;
			public Node(int data) {
				this.data = data;
				leftNode = rightNode = null;
			}
		}
		
		 Node createNode(int nodeData){
			Node newNode = new Node(nodeData);
			return newNode;
		}
		
		public Node insert(Node root, int key) {
			if(root == null) 
				return createNode(key);
			if(key<root.data)
				root.leftNode = insert(root.leftNode,key);
			else
				root.rightNode = insert(root.rightNode , key);
			return root;
			}
		public static void main(String[] args) {
			
			Node root = null;
			FindSumPair findPS = new FindSumPair();
			root = findPS.insert(root , 15);
			root = findPS.insert(root , 7);
			root = findPS.insert(root , 2);
			root = findPS.insert(root , 12);
			root = findPS.insert(root , 10);
			root = findPS.insert(root , 14);
			root = findPS.insert(root , 20);
			
			
			int targetSum = 60;
			findPS.findPairWithGivenSum(root , targetSum);
			findPS.inOrder(root);
			
		}
		
		private void findPairWithGivenSum(Node root,int targetSum) {
			Set<Integer> set = new HashSet<Integer>();
			if(!findPairutil(root, targetSum,set)) {
				System.out.println("Pair do not exist....");
			}
			
		}
		
		private boolean findPairutil(Node root, int targetSum,Set<Integer> set) {
			if(root == null)
				return false;
			
			if(findPairutil(root.leftNode, targetSum , set))
				return true;
			int diff = targetSum - root.data;
			if(set.contains(diff)) {
				System.out.println("Pair if found ("+(targetSum - root.data) + ", " + root.data + ")");
				return true;
			}else{
				set.add(root.data);
			}
					
			return findPairutil(root.rightNode, targetSum , set);
		}
		
		
		private void inOrder(Node root) {
			inOrder(root.leftNode);
			System.out.println(root.data+" ");
			inOrder(root.rightNode);
			
		}
		
		// TODO Auto-generated constructor stub
	

}
