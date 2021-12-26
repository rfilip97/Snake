package SnakeSRC;

import SnakeSRC.Logger.LogLevels;

public class Main {

	public static void main(String[] args) {
		Logger logger = Logger.getInstance();
		logger.setLogLevel(GameConfig.LOG_LEVEL);
		logger.log(LogLevels.INFO, "START");

		Game game = new Game();
		game.Run();
	}
}
