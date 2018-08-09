package com.lee.section04;

import java.util.Comparator;

public class MeetingSortByStartDate implements Comparator<Meeting> {

    @Override
    public int compare(Meeting m1, Meeting m2) {
        return m1.getStartTime() - m2.getStartTime();
    }
}
