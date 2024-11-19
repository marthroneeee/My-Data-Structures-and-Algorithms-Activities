public class QuijanoHeap {
    private int[] heap;
    private int size;
    private int capacity;

// Constructor to initialize the heap
public QuijanoHeap(int capacity) {
    this.capacity = capacity;
    this.size = 0;
    this.heap = new int[capacity];
    }

	// methods for heap operations
    private int parent(int a) { return (a - 1) / 2; }
    private int leftChild(int a) { return 2 * a + 1; }
    private int rightChild(int a) { return 2 * a + 2; }

// Swap two elements in the heap
private void swap(int a, int b) {
    int temp = heap[a];
    heap[a] = heap[b];
    heap[b] = temp;
    }

// Ensure the heap property is maintained
private void heapify(int a) {
    int largest = a;
    int left = leftChild(a);
    int right = rightChild(a);

if (left < size && heap[left] > heap[largest]) {
    largest = left;
    }
if (right < size && heap[right] > heap[largest]) {
    largest = right;
    }
if (largest != a) {
    swap(a, largest);
    heapify(largest);
    }
}

// Insert a key into the heap
public void insert(int key) {
	if (size == capacity) {
        System.out.println("Heap is full!");
        return;
        }
        heap[size] = key;
        int a = size;
        size++;

// Bubble up to maintain heap property
while (a != 0 && heap[parent(a)] < heap[a]) {
	swap(a, parent(a));
    a = parent(a);
    }
}

// Extract the maximum (root) element
public int extractMax() {
	if (size <= 0) {
        return Integer.MIN_VALUE;
        }
    if (size == 1) {
        size--;
        return heap[0];
        }

// Replace the root with the last element and heapify
int root = heap[0];
    heap[0] = heap[size - 1];
    size--;
    heapify(0);

    return root;
    }

// Get the maximum (root) element without removing it
public int getMax() {
	if (size <= 0) {
        return Integer.MIN_VALUE;
        }
        return heap[0];
    }

// Print the heap elements
public void printHeap() {
	for (int a = 0; a < size; a++) {
        System.out.print(heap[a] + " ");
        }
        System.out.println();
    }


public static void main(String[] args) {
	QuijanoHeap maxHeap = new QuijanoHeap(10);

		maxHeap.insert(3);
        maxHeap.insert(1);
        maxHeap.insert(5);
        maxHeap.insert(2);
        maxHeap.insert(4);
        maxHeap.insert(6);

        maxHeap.printHeap();

        System.out.println("Max value: " + maxHeap.getMax());

        System.out.println("Extracted Max: " + maxHeap.extractMax());
        maxHeap.printHeap();
    }
}
