package com.amitsalunke.piechart

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.animation.Easing
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.components.Legend
import com.github.mikephil.charting.data.PieData
import com.github.mikephil.charting.data.PieDataSet
import com.github.mikephil.charting.data.PieEntry
import com.github.mikephil.charting.formatter.PercentFormatter
import com.github.mikephil.charting.utils.MPPointF


class MainActivity : AppCompatActivity() {

    private lateinit var pieChart: PieChart

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pieChart = findViewById(R.id.pieChart)
        initPieChart()
        setDataToPieChart()
    }

    private fun initPieChart() {
        pieChart.setUsePercentValues(true)
        pieChart.description.text = ""
        //hollow pie chart
        pieChart.isDrawHoleEnabled = false
        pieChart.setTouchEnabled(false)
        pieChart.setDrawEntryLabels(false)
        //adding padding
        pieChart.setExtraOffsets(20f, 0f, 20f, 20f)
        //pieChart.setUsePercentValues(true)
        pieChart.isRotationEnabled = false
        //pieChart.setDrawEntryLabels(false)
        pieChart.legend.orientation = Legend.LegendOrientation.VERTICAL
        //pieChart.legend.setForm(Legend.LegendForm.CIRCLE)
        pieChart.legend.form = Legend.LegendForm.CIRCLE
        pieChart.legend.formSize = 9f
        pieChart.legend.isWordWrapEnabled = true


    }

    private fun setDataToPieChart() {
        //pieChart.setUsePercentValues(true)
        val dataEntries = ArrayList<PieEntry>()
        dataEntries.add(PieEntry(40f, "Cheque Management"))
        dataEntries.add(PieEntry(20f, "Accounts"))
        dataEntries.add(PieEntry(7f, "Future Dated Transfer Request"))
        dataEntries.add(PieEntry(4f, "Transfer Request"))

        val colors: ArrayList<Int> = ArrayList()
        colors.add(Color.parseColor("#0075B0"))
        colors.add(Color.parseColor("#6F2A7F"))
        colors.add(Color.parseColor("#E17F25"))
        colors.add(Color.parseColor("#58A618"))

        val dataSet = PieDataSet(dataEntries, "")
        val data = PieData(dataSet)

        // In Percentage
        data.setDrawValues(true)
        data.setValueFormatter(PercentFormatter(pieChart))
        dataSet.sliceSpace = 4f
        dataSet.colors = colors

        //
        //dataSet.iconsOffset = MPPointF(0f, 40f)
        //dataSet.selectionShift = 5f
        //

        // to show value outside the chart
        //dataSet.setXValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        //dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        //dataSet.setValueLinePart1OffsetPercentage(100f); /** When valuePosition is OutsideSlice, indicates offset as percentage out of the slice size */
       // dataSet.setValueLinePart1Length(0.6f); /** When valuePosition is OutsideSlice, indicates length of first half of the line */
       // dataSet.setValueLinePart2Length(0.6f); /** When valuePosition is OutsideSlice, indicates length of second half of the line */
        //setExtraOffsets(0.f, 5.f, 0.f, 5.f); // Ofsets of the view chart to prevent outside values being cropped /** Sets extra offsets (around the chart view) to be appended to the auto-calculated offsets.*/
        //

        pieChart.data = data
        data.setValueTextSize(15f)
        //data.setValueTextColor(Color.parseColor("#FFFFFF"))
        data.setValueTextColor(Color.WHITE)
        //pieChart.setExtraOffsets(5f, 10f, 5f, 5f)
        pieChart.animateY(1400, Easing.EaseInOutQuad)

        //create hole in center
        pieChart.holeRadius = 35f
        pieChart.transparentCircleRadius = 0f
        pieChart.isDrawHoleEnabled = true
        //pieChart.setHoleColor(Color.WHITE)


        //add text in center
        //pieChart.setDrawCenterText(true);
        //pieChart.centerText = "Mobile OS Market share"
        pieChart.invalidate()


        //l.setForm(LegendForm.SQUARE);
        //l.setFormSize(9f);

    }


}

