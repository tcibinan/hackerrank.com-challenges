package medianonheaps;

import java.util.*;

public class Solution {

    static Heap heap = new SortingHeap(100);

    public static void main(String[] args) {
        Scanner in = new Scanner(String.join(" ", args));
        int n = in.nextInt();
        int[] a = new int[n];

        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
            heap.add(a[a_i]);
            System.out.println(heap.getMedian());
        }
    }

    static class SortingHeap implements Heap {
        int[] data;
        int size;

        public SortingHeap(int length) {
            this.data = new int[length];
        }

        public SortingHeap(int[] data, int size) {
            this.data = Arrays.copyOf(data, data.length);
            this.size = size;
        }

        @Override
        public void add(int val) {
            data[size] = val;
            size++;

            heapifyUp();
        }

        private void heapifyUp() {
            int index = size -1;

            while (hasParent(data[index]) && data[index] < getParent(index)) {
                swapWithParent(index);
                index = getParentIndex(index);
            }
        }

        private void heapifyDown() {
            int index = 0;

            while (hasLeft(index)) {
                int swapIndex = getLeftIndex(index);
                if (hasRight(index)) {
                    swapIndex = getLeft(index) < getRight(index) ? getLeftIndex(index) : getRightIndex(index);
                }

                if (data[index] > data[swapIndex]) {
                    swap(index, swapIndex);
                } else {
                    break;
                }

                index = swapIndex;
            }
        }

        private boolean hasLeft(int parentIndex) {
            return getLeftIndex(parentIndex) < size;
        }

        private boolean hasRight(int parentIndex) {
            return getRightIndex(parentIndex) < size;
        }

        private int getRight(int parentIndex) {
            return data[getRightIndex(parentIndex)];
        }

        private int getLeft(int parentIndex) {
            return data[getLeftIndex(parentIndex)];
        }

        private boolean hasParent(int index) {
            return getParentIndex(index) >= 0;
        }

        private int getParent(int index) {
            return data[getParentIndex(index)];
        }

        private int getLeftIndex(int parentIndex) {
            return 2*parentIndex + 1;
        }

        private int getRightIndex(int parentIndex) {
            return 2*parentIndex + 2;
        }

        private int getParentIndex(int index) {
            return (index-1) / 2;
        }

        private void swapWithParent(int index) {
            swap(index, getParentIndex(index));
        }

        private void swap(int index1, int index2) {
            int temp = data[index1];
            data[index1] = data[index2];
            data[index2] = temp;
        }

        @Override
        public double getMedian() {
            Heap heap = new SortingHeap(data, size);
            int prev = 0;
            int cur = heap.pop();
            for (int i = 0; i < size/2; i++) {
                prev = cur;
                cur = heap.pop();
            }
            return size % 2 == 0 ? (double) (prev+cur)/2 : cur;
        }

        @Override
        public int pop() {
            int value = data[0];
            size--;
            data[0] = data[size];

            heapifyDown();
            return value;
        }

    }

    interface Heap {
        void add(int val);
        double getMedian();
        int pop();
    }

    static class MinsMaxsHeaps implements Heap {
        private PriorityQueue<Integer> maxs = new PriorityQueue<>(Comparator.naturalOrder());
        private PriorityQueue<Integer> mins = new PriorityQueue<>(Comparator.reverseOrder());

        @Override
        public void add(int val) {
            if (!maxs.isEmpty() && maxs.peek() < val) {
                maxs.add(val);
            } else if (!mins.isEmpty() && mins.peek() > val) {
                mins.add(val);
            } else {
                mins.add(val);
            }

            if (mins.size() - maxs.size() > 1) {
                while (mins.size() > maxs.size() + 1) {
                    maxs.add(mins.poll());
                }
            } else if (maxs.size() > mins.size()) {
                while (maxs.size() > mins.size()) {
                    mins.add(maxs.poll());
                }
            }
        }

        @Override
        public double getMedian() {
            if (isSizeEven()) {
                return (double) (mins.peek() + maxs.peek()) / 2;
            } else {
                return mins.peek();
            }
        }

        private boolean isSizeEven() {
            return getSize() % 2 == 0;
        }

        private int getSize() {
            return maxs.size() + mins.size();
        }

        @Override
        public int pop() {
            throw new UnsupportedOperationException();
        }
    }
}
