package com.niro.android.robolectric_test

import android.widget.TextView
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction
import org.junit.Test

import org.junit.Assert.*
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(RobolectricTestRunner::class)
class ExampleUnitTest {

    @Test
    fun test_activity_main() {
        val activity: MainActivity = Robolectric.setupActivity(MainActivity::class.java)
        val textView: TextView = activity.findViewById<TextView>(R.id.text_activity)
        assertEquals("Hello World!", textView.text)
    }

    @Test
    fun check_first_fragment(){
        val fragment = FirstFragment()
        val activity = Robolectric.buildActivity(
            SecondActivity::class.java
        )
            .create()
            .start()
            .resume()
            .get()

        val fragmentManager: FragmentManager = activity.supportFragmentManager
        val fragmentTransaction: FragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.add(fragment, null)
        fragmentTransaction.commit()

        val textView : TextView = activity.findViewById<TextView>(R.id.textview_first_fragment)
        assertEquals("hello first fragment", textView.text)
    }
}