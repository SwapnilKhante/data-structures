package io.github.swapnilkhante.heaps.medium;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by SK on 7/5/2022
 **/
public class MinHeapDemo {

    static class MinHeap {
        List<Integer> heap = new ArrayList<Integer>();

        public MinHeap(List<Integer> array) {
            heap = buildHeap(array);
        }

        // time = O(N) | space O(1)
        public List <Integer> buildHeap(List<Integer> array) {
            int firstParentIdx = (array.size() - 2 )/2;
            for(int i = firstParentIdx; i > 0; i--) {
               siftDown(i, array.size() -1, array);
            }
            return array;
        }

        // time = O(logN) | space O(1)
        public void siftDown(int currentIdx, int endIdx, List<Integer> heap) {
            int child1Idx = currentIdx * 2 +1;

            while (child1Idx <= endIdx) {
                int child2Idx = currentIdx * 2 + 2 <= endIdx ? currentIdx * 2 + 2 : -1;
                int indexToSwap;
                if (child2Idx != -1 && heap.get(child2Idx) < heap.get(child1Idx)) {
                    indexToSwap = child2Idx;
                } else{
                    indexToSwap = child1Idx;
                }
                if(heap.get(currentIdx) > heap.get(indexToSwap)) {
                    swap(currentIdx, indexToSwap, heap);
                    currentIdx = indexToSwap;
                    child1Idx = currentIdx * 2 +1;
                } else{
                    return;
                }

            }
        }

        // time = O(logN) | space O(1)
        public void siftUp(int currentIdx, List<Integer> heap) {

            int parent = (currentIdx - 1 )/2;
            while (currentIdx > 0 && heap.get(parent) > heap.get(currentIdx)) {
                swap(currentIdx, parent, heap);
                currentIdx = parent;
                parent = (currentIdx - 1)/2;
            }
        }

        private void swap(int currentIdx, int parent, List <Integer> heap) {
            int temp = heap.get(currentIdx);
            heap.set(currentIdx, heap.get(parent));
            heap.set(parent, temp);
        }

        // time = O(1) | space O(1)
        public int peek() {
           return heap.get(0);
        }

        public int remove() {
            swap(0, heap.size() -1, heap);
            int valueToRemove = heap.remove(heap.size() - 1);
            siftDown(0, heap.size()  - 1, heap);
            return valueToRemove;
        }

        public void insert(int value) {
           heap.add(value);
           siftUp(heap.size() - 1, heap);
        }
    }
}
