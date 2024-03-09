package progressive

interface Denomination {
    val value: Int
}

enum class DenominationType {
    COIN,
    NOTE
}

enum class Dollar(override val value: Int, val type: DenominationType): Denomination {
    ONE_HUNDRED_DOLLAR_NOTE(100000, DenominationType.NOTE),
    FIFTY_DOLLAR_NOTE(50000, DenominationType.NOTE),
    TWENTY_DOLLAR_NOTE(20000, DenominationType.NOTE),
    TEN_DOLLAR_NOTE(10000, DenominationType.NOTE),
    FIVE_DOLLAR_NOTE(500, DenominationType.NOTE),
    ONE_DOLLAR_NOTE(100, DenominationType.NOTE),
    QUARTER_COIN(25, DenominationType.COIN),
    DIME_COIN(10, DenominationType.COIN),
    PENNY_COIN(1, DenominationType.COIN);
}

enum class Euro(override val value: Int, type: DenominationType): Denomination {
    ONE_HUNDRED_EURO_NOTE(10000, DenominationType.NOTE),
    FIFTY_EURO_NOTE(5000, DenominationType.NOTE),
    TWENTY_EURO_NOTE(2000, DenominationType.NOTE),
    TEN_EURO_NOTE(1000, DenominationType.NOTE),
    FIVE_EURO_NOTE(500, DenominationType.NOTE),
    TWO_EURO_COIN(200, DenominationType.COIN),
    ONE_EURO_COIN(100, DenominationType.COIN),
    FIFTY_CENT_COIN(50, DenominationType.COIN),
    TWENTY_CENT_COIN(20, DenominationType.COIN),
    TEN_CENT_COIN(10, DenominationType.COIN),
    FIVE_CENT_COIN(5, DenominationType.COIN),
    TWO_CENT_COIN(2, DenominationType.COIN),
    ONE_CENT_COIN(1, DenominationType.COIN);
}
