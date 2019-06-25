# Grupo Leftovers!
![logo](https://i.ibb.co/8z6F13t/fefe.jpg)

Membros: Gabriel Félix, René F. Jallais, Gustavo Garcia.

# Componente `INeuralDoctor`

Campo | Valor
----- | -----
Classe | `NewSmartDoctor.java`
Autores | `Gabriel Félix`
Objetivo | `Gerar uma rede neural para ser utilizada pelo Doutor no diagnóstico do paciente`
Interface | `INewDoctor.java`
~~~
package org.encog.examples.guide.classification;

public interface INewDoctor extends IEnquirer, IResponderReceptacle, ITableProducerReceptacle {
    public void treinarDoutor();
    public void diagnosticar(ArrayList<String> sintomas);
}


~~~

### Classe `NewSmartDoctor`
Classe doutor inteligente, implementação de um doutor que se utiliza de rede neural do tipo Feed Foward para diagnosticar pacientes.

Método | Objetivo
-------| --------
`importData` | importar a matriz de sintomas (.csv) do HD já convertida em valores decimais (true -> 1.0 e false -> 0.0) para treinar a rede neural.
`diagnosticar` | recebe uma ArrayList de Strings com o sintomas do paciente para analisar, a partir de um modelo já treinado, qual é a doença do paciente. O método faz a comparação entre a resposta dada pelo doutor e a doença do paciente. Obviamente quanto melhor forem os dados fornecidos (# de casos), melhor será a acurácia do doutorInteligente. 
`treinarDoutor` | implementação da rede neural, onde a partir da matriz de sintomas e doenças é gerado um modelo baseado na rede neural Feedfoward (sem cíclos entre os nós dos layers). O método é chamado na main e não recebe nenhum parâmetro, ela gera um modelo para ser utilizado no método diagnosticar() e no final atualiza os atributos do doutor com uma rede neural já treinada.
`startInterview` | inicia a entrevista com um paciente, chamando o método diagnosticar no final.

### Classe `Patient`
Classe implementada pelo professor André Santachè, porém com a adiação de um novo método.

Método | Objetivo
-------| --------
`askSymp` | Questionamento do doutor em relação aos sintomas do paciente, que ao invés de responder apenas "yes" ou "no", ele responde variações de respostas afirmativas ou negativas.

# Componente `DataVisualizer`

Campo | Valor
----- | -----
Classe | `DataVisualizerBean.java`
Autores | `René F. Jallais`
Objetivo | `Organização e visualização de dados`
Interface | `IDataVisualizer`
~~~
public interface IDataPlot {
    void plotTable(String path);
    void plotTable(Table table);
    void plotTable(String[][] matrix);
    void plotGraph(String path, String symptom, String type, int case);
    void plotGraph(String path, String symptom1, String symptom2, String type, int case);
    void plotGraph(String path, String symptom1, String symptom2, String symptom3, String type, int case);
}

public interface IDataOrganizer {
    String[][] addPatient(String[] patient, String[][] matrix);
    String[][] sortTable(String path);
    String[][] sortTable(String[][] matrix);
}

public interface IDataVisualizer extends IDataPlot, IDataOrganizer {
}
~~~

## Detalhamento das Interfaces

### Interface `IDataPlot`
`Printa tabelas formatadas a partir de arquivos .csv; Plota gráficos para melhor compreensão de dados visuais estatisticos`.

Método | Objetivo
-------| --------
`plotTable` | `Visualização da table fornecida em arquivo .csv`
`plotGraph` | `Visualização em gráfico dos dados fornecidos`

### Interface `IDataOrganizer`
`Organização de dados: Adição de novos pacientes(linhas) na tabela, ordenação da tabela`.

Método | Objetivo
-------| --------
`addPatient` | `adiciona uma linha que representa um novo paciente à tabela`
`sortTable` | `Ordena a tabela`


# Componente `IEarlyDiagnosis`

Campo | Valor
----- | -----
Classe | `ProbabilityComponent.java`
Autores | `Gustavo Garcia`
Objetivo | `A partir de poucos sintomas iniciais, apresentar cada probabilidade das possíveis doenças`
Interface | `IEarlyDiagnosis.java`
~~~
public interface IEarlyDiagnosis {
    public void calculateProbability(String[] symptoms);
}
~~~

### Interface `IEarlyDiagnosis`
A interface auxiliará no diagnóstico precoce das doenças, baseada em poucos sintomas iniciais, entregando probabilidades de possíveis diagnósticos.

Método | Objetivo
-------| --------
`public void calculateProbability(String[] symptoms)` | O método pega um vetor de sintomas iniciais e imprime probabilidades de possíveis doenças.

### Como usar

// Criar um componente que representa seu dataset<br>
IDataSet dataset = new DataSetComponent();

// Importar seu dataset<br>
dataset.setDataSource("caminho-do-seu-dataset.csv");

// Criar um vetor de String com os sintomas iniciais<br>
String sintomas[] = {"sintoma1", "sintoma2",...};

// Criar o componente que calcula as probabilidades no seu dataset<br>
IEarlyDiagnosis prob = new ProbabilisticComponent(dataset);

// Chamar o método e receber a informação<br>
prob.calculateProbability(sintomas);
