package ua.com.reveta;

import ua.com.reveta.objects.Desk;
import ua.com.reveta.objects.Figura;

/**
 * Клас - рушій гри
 * <p>
 * Players player - змінна де зберігається гравець
 * Desk desk - об'єкт @see Desk
 * <p>
 *
 * @param {startGame} - while true гри
 * @param {nextStep}  - алгоритим для кожного кроку гри
 */
public final class Game {

    private static Utils utils;

    private Players player;
    private Desk desk;
    private boolean gameStatus = true;

    enum Players {player_1, player_2}


    public Game() {
        utils = new Utils();
        desk = new Desk();
        this.player = Players.player_1;
    }


    public void startGame() {

        while (gameStatus) {
            desk.deskToConsole();
            nextStep();
        }
    }


    private void nextStep() {

        String choiceFromConsole = getFromConsole();
        try {
            //Якщо всі умови для додавання фігури дотримані - завершити хід
            //Ні - повідомити про не коректні дані та перезапустити хід
            if (checkIf(//Для того, щоб добавити новий фільтр треба добавити повідомлення у мапу Utils.message
                    /**Перевірка чи отримані з консолі дані являються цифрами */
                    isChoiceNumber(choiceFromConsole),

                    /**Перевіряє чи вибір є в межах поля */
                    isChoiceCorrect(choiceFromConsole),

                    /**Міняємо статус фігури якщо вона була Empty*/
                    changeFiguraStatus(choiceFromConsole),

                    /**Перевіряє стан гри, чи ще не кінець */
                    desk.checkGameStatus())) {
                changePlayers();
            } else {
                //Перезапустити хід
                nextStep();
            }
        } catch (NumberFormatException e) {
        }

    }


    private boolean checkIf(boolean... filters) {
        int i = 0;
        for (boolean filter : filters) {
            if (!filter) {
                System.out.println(utils.getMessages().get(i++));
                return false;
            } else {
                i++;
            }
        }
        return true;
    }


    private String getFromConsole() {
        System.out.println("Гравець: " + player + " введіть клітинку: ");
        return utils.getScanner().next();
    }

    /**
     * Перевірка чи отримані з консолі дані являються цифрами
     */
    private boolean isChoiceNumber(String choiceFromConsoleString) {
        try {
            Integer.valueOf(choiceFromConsoleString);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    /**
     * Перевіряє чи вибір є в межах поля
     */
    private boolean isChoiceCorrect(String choiceFromConsoleString) throws NumberFormatException {
        final int firstDesk = 0;
        final int lastDesk = 8;

        int choiceFromConsole = Integer.valueOf(choiceFromConsoleString) - 1;

        if (choiceFromConsole >= firstDesk && choiceFromConsole <= lastDesk) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Перевіряємо і міняємо статус фігури якщо вона ще пуста
     */
    private boolean changeFiguraStatus(String choiceFromConsoleString) throws NumberFormatException {
        int choiceFromConsole = Integer.valueOf(choiceFromConsoleString) - 1;
        return desk.setFiguraToDesk(
                choiceFromConsole,
                (player == Players.player_1) ? Figura.Status.X : Figura.Status.O);
    }


    private void changePlayers() {
        player = (player != Players.player_1) ? Players.player_1 : Players.player_2;
    }
}
