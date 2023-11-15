package christmas.domain;

import christmas.constants.EventType;

public class Event {
    private final String badgy;

    public Event(final int discountAmount) {
        this.badgy = EventType.findEventByMoney(discountAmount);
    }

    public String getBadgyString() {
        return badgy;
    }
}
