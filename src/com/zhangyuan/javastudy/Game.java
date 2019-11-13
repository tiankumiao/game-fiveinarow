package com.zhangyuan.javastudy;

import com.zhangyuan.util.ConsoleUtil;

/**
 *  游戏控制类
 * @author 300S
 *
 */
public class Game {
	//创建需要的类的对象    棋盘对象 好比一个特殊变量 int n;
	private final ChessBoard board;
	//执黑子的棋手  多态 抽象类 未实例化对象
	private AbstractPlayer playerBlack;
	//执白子的棋手 
	private AbstractPlayer PlayerWhite;
	/**
	 * 构造器  给棋盘边长值
	 */
	public  Game() {
		this.board=new ChessBoard(15);
	}
	
	public AbstractPlayer getPlayerBlack() {
		return playerBlack;
	}
	//设置抽象类对象 用抽象类 子类实例化对象 多态
	public void setPlayerBlack(AbstractPlayer playerBlack) {
		//执黑子棋手为黑色方  默认颜色
		playerBlack.setColor(1);
		this.playerBlack = playerBlack;
	}

	public AbstractPlayer getPlayerWhite() {
		return PlayerWhite;
	}

	public void setPlayerWhite(AbstractPlayer playerWhite) {
		//执白子棋手为白色方  默认颜色
		playerWhite.setColor(2);
		PlayerWhite = playerWhite;
	}

	public ChessBoard getBoard() {
		return board;
	}

	//开始游戏
	public void start() {
		//游戏说明
		welcome();
		//绘制棋盘
		this.board.paint();
		//检查棋手是否准备就绪
		if(this.getPlayerBlack()==null||this.PlayerWhite==null) {
			System.out.println("棋手还未准备就绪,无法开始");
			return;
		}
		System.out.println("棋盘已就绪。。");
		System.out.println("棋手已就绪。。。");
		System.out.println("游戏开始!");
		Boolean isContinue=true;
		while(isContinue) {
			//黑方下子  并绘制棋盘
			ChessPieces cpBlack=this.playerBlack.move(this.board);
			this.board.paint();
			//棋盘是否已满 平局
			if(this.board.isFull()) {
				System.out.println("平局！");
				break;
			}
			//黑方是否胜利   winner is black
			if(isWin(cpBlack)) {
				System.out.println("黑子胜利！");
				break;
			}
			//白方下子  并绘制棋盘
			ChessPieces cpWhite=this.PlayerWhite.move(this.board);
			this.board.paint();
			//棋盘是否已满 平局
			if(this.board.isFull()) {
				System.out.println("平局！");
				break;
			}	
			//白方是否胜利   winner is white
			if(isWin(cpWhite)) {
				System.out.println("白子胜利！");
				break;
			}
		}
		//是否继续
		if(ConsoleUtil.readBoolean("是否继续:（默认）y是，其他否>", true)) {
			//初始化棋盘
			this.board.init();
			//初始化棋子数
			this.board.setPiecesCount(0);
			//递归 重新开始
			this.start();
		}
		//游戏结束 提示语
		end();
	}
	//游戏开始提示语
	public void welcome() {
		System.out.println("欢迎游戏 !");
		System.out.println("--------------------");
	}
	/**
	 * 传入棋子调用棋盘方法判断胜负
	 * @param cp
	 * @return
	 */
	public boolean isWin(ChessPieces cp) {
		return this.board.isWin(cp);
	}
	//游戏结束提示语
	public void end() {
		System.out.println("再见 !");
		System.out.println("--------------------");
	}
	
}
