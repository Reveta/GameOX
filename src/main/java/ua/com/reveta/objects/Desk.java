package ua.com.reveta.objects;

import java.util.ArrayList;
import java.util.List;

import static ua.com.reveta.objects.Figura.getGraficxSym;

/**
 * Об'єкт для зберігання та відображення ігрової дошки
 * <p>
 * Має параметри:
 * List<Figura> desk - для зберігання всіх 9 квадратиків на дошці
 * StringBuilder builder - для заповнення, а потім відтворення в консолі
 * <p>
 *
 * @param {deskToConsole} виводить гру в консоль - головний спосіб її відображати
 *                        використовуються шаблони рядків ігрового поля(3 рядки)
 *                        вони заповнюється об'єктами StringBuilder з копією Graficx елмементами.
 */
public final class Desk {

    private List<Figura> desk;
    private StringBuilder builder;

    public Desk() {
        this.builder = new StringBuilder();
        this.desk = new ArrayList<Figura>();
        setDefaultValue();
    }


    /**
     * метод являється шаблоном для одного рядочку ігрового поля
     * Вхідні значення розміщуються у шаблоні рядочка
     * і виводиться у консоль
     */
    private void showLine(final Figura.Status... figuras) {

        builder.append(getGraficxSym(figuras[0]));
        builder.append(Graficx.verticalSym());
        builder.append(getGraficxSym(figuras[1]));
        builder.append(Graficx.verticalSym());
        builder.append(getGraficxSym(figuras[2]));
        builder.append("\n");

        System.out.println(builder);
        builder.setLength(0);
    }


    /**
     * метод для виводу гри в консоль
     * він перебирає всі фігури з desk і передає методу showLine
     * кожен з яких являється одним ігровим рядочком з трьох
     */
    public void deskToConsole() {
        showLine(getFiguraSt(0), getFiguraSt(1), getFiguraSt(2));
        showLine(getFiguraSt(3), getFiguraSt(4), getFiguraSt(5));
        showLine(getFiguraSt(6), getFiguraSt(7), getFiguraSt(8));
    }


    /**
     * метод вертає статус фігури
     * назва скорочена для читабельності
     * використовується в deskToConsole() для заповенння
     * шаблонів рядків, зручно і читабельно повертає status об'єкта
     */
    private Figura.Status getFiguraSt(int index) {
        return desk.get(index).getStatus();
    }


    /**
     * При створенні Desk, "створює" 9 клітинок і заповнює
     * об'єктами Figura з статусом EMPTY
     */
    private void setDefaultValue() {
        int numberOfSquad = 9;
        for (int i = 0; i < numberOfSquad; i++) {
            desk.add(Figura.getDefaultValue());
        }
    }


    /**
     * метод для заповнення клтинки на дошці
     */
    public boolean setFiguraToDesk(int index, Figura.Status status) {
        boolean isEmpty = desk.get(index).getStatus() == Figura.Status.EMPTY;
        if (isEmpty) {
            desk.get(index).setStatus(status);
            return true;
        } else {
            return false;
        }
    }

    /**
     * перевірити чи гра не завершилась
     */
    public boolean checkGameStatus() {

        return true;
    }
}
