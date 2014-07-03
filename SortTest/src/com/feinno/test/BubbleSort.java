package com.feinno.test;

import java.util.Random;

/**
 * 冒泡排序
 * @author renzhaolong
 *
 */
public class BubbleSort extends SortBase {

	public BubbleSort(){
		super("BubbleSort");
	}
	@Override
	protected void sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++){
			boolean swaped = false;
			for (int j = arr.length - 1; j > i; j--){
				if (bigger(arr[j - 1], arr[j])){
					swaped = true;
					swap(arr, j - 1, j);
				}
			}
			if (!swaped){
				return;
			}
		}
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
		//arr = new int[]{ 2, 3, 4, 5, 6, 7, 8, 9, 1};
		SortBase sort = new BubbleSort();
		sort.beginSort(arr);

		if (sort.checkedResult()){
			System.out.println(sort.getResult());
		}
		else{
			System.out.println("wrong order");
		}
	}

}
