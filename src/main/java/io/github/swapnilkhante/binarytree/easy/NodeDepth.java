package io.github.swapnilkhante.binarytree.easy;

/**
 * Created by SK on 6/14/2022
 **/
public class NodeDepth {

  public static void main(String[] args) {
    var root = new BinaryTree(1);
    root.left = new BinaryTree(2);
    root.left.left = new BinaryTree(4);
    root.left.left.left = new BinaryTree(8);
    root.left.left.right = new BinaryTree(9);
    root.left.right = new BinaryTree(5);
    root.right = new BinaryTree(3);
    root.right.left = new BinaryTree(6);
    root.right.right = new BinaryTree(7);
    int actual = nodeDepthsHelper(root);
    System.out.println(actual);
  }

  private static int nodeDepthsHelper(BinaryTree root) {
    return nodeDepthsHelper(root, 0);
  }

  // O(N) time and O(h) space
  private static int nodeDepthsHelper(BinaryTree node, int depth) {
    if (node == null) return 0;
    return depth + nodeDepthsHelper(node.left, depth + 1) + nodeDepthsHelper(node.right, depth + 1);
  }
}
