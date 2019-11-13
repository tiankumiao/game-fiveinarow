package com.zhangyuan.javastudy;
/**
 *  棋盘上的点
 * @author 300S
 *
 */
public class ChessPoint {
	//坐标
	private int x,y;
	//点上的棋子
	private ChessPieces cp;
	//构造器
	public ChessPoint(int x,int y) {
		this.x=x;
		this.y=y;
	}

	public ChessPieces getCp() {
		return cp;
	}
	public void setCp(ChessPieces cp) {
		this.cp = cp;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	//返回点上是否有指定颜色的棋子
	public Boolean hasColor(int color) {
		//没有棋子 false
		if(this.cp==null) {
			
			return false;
			
		}
		//调用棋子cp的方法判断是否颜色相等
		return this.cp.sameColor(color);
	}
	//没棋子画出点➕，有棋子调用棋子类 画棋子
	public void paint() {
		if(this.cp==null) {
			System.out.print("╋");
		}else {
			this.cp.paint();
		}
	}
}
