fun main(args: Array<String>) {
    println("Добро пожаловать в приложение \"Заметки\"!")
    val archiveList: MutableList<NoteArchive> = mutableListOf()
    val archiveMenu: Menu<NoteArchive> = Menu("архив", "архивов", archiveList)
    archiveMenu.input({NoteArchive.createArchive()}, { it ->
        val noteMenu: Menu<Note> = Menu("заметку", "заметок архива ${archiveList[it].name}", archiveList[it].noteList)
        noteMenu.input({archiveList[it].createNote()}, {that ->
            println("Содержимое данной заметки:")
            println(archiveList[it].noteList[that].text)
        })
    })
    println("Спасибо, что воспользовались приложением \"Заметки\". До новых встреч!")
}