package Application;

import java.util.Scanner;
import MinHeap.MinHeap;

public class Main {

	public static void main(String[] args) {
		System.out.println("MinHeap Implementation in Java");
		System.out.println("-------------------------------");
		
		System.out.println("Enter the number of elements to be inserted in the MinHeap");
		try {
			Scanner scanner = new Scanner(System.in);
			int sizeOfMinHeap = scanner.nextInt();
			MinHeap minHeap = new MinHeap(10);
			for(int index = 0; index < sizeOfMinHeap; index++) {
				System.out.println("Enter the element "+(index+1));
				minHeap.InsertInMinHeap(scanner.nextInt());
			}
			System.out.println("Extracted Minimum from the MinHeap is "+minHeap.ExtractMinimum());
			minHeap.PrintMinHeapContents();			
		}catch(Exception exception) {
			System.out.println("Application:Main:Thrown exception is "+exception.getMessage());			
		}
	}
}
