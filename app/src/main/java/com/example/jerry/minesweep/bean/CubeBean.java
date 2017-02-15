package com.example.jerry.minesweep.bean;

import java.io.Serializable;

/**
 * 格子数据
 * <p>
 * Created by Jerry on 2017/2/15.
 */

public class CubeBean implements Serializable
{
	// 标志(-1代表地雷,0-8代表周围地雷数)
	private int flag;
	// 是否被打开
	private boolean isOpened;

	public CubeBean(int flag)
	{
		this.flag = flag;
		this.isOpened = true;
	}

	public int getFlag()
	{
		return flag;
	}

	public void setFlag(int flag)
	{
		this.flag = flag;
	}

	public boolean isOpened()
	{
		return isOpened;
	}

	public void setOpened(boolean opened)
	{
		isOpened = opened;
	}

	@Override
	public String toString()
	{
		return "CubeBean{" +
				"flag=" + flag +
				", isOpened=" + isOpened +
				'}';
	}
}
