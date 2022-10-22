package com.example.graphview;
import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import com.jjoe64.graphview.DefaultLabelFormatter;
import com.jjoe64.graphview.GraphView;
import com.jjoe64.graphview.ValueDependentColor;
import com.jjoe64.graphview.series.BarGraphSeries;
import com.jjoe64.graphview.series.DataPoint;
import com.jjoe64.graphview.series.DataPointInterface;
import com.jjoe64.graphview.series.LineGraphSeries;

public class MainActivity extends AppCompatActivity {

    LineGraphSeries<DataPoint> series;
    BarGraphSeries<DataPoint> series2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        GraphView graph = findViewById(R.id.graph1);
        series = new LineGraphSeries<>(getDataPoint());
        series2 = new BarGraphSeries<>(getDataPoint());
        series2.setSpacing(20);

        series2.setValueDependentColor(new ValueDependentColor() {
            @Override
            public int get(DataPointInterface data) {
                return Color.rgb((int) data.getX()*255/4,(int) Math.abs(data.getY()*255/20),100) ;
            }
        });

        graph.addSeries(series2);
        graph.getViewport().setXAxisBoundsManual(true);
        graph.getViewport().setMinX(0);
        graph.getViewport().setMaxX(11.3);
        graph.getViewport().setScrollable(true);

        graph.getGridLabelRenderer().setLabelFormatter(new DefaultLabelFormatter(){

            @Override
            public String formatLabel(double value, boolean isValueX) {

                if (isValueX){

                    switch ((int) value){

                        case 0:
                            return "Jan";
                        case 2:
                            return "Mars";
                        case 4:
                            return "Mai";
                        case 6:
                            return "Juillet";
                        case 8:
                            return "Sept";
                        case 10:
                            return "Nov";

                    }

                }
                return super.formatLabel(value, isValueX);
            }
        });
        series2.setDrawValuesOnTop(true);
        series2.setValuesOnTopColor(Color.RED);
    }


    private DataPoint[] getDataPoint() {

        DataPoint[] dp = new  DataPoint[]{

                new DataPoint(0,Ordonne(0)),
                new DataPoint(1,Ordonne(1)),
                new DataPoint(2,Ordonne(2)),
                new DataPoint(3,Ordonne(3)),
                new DataPoint(4,Ordonne(4)),
                new DataPoint(5,Ordonne(5)),
                new DataPoint(6,Ordonne(6)),
                new DataPoint(7,Ordonne(7)),
                new DataPoint(8,Ordonne(8)),
                new DataPoint(9,Ordonne(9)),
                new DataPoint(10,Ordonne(10)),
                new DataPoint(11,Ordonne(11)),

        };

        return dp;
    }

    double Ordonne(int i){

        double y[]={5,6,4,5,8,10,12,10,8,10,2,7};
        return y[i];

    }
}
