import JavaBeans.DataVisualizerBean;
import JavaBeans.IDataVisualizer;
import earlydiagnosis.IEarlyDiagnosis;
import earlydiagnosis.ProbabilisticComponent;
import org.encog.examples.guide.classification.*;

import java.util.ArrayList;
import java.util.Scanner;

public class Leftovers {
    public static void main(String[] args) {

        // instanciando o componente DataSet
        IDataSet dataset = new DataSetComponent();
        dataset.setDataSource("FinalProject/data/zombiebig.csv");

        // instanciando o componente paciente
        IPatient aPatient = new Patient();
        // conectando-o no componente DataSetaPatient.connect(dataset);
        aPatient.connect(dataset);

        // instanciando o componente doutor louco
        INewDoctor SmartDoctor = new NewSmartDoctor();

        // conectando-o ao componente DataSet
        SmartDoctor.connect(dataset);

        // conectando-o ao componente paciente
        SmartDoctor.connect(aPatient);

        // treinar o doutor a partir da tabela de sintomas e doenças
        SmartDoctor.treinarDoutor();

        // iniciar a consulta com o paciente
        SmartDoctor.startInterview();

        System.out.println();

        // gerar um novo paciente para o doutor
        aPatient.connect(dataset);

        // realizar uma nova consulta sem a necessidade de um novo treinamento
        SmartDoctor.startInterview();

        // Para fazer novas consultas basta atualizar o paciente, ou conectar um novo paciente com o doutor
        // e chamar o metodo .startInterview() para realizar uma nova consulta

        // Instanciando o componente DataVisualizer
        IDataVisualizer dv = new DataVisualizerBean();
        // Criando uma matriz de strings que recebe o resultado do método que ordena informações de arquivos
        // .csv em uma tabela
        String[][] tabela = dv.sortTable("FinalProject/data/zombiebig.csv");
        // Chamada do método que printa a tabela de forma organizada, com uma formatação no console
        dv.plotTable(tabela);

        // Criando um exemplo de novo paciente e adicionando-o a tabela
        String [] paciente = {"false", "false", "false", "false", "true", "true", "viral_infection"};
        tabela = dv.addPatient(paciente, tabela);
        dv.plotTable(tabela);

        // Re-ordenando tabela após adição de novo paciente
        tabela = dv.sortTable(tabela);
        dv.plotTable(tabela);

        // Plotando um exemplo de gráfico com análise de 1 sintoma
        dv.plotGraph("FinalProject/data/zombie-health-cases500.csv", "member_loss", "Pie", 1);
        dv.plotGraph("FinalProject/data/zombie-health-cases500.csv", "trembling_finger", "Pie", 1);

        // Plotando um exemplo de gráfico com análise de 2 sintomas
        dv.plotGraph("FinalProject/data/zombie-health-cases500.csv", "paralysis",
                "yellow_tongue", "Scatter", 1);

        // Plotando um exemplo de gráfico com análise de 3 sintomas
        dv.plotGraph("FinalProject/data/zombie-health-cases500.csv", "trembling_finger",
                "chest_pain", "severe_anger", "Scatter3D", 0);

        //componente EarlyDiagnostic
        int i                      = 0;
        String path                = null;
        String sintoma             = null;
        ArrayList<String> sintomas = new ArrayList<String>();
        earlydiagnosis.IDataSet dataset1 = new earlydiagnosis.DataSetComponent();
        Scanner sc                 = new Scanner(System.in);

        System.out.print("Entre com o caminho do Dataset: ");
2        path = sc.next();
        dataset1.setDataSource(path);

        System.out.println("Digite os sintomas (Enter após cada um) ou digite # para terminar");
        System.out.println("Sintoma " + i + ": ");
        sintoma = sc.next();

        while(!sintoma.equals("#")){
            sintomas.add(sintoma);
            i++;
            System.out.print("Sintoma " + i + ": ");
            sintoma = sc.next();
        }
        sc.close();

        IEarlyDiagnosis prob = new ProbabilisticComponent(dataset1);
        prob.calculateProbability(sintomas);
    }
}
