package MinHeap;

public class MinHeap {

	private int[] minHeapArray;
	private int minHeapCapacity;
	private int minHeapSize;
	
	public MinHeap(int minHeapCapacity) {
		this.minHeapCapacity = minHeapCapacity;
		this.minHeapArray = new int[this.minHeapCapacity];
		this.minHeapSize = 0;		
	}
	
	public int[] GetMinHeapArray() {
		return this.minHeapArray;
	}
	
	public int GetMinHeapSize() {
		return this.minHeapSize;
	}
	
	public int GetMinHeapCapacity() {
		return this.minHeapCapacity;
	}
	
	public void SetMinHeapCapacity(int capacity) {
		this.minHeapArray = new int[capacity];
		this.minHeapCapacity = capacity;
	}
	
	public void SetMinHeapSize(int sizeValue) {
		this.minHeapSize = sizeValue;
	}
	
	public void SetMinHeapArray(int[] array) {
		this.minHeapArray = array;
	}
	
	public void InsertInMinHeap(int data) {
		if(this.minHeapSize == this.minHeapCapacity) {
			System.out.println("The MinHeap is full! Cannot insert!");			
		}else {
			this.minHeapSize++;
			int lastIndex = this.minHeapSize-1;
			this.minHeapArray[lastIndex] = data;
			
			//Check whether this insertion has caused any violation in the parent -> Percolate Up
			while(lastIndex != 0 && this.minHeapArray[(lastIndex-1)/2] > this.minHeapArray[lastIndex]) {
				
				//If there is a violation of minHeap property, swap and percolate up
				int temporaryVariable = this.minHeapArray[lastIndex];
				this.minHeapArray[lastIndex] = this.minHeapArray[(lastIndex-1)/2];
				this.minHeapArray[(lastIndex-1)/2] = temporaryVariable;
				
				//Reach parent so that loop verifies the MinHeap property
				lastIndex = (lastIndex-1)/2;
			}			
		}
	}
	
	public int ExtractMinimum() {
		
		if(this.minHeapSize <= 0) {
			System.out.println("MinHeap is empty! Cannot extract minimum");
			return -1;
		}
		
		if(this.minHeapSize == 1) {
			this.minHeapSize--;
			return this.minHeapArray[0];			
		}
		
		//Find next candidate among children to occupy root
		int minimumValueAtRoot = this.minHeapArray[0];
		//Replace the root with the last element
		this.minHeapArray[0] = this.minHeapArray[this.minHeapSize-1];
		//Decrement size and MinHeapify
		this.minHeapSize--;
		MinHeapify(0);
		return minimumValueAtRoot;
	}
	
	public void MinHeapify(int index) {
		
		int leftIndex = 2*index+1;
		int rightIndex = 2*index+2;
		int smallestValueIndex = index;
		
		//Find if one of the children qualifies to be the root
		if(leftIndex < this.minHeapSize && this.minHeapArray[leftIndex] < this.minHeapArray[index]) {
			smallestValueIndex = leftIndex;			
		}
		
		if(rightIndex < this.minHeapSize && this.minHeapArray[rightIndex] < this.minHeapArray[smallestValueIndex]) {
			smallestValueIndex = rightIndex;
		}
		
		//Swap if smallestValue is found
		if(smallestValueIndex != index) {
			int dummyVariable = this.minHeapArray[index];
			this.minHeapArray[index] = this.minHeapArray[smallestValueIndex];
			this.minHeapArray[smallestValueIndex] = dummyVariable;
			
			//MinHeapify this index to explore minimum further
			MinHeapify(smallestValueIndex);
		}		
	}
	
	public void PrintMinHeapContents() {
		System.out.println("---Printing the contents of the MinHeap---");
		
		for(int index = 0; index < this.minHeapSize; index++) {
			System.out.print(this.minHeapArray[index]+" ");
		}
		
	}
}
