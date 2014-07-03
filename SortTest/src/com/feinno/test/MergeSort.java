package com.feinno.test;

import java.util.Random;

/**
 * 合并排序
 * @author renzhaolong
 *
 */
public class MergeSort extends SortBase {

	public MergeSort() {
		super("MergeSort");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void sort(int[] arr) {
		//mergeSort2(arr);
		sortedArr = mergeSort(arr, 0, arr.length - 1);
	}
	
	private void mergeSort2(int[] arr){
		int step = 1;
		while (step < arr.length){
			int[] tempArr = arr.clone();
			for (int i = 0; i < arr.length; i += step * 2){
				int b1 = i, b2 = i + step;
				int position = i;
				while (b1 < i + step && b1 < arr.length && b2 < arr.length && b2 < i + step * 2){
					if (smaller(tempArr[b1], tempArr[b2])){
						arr[position] = tempArr[b1];
						b1++;
					}
					else{
						arr[position] = tempArr[b2];
						b2++;
					}
					swapCount++;
					position++;
				}
				while (b1 < i + step && b1 < arr.length){
					arr[position] = tempArr[b1];
					b1++;
					swapCount++;
					position++;
				}
				while (b2 < arr.length && b2 < i + step * 2){
					arr[position] = tempArr[b2];
					b2++;
					swapCount++;
					position++;
				}
			}
			step *= 2;
		}
	}

	private int[] mergeSort(int[] arr, int begin, int end){
		if (begin == end)
			return arr;
		int mid = (begin + end) / 2;
		arr= mergeSort(arr, begin, mid);
		arr = mergeSort(arr, mid + 1, end);
		
		int[] arrResult = arr.clone();
		int i = begin, j = mid + 1, position = begin;
		while (i <= mid && j <= end){
			if (smaller(arr[i], arr[j])){
				arrResult[position] = arr[i];
				swapCount++;
				i++;
			}
			else {
				arrResult[position] = arr[j];
				swapCount++;
				j++;
			}
			position++;
		}
		
		while (i <= mid){
			arrResult[position] = arr[i];
			swapCount++;
			i++;
			position++;
		}
		
		while (j <= end){
			arrResult[position] = arr[j];
			swapCount++;
			j++;
			position++;
		}
		arr = arrResult;
		return arrResult;
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {

		int[] arr = new int[100];
		Random r = new Random();
		for (int i =0; i < arr.length; i++){
			arr[i] = r.nextInt(1000);
		}
		SortBase sort = new MergeSort();
		sort.beginSort(arr);

		if (sort.checkedResult()){
			System.out.println(sort.getResult());
		}
		else{
			System.out.println("wrong order");
		}
	}
}
