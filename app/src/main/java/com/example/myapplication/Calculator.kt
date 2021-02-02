package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.myapplication.databinding.ActivityCalculatorBinding

class Calculator : AppCompatActivity() {
    private lateinit var binding: ActivityCalculatorBinding
    private var inCalculating: Boolean = false
    private var currentValue: Long = 0
    private var storedValue: Long = 0
    private var selectedOper: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculator)
        binding = ActivityCalculatorBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.calPlusBtn.setOnClickListener{
            pushOperatorBtn(0)
        }

        binding.calMinusBtn.setOnClickListener{
            pushOperatorBtn(1)
        }

        binding.calMultiBtn.setOnClickListener{
            pushOperatorBtn(2)
        }

        binding.calDivBtn.setOnClickListener{
            pushOperatorBtn(3)
        }

        binding.calCABtn.setOnClickListener{
            clear()
        }

        binding.calEqBtn.setOnClickListener{
            calculating()
        }

        binding.cal1Btn.setOnClickListener{
            addNumAtEndOfPlate(1)
        }
        binding.cal2Btn.setOnClickListener{
            addNumAtEndOfPlate(2)
        }
        binding.cal3Btn.setOnClickListener{
            addNumAtEndOfPlate(3)
        }
        binding.cal4Btn.setOnClickListener{
            addNumAtEndOfPlate(4)
        }
        binding.cal5Btn.setOnClickListener{
            addNumAtEndOfPlate(5)
        }
        binding.cal6Btn.setOnClickListener{
            addNumAtEndOfPlate(6)
        }
        binding.cal7Btn.setOnClickListener{
            addNumAtEndOfPlate(7)
        }
        binding.cal8Btn.setOnClickListener{
            addNumAtEndOfPlate(8)
        }
        binding.cal9Btn.setOnClickListener{
            addNumAtEndOfPlate(9)
        }
        binding.cal0Btn.setOnClickListener{
            addNumAtEndOfPlate(0)
        }
    }

    private fun addNumAtEndOfPlate(num: Int) {
        currentValue = (currentValue*10 + num)
        setValueOfResultBlock()
    }

    private fun pushOperatorBtn(oper: Int) {
        if(inCalculating) {
            calculating()
        }

        inCalculating = true
        selectedOper = oper
        storedValue = currentValue
        currentValue = 0
    }

    private fun calculating() {
        if(!inCalculating) return

        when(selectedOper) {
            0 -> storedValue += currentValue
            1 -> storedValue -= currentValue
            2 -> storedValue *= currentValue
            3 -> storedValue /= currentValue
        }
        currentValue = storedValue
        storedValue = 0
        inCalculating = false

        setValueOfResultBlock()
    }

    private fun setValueOfResultBlock() {
        binding.calResultBlock.text = currentValue.toString()
    }

    private fun clear() {
        inCalculating = false;
        currentValue = 0
        storedValue = 0
        setValueOfResultBlock()
    }



}