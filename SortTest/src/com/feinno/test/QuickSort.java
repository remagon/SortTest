package com.feinno.test;

import java.util.Random;

/**
 * 快速排序
 * @author renzhaolong
 *
 */
public class QuickSort extends SortBase {

	public QuickSort(){
		super("QuickSort");
	}
	
	@Override
	protected void sort(int[] arr) {
		quickSort(arr, 0, arr.length - 1);
	}

	private void quickSort(int[] arr, int beginNum, int endNum){
		if (beginNum >= endNum){
			return;
		}
		int position = beginNum;
		int first = beginNum;
		int last = endNum;
		while (beginNum < endNum){
			while (position < endNum){
				if (smaller(arr[position], arr[endNum])){
					endNum--;
				}
				else {
					swap(arr, position, endNum);
					position = endNum;
					beginNum++;
					break;
				}
			}
			while (beginNum < position){
				if (bigger(arr[position], arr[beginNum])){
					beginNum++;
				}
				else{
					swap(arr, position, beginNum);
					position = beginNum;
					endNum--;
					break;
				}
			}
		}
		quickSort(arr, first, position - 1);
		quickSort(arr, position + 1, last);
	}

	
	public static void main(String[] args){
		int[] arr = new int[100];
		Random r = new Random();
		for (int i =0; i < arr.length; i++){
			arr[i] = r.nextInt(1000);
		}
		SortBase sort = new QuickSort();
		sort.beginSort(arr);

		System.out.println(sort.getResult());
	}
}
