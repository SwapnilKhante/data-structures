package io.github.swapnilkhante.binarytree.easy;

import java.util.concurrent.atomic.AtomicInteger;

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
    int actual = nodeDepths(root);
    System.out.println(actual);
  }

  private static int nodeDepths(BinaryTree root) {

    AtomicInteger parentDepth = new AtomicInteger(0);
    if (root == null) return 0;
    return nodeDepths(root, parentDepth);
  }

  private static int nodeDepths(BinaryTree node, AtomicInteger depth) {

//    if (node.left != null && node.right!=null) {
//      nodeDepths(node.left, depth.);
//    }
//    if(node.right!=null) {
//      depth++;
//    }
//    return depth;
//  }

    return 0;
  }
}
