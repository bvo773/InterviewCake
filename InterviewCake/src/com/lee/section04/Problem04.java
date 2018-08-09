package com.lee.section04;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem04 {
    Meeting[] mergeRanges(Meeting[] meetings) {
        List<Meeting> mergedMeetings = new ArrayList<>();

        // sort the meetings by the start time
        Arrays.sort(meetings, new MeetingSortByStartDate());

        Meeting previousMeeting = meetings[0];
        for (Meeting meeting : meetings) {
            if (meeting.getStartTime() <= previousMeeting.getEndTime()) {
                int maxEndTime = Integer.max(previousMeeting.getEndTime(), meeting.getEndTime());
                previousMeeting.setEndTime(maxEndTime);
            } else {
                mergedMeetings.add(previousMeeting);
                previousMeeting = meeting;
            }
        }
        mergedMeetings.add(previousMeeting); // add the last meeting into the list

        return mergedMeetings.toArray(new Meeting[mergedMeetings.size()]);
    }
}

// 0  9:00am
// 1  9:30am
// 2 10:00am

// INPUT   [Meeting(9, 10), Meeting(0, 1), Meeting(3, 5), Meeting(4, 8), Meeting(10, 12)]
// OUTPUT  [Meeting(0, 1), Meeting(3, 8), Meeting(9, 12)]


// INPUT [Meeting(9, 10), Meeting(11, 12)]