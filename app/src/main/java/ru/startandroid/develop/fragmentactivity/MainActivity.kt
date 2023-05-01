package ru.startandroid.develop.fragmentactivity

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import ru.startandroid.develop.fragmentactivity.Fragment2.onSomeEventListener


class MainActivity : AppCompatActivity(), onSomeEventListener {
    public override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val frag2: Fragment = Fragment2()
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.add(R.id.fragment2, frag2)
        ft.commit()
    }

    override fun someEvent(s: String?) {
        val frag1: Fragment = supportFragmentManager.findFragmentById(R.id.fragment1)!!
        (frag1.view?.findViewById<View>(R.id.textView) as TextView).text =
            "Text from Fragment 2:$s"
    }
}