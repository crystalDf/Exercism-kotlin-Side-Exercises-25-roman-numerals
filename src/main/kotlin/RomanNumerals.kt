object RomanNumerals {

    private val slices = "IVXLCDM".windowed(3, 2, true)

    fun value(n: Int): String {

        return n.toString()
                .reversed()
                .mapIndexed{ index, char -> basicConversion(slices[index], char) }
                .reversed()
                .joinToString("")
    }

    private fun basicConversion(slice: String, char: Char): String {

        return when (val digit = "$char".toInt()) {
            1, 2, 3 -> "${slice[0]}".repeat(digit)
            4 -> "${slice[0]}${slice[1]}"
            5 -> "${slice[1]}"
            6, 7, 8 -> "${slice[1]}${"${slice[0]}".repeat(digit - 5)}"
            9 -> "${slice[0]}${slice[2]}"
            else -> ""
        }
    }
}
