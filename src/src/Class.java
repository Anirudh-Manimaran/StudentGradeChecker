/**
 * @Anirudh Manimaran
 * @Version 2.0
 * Class to represent a class in the grade accessor.
 */

import java.util.HashMap;
import java.util.Map;

public class Class {
    private final String name;
    private String description = "";
    private Map<String, Double[]> assignments = new HashMap<>();

    public String getName() {
        return name;
    }
    public Map<String, Double[]> getAssignments() {
        return assignments;
    }

    public void addAssignment(String assignment, Double[] score) {
        assignments.put(assignment, score);
    }

    public void removeAssignment(String assignment) {
        assignments.remove(assignment);
    }

    public Class(String name, String description) {
        this(name);
        this.description = description;
    }

    public Class(String name) {
        this.name = name;
    }

    public String viewAssignments() {
        String output = name + "\n";
        for(Map.Entry<String, Double[]> entry : assignments.entrySet()) {
            output +=("Assignment " + entry.getKey() + ", Grade: " + entry.getValue()[0] + ", Weight: " + entry.getValue()[1] + "\n");
        }
        return output;
    }

    public void editAssignment (String assignment, Double[] newGrade){
        assignments.replace(assignment,newGrade);
    }

    public double totalGrade() {
        double weightedSum = 0;
        double totalWeight = 100-remainingWeight();
        if (totalWeight == 0) {
            return Double.NaN;
        }
        for (Double[] values : assignments.values()) {
            weightedSum += values[0] * values[1];
        }
        return weightedSum / totalWeight;
    }

    public double remainingWeight(){
        double totalWeight = 0;
        for (Double[] values : assignments.values()) {
            totalWeight += values[1];
        }
        return 100-totalWeight;
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
