# Componente `<INeuralDoctor>`

Campo | Valor
----- | -----
Classe | `<...>`
Autores | `<Gabriel F�lix>`
Objetivo | `<Gerar uma rede neural para ser utilizada pelo Doutor no diagn�stico do paciente>`
Interface | `<INeuralDoctor.java>`
~~~
import java.io.File;
import java.util.Arrays;
import org.encog.*;

public interface INeuralDoctor {
    public File importData(String[] args);
    public EncogModel analyseData (File dataFile, int numColumns);
    public MLRegression generateNeuralNetwork (EncogModel model);
    public void analyseCase (MLRegression neuralNet, Patient namePaciente);
    public void endDiagnostics (File dataFile);
}
~~~

### Interface `INeuralDoctor`
Interface provida por qualquer fonte de dados que os forne�a na forma de uma tabela.

M�todo | Objetivo
-------| --------
`importData` | importar a matriz de sintomas (.csv) do HD ou de alguma URL (futuramente pode-se utilizar a componente j� pronta DataSource).
`analyseData` | atrav�s da biblioteca externa "Encog" analisar o arquivo (.csv): examinando cada coluna de sintoma e mapeando cada linha correspondente a uma doen�a. Por fim, gerar uma rede neural do tipo feed forward.
`generateNeuralNetwork` | normalizar os dados do modelo e avaliar o melhor m�todo para ser implementado na rede.
`analyseCase` | recebe um paciente e a rede neural como par�metros para diagnostic�-lo (vai ser conectado ao doutor).
`endDiagnostics` | apaga o arquivo (.csv) e encerra as opera��es da rede neural.