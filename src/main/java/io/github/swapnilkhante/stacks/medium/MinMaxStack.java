package io.github.swapnilkhante.stacks.medium;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by SK on 6/21/2022
 **/
public class MinMaxStack {

  private List <Map <String, Integer>> minMaxStack = new ArrayList <>();
  private List <Integer> stack = new ArrayList <>();


  // Time - O(1) | Space O(1)
  public int peek() {
    return stack.get(stack.size() - 1);
  }

  // Time - O(1) | Space O(1)
  public int pop() {
    minMaxStack.remove(minMaxStack.size() - 1);
    return stack.remove(stack.size() - 1);
  }

  // Time - O(1) | Space O(1)
  public void push(int number) {
    Map <String, Integer> newMinMax = new HashMap <>();
    newMinMax.put("min", number);
    newMinMax.put("max", number);

    if (minMaxStack.size() > 0) {
      Map <String, Integer> lastMinMax = new HashMap <>(minMaxStack.get(minMaxStack.size() - 1));
      newMinMax.replace("min", Math.min(lastMinMax.get("min"), number));
      newMinMax.replace("max", Math.max(lastMinMax.get("max"), number));
    }

    minMaxStack.add(newMinMax);
    stack.add(number);
  }

  // Time - O(1) | Space O(1)
  public int getMin() {
    return minMaxStack.get(minMaxStack.size() - 1).get("min");
  }

  // Time - O(1) | Space O(1)
  public int getMax() {
    return minMaxStack.get(minMaxStack.size() - 1).get("max");
  }
}
