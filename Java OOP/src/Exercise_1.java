public class Exercise_1{

    public static class Student {
        private final String name;
        private int age;

        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public Student(String name) {
            this.name = name;
            this.age = 20;
        }

        public String toString() {
            return name;
        }

        public double calculateMean(StudentLabGrade[] studentLabGrades) {
            double sum = 0;
            int count = 0;
            for (StudentLabGrade grade : studentLabGrades) {
                if (grade.students[0] == this || grade.students[1] == this) {
                    sum += grade.getGrade();
                    count++;
                }
            }
            return count > 0 ? sum / count : 0;
        }
    }

    public static class StudentLabGrade {
        public final Student[] students = new Student[2];
        private final double grade;

        public StudentLabGrade(Student student1, Student student2, double grade) {
            this.students[0] = student1;
            this.students[1] = student2;
            this.grade = grade;
        }

        public double getGrade() {
            return grade;
        }
    }

    public static void main(String[] args){
        Student[] group = new Student[5];
        group[0] = new Student("Riri", 12);
        group[1] = new Student("Fifi", 10);
        group[2] = new Student("Loulou", 81);

//        group[1] = group[2];
//        group[3] = group[1];

        StudentLabGrade[] studentLabGrades = new StudentLabGrade[2];
        studentLabGrades[0] = new StudentLabGrade(group[0], group[1], 14.0);
        studentLabGrades[1] = new StudentLabGrade(group[1], group[2], 16.0);

        System.out.println("Moyenne de " + group[0] + " : " + group[0].calculateMean(studentLabGrades));
        System.out.println("Moyenne de " + group[1] + " : " + group[1].calculateMean(studentLabGrades));
    }
}