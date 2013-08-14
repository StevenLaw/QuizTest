/**
 * 
 */
package org.enactus.QuizTest;

import java.io.File;
import java.util.ArrayList;

import org.enactus.QuizLib.*;

/**
 * This classes purpose is to test the library classes for the QuizLib class 
 * 
 * @author Steven Law
 * @version 0.1
 */
public class QuizTest {

	/**
	 * The main method
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		Quiz quiz = new Quiz("Test Quiz", "Easy");
		
		ArrayList<Answer> answers = new ArrayList<Answer>();
		Answer a = new Answer(1, 3, "The first question", "This is indeed the first question.");
		answers.add(a);
		a = new Answer(2, 3, "Nothing",  "This question is indeed totally pointless.");
		answers.add(a);
		a = new Answer(3, 3, "Something",  "This is actually a question so I am asking " +  
				"something no matter how pointless");
		answers.add(a);
		
		Question q = new Question(1, 3, "What am I asking?", answers);
		
		quiz.add(q);
		
		File f = new File("TestXML.xml");
		QuizXmlReader qr = new QuizXmlReader(f);
		try{
			Quiz tmp = qr.getQuiz();	
		}
		catch (Exception e){
			e.printStackTrace();
		}
		
		File out = new File("TestXMLOut.xml");
		QuizXmlWriter qw = new QuizXmlWriter(out);
		try{
			qw.writeQuiz(quiz);
		}
		catch (Exception e){
			e.printStackTrace();
		}
	}

}
