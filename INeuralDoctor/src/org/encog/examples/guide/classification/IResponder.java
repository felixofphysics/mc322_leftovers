package org.encog.examples.guide.classification;

public interface IResponder {
    public String askSymp(String question);
    public String ask(String question);
    public boolean finalAnswer(String answer);
}