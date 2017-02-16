package com.example.jerry.minesweep.view;

import com.example.jerry.minesweep.bean.BoardBean;

/**
 * 主界面显示接口
 * <p>
 * Created by Jerry on 2017/2/15.
 */

public interface MainInterface
{
	int getRowNum();

	int getColumnNum();

	int getMineNum();

	void showBoard(BoardBean boardBean);

	void openCube(int cubeRow, int cubeColumn);
}
