import java.awt.desktop.QuitStrategy;
import java.util.ArrayList;
import java.util.List;

public class StackOverFlowDemo {
    public static void main(String[] args) {
        StackOverFlow system = new StackOverFlow();

        User alice = system.createUser("alice12", "alice@email.com");
        User bob = system.createUser("bob", "blob@email.com");
        User cat = system.createUser("cat", "cat@email.com");

        List<String> tags = new ArrayList<>();
        tags.add("#java");
        tags.add("#oops");
        Question aliceQuestion =  alice.askQuestion("Polymorphism in java", "How is polymorphism is implemented in java", tags);

        bob.giveComment(aliceQuestion, "Great question!");

        tags = List.of("#travel", "#international");
        Question bobQuestion = bob.askQuestion("Asking for Travel tips", "Wanted to travel this weekend in city, Can someone suggest a good weekend getaway?", tags);
        cat.giveComment(bobQuestion, "I would like to follow this question for my plans as well");

        cat.giveAnswer("Polymorphism can be implemented in Java by method overloading and method overriding.", aliceQuestion);


        // Summary
        printAllData(alice);
        printAllData(bob);
        printAllData(cat);
    }

    public static void printAllData(User user) {
        System.out.println(user.getUsername());
        System.out.println("Questions");
        for (Question ques : user.getQuestions()) {
            System.out.println(ques.getTitle() + "\n" + ques.getContent());
        }

        System.out.println("Answers");
        for (Answer answer : user.getAnswers()) {
            System.out.println("Ques: " + answer.getQuestion().getTitle() + "\n" + answer.getContent());
        }

        System.out.println("Comments");
        for (Comment comment : user.getComments()) {
            System.out.println(comment.getContent() + "\n");
        }
    }
}
