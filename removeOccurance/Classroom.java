package removeOccurance;
//Definition of the Student class


//Definition of the Classroom class
public class Classroom {
 // Method to register a student
 public String registerStudent(Student student) {
     // Check if the name is in uppercase
     if (!student.getName().equals(student.getName().toUpperCase())) {
         return "Block letters needed";
     }
     
     // Check if the score is between 0 and 100
     if (student.getScore() < 0 || student.getScore() > 100) {
         return "Invalid score";
     }
     
     // If both conditions are satisfied, return "Registered"
     return "Registered";
 }
 
 // Method to generate a student card
 public String studentCard(String card) {
     // Implementation of the student card generation process
     // Here, we'll simply return the card information
//     return "Student card: " + card;
	 if(!card.matches("\\d+")) {
		 return "invalid card";
	 }
	 return "valid card";
 }
 
 // Main method for testing
 public static void main(String[] args) {
     // Creating student objects
     Student student1 = new Student("JOHN DOE", 85);
     Student student2 = new Student("John Doe", 85);
     Student student3 = new Student("JANE DOE", 105);
     
     // Creating a classroom object
     Classroom classroom = new Classroom();
     
     // Registering the students
     String result1 = classroom.registerStudent(student1);
     String result2 = classroom.registerStudent(student2);
     String result3 = classroom.registerStudent(student3);
     
     // Printing the results
     System.out.println(result1); // Output: Registered
     System.out.println(result2); // Output: Block letters needed
     System.out.println(result3); // Output: Invalid score
     
     // Generating a student card
//     String studentCardResult = classroom.studentCard("Card12345");
//     System.out.println(studentCardResult); // Output: Student card: Card12345
 }
}
