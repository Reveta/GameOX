package ua.com.reveta.objects;

public abstract class Graficx {

    private static StringBuilder stringBuilder = new StringBuilder();

    public static StringBuilder emptySquad(){
        cleanBuilder();
        stringBuilder.append("   ");

        return stringBuilder;
    }

    public static StringBuilder xSquad(){
        cleanBuilder();
        stringBuilder.append(" X ");

        return stringBuilder;
    }

    public static StringBuilder oSquad(){
        cleanBuilder();
        stringBuilder.append(" O ");

        return stringBuilder;
    }

    public static StringBuilder verticalSym(){
        cleanBuilder();
        stringBuilder.append(" | ");

        return stringBuilder;
    }

    public static StringBuilder gorizontalSym(){
        cleanBuilder();
        stringBuilder.append("---");

        return stringBuilder;
    }

    private static void cleanBuilder(){
        stringBuilder.setLength(0);
    }
}
