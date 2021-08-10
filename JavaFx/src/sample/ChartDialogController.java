package sample;


import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;


import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class ChartDialogController implements Initializable {


    private Stage ChartDialStage;

    @FXML
    private PieChart pieChart;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void plotting(MyСircle circle) {
        //КАК НАПИСАТЬ ДИАГРАММУ??
        /*
        public class CreateChart extends JFrame{

    public CreateChart(String appTitle, String chartTitle)
    {
        PieDataset dataset = createDataset();
        JFreeChart chart = createChart(dataset,chartTitle);
        ChartPanel chartPanel = new ChartPanel(chart);
        chartPanel.setPreferredSize(new java.awt.Dimension(500,300));
        setContentPane(chartPanel);
    }


    private PieDataset createDataset()
    { int[] mas = {1,1,1,2,2,4,3,2,3,4,5};
      Map<Integer, Integer> map = new HashMap<Integer, Integer>();

     for(int i=0;i<mas.length;++i)
     {
         if(map.containsKey(mas[i]))
         {
             map.put(mas[i], map.get(mas[i])+1);
         }
         else {map.put(mas[i], 1);}
     }

      DefaultPieDataset result = new DefaultPieDataset();

      for (Map.Entry entry : map.entrySet()) {
     result.setValue(entry.getKey().toString(), (Double)entry.getValue());
}
    }
    private JFreeChart createChart(PieDataset dataset, String title)
    {
        JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, true, true, false);

        PiePlot3D plot = (PiePlot3D) chart.getPlot();
        plot.setStartAngle(90);
        plot.setDirection(Rotation.CLOCKWISE);
        plot.setForegroundAlpha(0.5f);
        return chart;
    }

    public static void main(String[] args)
    {
            CreateChart CC = new CreateChart("Pie Chart Test","OS Comparison");
            CC.pack();
            CC.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            CC.setVisible(true);
    }
}


        private JFreeChart createChart(PieDataset dataset, String title)
        {
            JFreeChart chart = ChartFactory.createPieChart3D(title, dataset, true, true, false);

            PiePlot3D plot = (PiePlot3D) chart.getPlot();
            plot.setStartAngle(90);
            plot.setDirection(Rotation.CLOCKWISE);
            plot.setForegroundAlpha(0.5f);
            return chart;
        }

         */
        int[] ch;
        int k=0;
        ch=circle.Mass();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();

        for(int i=0;i<ch.length;++i)
        {
            if(map.containsKey(ch[i]))
            {
                map.put(ch[i], map.get(ch[i])+1);
            }
            else {map.put(ch[i], 1);}
        }
        //Как создать несколько piechart'ов??
        pieChart = new PieChart();

        for (Map.Entry entry : map.entrySet()) {
            pieChart.getData().add(new PieChart.Data(entry.getKey().toString(), (double) entry.getValue()));
        }
    }








    public void setDialogStage(Stage ChartDialStage){
        this.ChartDialStage = ChartDialStage;
    }

    @FXML
    void closeChartDial(ActionEvent event) {
        ChartDialStage.close();
    }




}