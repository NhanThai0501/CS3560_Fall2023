package cs3560;

import java.util.List;

public class Question {
    private String type;
    private List<String> studentAnswers;
    private boolean allowMultipleChoices;

    public Question(String type, List<String> studentAnswers, boolean allowMultipleChoices) {
        this.type = type;
        this.studentAnswers = studentAnswers;
        this.allowMultipleChoices = allowMultipleChoices;
    }

    public String getType() {
        return type;
    }

    public List<String> getCandidateAnswers() {
        return studentAnswers;
    }

    public boolean allowMultipleChoices() {
        return allowMultipleChoices;
    }
}
