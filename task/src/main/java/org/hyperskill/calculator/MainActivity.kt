package org.hyperskill.calculator

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import android.widget.EditText
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*

var memory1 = "0"
var memory2 = "0"
var operator = ""
var ans = ""
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)





        button0.setOnClickListener {
            if (editText.text.toString() != "0" && editText.text.toString() != "-0") {
                setTextField("0")
            }
        }
        dotButton.setOnClickListener {
            if (editText.text.toString() == "-") {
                editText.text.clear()
                setTextField("-0.")
            }
            if (editText.text.toString() != "" && !editText.text.toString().contains('.')) {
                setTextField(".")
            }
        }
        button1.setOnClickListener {
            if (editText.text.toString() == "0") { editText.text.clear() }
            setTextField("1")
            if (editText.text.toString() == "-01") {
                editText.text.clear()
                setTextField("-1")
            }
        }
        button2.setOnClickListener {
            if (editText.text.toString() == "0") { editText.text.clear() }
            setTextField("2")
            if (editText.text.toString() == "-02") {
                editText.text.clear()
                setTextField("-2")
            }
        }
        button3.setOnClickListener {
            if (editText.text.toString() == "0") { editText.text.clear() }
            setTextField("3")
            if (editText.text.toString() == "-03") {
                editText.text.clear()
                setTextField("-3")
            }
        }
        button4.setOnClickListener {
            if (editText.text.toString() == "0") { editText.text.clear() }
            setTextField("4")
            if (editText.text.toString() == "-04") {
                editText.text.clear()
                setTextField("-4")
            }
        }
        button5.setOnClickListener {
            if (editText.text.toString() == "0") { editText.text.clear() }
            setTextField("5")
            if (editText.text.toString() == "-05") {
                editText.text.clear()
                setTextField("-5")
            }
        }
        button6.setOnClickListener {
            if (editText.text.toString() == "0") { editText.text.clear() }
            setTextField("6")
            if (editText.text.toString() == "-06") {
                editText.text.clear()
                setTextField("-6")
            }
        }
        button7.setOnClickListener {
            if (editText.text.toString() == "0") { editText.text.clear() }
            setTextField("7")
            if (editText.text.toString() == "-07") {
                editText.text.clear()
                setTextField("-7")
            }
        }
        button8.setOnClickListener {
            if (editText.text.toString() == "0") { editText.text.clear() }
            setTextField("8")
            if (editText.text.toString() == "-08") {
                editText.text.clear()
                setTextField("-8")
            }
        }
        button9.setOnClickListener {
            if (editText.text.toString() == "0") { editText.text.clear() }
            setTextField("9")
            if (editText.text.toString() == "-09") {
                editText.text.clear()
                setTextField("-9")
            }
        }

        clearButton.setOnClickListener {
            editText.text.clear()
            setTextField("0")
            ans = "0"
            operator = ""
            memory1 = "0"
            memory2 = "0"
            editText.hint = "0"
        }

        addButton.setOnClickListener {
            if (memory1 == "0") {
                memory1 = editText.text.toString()
                operator = "+"
            } else {
                calcResult()
                memory1 = ans
                memory2 = ""
                operator = "+"
            }
            editText.text.clear()
            editText.hint = memory1
        }

        subtractButton.setOnClickListener {
            if (editText.text.toString() == "0") {
                editText.text.clear()
                editText.text.append("-0")
            } else {
                if (memory1 == "0") {
                    memory1 = editText.text.toString()
                    operator = "-"
                } else {
                    calcResult()
                    memory1 = ans
                    memory2 = "0"
                    operator = "-"
                }
                editText.text.clear()
                editText.hint = memory1
            }
        }

        multiplyButton.setOnClickListener {
            if (memory1 == "0") {
                memory1 = editText.text.toString()
                operator = "*"
            } else {
                calcResult()
                memory1 = ans
                memory2 = "0"
                operator = "*"
            }
            editText.text.clear()
            editText.hint = memory1
        }

        divideButton.setOnClickListener {
            if (memory1 == "0") {
                memory1 = editText.text.toString()
                operator = "/"
            } else {
                calcResult()
                memory1 = ans
                memory2 = "0"
                operator = "/"
            }
            editText.text.clear()
            editText.hint = memory1
        }

        equalButton.setOnClickListener {
            calcResult()
            editText.text.clear()
            setTextField(ans)
        }



    }

    fun setTextField(str: String) {
        editText.append(str)
    }
    fun calcResult() {
        memory2 = editText.text.toString()
        editText.text.clear()
        when (operator) {
            "+" -> {
                ans = if (memory1.contains('.') || memory2.contains('.')) {
                    (memory1.toDouble() + memory2.toDouble()).toString()
                } else {
                    (memory1.toInt() + memory2.toInt()).toString()
                }
            }
            "-" -> {
                ans = if (memory1.contains('.') || memory2.contains('.')) {
                    (memory1.toDouble() - memory2.toDouble()).toString()
                } else {
                    (memory1.toInt() - memory2.toInt()).toString()
                }
            }
            "*" -> {
                ans = if (memory1.contains('.') || memory2.contains('.')) {
                    (memory1.toDouble() * memory2.toDouble()).toString()
                } else {
                    (memory1.toInt() * memory2.toInt()).toString()
                }
            }
            "/" -> { ans = (memory1.toDouble() / memory2.toDouble()).toString() }
        }
    }
}
