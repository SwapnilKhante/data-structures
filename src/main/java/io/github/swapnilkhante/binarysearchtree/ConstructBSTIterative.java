package io.github.swapnilkhante.binarysearchtree;

/**
 * Created by SK on 6/9/2022
 **/
public class ConstructBSTIterative {

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }


    // average O(log(N)) time , O(1) space as we are using iterative approach
    // worst O(N) time , O(1) space
    public BST insert(int value) {
      BST currentNode = this;
      while (true) {
        if (value < currentNode.value) {
          if (currentNode.left == null) {
            BST newBst = new BST(value);
            currentNode.left = newBst;
            break;
          } else {
            currentNode = currentNode.left;
          }
        } else {
          // traverse to the right
          if (currentNode.right == null) {
            BST newBst = new BST(value);
            currentNode.right = newBst;
            break;
          } else {
            //travers down
            currentNode = currentNode.right;
          }
        }
      }
      return this;
    }

    // average O(log(N)) time , O(1) space as we are using iterative approach
    // average O(N) time , O(1) space
    public boolean contains(int value) {

      BST currentNode = this;
      while (currentNode != null) {
        if (currentNode.value > value) {
          // traverse left
          currentNode = currentNode.left;
        } else if (currentNode.value < value) {
          // traverse right
          currentNode = currentNode.right;
        } else {
          return true;
        }
      }
      return false;
    }

    public BST remove(int value) {
      remove(value, null);
      return this;
    }


    // average O(log(N)) time , O(1) space as we are using iterative approach
    // average O(N) time , O(1) space
    private void remove(int value, BST parentNode) {

      BST currentNode = this;
      while (currentNode != null) {

        if (value < currentNode.value) {
          // traversing to the left most node
          parentNode = currentNode;
          currentNode = currentNode.left;
        } else if (value > currentNode.value) {

          // traversing to the right most node
          parentNode = currentNode;
          currentNode = currentNode.right;
        } else {

          // node to be removed has both right and left children, this will include the case if root node is to be deleted
          if (currentNode.left != null && currentNode.right != null) {

            // find out the smallest right node which will replace the node to be deleted
            currentNode.value = currentNode.right.getMinValue();
            currentNode.right.remove(currentNode.value, currentNode);
          } else if (parentNode == null) {

            // this code is executed when node to be deleted is root node and either of right or left is null
            if (currentNode.left != null) {
              //when right node is null
              currentNode.value = currentNode.left.value;
              currentNode.right = currentNode.left.right;
              currentNode.left = currentNode.left.left;
            } else if (currentNode.right != null) {

              // when left node is null
              currentNode.value = currentNode.right.value;
              currentNode.left = currentNode.right.left;
              currentNode.right = currentNode.right.right;
            } else {
              // when node to be deleted is root node, and it has both right and left child as null
            }
            // special edge case where node to be deleted is the root node
            //  we will come back to scenario
          } else if (parentNode.left == currentNode) {
            // if not to be deleted is the left child of parent has itself one child or none
            parentNode.left = currentNode.left != null ? currentNode.left : currentNode.right;

          } else if (parentNode.right == currentNode) {
            // if node to be deleted is the right node
            parentNode.right = currentNode.left != null ? currentNode.left : currentNode.right;
          }
          break;
        }
      }
    }

    private int getMinValue() {
      if (left == null) {
        return value;
      } else {
        return left.getMinValue();
      }
    }
  }
}
