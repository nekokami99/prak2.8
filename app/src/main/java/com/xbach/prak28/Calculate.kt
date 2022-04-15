package com.xbach.prak28

object Calculate {
    private var result:Int =0

    fun setResult(option: Int, a: Int, b: Int, c: Int){
        if(option == 0)
            result = (a+b+c)*4
        else if(option == 1)
            result = (a * b + b * c + c * a) * 2
        else
            result = a*b*c
    }

    fun getResult(): Int{
        return result
    }
}
