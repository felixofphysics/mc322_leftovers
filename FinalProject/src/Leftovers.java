import JavaBeans.DataVisualizerBean;
import JavaBeans.IDataVisualizer;
import org.encog.examples.guide.classification.*;

public class Leftovers {
    public static void main(String[] args) {

        // instanciando o componente DataSet
        IDataSet dataset = new DataSetComponent();
        dataset.setDataSource("data/zombiebig.csv");

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
        String[][] tabela = dv.sortTable("data/zombiebig.csv");
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
        dv.plotGraph("FinalProject/data/zombie-health-cases500.csv", "chest_pain", "Pie", 1);

        // Plotando um exemplo de gráfico com análise de 2 sintomas
        dv.plotGraph("FinalProject/data/zombie-health-cases500.csv", "paralysis",
                "trembling_finger", "Scatter", 0);

        // Plotando um exemplo de gráfico com análise de 3 sintomas
        dv.plotGraph("FinalProject/data/zombie-health-cases500.csv", "yellow_tongue",
                "member_loss", "severe_anger", "Bubble", 0);


    }
}
