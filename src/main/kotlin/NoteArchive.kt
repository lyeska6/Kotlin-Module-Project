import java.util.Scanner

class NoteArchive(
        override val name: String
) : Creatable {
    val noteList: MutableList<Note> = mutableListOf()

    fun createNote() : Note{
        println("Введите название заметки")
        var name: String = Scanner(System.`in`).nextLine()
        while (name == "") {
            println("Название не может быть пустым. Повторите ввод.")
            name = Scanner(System.`in`).nextLine()
        }
        println("Введите текст заметки")
        var text: String = Scanner(System.`in`).nextLine()
        while (text=="") {
            println("Название не может быть пустым. Повторите ввод.")
            text = Scanner(System.`in`).nextLine()
        }
        val archive: NoteArchive = NoteArchive("")
        return Note(name, text, this)
    }

    companion object {
        fun createArchive() : NoteArchive{
            println("Введите название нового архива.")
            var name = Scanner(System.`in`).nextLine()
            while (name == "") {
                println("Название не может быть пустым. Повторите ввод.")
                name = Scanner(System.`in`).nextLine()
            }
            return NoteArchive(name)
        }
    }
}