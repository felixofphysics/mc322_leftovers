# Componente `<IProbOfIllness>`

Campo | Valor
----- | -----
Classe | `<...>`
Autores | `<Gustavo Garcia>`
Objetivo | `<A partir de poucos sintomas iniciais, apresentar cada probabilidade das poss�veis doen�as>`
Interface | `<IProbability.java>`
~~~
public interface IProbability {
    public String[] diagnosis(File dataFile);
}
~~~

### Interface `IProbability`
A interface auxiliar� no diagn�stico precoce das doen�as, baseada em poucos sintomas iniciais, entregando probabilidades de poss�veis diagn�sticos.

M�todo | Objetivo
-------| --------
`diagnosis` | importar a matriz de sintomas (.csv) do HD ou de alguma URL (futuramente pode-se utilizar a componente j� pronta DataSource) e devolver um diagn�stico probabil�stico.
