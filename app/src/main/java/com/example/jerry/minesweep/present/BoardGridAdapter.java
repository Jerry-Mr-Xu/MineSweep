package com.example.jerry.minesweep.present;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.example.jerry.minesweep.R;
import com.example.jerry.minesweep.bean.CubeBean;

import java.util.Locale;

/**
 * 棋盘网格适配器
 * <p>
 * Created by Jerry on 2017/2/15.
 */

public class BoardGridAdapter extends BaseAdapter
{
	private Context context;
	private CubeBean[][] cubes;
	private int cubeNum;
	private int columnNum;

	public BoardGridAdapter(Context context, CubeBean[][] cubes, int cubeNum, int columnNum)
	{
		this.context = context;
		this.cubes = cubes;
		this.cubeNum = cubeNum;
		this.columnNum = columnNum;
	}

	@Override
	public int getCount()
	{
		return cubeNum;
	}

	@Override
	public Object getItem(int position)
	{
		return cubes[position / columnNum][position % columnNum];
	}

	@Override
	public long getItemId(int position)
	{
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent)
	{
		if (convertView == null)
		{
			convertView = LayoutInflater.from(context).inflate(R.layout.cb_cube, parent, false);
		}

		int rowPos = position / columnNum;
		int columnPos = position % columnNum;
		if (cubes[rowPos][columnPos].isOpened())
		{
			// 如果格子被打开，则不可再点击
			convertView.setEnabled(false);
			((CheckBox) convertView).setOnCheckedChangeListener(null);
			// 显示选中状态
			((CheckBox) convertView).setChecked(true);

			if (cubes[rowPos][columnPos].getFlag() != 0)
			{
				// 如果格子周围有地雷或格子本身为地雷，则显示标识
				((CheckBox) convertView).setTextColor(Color.BLACK);
				((CheckBox) convertView).setText(String.format(Locale.CHINA, "%d", cubes[rowPos][columnPos].getFlag()));
			}
		}
		else
		{
			((CheckBox) convertView).setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener()
			{
				@Override
				public void onCheckedChanged(CompoundButton buttonView, boolean isChecked)
				{
					if (isChecked)
					{
						// TODO 点击格子
					}
				}
			});
		}
		return convertView;
	}
}
