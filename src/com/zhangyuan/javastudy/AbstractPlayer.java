package com.zhangyuan.javastudy;

import java.io.Serializable;

/**
 *  玩家 抽象 父类
 * @author 300S
 *
 */
public abstract class AbstractPlayer implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//棋手执棋的颜色 
	private int color;
	//返回棋手是  黑方 还是  白方
	public String blackAndWhite() {
		if(color==2) {
			return "白子";
		}
		return "黑子";
		//return this.color==1?"黑子":"白子";
	}
	public int getColor() {
		return color;
	} 
	public void setColor(int color) {
		this.color = color;
	}
	//棋手下子 返回放置的棋子 move 需要给棋手一个棋盘
	public abstract ChessPieces move(ChessBoard board);
}
