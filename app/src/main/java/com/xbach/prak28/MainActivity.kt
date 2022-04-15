package com.xbach.prak28

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.lifecycle.Observer
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider



class MainActivity : AppCompatActivity() {

    private lateinit var spinner: Spinner
    private lateinit var tvCaption: TextView
    private lateinit var tvSideA:TextView
    private lateinit var editTextA: EditText
    private lateinit var tvSideB:TextView
    private lateinit var editTextB: EditText
    private lateinit var tvSideC:TextView
    private lateinit var editTextC: EditText
    private lateinit var textView: TextView
    private lateinit var button: Button
    private lateinit var viewModel:MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initUI()

        val provider = ViewModelProvider(this)
        viewModel = provider.get(MainViewModel::class.java)
        observeViewModel()

        initView()
    }

    private fun observeViewModel() {
        viewModel.res.observe(this, Observer {
            textView.text = it.toString()
        })
    }

    private fun initView(){
        var option: Int = 0
        var a: Int=0
        var b: Int=0
        var c: Int=0

        val options = resources.getStringArray(R.array.option)
        if(spinner != null) {
            val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, options)
            spinner.adapter = adapter
            spinner.setSelection(0)
        }

        button.setOnClickListener {
            if(editTextA.text.toString().toIntOrNull() != null &&
                editTextB.text.toString().toIntOrNull() != null &&
                editTextC.text.toString().toIntOrNull() != null
            ) {
                a = editTextA.text.toString().toInt()
                b = editTextB.text.toString().toInt()
                c = editTextC.text.toString().toInt()
                if(a >= 0 && b >= 0 && c >= 0){
                    viewModel.doMath(option, a, b, c)
                }
                else
                    textView.text = "Ошибка ввода"
            }
            else
                textView.text = "Ошибка ввода"
        }

        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                if(position==0)
                    option=0
                else if(position==1)
                    option=1
                else if(position==2)
                    option=2
            }
            override fun onNothingSelected(parent: AdapterView<*>) {
            }
        }

    }

    private fun initUI(){
        spinner=findViewById(R.id.spinner)
        editTextA=findViewById(R.id.sideA)
        editTextB=findViewById(R.id.sideB)
        editTextC=findViewById(R.id.sideC)
        textView=findViewById(R.id.solution)
        button=findViewById(R.id.getSolution)
        tvCaption=findViewById(R.id.caption)
        tvSideA=findViewById(R.id.sideALabel)
        tvSideB=findViewById(R.id.sideBLabel)
        tvSideC=findViewById(R.id.sideCLabel)
    }
}