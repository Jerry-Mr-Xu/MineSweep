package com.example.jerry.minesweep.bean;

import com.litesuits.orm.db.annotation.Column;
import com.litesuits.orm.db.annotation.PrimaryKey;
import com.litesuits.orm.db.annotation.Table;
import com.litesuits.orm.db.enums.AssignType;

import java.io.Serializable;
import java.util.Arrays;

/**
 * 棋盘数据
 * <p>
 * Created by Jerry on 2017/2/15.
 */
@Table("Board")
public class BoardBean implements Serializable
{
	@PrimaryKey(AssignType.AUTO_INCREMENT)
	private int boardId;

	@Column("row")
	private int rowNum;
	@Column("column")
	private int columnNum;
	@Column("mine")
	private int mineNum;

	@Column("cubes")
	private CubeBean[][] cubeBeans;

	public BoardBean(int rowNum, int columnNum, int mineNum, CubeBean[][] cubeBeans)
	{
		this.rowNum = rowNum;
		this.columnNum = columnNum;
		this.mineNum = mineNum;
		this.cubeBeans = cubeBeans;
	}

	public int getRowNum()
	{
		return rowNum;
	}

	public void setRowNum(int rowNum)
	{
		this.rowNum = rowNum;
	}

	public int getColumnNum()
	{
		return columnNum;
	}

	public void setColumnNum(int columnNum)
	{
		this.columnNum = columnNum;
	}

	public int getMineNum()
	{
		return mineNum;
	}

	public void setMineNum(int mineNum)
	{
		this.mineNum = mineNum;
	}

	public CubeBean[][] getCubeBeans()
	{
		return cubeBeans;
	}

	public void setCubeBeans(CubeBean[][] cubeBeans)
	{
		this.cubeBeans = cubeBeans;
	}

	@Override
	public String toString()
	{
		return "BoardBean{" +
				"boardId=" + boardId +
				", rowNum=" + rowNum +
				", columnNum=" + columnNum +
				", mineNum=" + mineNum +
				", cubeBeans=" + Arrays.toString(cubeBeans) +
				'}';
	}
}
