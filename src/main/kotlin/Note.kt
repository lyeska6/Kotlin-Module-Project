import java.util.Scanner

class Note(
        override val name: String,
        val text: String,
        var archive: NoteArchive
) : Creatable {



}