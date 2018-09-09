package ua.com.reveta.objects;


/**
 * Об'єкт який існує на клітинці таблиці
 * */
public final class Figura {

    private  Figura.Status status;

    public enum Status{EMPTY, X, O}

    public Figura(Status status) {
        this.status = status;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    /** Приймаючи статус метод повертає
     *  його Graficx копію у StringBuilding об'єкті
     * @param status приймає enum Figura.Status
     * @return StringBuilder з графічним відображенням фігури(по статусу)*/
    public static StringBuilder getGraficxSym(Figura.Status status){
        switch (status){

            case EMPTY:
                return Graficx.emptySquad();
            case X:
                return Graficx.xSquad();
            case O:
                return Graficx.oSquad();
        }

        return null;
    }

    /** @return пусту клітинку для створення статової карти*/
    static Figura getDefaultValue(){
        return new Figura(Status.EMPTY);
    }
}
