package com.example.jerry.minesweep.model;

import com.example.jerry.minesweep.bean.BoardBean;

/**
 * 棋盘数据接口
 * <p>
 * Created by Jerry on 2017/2/16.
 */

public interface BoardInterface
{
	boolean saveBoard(BoardBean boardBean);
}
