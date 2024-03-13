package za.co.za.nharire.divisi.enums;

public enum UnitOfMeasure {
    PIECE("Piece"),
    KILOGRAM("Kilogram"),
    GRAM("Gram"),
    LITER("Liter"),
    MILLILITER("Milliliter"),
    METER("Meter"),
    CENTIMETER("Centimeter"),
    SQUARE_METER("Square Meter"),
    CUBIC_METER("Cubic Meter"),
    CHICK("Chick"),
    DOZEN("Dozen");

    private final String displayName;

    UnitOfMeasure(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
