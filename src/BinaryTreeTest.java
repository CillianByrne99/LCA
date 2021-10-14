import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BinaryTreeTest {
	
	@Test
	 public void testNode(){
	        BinaryTree tree = new BinaryTree();
	        // testing the binary search tree for that I'll be mainly using for the later tests
	        // making sure that the node function, functions correctly
	        tree.root = new Node(20);
	        assertEquals(tree.root.data, 20);
	        tree.root.left = new Node(8);
	        assertEquals(tree.root.left.data, 8);
	        tree.root.right = new Node(22);
	        assertEquals(tree.root.right.data, 22);
	        tree.root.left.left = new Node(4);
	        assertEquals(tree.root.left.left.data, 4);
	        tree.root.left.right = new Node(12);
	        assertEquals(tree.root.left.right.data, 12);
	        tree.root.left.right.left = new Node(10);
	        assertEquals(tree.root.left.right.left.data, 10);
	        tree.root.left.right.right = new Node(14);
	        assertEquals(tree.root.left.right.right.data, 14);

	    }

	    @Test
	    public void testLCANormal(){
	    	//Testing three different nodes and finding there LCA each
	        BinaryTree tree = new BinaryTree();
	        tree.root = new Node(20);
	        tree.root.left = new Node(8);
	        tree.root.right = new Node(22);
	        tree.root.left.left = new Node(4);
	        tree.root.left.right = new Node(12);
	        tree.root.left.right.left = new Node(10);
	        tree.root.left.right.right = new Node(14);
	        int n1 = 10, n2 = 14;
	        int low = 12;
	        Node lca = tree.findLCA(n1, n2);
	        assertEquals(lca.data, low,"");

	        n1 = 14;
	        n2 = 8;
	        low = 8;
	        lca = tree.findLCA(n1, n2);
	        assertEquals(lca.data, low,"");

	        n1 = 10;
	        n2 = 22;
	        low = 20;
	        lca = tree.findLCA(n1, n2);
	        assertEquals(lca.data, low,"");
	    }
	    @Test
	    public void testNullNode(){
	    	// testing for a scenario where the intergers passed in are not in the BST
	        BinaryTree tree = new BinaryTree();
	        tree.root = new Node(20);
	        tree.root.left = new Node(8);
	        tree.root.right = new Node(22);
	        tree.root.left.left = new Node(4);
	        tree.root.left.right = new Node(12);
	        tree.root.left.right.left = new Node(10);
	        tree.root.left.right.right = new Node(14);
	        int n1 = 0;
	        int n2 = 100;
	        Node lca = tree.findLCA(n1, n2);
	        assertEquals(null, lca, "null node returned as the ints searched for do not exist in the binary search tree");
	    }
	   
	    @Test
	    public void testfindLCAUtil(){
	    	// testing the function findLCAUtil separately to the findLCA function to check its working independently
	        BinaryTree tree = new BinaryTree();
	        tree.root = new Node(20);
	        tree.root.left = new Node(8);
	        tree.root.right = new Node(22);
	        tree.root.left.left = new Node(4);
	        tree.root.left.right = new Node(12);
	        tree.root.left.right.left = new Node(10);
	        tree.root.left.right.right = new Node(14);
	        int n1 = 10, n2 = 14;
	        int low = 12;
	        Node lca = null;
	        lca = tree.findLCAUtil(tree.root, n1, n2);
	        assertEquals(lca.data, low);
	       
	        n1 = 14;
	        n2 = 8;
	        low = 8;
	        lca = null;
	        lca =tree.findLCAUtil(tree.root, n1, n2);
	        assertEquals(lca.data, low);
	        
	        n1 = 10;
	        n2 = 22;
	        low = 20;
	        lca = null;
	        lca =tree.findLCAUtil(tree.root, n1, n2);
	        assertEquals(lca.data, low);
	        
	        n1 = 0;
	        n2 = 0;
	        lca = null;
	        lca =tree.findLCAUtil(tree.root, n1, n2);
	        assertEquals(lca, null);
	    }
		@Test
	    public void testEmptyBST(){
	    	// testing for a scenario where the BST is empty
	        BinaryTree tree = new BinaryTree();
	       
	        int n1 = 0;
	        int n2 = 100;
	        Node lca = tree.findLCA(n1, n2);
	        assertEquals(null, lca, "null node returned as binary search tree is empty");
	    }

}
