package com.example.hw1_duy_b1605326;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.github.mikephil.charting.charts.PieChart;
import com.github.mikephil.charting.components.Legend;
import com.github.mikephil.charting.data.PieData;
import com.github.mikephil.charting.data.PieDataSet;
import com.github.mikephil.charting.data.PieEntry;
import com.github.mikephil.charting.formatter.PercentFormatter;
import com.github.mikephil.charting.utils.ColorTemplate;
import java.util.ArrayList;
public class pieChart5 extends AppCompatActivity{
    ImageButton imageButton;
    String Des1,Des2,Des3,Des4,Des5,Title;
    double amount1,amount2,amount3,amount4,amount5;
    TextView textView;
    PieChart pieChartpie;
    PieData data5;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pie_chart5);
        pieChartpie =  findViewById(R.id.PieChartMp);
        imageButton = findViewById(R.id.imagebutton);
        imageButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        textView=(TextView)findViewById(R.id.laytitle);
        Intent intent = getIntent();
        amount1=intent.getDoubleExtra("segment1",123);
        amount2=intent.getDoubleExtra("segment2",123);
        amount3=intent.getDoubleExtra("segment3",123);
        amount4=intent.getDoubleExtra("segment4",123);
        amount5=intent.getDoubleExtra("segment5",123);
        Title=intent.getStringExtra("tendothi");
        Des1=intent.getStringExtra("Des1");
        Des2=intent.getStringExtra("Des2");
        Des3=intent.getStringExtra("Des3");
        Des4=intent.getStringExtra("Des4");
        Des5=intent.getStringExtra("Des5");
        textView.setText("Đồ thị: "+Title);
        //vẽ đồ thị
        pieChartpie.setUsePercentValues(true);// chú giải chữ bên trong vòng tròn nhỏ
        pieChartpie.getDescription().setEnabled(false);//bật dòng chữ chú thích
        pieChartpie.setCenterText(generateCenterSpannableText());//viết chữ bên trong đường tròn
        pieChartpie.setExtraOffsets(20.f, 0.f, 20.f, 0.f);// định vị trí của đồ thị
        //tạo đường tròn ở trong
        pieChartpie.setDrawHoleEnabled(true);//vẽ đường viền bên trong
        pieChartpie.setHoleColor(Color.WHITE);//màu nền của đường tròn bên trong
        //tạo đường viền bên trong hìnht tròn
        pieChartpie.setTransparentCircleColor(Color.WHITE);//màu của đường viền
        pieChartpie.setTransparentCircleAlpha(110);//kích cỡ đường viền
        // pieChartpie.setCenterTextColor(Color.RED);//
        pieChartpie.setHoleRadius(52f);//58 số độ công của đường viền tròn
        pieChartpie.setTransparentCircleRadius(55f);//61
        pieChartpie.setDrawCenterText(true);
//
        setData5(5,100);
        pieChartpie.setData(data5);
        pieChartpie.setVisibility(View.VISIBLE);
    }
    private SpannableString generateCenterSpannableText() {
        SpannableString s = new SpannableString("PieChartAndroid");
        s.setSpan(new RelativeSizeSpan(1.5f), 0, 15, 0);
        s.setSpan(new StyleSpan(Typeface.ITALIC), s.length() - 15, s.length(), 0);
        s.setSpan(new ForegroundColorSpan(ColorTemplate.getHoloBlue()), s.length() - 15, s.length(), 0);
        return s;
    }
    private void setData5(int count, float range) {
        String[] mParties = new String[] {Des1,Des2,Des3,Des4,Des5};
        ArrayList<PieEntry> yEntrys = new ArrayList<>();
        double tong5=amount1+amount2+amount3+amount4+amount5;
        double[] yData5={amount1,amount2,amount3,amount4,amount5};
        for (int i = 0; i < count; i++) {
            yEntrys .add(new PieEntry((float) (yData5[i]/tong5)*100,
                    mParties[i]));//i % mParties.length
        }
        PieDataSet dataSet = new PieDataSet(yEntrys,null);
        dataSet.setSliceSpace(3f);//khoảng cách giữa các phân đoạn
        ArrayList<Integer> colors = new ArrayList<>();
        colors.add(Color.BLUE);
        colors.add(Color.GREEN);
        colors.add(Color.MAGENTA);
        colors.add(Color.YELLOW);
        colors.add(Color.RED);
        colors.add(ColorTemplate.getHoloBlue());
        dataSet.setColors(colors);
        dataSet.setYValuePosition(PieDataSet.ValuePosition.OUTSIDE_SLICE);
        data5 = new PieData(dataSet);
        data5.setValueFormatter(new PercentFormatter());//thêm sô phân trăm
        data5.setValueTextSize(13f); //kích thước số liệu
        pieChartpie.invalidate();
        Legend l = pieChartpie.getLegend();
        l.setVerticalAlignment(Legend.LegendVerticalAlignment.TOP);
        l.setHorizontalAlignment(Legend.LegendHorizontalAlignment.RIGHT);
        l.setOrientation(Legend.LegendOrientation.HORIZONTAL);
        l.setDrawInside(false);
        l.setEnabled(true);
        l.setTextSize(16);
    }

}
