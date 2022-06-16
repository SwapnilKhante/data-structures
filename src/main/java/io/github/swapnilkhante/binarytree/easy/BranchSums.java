package io.github.swapnilkhante.binarytree.easy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SK on 6/9/2022
 **/
public class  BranchSums {

  public static class BinaryTree {
    int value;
    BinaryTree left;
    BinaryTree right;

    BinaryTree(int value) {
      this.value = value;
      this.left = null;
      this.right = null;
    }
  }

  public static List <Integer> branchSums(BinaryTree root) {

    List <Integer> sums = new ArrayList <>();
    calculateBranchSum(root, 0, sums);
    return sums;
  }

  // O(N) time complexity as we are traversing each and every node
  // O(N) space complexity as we are maintaining array of sums = total no of leaf nodes (~ = 2^n where n is the depth of a balanced tree)
  // Event though we are size of the array is not same as the no of nodes O(n/2) ~ O(N)
  // We are also needs to consider the space in the call stack as we are using recursive functions however only
  // for half of the nodes function is getting called
  private static void calculateBranchSum(BinaryTree root, int runningSum, List <Integer> sums) {

    if (root == null) return;

    runningSum += root.value;
    if (root.left == null && root.right == null) {
      sums.add(runningSum);
      return;
    }

    calculateBranchSum(root.left, runningSum, sums);
    calculateBranchSum(root.right, runningSum, sums);
  }
}
