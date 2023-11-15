package christmas.domain.dto;

import christmas.domain.Event;

public class EventDto {
    private final String event;

    private EventDto(final Event event) {
        this.event = event.getBadgyString();
    }

    public static EventDto fromEvent(final Event event) {
        return new EventDto(event);
    }

    public String getBadgy() {
        return event;
    }
}
