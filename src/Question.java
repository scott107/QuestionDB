import java.util.ArrayList;

public class Question {
	public String question;
	public int id;
	public ArrayList<String> answerToQuestions;
	public Question(int id, String question) {
		this.question = question;
		this.id = id;
		this.answerToQuestions = new ArrayList<String>();
	}
}
