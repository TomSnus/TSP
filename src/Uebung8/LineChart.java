package Uebung8;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.ui.ApplicationFrame;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.DefaultCategoryDataset;

public class LineChart extends ApplicationFrame
{
   private static final long serialVersionUID = -3587490116553582074L;

   public LineChart(String applicationTitle, String chartTitle, String columnTitle,
		   String rowTitle, DefaultCategoryDataset dataSet)
   {
      super(applicationTitle);
      JFreeChart lineChart = ChartFactory.createLineChart(
         chartTitle, columnTitle, rowTitle, dataSet, PlotOrientation.VERTICAL,
         true,true,false);
         
      ChartPanel chartPanel = new ChartPanel(lineChart);
      chartPanel.setPreferredSize(new java.awt.Dimension(560, 367));
      setContentPane(chartPanel);
   }
}