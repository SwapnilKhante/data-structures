package io.github.swapnilkhante.binarysearchtree;

/**
 * Created by SK on 6/8/2022
 **/
public class ConstructBSTRecursive {

  static class BST {
    public int value;
    public BST left;
    public BST right;

    public BST(int value) {
      this.value = value;
    }

    public BST insert(int value) {

      // if value is less than node
      if (value < this.value) {
        if (left == null) {
          BST newBst = new BST(value);
          left = newBst;
        } else {
          left.insert(value);
        }
      } else {
        // if value is greater than the node
        if (right == null) {
          BST newBst = new BST(value);
          right = newBst;
        } else {
          right.insert(value);
        }
      }
      return this; // allows us to do method chaining
    }

    public boolean contains(int value) {

      if(value < left.value) {
        if(left == null) {
          return false;
        } else {
          return left.contains(value);
        }
      } else if (value > right.value) {
        if(right == null) {
          return false;
        } else{
          return right.contains(value);
        }
      } else{
        return true;
      }
    }

    public BST remove(int value) {

      if (value < left.value) {
        if(left == null ){

        }

      }
      return this;
    }

  }

}




