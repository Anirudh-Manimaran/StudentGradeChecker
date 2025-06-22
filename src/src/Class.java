import java.util.HashMap;
import java.util.Map;

public class Class {
    private final String name;
    private String description = "";
    private Map<String, Double> assignments = new HashMap<>();

    public String getName() {
        return name;
    }
    public Map<String, Double> getAssignments() {
        return assignments;
    }

    public void addAssignment(String assignment, Double score) {
        assignments.put(assignment, score);
    }

    public void removeAssignment(String assignment) {
        assignments.remove(assignment);
    }

    public Class(String name, String description) {
        this(name);
        this.description = description;
    }

    public Class(String name, String description, Map<String, Double> assignments) {
        this(name, description);
        this.assignments = new HashMap<>(assignments);
    }

    // Constructor for classes without a description
    public Class(String name) {
        this.name = name;
    }

    public String viewAssignments(Map<Class, Double> assignments) {
        String output = "";
        for(Map.Entry<Class, Double> entry : assignments.entrySet()) {
            output +=( "Class: " +entry.getKey() + ", Score: " + entry.getValue() + "\n");
        }
        return output;
    }

    public void editAssignment (String assignment, Double newGrade){
        assignments.replace(assignment,newGrade);
    }

    public String getDescription(){
        return description;
    }

    public void editDescription(String description){
        this.description = description;
    }

    @Override
    public String toString() {
        return "Course{name='" + name + "', description='" + description + "'}";
    }


}
