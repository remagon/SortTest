package com.feinno.test;

import java.util.Random;

/**
 * 侏儒排序
 * @author renzhaolong
 *
 */
public class DwarfSort extends SortBase {

	public DwarfSort() {
		super("DwarfSort");
		// TODO Auto-generated constructor stub
	}

	@Override
	protected void sort(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++){
			if (bigger(arr[i], arr[i + 1])){
				swap(arr, i, i + 1);
				for (int j = i; j > 0; j--){
					if (smaller(arr[j], arr[j - 1])){
						swap(arr, j, j - 1 );
					}
					else{
						break;
					}
				}
			}
		}
	}

	public static void main(String[] args){

		int[] arr = new int[100];
		Random r = new Random();
		for (int i =0; i < arr.length; i++){
			arr[i] = r.nextInt(1000);
		}
		//arr = new int[]{ 2, 3, 4, 5, 6, 7, 8, 9, 1};
		SortBase sort = new DwarfSort();
		sort.beginSort(arr);

		if (sort.checkedResult()){
			System.out.println(sort.getResult());
		}
		else{
			System.out.println("wrong order");
		}
	}
}
