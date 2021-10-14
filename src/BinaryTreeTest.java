import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.Test;

public class testBinaryTree{
    public void testNode(){
        BinaryTree tree = new BinaryTree();
        // testing the binary search tree for that i'll be mainly using for the later tests
        // making sure that the node function, functions correctly
        tree.root = new Node(20);
        assertEquals(tree.root.left.data, 20);
        tree.root.left = new Node(8);
        assertEquals(tree.root.data, 20);
        tree.root.right = new Node(22);
        assertEquals(tree.root.right.data, 20);
        tree.root.left.left = new Node(4);
        assertEquals(tree.root.left.left.data, 20);
        tree.root.left.right = new Node(12);
        assertEquals(tree.root.left.right.data, 20);
        tree.root.left.right.left = new Node(10);
        assertEquals(tree.root.left.right.left.data, 20);
        tree.root.left.right.right = new Node(14);
        assertEquals(tree.root.left.right.right.data, 20);

    }

    @Test
    public void testLCANormal(){
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
        assertEquals(null, lca);
    }
    @Test
    public void testIntNotPresent(){
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
        assertEquals(null, lca,"null node returned as the ints searched for do not exist in the binary search tree");
    }
}
 