import java.util.Scanner

open class Menu<T : Creatable> (
        var what: String,
        var ofWhat: String,
        var options: MutableList<T>
){
    init {
        showMenu()
    }

    fun showMenu(){
        println("Список ${ofWhat}:")
        println("0. Создать $what")
        for (i in 1..options.size) {
            println("${i}. ${options[i-1].name}")
        }
        println("${options.size+1}. Выход")
    }


    fun input(create: () -> T, goInside: (num: Int) -> Unit) {
        println("Введите число.")
        var newInput: Int? = Scanner(System.`in`).nextLine().toIntOrNull()
        while (true) {
            when (newInput) {
                options.size+1 -> break
                0 -> options.add(create())
                in (1..options.size) -> goInside(newInput!!-1)
                null -> println("Вы ввели не число. Повторите ввод, пожалуйста.")
                else -> println("Такого элемента нет на экране. Введите другое число, пожалуйста.")
            }
            showMenu()
            newInput = Scanner(System.`in`).nextLine().toIntOrNull()
        }
    }
}