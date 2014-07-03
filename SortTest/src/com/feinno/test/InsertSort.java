package com.feinno.test;

import java.util.Random;

/**
 * 插入排序
 * @author renzhaolong
 *
 */
public class InsertSort extends SortBase {

	public InsertSort(){
		super("InsertSort");
	}
	@Override
	protected void sort(int[] arr) {
		for (int i = 1; i < arr.length; i++){
			for (int j = i; j > 0; j--){
				if (smaller(arr[j], arr[j - 1])){
					swap(arr, j, j - 1);
				}
				else{
					break;
				}
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
		SortBase sort = new InsertSort();
		sort.beginSort(arr);

		if (sort.checkedResult()){
			System.out.println(sort.getResult());
		}
		else{
			System.out.println("wrong order");
		}
	}
}
