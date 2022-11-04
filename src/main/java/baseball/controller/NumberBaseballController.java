package baseball.controller;

import baseball.controller.dto.UserInputPlayNumbers;
import baseball.model.gameresult.GameResult;
import baseball.model.numberbaseball.NumberBaseball;
import baseball.model.numberbaseball.application.NumberBaseballService;
import baseball.view.NumberBaseballView;

public class NumberBaseballController {
	private final NumberBaseballView numberBaseballView = new NumberBaseballView();
	private final NumberBaseballService numberBaseballService = new NumberBaseballService();

	public void initGame() {
		numberBaseballView.initPage();
	}

	public void playBall() {
		NumberBaseball computerNumber = getComputerNumberBaseball();

		GameResult gameResult;
		do {
			NumberBaseball userNumber = getUserInputPlayNumbers();
			gameResult = numberBaseballService.compareNumberBaseBall(computerNumber, userNumber);
			numberBaseballView.resultPage(gameResult);
		} while (!gameResult.isEndCondition());
	}

	private NumberBaseball getComputerNumberBaseball() {
		return numberBaseballService.createNumberBaseball();
	}

	private NumberBaseball getUserInputPlayNumbers() {
		UserInputPlayNumbers userInputPlayNumbers = numberBaseballView.playPage();
		return userInputPlayNumbers.toNumberBaseball();
	}
}
