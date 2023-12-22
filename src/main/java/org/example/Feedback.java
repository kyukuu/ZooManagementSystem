package org.example;

import java.util.HashMap;

public abstract class Feedback implements FeedbackMethods{
    private static HashMap<String,String> feedbackList= new HashMap<>();

    public static HashMap<String, String> getFeedbackList() {
        return feedbackList;
    }

    public static void setFeedbackList(HashMap<String, String> feedbackList) {
        Feedback.feedbackList = feedbackList;
    }
}
