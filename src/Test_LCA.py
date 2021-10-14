from unittest import TestCase
from LCA import *


class TestLca(TestCase):
    # test case for finding the lca of 2 nodes
    def test_find_path(self):
        root = Node(20)
        root.left = Node(8)
        root.right = Node(22)
        root.left.left = Node(4)
        root.left.right = Node(12)
        root.left.right.left = Node(10)
        root.left.right.right = Node(14)
        lca = findLCA(root, 10, 14)
        self.assertEqual(lca.key, 12, "test for finding lca")

    def test_find_path(self):
        # test case for finding the lca of 2 nodes
        root = Node(20)
        root.left = Node(8)
        root.right = Node(22)
        root.left.left = Node(4)
        root.left.right = Node(12)
        root.left.right.left = Node(10)
        root.left.right.right = Node(14)
        lca = findLCA(root, 14, 8)
        self.assertEqual(lca.key, 8, "test for finding lca")

    def test_find_path(self):
        # test case for finding the lca of 2 nodes
        root = Node(20)
        root.left = Node(8)
        root.right = Node(22)
        root.left.left = Node(4)
        root.left.right = Node(12)
        root.left.right.left = Node(10)
        root.left.right.right = Node(14)
        lca = findLCA(root, 10, 22)
        self.assertEqual(lca.key, 20, "test for finding lca")


class TestKeyNotPresent(TestCase):
    # test case for keys not present in the BST
    def test_find_path(self):
        root = Node(20)
        root.left = Node(8)
        root.right = Node(22)
        root.left.left = Node(4)
        root.left.right = Node(12)
        root.left.right.left = Node(10)
        root.left.right.right = Node(14)
        lca = findLCA(root, 0, 100)
        self.assertEqual(None, None, "test for keys not present in binary search tree")


class TestEmptyBST(TestCase):
    # test case for empty BST
    def test_find_path(self):
        root = None
        lca = findLCA(root, 1, 1)
        self.assertEqual(lca, None, "test for empty binary search tree")
