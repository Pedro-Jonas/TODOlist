package Enums;

public enum PriorityEnum {
    P1(1), P2(2), P3(3), P4(4), P5(5);
    private final int priority;

    PriorityEnum(int priority) {
        this.priority = priority;
    }

    public int getPriority() {
        return priority;
    }
}
