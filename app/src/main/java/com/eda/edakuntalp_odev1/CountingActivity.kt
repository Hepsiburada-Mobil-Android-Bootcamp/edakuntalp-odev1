package com.eda.edakuntalp_odev1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton

class CountingActivity : AppCompatActivity() {

    private val count_tv by lazy {findViewById<TextView>(R.id.count_txt)}
    private val count_btn by lazy {findViewById<ExtendedFloatingActionButton>(R.id.count_btn)}

    var countingViewModel: CountingViewModel? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counting)

        countingViewModel= ViewModelProviders.of(this).get(CountingViewModel::class.java)

        var count: MutableLiveData<Int>? = countingViewModel?.getInitialcount()
        count?.observe(this, Observer {
            count_tv.setText(it)
        })

        count_btn.setOnClickListener {
            countingViewModel?.getCount()
        }
    }
}