

// Задача 1: вычислить знакочередующуюся сумму ряда
fun alternatingSum() {
    println("Введите число n, потом n чисел(каждое на новой строке)")
    val n = readln().toInt()
    if (n <= 0) {
        println("Неверный ввод: n должно быть больше 0")
        return
    }

    var sum = 0
    var sign = 1
    for (i in 1..n) {
        val x = readln().toInt()
        sum += sign * x
        sign *= -1
    }
    println(sum)
}

// Задача 2: найти максимальную высоту грузовика
fun maxTruckHeight() {
    println("Введите количество дорог. Затем для каждой дороги вводится (на отдельных строках) количество туннелей и высота каждого туннеля.")
    val n = readln().toInt()
    val heights = mutableListOf<Int>()
    for (i in 1..n) {
        val k = readln().toInt()
        var min = Int.MAX_VALUE
        for (j in 1..k) {
            val h = readln().toInt()
            if (h < min) {
                min = h
            }
        }
        heights.add(min)
    }

    var maxRoad = 0
    var max = 0
    for (i in 0 until n) {
        if (heights[i] > max) {
            max = heights[i]
            maxRoad = i + 1
        }
    }
    println("$maxRoad $max")

}

// Задача 3: дважды четное число
fun doubleEven() {
    println("Введите целое трехзначное число")
    val n = readln().toInt()
    if (n < 100 || n > 999) {
        println("Неверный ввод")
        return
    }

    val a = n / 100
    val b = (n / 10) % 10
    val c = n % 10
    val sum = a + b + c
    val product = a * b * c

    if (sum % 2 == 0 && product % 2 == 0) {
        println("Дважды четное")
    }
    else println("Не является дважды четным")

}

// Задача 4: наибольшая подстрока, в которой все символы уникальны
fun uniqueSubstring() {
    println("Введите строку:")
    val s = readln().toString()
    var current = ""
    var longest = ""
    val set = mutableSetOf<Char>()
    for (c in s) {
        if (c in set) {
            val index = current.indexOf(c)
            current = current.substring(index + 1)
            set.removeIf { it < c }
        }

        current += c
        set.add(c)
        if (current.length > longest.length) {
            longest = current
        }

    }
    println(longest)

}

// Задача 5: максимальный элемент в каждой строке двумерного массива
fun maxRowElements() {
    println("Введите размер массива (по строкам и столбцам) на разных строках")
    val m = readln().toInt()
    val n = readln().toInt()
    val matrix = Array(m) { Array(n) { 0 } }
    for (i in 0 until m) {
        for (j in 0 until n) {
            matrix[i][j] = (0..99).random()
        }
    }

    for (row in matrix) {
        println(row.joinToString(" "))
    }

    val maxElements = mutableListOf<Int>()
    for (row in matrix) {
        var max = Int.MIN_VALUE
        for (element in row) {
            if (element > max) {
                max = element
            }
        }
        maxElements.add(max)
    }
    println(maxElements)

}


fun main() {
    alternatingSum()
    maxTruckHeight()
    doubleEven()
    uniqueSubstring()
    maxRowElements()
}
