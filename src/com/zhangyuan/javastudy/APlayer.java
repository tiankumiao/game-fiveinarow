package com.zhangyuan.javastudy;

import com.zhangyuan.util.ConsoleUtil;

/**
 *  一个人类棋手
 * @author 300S
 *
 */
public class APlayer extends AbstractPlayer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public APlayer(int color) {
		this.setColor(color);
	}
	public ChessPieces move(ChessBoard board) {
		//获取棋手的下棋坐标 
		int x=getX(board.getWide());
		int y=getY(board.getWide());
		//判断该坐标是否已有棋子（棋盘判断）  有则递归 重新随机
		if(board.isExistAt(x, y)) {
			System.out.println("该位置有子，请重新输入");
			return move(board);
		}
		//改变棋盘上内部数组
		return board.setChessPiecesAt(x, y, this.getColor());
	}
	
	
	//获取x  不能越界 x应从1开始
	private int getX(int max) {
		int x;
		while(true) {
			x=ConsoleUtil.readInt(super.blackAndWhite()+"请输入x坐标(1-"+max+"):>");
			if(x>max||x<1) {
				System.out.println("输入x坐标超出棋盘范围，请重新输入！");
			}else {
				break;
			}
		}
		return x-1;
	}
	//获取y
	private int getY(int may) {
		int y;
		while(true) {
			y=ConsoleUtil.readInt(super.blackAndWhite()+"请输入x坐标(1-"+may+"):>");
			if(y>may||y<1) {
				System.out.println("输入x坐标超出棋盘范围，请重新输入！");
			}else {
				break;
			}
		}
		return y-1;
	}
}
