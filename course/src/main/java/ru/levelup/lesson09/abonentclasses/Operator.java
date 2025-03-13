package ru.levelup.lesson09.abonentclasses;

public enum Operator {
    MTS("+792241", "+792242", "+792243", "+792244")
    , MEGAFON("+790122", "+790123", "+790124", "+790125")
    , TELE2("+796301", "+796304", "+796305", "+796306")
    , BEELINE("+791196", "+791197", "+791198", "+791199");

    private String[] prefixs;

    Operator(String... prefixs) {
        this.prefixs = prefixs;
    }

    public String[] getPrefixs() {
        return prefixs;
    }

    @Override
    public String toString() {
        return switch (this) {
            case MTS -> "МТС";
            case MEGAFON -> "Мегафон";
            case TELE2 -> "Теле2";
            case BEELINE -> "Билайн";
            default -> null;
        };
    }
}