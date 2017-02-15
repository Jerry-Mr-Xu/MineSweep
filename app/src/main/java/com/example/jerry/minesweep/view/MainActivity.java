package com.example.jerry.minesweep.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.GridView;

import com.example.jerry.minesweep.R;
import com.example.jerry.minesweep.bean.BoardBean;
import com.example.jerry.minesweep.present.BoardGridAdapter;
import com.example.jerry.minesweep.present.MainPresent;

public class MainActivity extends AppCompatActivity implements MainInterface
{
	// 棋盘网格布局
	private GridView gvBoard;
	// 棋盘网格适配器
	private BoardGridAdapter adapter;

	// 棋盘行数
	private int rowNum = 5;
	// 棋盘列数
	private int columnNum = 5;
	// 地雷数
	private int mineNum = 5;

	private MainPresent present;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		initView();
	}

	private void initView()
	{
		gvBoard = (GridView) findViewById(R.id.gv_board);
		gvBoard.setNumColumns(columnNum);
		present = new MainPresent(this);
		present.initBoard();
	}

	@Override
	public int getRowNum()
	{
		return rowNum;
	}

	@Override
	public int getColumnNum()
	{
		return columnNum;
	}

	@Override
	public int getMineNum()
	{
		return mineNum;
	}

	@Override
	public void showBoard(BoardBean boardBean)
	{
		adapter = new BoardGridAdapter(this, boardBean.getCubeBeans(), boardBean.getRowNum() * boardBean.getColumnNum(), boardBean.getColumnNum());
		gvBoard.setAdapter(adapter);
	}
}
