package com.zhangyuan.javastudy;
/**
 *  电脑棋手
 * @author 300S
 *
 */
public class AIPlayer extends AbstractPlayer{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public AIPlayer(int color) {
		this.setColor(color);
	}
	
	//获取电脑棋手的下棋坐标  随机
	public ChessPieces move(ChessBoard board) {
		int x=(int)(Math.random()*board.getWide());
		int y=(int)(Math.random()*board.getWide());
		//判断该坐标是否已有棋子（棋盘判断）  有则递归 重新随机
		if(board.isExistAt(x, y)) {
			return move(board);
		}
		System.out.println(super.blackAndWhite()+"落子完成");
		//改变棋盘上内部数组
		return  board.setChessPiecesAt(x, y, this.getColor());
	}
	
}
