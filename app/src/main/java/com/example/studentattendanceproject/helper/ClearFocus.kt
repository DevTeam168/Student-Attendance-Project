package com.example.studentattendanceproject.helper

import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import soup.neumorphism.NeumorphCardView

object ClearFocus {
    fun clearTextView(constraintLayout:ConstraintLayout?){
        //loop all elements in constraint layout
        //if it's CardView and Contain EditText
        //will clear/remove focus from it
        constraintLayout?.children?.forEach {
            if(it is NeumorphCardView){
                it.children.forEach { it1 ->
                    if(it1 is EditText){
                        if(it1.isFocused){
                            it1.clearFocus()
                        }
                    }
                }
            }
        }
    }
}