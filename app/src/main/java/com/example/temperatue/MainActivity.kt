package com.example.temperatue

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.anychart.AnyChart
import com.anychart.AnyChartView
import com.anychart.chart.common.dataentry.DataEntry
import com.anychart.charts.Cartesian
import java.util.*
import kotlin.collections.ArrayList
import com.anychart.chart.common.dataentry.ValueDataEntry
import java.sql.Time


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var tempChart = findViewById<com.anychart.AnyChartView>(R.id.chartView)
        var chart: Cartesian = AnyChart.line()
        chart.animation(true)
        chart.title("Temperature.")

        var hours = Calendar.getInstance().time.hours
        var minutes = Calendar.getInstance().time.minutes
        var b: String
        var data = ArrayList<DataEntry>()
        for (i in 0..10) {
            b = hours.toString() + ':' + minutes.toString()
            minutes++
            data.add(i, ValueDataEntry(b, i))

        }

        chart.line(data)
        tempChart.setChart(chart)

    }
}


