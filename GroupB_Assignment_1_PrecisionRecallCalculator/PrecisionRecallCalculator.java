import java.util.*;

public class PrecisionRecallCalculator {
    public static void main(String[] args) {
        // Sample input: Answer set A, Query q1, and Relevant documents Rq1
        Set<String> answerSetA = new HashSet<>();
        answerSetA.add("Doc1");
        answerSetA.add("Doc2");
        answerSetA.add("Doc3");
        answerSetA.add("Doc4");
        answerSetA.add("Doc5");

        Set<String> relevantDocumentsRq1 = new HashSet<>();
        relevantDocumentsRq1.add("Doc1");
        relevantDocumentsRq1.add("Doc2");
        relevantDocumentsRq1.add("Doc3");

        // Query q1
        String query = "q1";

        // Calculate precision and recall
        double precision = calculatePrecision(answerSetA, relevantDocumentsRq1);
        double recall = calculateRecall(answerSetA, relevantDocumentsRq1);

        // Print the results
        System.out.println("Query: " + query);
        System.out.println("Precision: " + precision);
        System.out.println("Recall: " + recall);
    }

    // Calculate precision
    public static double calculatePrecision(Set<String> retrievedDocuments, Set<String> relevantDocuments) {
        int relevantRetrieved = 0;

        for (String doc : retrievedDocuments) {
            if (relevantDocuments.contains(doc)) {
                relevantRetrieved++;
            }
        }

        return (double) relevantRetrieved / retrievedDocuments.size();
    }

    // Calculate recall
    public static double calculateRecall(Set<String> retrievedDocuments, Set<String> relevantDocuments) {
        int relevantRetrieved = 0;

        for (String doc : retrievedDocuments) {
            if (relevantDocuments.contains(doc)) {
                relevantRetrieved++;
            }
        }

        return (double) relevantRetrieved / relevantDocuments.size();
    }
}