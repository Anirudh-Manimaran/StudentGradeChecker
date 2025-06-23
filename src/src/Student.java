/**
 * @author  Anirudh Manimaran
 * @version 2.0
 * Class to represent a Student in the grade accessor.
 */

import java.util.HashMap;
import java.util.Map;


public class Student {
    private final String name;
    private Map<String, Class> classes = new HashMap<>();
    private int absences;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Map<String, Class> getClasses() {
        return classes;
    }

    public void addClass(Class course) {
        classes.put(course.getName(), course);
    }

    public void removeClass(String className) {
        classes.remove(className);
    }

    public Class getClassByName(String className) {
        return classes.get(className);
    }

    public int getAbsences() {
        return absences;
    }

    public void setAbsences(int absences) {
        this.absences = absences;
    }

    public void addAbsences() {
        this.absences++;
    }

    public double getTermGPA() {
        if (classes.isEmpty()) return Double.NaN;
        double sum = 0;
        int count = 0;
        for (Class x : classes.values()) {
            double grade = x.totalGrade();
            if (!Double.isNaN(grade)) {
                sum += percentageToGPA(grade);
                count++;
            }
        }
        if(count == 0){
            return Double.NaN;
        }
        else{
            return sum / count;
        }
    }

    private double percentageToGPA(double percentage) {
        if (percentage >= 90){
            return 4;
        }
        else if (percentage >= 80){
            return 3;
        }
        else if (percentage >= 70){
            return 2;
        }
        else if (percentage >= 60){
            return 1;
        }
        return 0;

    }

    @Override
    public String toString() {
        return "Student{name='" + name + "', absences=" + absences + ", Term GPA=" + getTermGPA() + "}";
    }
}
