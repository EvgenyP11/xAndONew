fun userInput(list: MutableList<MutableList<String>>): MutableList<MutableList<String>> {
    println("Player X can make a move. Enter the coordinates of your field,")
    println("in the format (Y X). X and Y must be integers 1 .. 3.")
//    var counter = 0

//    val inputString = readLine()!!.toCharArray()
//    val charX = inputString.filter { it == 'X' }
//    val charO = inputString.filter { it == 'O' }

//    for (i in 0 until list.size) {
//        for (j in 0 until list.size) {
//            list[i][j] = inputString[counter].toString()
//            counter++
//        }
//    }
//    showGrid(list)
//
//    if (charX.size - charO.size > 1 || charO.size - charX.size > 1) println("Impossible")
//    else {
//        //xWins(list)
//    }
    return list

}
fun showGrid(list: MutableList<MutableList<String>>): MutableList<MutableList<String>> {
    println()
    println("---------")

    for (i in 0 until list.size) {
        print("| ")
        for (j in 0 until list.size) {
            print("${list[i][j]} ")
        }
        print("|")
        println()
    }
    println("---------")
    return list
}
fun playerTurnX(listOf: MutableList<MutableList<String>>): MutableList<MutableList<String>> {
    do {
        print(">")
        val input = readln()//с этим нужно, что-то делать, как то защитится от ввода строки
        val inputTurn = input.split(" ").map { it.toInt() }
        val y = inputTurn[0]
        val x = inputTurn[1]
        var result = when {
            y !in 1..3 || x !in 1..3 -> "Coordinates should be from 1 to 3!"
            listOf[y - 1][x - 1] != "_" -> "This cell is occupied! Choose another one!"
            else -> {""}
        }
        if (result == "") {
            listOf[y - 1][x - 1] = "X"
        } else println(result)
    } while (result != "")
    showGrid(listOf)
    return listOf
}
fun playerTurnO(listOf: MutableList<MutableList<String>>): MutableList<MutableList<String>> {
    do {
        print(">")
        val input = readln()//с этим нужно, что-то делать, как то защитится от ввода строки
        val inputTurn = input.split(" ").map { it.toInt() }
        val y = inputTurn[0]
        val x = inputTurn[1]
        var result = when {
            y !in 1..3 || x !in 1..3 -> "Coordinates should be from 1 to 3!"
            listOf[y - 1][x - 1] != "_" -> "This cell is occupied! Choose another one!"
            else -> {""}
        }
        if (result == "") {
            listOf[y - 1][x - 1] = "O"
        } else println(result)
    } while (result != "")
    showGrid(listOf)
    return listOf
}
fun gameWins(list: MutableList<MutableList<String>>) {
    //создать выигрышные шаблоны
    val winX = "X wins"
    val winO = "O wins"
    var resultX = ""
    var resultO = ""
    var count = 0

    /**
     * Проверка X
     */
    //1строка
    val firstString = mutableListOf(
        mutableListOf("X","X","X"),
        mutableListOf("_","_","_"),
        mutableListOf("_","_","_")
    )
    for (i in 0 until list.size) {
        if (firstString[0][i] == list[0][i]) count ++
    }
    if (count == 3) resultX = winX//println(win)
    //2строка
    count = 0
    val secondString = mutableListOf(
        mutableListOf("_","_","_"),
        mutableListOf("X","X","X"),
        mutableListOf("_","_","_")
    )
    for (i in 0 until list.size) {
        if (secondString[1][i] == list[1][i]) count ++
    }
    if (count == 3) resultX = winX//println(win)
    //3строка
    count = 0
    val thirdString = mutableListOf(
        mutableListOf("_","_","_"),
        mutableListOf("_","_","_"),
        mutableListOf("X","X","X")
    )
    for (i in 0 until list.size) {
        if (thirdString[2][i] == list[2][i]) count ++
    }
    if (count == 3) resultX = winX//println(win)
    //1столбец
    count = 0
    val firstColumn = mutableListOf(
        mutableListOf("X","_","_"),
        mutableListOf("X","_","_"),
        mutableListOf("X","_","_")
    )
    for (i in 0 until list.size) {
        if (firstColumn[i][0] == list[i][0]) count ++
    }
    if (count == 3) resultX = winX//println(win)
    //2столбец
    count = 0
    val secondColumn = mutableListOf(
        mutableListOf("_","X","_"),
        mutableListOf("_","X","_"),
        mutableListOf("_","X","_")
    )
    for (i in 0 until list.size) {
        if (secondColumn[i][1] == list[i][1]) count ++
    }
    if (count == 3) resultX = winX//println(win)
    //3столбец
    count = 0
    val thirdColumn = mutableListOf(
        mutableListOf("_","_","X"),
        mutableListOf("_","_","X"),
        mutableListOf("_","_","X")
    )
    for (i in 0 until list.size) {
        if (thirdColumn[i][2] == list[i][2]) count ++
    }
    if (count == 3) resultX = winX//println(win)
    //диагональ\
    count = 0
    val diagonal1 = mutableListOf(
        mutableListOf("X","_","_"),
        mutableListOf("_","X","_"),
        mutableListOf("_","_","X")
    )
    for (i in 0 until list.size) {
        if (diagonal1[i][i] == list[i][i]) count ++
    }
    if (count == 3) resultX = winX//println(win)
    //диагональ/
    count = 0
    val diagonal2 = mutableListOf(
        mutableListOf("_","_","X"),
        mutableListOf("_","X","_"),
        mutableListOf("X","_","_")
    )
    for (i in list.size - 1 downTo 0) {
        val j = (list.size - 1) - i
        if (diagonal2[j][i] == list[j][i]) count ++
    }
    if (count == 3) resultX = winX//println(win)

    /**
     * Проверка O
     */
    //1строка
    count = 0
    val firstStringO = mutableListOf(
        mutableListOf("O","O","O"),
        mutableListOf("_","_","_"),
        mutableListOf("_","_","_")
    )
    for (i in 0 until list.size) {
        if (firstStringO[0][i] == list[0][i]) count ++
    }
    if (count == 3) resultO = winO//println(win)
    //2строка
    count = 0
    val secondStringO = mutableListOf(
        mutableListOf("_","_","_"),
        mutableListOf("O","O","O"),
        mutableListOf("_","_","_")
    )
    for (i in 0 until list.size) {
        if (secondStringO[1][i] == list[1][i]) count ++
    }
    if (count == 3) resultO = winO//println(win)
    //3строка
    count = 0
    val thirdStringO = mutableListOf(
        mutableListOf("_","_","_"),
        mutableListOf("_","_","_"),
        mutableListOf("O","O","O")
    )
    for (i in 0 until list.size) {
        if (thirdStringO[2][i] == list[2][i]) count ++
    }
    if (count == 3) resultO = winO//println(win)
    //1столбец
    count = 0
    val firstColumnO = mutableListOf(
        mutableListOf("O","_","_"),
        mutableListOf("O","_","_"),
        mutableListOf("O","_","_")
    )
    for (i in 0 until list.size) {
        if (firstColumnO[i][0] == list[i][0]) count ++
    }
    if (count == 3) resultO = winO//println(win)
    //2столбец
    count = 0
    val secondColumnO = mutableListOf(
        mutableListOf("_","O","_"),
        mutableListOf("_","O","_"),
        mutableListOf("_","O","_")
    )
    for (i in 0 until list.size) {
        if (secondColumnO[i][1] == list[i][1]) count ++
    }
    if (count == 3) resultO = winO//println(win)
    //3столбец
    count = 0
    val thirdColumnO = mutableListOf(
        mutableListOf("_","_","O"),
        mutableListOf("_","_","O"),
        mutableListOf("_","_","O")
    )
    for (i in 0 until list.size) {
        if (thirdColumnO[i][2] == list[i][2]) count ++
    }
    if (count == 3) resultO = winO//println(win)
    //диагональ\
    count = 0
    val diagonal1O = mutableListOf(
        mutableListOf("O","_","_"),
        mutableListOf("_","O","_"),
        mutableListOf("_","_","O")
    )
    for (i in 0 until list.size) {
        if (diagonal1O[i][i] == list[i][i]) count ++
    }
    if (count == 3) resultO = winO//println(win)
    //диагональ/
    count = 0
    val diagonal2O = mutableListOf(
        mutableListOf("_","_","O"),
        mutableListOf("_","O","_"),
        mutableListOf("O","_","_")
    )
    for (i in list.size - 1 downTo 0) {
        val j = (list.size - 1) - i
        if (diagonal2O[j][i] == list[j][i]) count ++
    }
    if (count == 3) resultO = winO//println(win)

    /**
     * Проверка на свободные поля
     */
    notFinished(list, resultX, resultO)

}
fun notFinished(list: MutableList<MutableList<String>>,
                resultX: String,
                resultO: String): MutableList<MutableList<String>> {
    var count = 9// количество свободных полей по умолчанию
    val value = "_"// символ для сравнения
    val result = "" + resultX + resultO
    if (result == "X winsO wins") println("Impossible") else {
        if (result == "") {//проверка есть ли победитель
            for (i in 0 until list.size) {//в обоих циклах идет перебор полей и проверка сравнением символов
                for (j in 0 until list.size) {
                    if (value != list[i][j]) count --

                }
            }
            if (count > 0) {
                println("Game not finished")
            } else {
                println("Draw")
            }

        } else {
            println(result)
        }
    }
    return list
}
fun main() {
    val list = mutableListOf(
        mutableListOf("_","_","_"),
        mutableListOf("_","_","_"),
        mutableListOf("_","_","_")
    )

    var listOf = userInput(list)
    listOf = showGrid(listOf)
    listOf = playerTurnX(listOf)
    gameWins(listOf)
    listOf = playerTurnO(listOf)
    gameWins(listOf)
    listOf = playerTurnX(listOf)
    gameWins(listOf)
    listOf = playerTurnO(listOf)
    gameWins(listOf)
    listOf = playerTurnX(listOf)
    gameWins(listOf)
    listOf = playerTurnO(listOf)
    gameWins(listOf)
    listOf = playerTurnX(listOf)
    gameWins(listOf)
    listOf = playerTurnO(listOf)
    gameWins(listOf)
    listOf = playerTurnX(listOf)
    gameWins(listOf)

}

