package io.github.swapnilkhante.graph.medium;

/**
 * Created by SK on 6/20/2022
 **/
public class SingleCycleCheck {

    public static void main(String[] args) {

        System.out.println(hasSingleCycle(new int[] {2, 3, 1, -4, -4, 2}));
    }

    private static boolean hasSingleCycle(int[] array) {

        int numOfElementsVisited = 0;
        int currentIdx = 0;
        while(numOfElementsVisited < array.length) {
            if(numOfElementsVisited > 0 && currentIdx==0) {
                return false;
            }
            numOfElementsVisited++;
            currentIdx = findNextIdx(currentIdx, array);
        }

        return currentIdx == 0;
    }

    private static int findNextIdx(int currentIdx, int[] array) {
        int nextIdx = (array[currentIdx] + currentIdx) % array.length;
        return nextIdx >= 0 ? nextIdx : nextIdx + array.length;

    }
}
