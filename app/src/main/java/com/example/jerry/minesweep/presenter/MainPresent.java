package com.example.jerry.minesweep.presenter;

import com.example.jerry.minesweep.bean.BoardBean;
import com.example.jerry.minesweep.bean.CubeBean;
import com.example.jerry.minesweep.model.BoardModel;
import com.example.jerry.minesweep.view.MainInterface;

/**
 * 主界面逻辑
 * <p>
 * Created by Jerry on 2017/2/15.
 */

public class MainPresent
{
	private MainInterface mainView;
	private BoardModel boardModel;

	public MainPresent(MainInterface mainView)
	{
		this.mainView = mainView;
		this.boardModel = new BoardModel();
	}

	/**
	 * 初始化棋盘
	 */
	public void initBoard()
	{
		int rowNum = mainView.getRowNum();
		int columnNum = mainView.getColumnNum();
		int mineNum = mainView.getMineNum();
		CubeBean[][] cubes = new CubeBean[rowNum][columnNum];

		// 生成地雷
		initMine(rowNum * columnNum, columnNum, mineNum, cubes);

		// 生成除去地雷以外的格子
		for (int i = 0; i < rowNum; i++)
		{
			for (int j = 0; j < columnNum; j++)
			{
				if (cubes[i][j] == null)
				{
					// 统计周围地雷数
					int aroundMineNum = countAroundMineNum(cubes, i, j, rowNum, columnNum);
					cubes[i][j] = new CubeBean(aroundMineNum);
				}
			}
		}

		BoardBean boardBean = new BoardBean(rowNum, columnNum, mineNum, cubes);


		mainView.showBoard(boardBean);
	}

	/**
	 * 统计指定格子周围地雷数
	 *
	 * @param cubes     格子数据集
	 * @param rowPos    行坐标
	 * @param columnPos 列坐标
	 * @return 地雷数
	 */
	private int countAroundMineNum(CubeBean[][] cubes, int rowPos, int columnPos, int rowNum, int columnNum)
	{
		int aroundMineNum = 0;

		// 左上
		if (rowPos - 1 >= 0 && columnPos - 1 >= 0 && cubes[rowPos - 1][columnPos - 1] != null && cubes[rowPos - 1][columnPos - 1].getFlag() == -1)
		{
			aroundMineNum++;
		}
		// 正上
		if (rowPos - 1 >= 0 && cubes[rowPos - 1][columnPos] != null && cubes[rowPos - 1][columnPos].getFlag() == -1)
		{
			aroundMineNum++;
		}
		// 右上
		if (rowPos - 1 >= 0 && columnPos + 1 < columnNum && cubes[rowPos - 1][columnPos + 1] != null && cubes[rowPos - 1][columnPos + 1].getFlag() == -1)
		{
			aroundMineNum++;
		}
		// 正左
		if (columnPos - 1 >= 0 && cubes[rowPos][columnPos - 1] != null && cubes[rowPos][columnPos - 1].getFlag() == -1)
		{
			aroundMineNum++;
		}
		// 正右
		if (columnPos + 1 < columnNum && cubes[rowPos][columnPos + 1] != null && cubes[rowPos][columnPos + 1].getFlag() == -1)
		{
			aroundMineNum++;
		}
		// 左下
		if (rowPos + 1 < rowNum && columnPos - 1 >= 0 && cubes[rowPos + 1][columnPos - 1] != null && cubes[rowPos + 1][columnPos - 1].getFlag() == -1)
		{
			aroundMineNum++;
		}
		// 正下
		if (rowPos + 1 < rowNum && cubes[rowPos + 1][columnPos] != null && cubes[rowPos + 1][columnPos].getFlag() == -1)
		{
			aroundMineNum++;
		}
		// 右下
		if (rowPos + 1 < rowNum && columnPos + 1 < columnNum && cubes[rowPos + 1][columnPos + 1] != null && cubes[rowPos + 1][columnPos + 1].getFlag() == -1)
		{
			aroundMineNum++;
		}
		return aroundMineNum;
	}

	/**
	 * 初始化地雷
	 */
	private void initMine(int cubeNum, int columnNum, int mineNum, CubeBean[][] cubes)
	{
		int[] cube = new int[cubeNum];

		for (int i = 0; i < cubeNum; i++)
		{
			cube[i] = i;
		}

		for (int i = 0; i < mineNum; i++)
		{
			int randomPos = (int) (Math.random() * (cubeNum - i) + i);
			int temp = cube[randomPos];
			cube[randomPos] = cube[i];
			cube[i] = temp;

			// 生成地雷
			cubes[cube[i] / columnNum][cube[i] % columnNum] = new CubeBean(-1);
		}
	}
}
