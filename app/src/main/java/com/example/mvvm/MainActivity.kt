package com.example.mvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.mvvm.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)


         val notesDao = NotesDataBase.getdatabase(applicationContext).notesDao()
         val notesRepositery = NotesRepositery(notesDao)
         val mainViewModel = ViewModelProvider(this, MainViewModelFactory(notesRepositery)).get(MainViewModel::class.java)


        mainViewModel.getNotes().observe(this) {
            binding.textView.text = it.toString()
        }

        //button event
       binding.addButton.setOnClickListener {
           if (binding.searchBar.text!!.isEmpty()){
               binding.searchBar.error = "Empty"
           }
           else{
               mainViewModel.insertNotes(Notes(0,binding.searchBar.text.toString()))
               Toast.makeText(this, "DONE", Toast.LENGTH_SHORT).show()
               binding.searchBar.text = null
           }
       }


    }
}