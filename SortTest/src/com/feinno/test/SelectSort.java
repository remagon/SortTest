package com.feinno.test;

import java.util.Random;

/**
 * 选择排序
 * @author renzhaolong
 *
 */
public class SelectSort extends SortBase {

	public SelectSort(){
		super("SelectSort");
	}
	
	@Override
	protected void sort(int[] arr){
		for (int i = 0 ; i < arr.length; i++){
			int min = i;
			for (int j = i + 1; j < arr.length; j++)
			{
				if (smaller(arr[j], arr[min])){
					min = j;
				}
			}
			if (i != min){
				swap(arr, i, min);
			}
		}
	}
	
	public static void main(String[] args){
		int[] arr = new int[100];
		Random r = new Random();
		for (int i =0; i < arr.length; i++){
			arr[i] = r.nextInt(1000);
		}
		SortBase sort = new SelectSort();
		sort.beginSort(arr);

		System.out.println(sort.getResult());
	}
}
