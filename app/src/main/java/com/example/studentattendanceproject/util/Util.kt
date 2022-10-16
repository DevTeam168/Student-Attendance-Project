package com.example.studentattendanceproject.util

import android.app.Activity
import android.content.Context
import android.content.res.Resources
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.core.view.children
import soup.neumorphism.NeumorphCardView
import soup.neumorphism.ShapeType

object Util {

     fun hideKeyboard(activity: Activity, view: View) {
        val inputManager =
            activity.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        inputManager.hideSoftInputFromWindow(view.windowToken, 0)
    }

    fun getScreenHeight(): Int {
        return Resources.getSystem().displayMetrics.heightPixels
    }

    fun getScreenWidth(): Int {
        return Resources.getSystem().displayMetrics.widthPixels
    }

    fun clearEditText(constraintLayout: ConstraintLayout?){
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

    fun onFocusChange(view: EditText, cardView: NeumorphCardView) {
        view.setOnFocusChangeListener { _, b ->
            if (b) {
                cardView.setShapeType(ShapeType.PRESSED)
            } else {
                if (view.text.isEmpty()) {
                    cardView.setShapeType(ShapeType.FLAT)
                }
            }
        }

    }
}