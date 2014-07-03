package com.feinno.test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class test {

	private int[][] board = new int[3][3];
	
	public static void testSort(int length, SortBase sort){

		int[] arr = new int[length];
		Random r = new Random();
		for (int i =0; i < arr.length; i++){
			arr[i] = i * 9 + r.nextInt(i * 1 + 10);
		}
		
		long totalSwap = 0;
		long totalCompare = 0;
		for (int i = 0; i < 100; i++){
			sort.beginSort(arr);
			totalCompare += sort.getCompareCount();
			totalSwap += sort.getSwapCount();
		}
		System.out.println(sort.getSortType() + ":\r\n swapCount:" + totalSwap / 100 + "\r\n" + " compareCount:" + totalCompare / 100 + "\r\n");
		
	}
	
	public static void testSort(int[] arr, SortBase sort){
		int totalSwap = 0;
		int totalCompare = 0;
		for (int i = 0; i < 100; i++){
			sort.beginSort(arr);
			totalCompare += sort.getCompareCount();
			totalSwap += sort.getSwapCount();
		}
		System.out.println(sort.getSortType() + ":\r\n swapCount:" + totalSwap / 100 + "\r\n" + " compareCount:" + totalCompare / 100 + "\r\n");
	}
	public static void main(String[] args){
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
		System.out.println(df.format(new Date()));
		Date d = new Date();
		Calendar cal = Calendar.getInstance();

		int[] arr = new int[1000];
		Random r = new Random();
		for (int i =0; i < arr.length; i++){
			arr[i] = i * 9 + r.nextInt(i * 1 + 10);
		}
//		testSort(1000, new HeapSort());	
//		testSort(1000, new ShellSort());	
//		testSort(1000, new QuickSort());	
//		testSort(1000, new BubbleSort());	
//		testSort(1000, new SelectSort());
//		testSort(1000, new CocktailSort());
		testSort(arr, new DwarfSort());
		testSort(arr, new InsertSort());
		
//
//		testSort(10000, new HeapSort());	
//		testSort(10000, new ShellSort());	
//		testSort(10000, new QuickSort());	
//		testSort(10000, new BubbleSort());	
//		testSort(10000, new SelectSort());
//		testSort(10000, new CocktailSort());
//		
		int sum = (1 + 9) * 9 / 2 / 3;
		int n1 = 9;
		for (int n2 = 1; n2 < 3; n2++){
			int n3 = 6 - n2;
		}
		System.out.println("test");
	}
	
	private boolean checkBoard(){
		int sum = 0;
		int sum3 = 0;
		int sum4 = 0;
		for (int i = 0; i < 3; i++){
			sum3 += board[i][i];
			sum4 += board[i][2 - i];
			int sum1 = 0;
			int sum2 = 0;
			for (int j = 0; j < 3; j++){
				sum1 += board[i][j];
				sum2 += board[j][i];
			}
			if (sum1 != sum2){
				return false;
			}
			if (sum == 0){
				sum = sum1;
			}
			else if (sum != sum1){
				return false;
			}
		}
		if (sum != sum3 || sum != sum4)
			return false;
		return true;
	}

}
