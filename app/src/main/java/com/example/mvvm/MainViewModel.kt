package com.example.mvvm

import android.provider.ContactsContract.CommonDataKinds.Note
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.viewModelFactory
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val notesRepository: NotesRepositery):ViewModel() {


    //get notes
    fun getNotes(): LiveData<List<Notes>>{
        return notesRepository.getNotes()
    }

   fun insertNotes(notes: Notes){

       viewModelScope.launch(Dispatchers.IO) {
           notesRepository.insertNotes(notes)
       }


   }




}