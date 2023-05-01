package ru.startandroid.develop.fragmentactivity

import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment


class Fragment2 : Fragment() {
    interface onSomeEventListener {
        fun someEvent(s: String?)
    }

    var someEventListener: onSomeEventListener? = null
    override fun onAttach(activity: Activity) {
        super.onAttach(activity)
        someEventListener = try {
            activity as onSomeEventListener
        } catch (e: ClassCastException) {
            throw ClassCastException("$activity must implement onSomeEventListener")
        }
    }

    val LOG_TAG = "myLogs"

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        val v: View = inflater.inflate(R.layout.fragment2, null)
        val button = v.findViewById<View>(R.id.button) as Button
        button.setOnClickListener {
            v: View ->
                someEventListener!!.someEvent("Test text to Fragment1")
            }
        return v
    }
}