package com.feinno.test;

import java.util.Random;

/**
 * 鸡尾酒排序，双向冒泡排序
 * @author renzhaolong
 *
 */
public class CocktailSort extends SortBase {

	public CocktailSort(){
		super("CocktailSort");
	}
	@Override
	protected void sort(int[] arr) {
		for (int i = 0; i < arr.length / 2; i++){
			boolean swaped = false;
			for (int j = arr.length - i - 1; j > i; j--){
				if (bigger(arr[j - 1], arr[j])){
					swaped = true;
					swap(arr, j - 1, j);
				}
			}
			if (!swaped){
				return;
			}
			swaped = false;
			for (int j = i; j < arr.length - i - 1; j++){
				if (bigger(arr[j], arr[j + 1])){
					swaped = true;
					swap(arr, j, j + 1);
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
		arr = new int[]{9, 1, 2, 3, 4, 5, 6, 7, 8};
		SortBase sort = new CocktailSort();
		sort.beginSort(arr);

		if (sort.checkedResult()){
			System.out.println(sort.getResult());
		}
		else{
			System.out.println("wrong order");
		}

	}

}
