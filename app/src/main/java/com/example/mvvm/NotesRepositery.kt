package com.example.mvvm

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.LiveData

class NotesRepositery(private val notesDao: NotesDao) {

    //insert notes
    suspend fun insertNotes(notes: Notes){
        notesDao.insertNote(notes)
    }


    //get notes method
    fun getNotes() : LiveData<List<Notes>>{
        return notesDao.getAllNotes()
    }


}