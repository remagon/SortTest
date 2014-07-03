package com.feinno.test;

import java.util.Random;

/**
 * 堆排序
 * @author renzhaolong
 *
 */
public class HeapSort extends SortBase {
	
	public HeapSort(){
		super("HeapSort");
	}

	@Override
	protected void sort(int[] arr){
		for (int i = 1; i < arr.length; i++){
			pushHeap(arr, i, arr[i]);
		}
		for (int i = arr.length; i > 0; i--){
			int num = popHeap(arr, i);
			arr[i - 1] = num;
		}
	}
	
	public void pushHeap(int[] arr, int len, int num){
		arr[len] = num;
		while (len > 0){
			int parent = (len + 1) / 2 - 1;
			if (smaller(arr[parent], arr[len])){
				swap(arr, len, parent);
			}
			else{
				break;
			}
			len = parent;
		}
	}
	
	public int popHeap(int[] arr, int len){
		swap(arr, 0, len - 1);
		int node = 0;
		while (node < len - 1){
			int child1 = (node + 1) * 2;
			int child2 = child1 - 1;
			
			if (child1 < len - 1 && child2 < len - 1){
				if (bigger(arr[child1], arr[child2]))
					child2 = child1;
			}
			if (child2 < len - 1 && smaller(arr[node], arr[child2])){
				swap(arr, node, child2);
				node = child2;
			}
			else{
				break;
			}
		}
		return arr[len - 1];
	}
	
	public static void main(String[] args){
		int[] arr = new int[100];
		Random r = new Random();
		for (int i =0; i < arr.length; i++){
			arr[i] = r.nextInt(1000);
		}
		SortBase sort = new HeapSort();
		sort.beginSort(arr);

		if (sort.checkedResult()){
			System.out.println(sort.getResult());
		}
		else{
			System.out.println("wrong order");
		}
		
//		for (int i =0; i < arr.length; i++){
//			System.out.println(arr[i]);
//		}
		
	}
}
