package ru.startandroid.develop.fragmentactivity

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment

class Fragment1 : Fragment() {

    val LOG_TAG = "myLogs"

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ) : View {
        val v: View = inflater.inflate(R.layout.fragment1, null)

        val button: Button = v.findViewById(R.id.button) as Button
        button.setOnClickListener {
            (activity?.findViewById<View>(R.id.btnFind) as Button).text = "Access from Fragment1"
        }
        return v
    }
}