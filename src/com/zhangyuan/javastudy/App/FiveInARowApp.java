package com.zhangyuan.javastudy.App;

import com.zhangyuan.javastudy.AIPlayer;
import com.zhangyuan.javastudy.APlayer;
import com.zhangyuan.javastudy.Game;

/**
 * 入口
 * @author 300S
 *
 */
public class FiveInARowApp {
	public static void main(String[] args) {
		Game game=new Game();
		//设置棋手  黑棋先
		game.setPlayerBlack(new APlayer(1));
		game.setPlayerWhite(new AIPlayer(2));
		
		game.start();
	}

}
