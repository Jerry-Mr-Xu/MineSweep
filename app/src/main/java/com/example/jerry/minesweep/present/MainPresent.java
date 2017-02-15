package com.example.jerry.minesweep.present;

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

	public void initBoard()
	{
		mainView.showBoard(boardModel.initBoard(mainView.getRowNum(), mainView.getColumnNum(), mainView.getMineNum()));
	}
}
