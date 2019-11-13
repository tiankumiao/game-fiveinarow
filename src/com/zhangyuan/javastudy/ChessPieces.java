package com.zhangyuan.javastudy;
/**
 *  棋子
 * @author 300S
 *
 */
public class ChessPieces {
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getColor() {
		return color;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	//棋子属性   颜色 1黑色 2白色
	private final int color;
	private int x,y;
	//构造器 
	public ChessPieces(int x,int y,int color) {
		this.x=x;
		this.y=y;
		this.color=color;
	}
	//判断同色
	public boolean sameColor(int color) {
		return this.color==color;
	}
	//方法  画出自身  color 1黑棋 ⚫● 2白棋😡⚪○
	public void paint() {
		if(this.color==1) {
			System.out.print("●");
		}else if(this.color==2){
			System.out.print("○");
		}
	}
		
}
