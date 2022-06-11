package io.github.swapnilkhante.binarysearchtree;

/**
 * Created by SK on 6/9/2022
 **/
public class ClosestValue {

  public static int findClosestValueInBst(BST tree, int target) {

    return findClosest(tree, target, tree.value);
  }

  // average O(log(N)) time , O(log(N)) space as we are using iterative approach
  // average O(N) time , O(N) space
  public static int findClosest(BST tree, int target, int closest) {

    if (Math.abs(target - closest) > Math.abs(target - tree.value)) {
      closest = tree.value;
    }
    if (target < tree.value && tree.left != null) {
      return findClosest(tree.left, target, closest);
    } else if (target > tree.value && tree.right != null) {
      return findClosest(tree.right, target, closest);
    } else {
      return closest;
    }
  }

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }
  }
}
