package com.adl.ijin

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.DatePicker
import com.adl.ijin.model.GetIjinResponse
import com.adl.ijin.service.RetrofitConfig
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUI()

        RetrofitConfig().getIjin().getAllIjin().enqueue(object:Callback<GetIjinResponse>{
            override fun onResponse(
                call: Call<GetIjinResponse>,
                response: Response<GetIjinResponse>
            ) {
               Log.d("Response",response.body().toString())
            }

            override fun onFailure(call: Call<GetIjinResponse>, t: Throwable) {
                Log.e("error request",t.localizedMessage.toString())
            }


        })
    }

    var calendar = Calendar.getInstance()
    private fun setupUI() {

        btnDari.setOnClickListener({
            DatePickerDialog(this@MainActivity,getCalendarListener(0),calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show()

        })

        btnSampai.setOnClickListener({
            DatePickerDialog(this@MainActivity,getCalendarListener(1),calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),calendar.get(Calendar.DAY_OF_MONTH)).show()

        })
    }

    fun getCalendarListener (tipe:Int):DatePickerDialog.OnDateSetListener {
        var calendar = Calendar.getInstance()
        var dateSetListener = object : DatePickerDialog.OnDateSetListener {
            override fun onDateSet(p0: DatePicker?, p1: Int, p2: Int, p3: Int) {
                calendar.set(Calendar.YEAR, p1)
                calendar.set(Calendar.MONTH, p2)
                calendar.set(Calendar.DAY_OF_MONTH, p3)

                val formatDate = "MM/dd/yyyy"
                val sdf = SimpleDateFormat(formatDate, Locale.US)

                if(tipe==0){
                    txtDariTanggal.setText(sdf.format(calendar.time))

                }else{
                    txtSampaiTanggal.setText(sdf.format(calendar.time))

                }
            }

        }

        return dateSetListener


    }
}