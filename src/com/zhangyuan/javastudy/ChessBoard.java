package com.zhangyuan.javastudy;
/**
 *  棋盘
 * @author 300S
 *
 */
public class ChessBoard {
	//边长
	private final int wide;
	//棋盘上所有的点
	private final ChessPoint[][] points;
	//获得棋盘上棋子的数量即棋盘点points！=null 用于判断棋盘是否满了
	private int piecesCount=0;
	//棋盘最大棋子数
	private final int MAX_PIECES_COUNT;
	public ChessBoard(int wide) {
		 this.wide=wide;
		 this.MAX_PIECES_COUNT=this.wide*this.wide;
		 this.points=new ChessPoint[this.wide][this.wide];
		 this.init();
	}
	public int getPiecesCount() {
		return piecesCount;
	}
	public void setPiecesCount(int piecesCount) {
		this.piecesCount = piecesCount;
	}
	public int getWide() {
		return wide;
	}
	public ChessPoint[][] getPoints() {
		return points;
	}
	public int getMAX_PIECES_COUNT() {
		return MAX_PIECES_COUNT;
	}
	//初始化 棋盘
	public void init() {
		ChessPoint[][] cp=this.points;
		for (int x=0;x<this.wide;x++) {
			for(int y=0;y<this.wide;y++) {
				cp[x][y]=new ChessPoint(x,y);
			}
		}
	}
	//绘制棋盘
	public void paint() {
		//点数组记录 棋盘上所有的点
		ChessPoint[][] point=this.points;
		//循环历遍所有点
		for (int x=0;x<this.wide;x++) {
			for(int y=0;y<this.wide;y++) {
				//某一点 
				ChessPoint p=point[x][y];
				//绘制该点
				p.paint();
			}
			//换行
			System.out.println();
		}
	}
	//返回（x，y）坐标是否有棋子  输入x，y 一个棋盘上的点是否为null
	public boolean isExistAt(int x,int y) {
		ChessPoint point=this.points[x][y];
		return point.getCp()!=null;
	}
	//生成一枚棋子再把棋子放置
	public ChessPieces setChessPiecesAt(int x,int y,int color) {
		piecesCount++;
		ChessPieces cp=new ChessPieces(x,y,color);
		// 在指定点放置棋子
		this.points[x][y].setCp(cp);
		return cp;
	}
	
	
	//判断棋盘是否已满
	public boolean isFull() {
		return this.piecesCount==this.MAX_PIECES_COUNT;
	}
	//指定棋手 是否五子连珠 胜利
	public boolean isWin(ChessPieces cp) {
		//获得棋子 坐标 颜色
		int x=cp.getX();
		int y=cp.getY();
		int color=cp.getColor();
		
		int num=0;
		//调用棋盘方法判断是否同色 相连且同色num++
		this.isExistSamePiecesAt(x, y, color);
		//横 方向 相连同色棋子数
		num=this.acrossSamePiecesCount(x, y, color);
		if(num>4) {
			return true;
		}//垂直方向
		num=this.uprightSamePiecesCount(x, y, color);
		if(num>4) {
			return true;
		}
		//右斜方向
		num=this.rightSlopeSamePiecesCount(x, y, color);
		if(num>4) {
			return true;
		}
		//左斜方向
		num=this.leftSlopeSamePiecesCount(x, y, color);
		if(num>4) {
			return true;
		}
		return false;
	}
	/**
	 * 横方向相连同色棋子数
	 * @param x
	 * @param y
	 * @param color
	 * @return
	 */
	public int acrossSamePiecesCount(int x,int y,int color) {
		int count=0;
		//横 方向是否有五子 x不变 y-5<y<y+5变
		for(int i=1;i<5;i++) {
			//右边 计算同色count++ 到 不同色为止 
			if(this.isExistSamePiecesAt(x, y+i, color)) {
				count+=1;
			}else{
				break;
			}
		}
		for(int i=0;i<5;i++) {
			//左边 计算同色count++ 到 不同色为止 
			if(this.isExistSamePiecesAt(x, y-i, color)){
				count+=1;
			}else {
				break;
			}
		}
		return count;
	}
	/**
	 * 垂直方向 相连同色棋子数
	 * @param x
	 * @param y
	 * @param color
	 * @return
	 */
	public int uprightSamePiecesCount(int x,int y,int color) {
		int count=0;
		for(int i=1;i<5;i++) {
			if(this.isExistSamePiecesAt(x+i, y, color)) {
				count+=1;
			}else{
				break;
			}
		}
		for(int i=0;i<5;i++) {
			if(this.isExistSamePiecesAt(x-i, y, color)){
				count+=1;
			}else {
				break;
			}
		}
		return count;
	}
	/**
	 * 斜方向  如 3,3 4,4 5,5     
	 * @param x
	 * @param y
	 * @param color
	 * @return
	 */
	public int  rightSlopeSamePiecesCount(int x,int y,int color) {
		int count=0;
		for(int i=1;i<5;i++) {
			if(this.isExistSamePiecesAt(x+i, y+i, color)) {
				count+=1;
			}else{
				break;
			}
		}
		for(int i=0;i<5;i++) {
			if(this.isExistSamePiecesAt(x-i, y-i, color)){
				count+=1;
			}else {
				break;
			}
		}
		return count;
	}
	/**
	 * 斜方向  如 3,5  4,4  5,3   
	 * @param x
	 * @param y
	 * @param color
	 * @return
	 */
	public int leftSlopeSamePiecesCount(int x,int y,int color) {
		int count=0;
		for(int i=1;i<5;i++) {
			if(this.isExistSamePiecesAt(x-i, y+i, color)) {
				count+=1;
			}else{
				break;
			}
		}
		for(int i=0;i<5;i++) {
			if(this.isExistSamePiecesAt(x+i, y-i, color)){
				count+=1;
			}else {
				break;
			}
		}
		return count;
	}
	/**
	 * 判断棋盘上的点是否有对应颜色的棋子 
	 *且 判断五子相连时还要限制棋盘范围 阻止坐标越界
	 * @param x
	 * @param y
	 * @param color
	 * @return
	 */
	public boolean isExistSamePiecesAt(int x,int y,int color) {
		if(x<0||x>=this.wide) {
			return false;
		}
		if(y<0||y>=this.wide) {
			return false;
		}
		
		//获得对应点
		ChessPoint point=this.points[x][y];
		//调用点方法 比较点上棋子颜色
		return point.hasColor(color);
	}
}
